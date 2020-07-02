package edu.cnm.deepdive.powerlist.service;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.powerlist.model.entity.Goal;
import edu.cnm.deepdive.powerlist.model.entity.Item;
import edu.cnm.deepdive.powerlist.service.ListDatabase.Converters;
import java.util.Date;
import java.util.List;

@Database(
    entities = {Goal.class, List.class, Item.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class})
public abstract class ListDatabase extends RoomDatabase {



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
