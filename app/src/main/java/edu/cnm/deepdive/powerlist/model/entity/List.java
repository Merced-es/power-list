package edu.cnm.deepdive.powerlist.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = @ForeignKey(
        entity = Goal.class,
        parentColumns = "goal_id",
        childColumns = "goal_id",
        onDelete = ForeignKey.SET_NULL
    )
)

public class List {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "list_id")
    private long id;

    @ColumnInfo(name = "list_id", index = true)
    private Long listId;


}
