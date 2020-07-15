package edu.cnm.deepdive.powerlist.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.powerlist.model.entity.Item;
import edu.cnm.deepdive.powerlist.model.entity.TaskList;

public class ItemWithTaskList extends Item {

  @Relation(entity = TaskList.class, entityColumn = "list_id", parentColumn = "list_id")
  private TaskList taskList;

  public TaskList getTaskList() {
    return taskList;
  }

  public void setTaskList(TaskList taskList) {
    this.taskList = taskList;
  }

}
