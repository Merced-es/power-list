package edu.cnm.deepdive.powerlist.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import edu.cnm.deepdive.powerlist.model.pojo.ListType;

@Entity(
    indices = @Index(value = "list_name", unique = true),
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
    private long listId;

    private String listName;

    @ColumnInfo(name = "goal_id", index = true)
    private Long goalId;

    @ColumnInfo(index = true)
    private ListType type;

    public long getListId() {
        return listId;
    }

    public void setListId(long listId) {
        this.listId = listId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public Long getGoalId() {
        return goalId;
    }

    public void setGoalId(Long goalId) {
        this.goalId = goalId;
    }

    public ListType getType() {
        return type;
    }

    public void setType(ListType type) {
        this.type = type;
    }
}
