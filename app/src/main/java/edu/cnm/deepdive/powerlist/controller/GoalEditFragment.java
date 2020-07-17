package edu.cnm.deepdive.powerlist.controller;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.ColorSpace.Model;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.powerlist.R;
import edu.cnm.deepdive.powerlist.ViewModel.MainViewModel;
import edu.cnm.deepdive.powerlist.model.entity.Goal;
import java.util.List;
import java.util.UUID;

  public class GoalEditFragment extends DialogFragment implements TextWatcher {

    private static final String ID_KEY = "id";

    private AlertDialog dialog;
    private View root;
    private MainViewModel viewModel;
    private EditText goalText;
    private AutoCompleteTextView goalName;
    private List<Goal> goals;
    private Goal goal;

    public static void createAndShow(FragmentManager manager, Long id) {
      GoalEditFragment fragment = new GoalEditFragment();
      Bundle args = new Bundle();
      args.putSerializable(ID_KEY, id);
      fragment.setArguments(args);
      fragment.show(manager, GoalEditFragment.class.getName());
    }

