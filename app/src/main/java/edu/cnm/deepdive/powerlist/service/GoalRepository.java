package edu.cnm.deepdive.powerlist.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import edu.cnm.deepdive.powerlist.model.dao.GoalDao;
import edu.cnm.deepdive.powerlist.model.dao.ItemDao;
import edu.cnm.deepdive.powerlist.model.dao.ListDao;
import edu.cnm.deepdive.powerlist.model.entity.Goal;
import edu.cnm.deepdive.powerlist.model.entity.Item;
import edu.cnm.deepdive.powerlist.model.pojo.GoalWithLists;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class GoalRepository {

  private final ListDatabase database;
  private final GoalDao goalDao;
  private final ListDao listDao;
  private final ItemDao itemDao;

  public GoalRepository(Context context) {
    this.context = context;
    database = ListDatabase.getInstance();
    GoalDao = database.getGoalDao();
    GoalDao = database.getQuoteDao();
  }

  public LiveData<List<GoalWithLists>> getAll() {
    return goalDao.selectAll();
  }

  public Single<GoalWithLists> get(long id) {
    return GoalDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  public Completable save(Item item) {
    if (item.getId() == 0) {
      return Completable.fromSingle(GoalDao.insert(goal))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(GoalDao.update(goal))
          .subscribeOn(Schedulers.io());

    }
  }

  public Completable delete(Goal goal) {
    if (goal.getId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(GoalDao.delete(goal))
          .subscribeOn(Schedulers.io());
    }
  }

}
