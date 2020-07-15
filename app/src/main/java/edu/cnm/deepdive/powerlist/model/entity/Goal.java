package edu.cnm.deepdive.powerlist.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;


@Entity(
    indices = @Index(value = "title", unique = true)
)
public class Goal {


  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "goal_id")
  private long goalId;

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String title;

  @NonNull
  @ColumnInfo(index = true)
  private Date start;

  @ColumnInfo(index = true)
  private Date end;

  public Goal() {
  }

  public long getGoalId() {
    return goalId;
  }

  public void setGoalId(long goalId) {
    this.goalId = goalId;
  }

  @NonNull
  public String getTitle() {
    return title;
  }

  public void setTitle(@NonNull String title) {
    this.title = title;
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


