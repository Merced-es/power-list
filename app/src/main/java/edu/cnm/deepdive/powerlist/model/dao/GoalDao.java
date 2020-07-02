package edu.cnm.deepdive.powerlist.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.powerlist.model.entity.Goal;
import io.reactivex.Single;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Dao
public interface GoalDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Goal goal);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Goal... goals);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Goal> goals);

  @Update
  Single<Integer> update(Goal... goals);

  @Delete
  Single<Integer> delete(Goal... goals);

  @Query("SELECT * FROM Goal ORDER BY name")
  LiveData<List<Goal>> selectAll();

  @Query("SELECT * FROM Goal WHERE item_id = :itemId")
  Single<Goal> selectByItemId(long itemId);

  @Query("SELECT * FROM Goal WHERE list_id = :listId")
  Single<List<Goal>> selectByListId(long listId);

  @Query("SELECT * FROM Goal WHERE ")
  Single<GoalwithLists> selectById(long goalId);

  @Query("SELECT * FROM Goal ORDER BY name")
  LiveData<List<GoalWithItems>> selectAll();

  @Query("SELECT * FROM Goal WHERE goal_id = :goalId")
  Single<GoalwithLists> selectById(long goalId);
}
