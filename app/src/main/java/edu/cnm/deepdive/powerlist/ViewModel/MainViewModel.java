package edu.cnm.deepdive.powerlist.ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import edu.cnm.deepdive.powerlist.model.entity.Goal;
import edu.cnm.deepdive.powerlist.model.entity.TaskList;
import edu.cnm.deepdive.powerlist.model.pojo.GoalWithTaskList;
import edu.cnm.deepdive.powerlist.model.pojo.TaskListWithItem;
import edu.cnm.deepdive.powerlist.service.GoalRepository;
import edu.cnm.deepdive.powerlist.service.ItemRepository;
import edu.cnm.deepdive.powerlist.service.TaskListRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private final GoalRepository goalRepository;
  private final TaskListRepository taskListRepository;
  private final ItemRepository itemRepository;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;
  private final MutableLiveData<GoalWithTaskList> goal;
  private final MutableLiveData<TaskListWithItem> taskList;
  private final MutableLiveData<List<Goal>> goals;
  private final MutableLiveData<List<TaskList>> lists;
  private final MutableLiveData<List<Content>> contents;



  public MainViewModel() {
    goal = new MutableLiveData<>();
    lists = new MutableLiveData<>();
    contents = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
  }

  public LiveData<List<GoalWithTaskList>> getGoals() {
    return goalRepository.getAll();
  }

  public LiveData<List<TaskListWithItem>> getTaskList() {
    return taskListRepository.getAll();
  }


  public LiveData<GoalWithTaskList> getGoal() {
    return goal;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }



}