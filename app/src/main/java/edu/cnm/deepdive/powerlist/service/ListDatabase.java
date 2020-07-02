package edu.cnm.deepdive.powerlist.service;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.powerlist.service.ListDatabase.Converters;
import java.util.Date;


@TypeConverters({Converters.class})

public class ListDatabase {

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
