package edu.cnm.deepdive.powerlist.view;

import android.content.Context;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.powerlist.model.pojo.GoalWithTaskList;
import java.util.List;

public class GoalAdapter extends RecyclerView.Adapter<Holder> {

  public GoalAdapter(Context context,
      List<GoalWithTaskList> goals,
      OnClickListener clickListener) {
    super();
    this.context = context;
    this.goals = goals;
  }
}
