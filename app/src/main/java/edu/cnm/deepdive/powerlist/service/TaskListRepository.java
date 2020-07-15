package edu.cnm.deepdive.powerlist.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.powerlist.model.dao.GoalDao;
import edu.cnm.deepdive.powerlist.model.dao.ItemDao;
import edu.cnm.deepdive.powerlist.model.dao.ListDao;
import edu.cnm.deepdive.powerlist.model.entity.Item;
import edu.cnm.deepdive.powerlist.model.entity.TaskList;
import edu.cnm.deepdive.powerlist.model.pojo.TaskListWithItem;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Collection;
import java.util.List;

public class TaskListRepository {

  private final ListDatabase database;
  private final GoalDao goalDao;
  private final ListDao listDao;
  private final ItemDao itemDao;
  private final Context context;

  public TaskListRepository(Context context) {
    this.context = context;
    database = ListDatabase.getInstance();
    goalDao = database.getGoalDao();
    listDao = database.getListDao();
    itemDao = database.getItemDao();
  }

  public Single<TaskList> get(long id) {
    return listDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  public LiveData<List<TaskListWithItem>> getAll() {
    return listDao.selectAll();
  }

  public Completable save(TaskList taskList) {
    if (taskList.getListId() == 0) {
      return Completable.fromSingle(itemDao.insert((Collection<Item>) taskList))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(itemDao.update(taskList))
          .subscribeOn(Schedulers.io());
    }
  }

  public Completable delete(TaskList taskList) {
    if (taskList.getListId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(listDao.delete(taskList))
          .subscribeOn(Schedulers.io());
    }
  }
}

