package edu.cnm.deepdive.powerlist.model.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;


@Entity(
    indices = @Index(value = "name", unique = true)
)
public class Goal {


  @PrimaryKey(autoGenerate = true)
  @ColumnInfo
  private long goalId;

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String name;

  @NonNull
  @ColumnInfo(index = true)
  private Date start;

  @ColumnInfo(index = true)
  private Date end;

  public long getGoalId() {
    return goalId;
  }

  public void setGoalId(long goalId) {
    this.goalId = goalId;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  @NonNull
  public Date getStart() {
    return start;
  }

  public void setStart(@NonNull Date start) {
    this.start = start;
  }

  public Date getEnd() {
    return end;
  }

  public void setEnd(Date end) {
    this.end = end;
  }
}


