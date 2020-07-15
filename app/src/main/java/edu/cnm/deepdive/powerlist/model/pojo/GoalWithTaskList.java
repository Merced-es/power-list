package edu.cnm.deepdive.powerlist.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.powerlist.model.entity.Goal;
import edu.cnm.deepdive.powerlist.model.entity.Item;
import edu.cnm.deepdive.powerlist.model.entity.TaskList;

public class GoalWithTaskList extends Goal {

  @Relation(entity = TaskList.class, entityColumn = "List_id", parentColumn = "item_id")
  private TaskList taskList;

  public TaskList getTaskList() {
    return taskList;
  }

  public void setTaskList(TaskList taskList) {
    this.taskList = taskList;
  }
}
