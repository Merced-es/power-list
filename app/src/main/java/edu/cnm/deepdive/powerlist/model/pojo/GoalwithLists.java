package edu.cnm.deepdive.powerlist.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.powerlist.model.entity.Goal;
import edu.cnm.deepdive.powerlist.model.entity.Item;
import edu.cnm.deepdive.powerlist.model.entity.List;

public class GoalwithLists extends Goal {

  @Relation(entity = List.class, entityColumn = "List_id", parentColumn = "item_id")
  private Item item;

  public Item getItem() { return item; }

  public void setItem(Item item) {
    this.item = item;
  }


}
