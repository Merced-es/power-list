package edu.cnm.deepdive.powerlist.model.pojo;

import androidx.annotation.NonNull;
import androidx.room.Relation;
import edu.cnm.deepdive.powerlist.model.entity.Goal;
import edu.cnm.deepdive.powerlist.model.entity.Item;

public class GoalWithItems extends Goal {

  @Relation(entity = Item.class, entityColumn = "item_id", parentColumn = "item_id")
  private Item item;

  public Item getItem() { return item; }

  public void setItem(Item item) {
    this.item = item;
  }

}
