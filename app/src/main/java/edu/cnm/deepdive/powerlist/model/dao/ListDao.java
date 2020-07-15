package edu.cnm.deepdive.powerlist.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.powerlist.model.entity.TaskList;
import edu.cnm.deepdive.powerlist.model.pojo.TaskListWithItem;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface ListDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(List list);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(List... lists);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<List> lists);

  @Update
  Single<Integer> update(List... lists);

  @Delete
  Single<Integer> delete(TaskList lists);

  @Query("SELECT * FROM TaskList WHERE list_id = :listId")
  Single<TaskList> selectById(long listId);

  @Query("SELECT * FROM TaskList ORDER BY listName")
  LiveData<List<TaskListWithItem>> selectAll();

}
