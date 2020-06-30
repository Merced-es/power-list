package edu.cnm.deepdive.powerlist.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Goal {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "goal_id")
  private long id;

  @ColumnInfo(name = "goal_id", index = true)
  private Long goalId;


}
