package edu.cnm.deepdive.powerlist.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.powerlist.model.entity.Item;
import edu.cnm.deepdive.powerlist.model.entity.TaskList;

public class TaskListWithItem extends TaskList {

  @Relation(entity = Item.class, entityColumn = "item_id", parentColumn = "item_id")
  private Item item;

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }
}
