package edu.cnm.deepdive.powerlist.service;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabase.Callback;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import edu.cnm.deepdive.powerlist.R;
import edu.cnm.deepdive.powerlist.model.dao.GoalDao;
import edu.cnm.deepdive.powerlist.model.dao.ItemDao;
import edu.cnm.deepdive.powerlist.model.dao.ListDao;
import edu.cnm.deepdive.powerlist.model.entity.Goal;
import edu.cnm.deepdive.powerlist.model.entity.Item;
import edu.cnm.deepdive.powerlist.model.pojo.ListType;
import edu.cnm.deepdive.powerlist.service.ListDatabase.Converters;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Database(
    entities = {Goal.class, List.class, Item.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class, ListType.class})
public abstract class ListDatabase extends RoomDatabase {

  private static final String DB_NAME = "goal_db";

  private static Application context;

  public static void setContext(Application context) {
    ListDatabase.context = context;
  }

  public abstract GoalDao getGoalDao();

  public abstract ListDao getListDao();

  public abstract ItemDao getItemDao();

  public static ListDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  private static class InstanceHolder {

    private static final ListDatabase INSTANCE =
        Room.databaseBuilder(context, ListDatabase.class, DB_NAME)
            .build();

  }


  public static class Converters {

    @TypeConverter
    public static Long dateToLong(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date longToDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }

  }

}
