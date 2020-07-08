package edu.cnm.deepdive.powerlist.model.pojo;

import androidx.room.TypeConverter;

public enum ListType {
  POWER_LIST, VISION_BOARD;

  @TypeConverter
  public static ListType integerToListType(Integer value) {
    return (value == null) ? null : ListType.values()[value];
  }

  @TypeConverter
  public static Integer listTypeToInteger(ListType value) {
    return (value == null) ? null : value.ordinal();
  }

}
