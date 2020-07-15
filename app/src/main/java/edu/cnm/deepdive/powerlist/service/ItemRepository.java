package edu.cnm.deepdive.powerlist.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.powerlist.model.dao.GoalDao;
import edu.cnm.deepdive.powerlist.model.dao.ItemDao;
import edu.cnm.deepdive.powerlist.model.dao.ListDao;
import edu.cnm.deepdive.powerlist.model.entity.Item;
import edu.cnm.deepdive.powerlist.model.pojo.ItemWithTaskList;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class ItemRepository {

  private final ListDatabase database;
  private final GoalDao goalDao;
  private final ListDao listDao;
  private final ItemDao itemDao;
  private final Context context;

  public ItemRepository(Context context) {
    this.context = context;
    database = ListDatabase.getInstance();
    goalDao = database.getGoalDao();
    listDao = database.getListDao();
    itemDao = database.getItemDao();
  }

  public LiveData<List<ItemWithTaskList>> getAll() {
    return itemDao.selectAll();
  }

  public Single<Item> get(long id) {
    return itemDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  public Completable save(edu.cnm.deepdive.powerlist.model.entity.Item item) {
    if (item.getItemId() == 0) {
      return Completable.fromSingle(itemDao.insert(item))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(itemDao.update(item))
          .subscribeOn(Schedulers.io());

    }
  }

  public Completable delete(Item item) {
    if (item.getItemId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(itemDao.delete(item))
          .subscribeOn(Schedulers.io());
    }
  }

}
