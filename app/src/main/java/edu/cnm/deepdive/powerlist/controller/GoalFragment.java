package edu.cnm.deepdive.powerlist.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.powerlist.R;
import edu.cnm.deepdive.powerlist.ViewModel.MainViewModel;
import edu.cnm.deepdive.powerlist.model.pojo.GoalWithTaskList;
import edu.cnm.deepdive.powerlist.view.GoalAdapter;

public class GoalFragment extends Fragment implements GoalAdapter.OnClickListener {

  private MainViewModel mainViewModel;
  private RecyclerView goalsList;
  private FloatingAction addGoal;

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    //noinspection ConstantConditions
    mainViewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
    mainViewModel.getGoals().observe(getViewLifecycleOwner(), (goals) -> {
      goalsList.setAdapter(new GoalAdapter(getContext(), goals, this));
    });
  }

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_goals, container, false);
    goalsList = root.findViewById(R.id.goal_list);
    addGoal = root.findViewById(R.id.add_goal);
    addGoal.setOnClickListener((v) -> editGoal(0));
    return root;
  }

  @Override
  public void onClick(View v, int position, GoalWithTaskList goal) {
    editGoal(goal.getId());
    //    Toast.makeText(getContext(),
//        String.format("Item %d [%s] was clicked", position, quote), Toast.LENGTH_LONG).show();
  }

  private void editGoal(long goalId) {
    GoalEditFragment fragment = GoalEditFragment.newInstance(goalId);
    fragment.show(getChildFragmentManager(), fragment.getClass().getName());
  }

}
