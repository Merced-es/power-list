package edu.cnm.deepdive.powerlist.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.powerlist.model.entity.Item;
import edu.cnm.deepdive.powerlist.model.pojo.ItemWithGoals;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface ItemDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Item item);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Item... items);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Item> items);

  @Update
  Single<Integer> update(Item... items);

  @Delete
  Single<Integer> delete(Item... items);

  @Query("SELECT * FROM Item ORDER BY name")
  LiveData<List<Item>> selectAll();

  @Query("SELECT * FROM Item WHERE item_id = :goalId")
  LiveData<List<ItemWithGoals>> selectAllByTitle(long goalId);

  @Query("SELECT * FROM Item WHERE name = name")
  Single<Item> selectByItemName (long name);


}
