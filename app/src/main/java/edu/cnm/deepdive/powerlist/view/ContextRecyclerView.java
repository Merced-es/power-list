package edu.cnm.deepdive.powerlist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class ContextRecyclerView extends RecyclerView {
  private ContextMenuInfo menuInfo;

  public ContextRecyclerView(@NonNull Context context) {
    super(context);
  }

  public ContextRecyclerView(@NonNull Context context,
      @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public ContextRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
    return menuInfo;
  }

  @SuppressWarnings("ConstantConditions")
  @Override
  public boolean showContextMenuForChild(View originalView) {
    final boolean handled;
    int position = getChildAdapterPosition(originalView);
    if (position >= 0) {
      long id = getAdapter().getItemId(position);
      menuInfo = new ContextMenuInfo(position, originalView, id);
      handled = super.showContextMenuForChild(originalView);
    } else {
      handled = false;
    }
    return handled;
  }

  public static class ContextMenuInfo implements ContextMenu.ContextMenuInfo {

    final int position;
    final View view;
    final long id;

    public ContextMenuInfo(int position, @NonNull View view, long id) {
      this.position = position;
      this.view = view;
      this.id = id;
    }

    public int getPosition() {
      return position;
    }

    @NonNull
    public View getView() {
      return view;
    }

    public long getId() {
      return id;
    }

  }

}
