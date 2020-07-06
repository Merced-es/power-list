package edu.cnm.deepdive.powerlist.model.pojo;

import androidx.annotation.NonNull;
import androidx.room.Relation;
import edu.cnm.deepdive.powerlist.model.entity.Goal;
import edu.cnm.deepdive.powerlist.model.entity.Item;

public class ItemWithGoals extends Item {

  @Relation(entity = Goal.class, entityColumn = "goal_id", parentColumn = "goal_id")
  private Goal goal;

  public Goal getGoal() {
    return goal;
  }

  public void setGoal(Goal goal) {
    this.goal = goal;
  }

}
