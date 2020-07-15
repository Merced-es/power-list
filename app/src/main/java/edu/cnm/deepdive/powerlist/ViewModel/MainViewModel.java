package edu.cnm.deepdive.powerlist.ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
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

  public MainViewModel(@NonNull Application application) {
    super(application);
    goalRepository = new GoalRepository(application);
    taskListRepository = new TaskListRepository(application);
    itemRepository = new ItemRepository(application);
    goal = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
    taskList = new MutableLiveData<>();
  }

  public LiveData<List<GoalWithTaskList>> getGoals() {
    return goalRepository.getAll();
  }

  public LiveData<List<TaskListWithItem>> getTaskList () {
    return taskListRepository.getAll();
  }


  public LiveData<QuoteWithSource> getQuote() {
    return quote;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public void setQuoteId(long id) {
    throwable.setValue(null);
    pending.add(
        quoteRepository.get(id)
            .subscribe(
                (quote) -> this.quote.postValue(quote),
                (throwable) -> this.throwable.postValue(throwable)
            )
    );
  }

  public void saveQuote(Quote quote) {
    throwable.setValue(null);
    pending.add(
        quoteRepository.save(quote)
            .subscribe(
                () -> {
                },
                (throwable) -> this.throwable.postValue(throwable)
            )
    );
  }

  public void deleteQuote(Quote quote) {
    throwable.setValue(null);
    pending.add(
        quoteRepository.delete(quote)
            .subscribe(
                () -> {
                },
                (throwable) -> this.throwable.postValue(throwable)
            )
    );
  }

  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending() {
    pending.clear();
  }

}