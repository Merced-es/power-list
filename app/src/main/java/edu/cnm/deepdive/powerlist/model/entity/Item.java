package edu.cnm.deepdive.powerlist.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(
    indices = @Index(value = "name", unique = true),
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
  private long itemId;

  @ColumnInfo(index = true)
  private Long listId;

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String name;

  @ColumnInfo()
  private Date completed;

  @ColumnInfo(index = true, collate = ColumnInfo.NOCASE)
  private String description;

  @ColumnInfo(name = "media_uri")
  private String mediaUri;

  @ColumnInfo(index = true)
  private int sequence;

  public long getItemId() {
    return itemId;
  }

  public void setItemId(long itemId) {
    this.itemId = itemId;
  }

  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  public Date getCompleted() {
    return completed;
  }

  public void setCompleted(Date completed) {
    this.completed = completed;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getMediaUri() {
    return mediaUri;
  }

  public void setMediaUri(String mediaUri) {
    this.mediaUri = mediaUri;
  }

  public int getSequence() {
    return sequence;
  }

  public void setSequence(int sequence) {
    this.sequence = sequence;
  }

  public Long getListId() {
    return listId;
  }
}
