package edu.cnm.deepdive.powerlist;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.powerlist.service.ListDatabase;
import io.reactivex.schedulers.Schedulers;

public class ListApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    ListDatabase.setContext(this);
    ListDatabase database = ListDatabase.getInstance();
    database.getDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
    Stetho.initializeWithDefaults(this);

  }

}
