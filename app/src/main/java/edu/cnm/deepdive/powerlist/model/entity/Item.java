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



}
