import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

final class adm
  implements ListAdapter, SpinnerAdapter
{
  private SpinnerAdapter a;
  private ListAdapter b;
  
  public adm(SpinnerAdapter paramSpinnerAdapter, Resources.Theme paramTheme)
  {
    this.a = paramSpinnerAdapter;
    if ((paramSpinnerAdapter instanceof ListAdapter)) {
      this.b = ((ListAdapter)paramSpinnerAdapter);
    }
    if ((paramTheme != null) && (adk.a) && ((paramSpinnerAdapter instanceof ThemedSpinnerAdapter)))
    {
      ThemedSpinnerAdapter localThemedSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
      if (localThemedSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
        localThemedSpinnerAdapter.setDropDownViewTheme(paramTheme);
      }
    }
  }
  
  public final boolean areAllItemsEnabled()
  {
    ListAdapter localListAdapter = this.b;
    if (localListAdapter != null) {
      return localListAdapter.areAllItemsEnabled();
    }
    return true;
  }
  
  public final int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.getCount();
  }
  
  public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.a == null) {
      return null;
    }
    return this.a.getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public final Object getItem(int paramInt)
  {
    if (this.a == null) {
      return null;
    }
    return this.a.getItem(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    if (this.a == null) {
      return -1L;
    }
    return this.a.getItemId(paramInt);
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  public final boolean hasStableIds()
  {
    return (this.a != null) && (this.a.hasStableIds());
  }
  
  public final boolean isEmpty()
  {
    return getCount() == 0;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    ListAdapter localListAdapter = this.b;
    if (localListAdapter != null) {
      return localListAdapter.isEnabled(paramInt);
    }
    return true;
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if (this.a != null) {
      this.a.registerDataSetObserver(paramDataSetObserver);
    }
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if (this.a != null) {
      this.a.unregisterDataSetObserver(paramDataSetObserver);
    }
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     adm
 * JD-Core Version:    0.7.0.1
 */