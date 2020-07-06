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
import edu.cnm.deepdive.powerlist.model.pojo.GoalWithItems;
import edu.cnm.deepdive.powerlist.model.pojo.GoalwithLists;
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

  @Query("SELECT * FROM Goal ORDER BY title")
  LiveData<List<Goal>> selectAll();

  @Query("SELECT * FROM Goal ORDER BY title")
  LiveData<List<GoalwithLists>> selectByListName();

  @Query("SELECT * FROM Goal ORDER BY title")
  LiveData<List<GoalWithItems>> selectByItemID();

}
