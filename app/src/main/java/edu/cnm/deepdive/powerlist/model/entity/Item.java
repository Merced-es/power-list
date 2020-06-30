package edu.cnm.deepdive.powerlist.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = @ForeignKey(
        entity = List.class,
        parentColumns = "list_id",
        childColumns = "list_id",
        onDelete = ForeignKey.SET_NULL
    )
)

public class Item {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "item_id")
  private long id;

  @ColumnInfo(name = "item_id", index = true)
  private Long itemId;

}
