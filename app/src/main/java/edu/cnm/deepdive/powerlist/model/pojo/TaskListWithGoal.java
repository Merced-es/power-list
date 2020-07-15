package edu.cnm.deepdive.powerlist.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.powerlist.model.entity.Goal;
import edu.cnm.deepdive.powerlist.model.entity.TaskList;

public class TaskListWithGoal extends TaskList {

  @Relation(entity = Goal.class, entityColumn = "goal_id", parentColumn = "goal_id")
  private Goal goal;

  public Goal getGoal() {
    return goal;
  }

  public void setGoal(Goal goal) {
    this.goal = goal;
  }


}
