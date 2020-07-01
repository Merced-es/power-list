package edu.cnm.deepdive.powerlist.model.entity;

import androidx.annotation.NonNull;
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

  @PrimaryKey
  @ColumnInfo(name = "item_id")
  private long id;

  @ColumnInfo(name = "item_id", index = true)
  private Long itemId;

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String text = "";

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Long getListId() {
    return listId;
  }

  public void setListId(Long ListId) {
    this.listId = listId;
  }

  @NonNull
  public String getText() {
    return text;
  }

  public void setText(@NonNull String text) {
    this.text = text;
  }

  @NonNull
  @Override
  public String toString() {
    return text;
  }
}

}
