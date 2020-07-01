package edu.cnm.deepdive.powerlist.model.entity;

import androidx.annotation.NonNull;
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

    @NonNull
    @ColumnInfo(collate = ColumnInfo.NOCASE)
    private String text = "";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getGoalId() {
        return goalId;
    }

    public void setGoalId(Long goalId) {
        this.goalId = goalId;
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
