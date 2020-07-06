package edu.cnm.deepdive.powerlist.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import edu.cnm.deepdive.powerlist.model.dao.GoalDao;
import edu.cnm.deepdive.powerlist.model.dao.ItemDao;
import edu.cnm.deepdive.powerlist.model.entity.Item;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class ItemRepository {

  public QuoteRepository(Context context) {
    this.context = context;
    database = ListDatabase.getInstance();
    GoalDao = database.getGoalDao();
    ItemDao = database.getQuoteDao();
  }

  public LiveData<List<ItemWithGoals>> getAll() {
    return ItemDao.selectAll();
  }

  public Single<ItemWithGoals> get(long id) {
    return ItemDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  public Completable save(Item item) {
    if (item.getId() == 0) {
      return Completable.fromSingle(ItemDao.insert(item))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(ItemDao.update(item))
          .subscribeOn(Schedulers.io());

    }
  }

  public Completable delete(Item item) {
    if (item.getId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(ItemDao.delete(item))
          .subscribeOn(Schedulers.io());
    }
  }

}
