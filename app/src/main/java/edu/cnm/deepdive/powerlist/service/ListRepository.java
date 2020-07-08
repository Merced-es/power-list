package edu.cnm.deepdive.powerlist.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.powerlist.model.dao.GoalDao;
import edu.cnm.deepdive.powerlist.model.dao.ItemDao;
import edu.cnm.deepdive.powerlist.model.dao.ListDao;
import edu.cnm.deepdive.powerlist.model.entity.Goal;
import edu.cnm.deepdive.powerlist.model.pojo.ListWithGoal;
import edu.cnm.deepdive.powerlist.model.pojo.ListWithItems;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class ListRepository {

  private final ListDatabase database;
  private final GoalDao goalDao;
  private final ListDao listDao;
  private final ItemDao itemDao;
  private final Context context;

  public ListRepository(Context context) {
    this.context = context;
    database = ListDatabase.getInstance();
    goalDao = database.getGoalDao();
    listDao = database.getListDao();
    itemDao = database.getItemDao();
  }

  public Single<List> get(long id) {
    return listDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  public LiveData<List<ListWithItems>> getAll() {
    return ListDao.selectAll();
  }

  public Completable save(List list) {
    if (list.getListId == 0) {
      return Completable.fromSingle(listDao.insert(list))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(listDao.update(list))
          .subscribeOn(Schedulers.io());

    }
  }

  public Completable delete(List list) {
    if (list.getListId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(listDao.delete(list))
          .subscribeOn(Schedulers.io());
    }
  }
}

