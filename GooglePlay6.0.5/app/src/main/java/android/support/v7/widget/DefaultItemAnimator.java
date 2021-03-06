package android.support.v7.widget;

import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class DefaultItemAnimator
  extends SimpleItemAnimator
{
  ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList();
  ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList = new ArrayList();
  ArrayList<RecyclerView.ViewHolder> mChangeAnimations = new ArrayList();
  ArrayList<ArrayList<ChangeInfo>> mChangesList = new ArrayList();
  ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList();
  ArrayList<ArrayList<MoveInfo>> mMovesList = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> mPendingAdditions = new ArrayList();
  private ArrayList<ChangeInfo> mPendingChanges = new ArrayList();
  private ArrayList<MoveInfo> mPendingMoves = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList();
  ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList();
  
  private static void cancelAll(List<RecyclerView.ViewHolder> paramList)
  {
    for (int i = -1 + paramList.size(); i >= 0; i--) {
      ViewCompat.animate(((RecyclerView.ViewHolder)paramList.get(i)).itemView).cancel();
    }
  }
  
  private void endChangeAnimation(List<ChangeInfo> paramList, RecyclerView.ViewHolder paramViewHolder)
  {
    for (int i = -1 + paramList.size(); i >= 0; i--)
    {
      ChangeInfo localChangeInfo = (ChangeInfo)paramList.get(i);
      if ((endChangeAnimationIfNecessary(localChangeInfo, paramViewHolder)) && (localChangeInfo.oldHolder == null) && (localChangeInfo.newHolder == null)) {
        paramList.remove(localChangeInfo);
      }
    }
  }
  
  private void endChangeAnimationIfNecessary(ChangeInfo paramChangeInfo)
  {
    if (paramChangeInfo.oldHolder != null) {
      endChangeAnimationIfNecessary(paramChangeInfo, paramChangeInfo.oldHolder);
    }
    if (paramChangeInfo.newHolder != null) {
      endChangeAnimationIfNecessary(paramChangeInfo, paramChangeInfo.newHolder);
    }
  }
  
  private boolean endChangeAnimationIfNecessary(ChangeInfo paramChangeInfo, RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramChangeInfo.newHolder == paramViewHolder) {
      paramChangeInfo.newHolder = null;
    }
    for (;;)
    {
      ViewCompat.setAlpha(paramViewHolder.itemView, 1.0F);
      ViewCompat.setTranslationX(paramViewHolder.itemView, 0.0F);
      ViewCompat.setTranslationY(paramViewHolder.itemView, 0.0F);
      dispatchAnimationFinished(paramViewHolder);
      return true;
      if (paramChangeInfo.oldHolder != paramViewHolder) {
        break;
      }
      paramChangeInfo.oldHolder = null;
    }
    return false;
  }
  
  private void resetAnimation(RecyclerView.ViewHolder paramViewHolder)
  {
    AnimatorCompatHelper.clearInterpolator(paramViewHolder.itemView);
    endAnimation(paramViewHolder);
  }
  
  public final boolean animateAdd(RecyclerView.ViewHolder paramViewHolder)
  {
    resetAnimation(paramViewHolder);
    ViewCompat.setAlpha(paramViewHolder.itemView, 0.0F);
    this.mPendingAdditions.add(paramViewHolder);
    return true;
  }
  
  public final boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramViewHolder1 == paramViewHolder2) {
      return animateMove(paramViewHolder1, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    float f1 = ViewCompat.getTranslationX(paramViewHolder1.itemView);
    float f2 = ViewCompat.getTranslationY(paramViewHolder1.itemView);
    float f3 = ViewCompat.getAlpha(paramViewHolder1.itemView);
    resetAnimation(paramViewHolder1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    ViewCompat.setTranslationX(paramViewHolder1.itemView, f1);
    ViewCompat.setTranslationY(paramViewHolder1.itemView, f2);
    ViewCompat.setAlpha(paramViewHolder1.itemView, f3);
    if (paramViewHolder2 != null)
    {
      resetAnimation(paramViewHolder2);
      ViewCompat.setTranslationX(paramViewHolder2.itemView, -i);
      ViewCompat.setTranslationY(paramViewHolder2.itemView, -j);
      ViewCompat.setAlpha(paramViewHolder2.itemView, 0.0F);
    }
    this.mPendingChanges.add(new ChangeInfo(paramViewHolder1, paramViewHolder2, paramInt1, paramInt2, paramInt3, paramInt4, (byte)0));
    return true;
  }
  
  public final boolean animateMove(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramViewHolder.itemView;
    int i = (int)(paramInt1 + ViewCompat.getTranslationX(paramViewHolder.itemView));
    int j = (int)(paramInt2 + ViewCompat.getTranslationY(paramViewHolder.itemView));
    resetAnimation(paramViewHolder);
    int k = paramInt3 - i;
    int m = paramInt4 - j;
    if ((k == 0) && (m == 0))
    {
      dispatchAnimationFinished(paramViewHolder);
      return false;
    }
    if (k != 0) {
      ViewCompat.setTranslationX(localView, -k);
    }
    if (m != 0) {
      ViewCompat.setTranslationY(localView, -m);
    }
    this.mPendingMoves.add(new MoveInfo(paramViewHolder, i, j, paramInt3, paramInt4, (byte)0));
    return true;
  }
  
  public final boolean animateRemove(RecyclerView.ViewHolder paramViewHolder)
  {
    resetAnimation(paramViewHolder);
    this.mPendingRemovals.add(paramViewHolder);
    return true;
  }
  
  final void dispatchFinishedWhenDone()
  {
    if (!isRunning()) {
      dispatchAnimationsFinished();
    }
  }
  
  public final void endAnimation(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    ViewCompat.animate(localView).cancel();
    for (int i = -1 + this.mPendingMoves.size(); i >= 0; i--) {
      if (((MoveInfo)this.mPendingMoves.get(i)).holder == paramViewHolder)
      {
        ViewCompat.setTranslationY(localView, 0.0F);
        ViewCompat.setTranslationX(localView, 0.0F);
        dispatchAnimationFinished(paramViewHolder);
        this.mPendingMoves.remove(i);
      }
    }
    endChangeAnimation(this.mPendingChanges, paramViewHolder);
    if (this.mPendingRemovals.remove(paramViewHolder))
    {
      ViewCompat.setAlpha(localView, 1.0F);
      dispatchAnimationFinished(paramViewHolder);
    }
    if (this.mPendingAdditions.remove(paramViewHolder))
    {
      ViewCompat.setAlpha(localView, 1.0F);
      dispatchAnimationFinished(paramViewHolder);
    }
    for (int j = -1 + this.mChangesList.size(); j >= 0; j--)
    {
      ArrayList localArrayList3 = (ArrayList)this.mChangesList.get(j);
      endChangeAnimation(localArrayList3, paramViewHolder);
      if (localArrayList3.isEmpty()) {
        this.mChangesList.remove(j);
      }
    }
    int k = -1 + this.mMovesList.size();
    if (k >= 0)
    {
      ArrayList localArrayList2 = (ArrayList)this.mMovesList.get(k);
      for (int n = -1 + localArrayList2.size();; n--)
      {
        if (n >= 0)
        {
          if (((MoveInfo)localArrayList2.get(n)).holder != paramViewHolder) {
            continue;
          }
          ViewCompat.setTranslationY(localView, 0.0F);
          ViewCompat.setTranslationX(localView, 0.0F);
          dispatchAnimationFinished(paramViewHolder);
          localArrayList2.remove(n);
          if (localArrayList2.isEmpty()) {
            this.mMovesList.remove(k);
          }
        }
        k--;
        break;
      }
    }
    for (int m = -1 + this.mAdditionsList.size(); m >= 0; m--)
    {
      ArrayList localArrayList1 = (ArrayList)this.mAdditionsList.get(m);
      if (localArrayList1.remove(paramViewHolder))
      {
        ViewCompat.setAlpha(localView, 1.0F);
        dispatchAnimationFinished(paramViewHolder);
        if (localArrayList1.isEmpty()) {
          this.mAdditionsList.remove(m);
        }
      }
    }
    this.mRemoveAnimations.remove(paramViewHolder);
    this.mAddAnimations.remove(paramViewHolder);
    this.mChangeAnimations.remove(paramViewHolder);
    this.mMoveAnimations.remove(paramViewHolder);
    dispatchFinishedWhenDone();
  }
  
  public final void endAnimations()
  {
    for (int i = -1 + this.mPendingMoves.size(); i >= 0; i--)
    {
      MoveInfo localMoveInfo2 = (MoveInfo)this.mPendingMoves.get(i);
      View localView2 = localMoveInfo2.holder.itemView;
      ViewCompat.setTranslationY(localView2, 0.0F);
      ViewCompat.setTranslationX(localView2, 0.0F);
      dispatchAnimationFinished(localMoveInfo2.holder);
      this.mPendingMoves.remove(i);
    }
    for (int j = -1 + this.mPendingRemovals.size(); j >= 0; j--)
    {
      dispatchAnimationFinished((RecyclerView.ViewHolder)this.mPendingRemovals.get(j));
      this.mPendingRemovals.remove(j);
    }
    for (int k = -1 + this.mPendingAdditions.size(); k >= 0; k--)
    {
      RecyclerView.ViewHolder localViewHolder2 = (RecyclerView.ViewHolder)this.mPendingAdditions.get(k);
      ViewCompat.setAlpha(localViewHolder2.itemView, 1.0F);
      dispatchAnimationFinished(localViewHolder2);
      this.mPendingAdditions.remove(k);
    }
    for (int m = -1 + this.mPendingChanges.size(); m >= 0; m--) {
      endChangeAnimationIfNecessary((ChangeInfo)this.mPendingChanges.get(m));
    }
    this.mPendingChanges.clear();
    if (!isRunning()) {
      return;
    }
    for (int n = -1 + this.mMovesList.size(); n >= 0; n--)
    {
      ArrayList localArrayList3 = (ArrayList)this.mMovesList.get(n);
      for (int i5 = -1 + localArrayList3.size(); i5 >= 0; i5--)
      {
        MoveInfo localMoveInfo1 = (MoveInfo)localArrayList3.get(i5);
        View localView1 = localMoveInfo1.holder.itemView;
        ViewCompat.setTranslationY(localView1, 0.0F);
        ViewCompat.setTranslationX(localView1, 0.0F);
        dispatchAnimationFinished(localMoveInfo1.holder);
        localArrayList3.remove(i5);
        if (localArrayList3.isEmpty()) {
          this.mMovesList.remove(localArrayList3);
        }
      }
    }
    for (int i1 = -1 + this.mAdditionsList.size(); i1 >= 0; i1--)
    {
      ArrayList localArrayList2 = (ArrayList)this.mAdditionsList.get(i1);
      for (int i4 = -1 + localArrayList2.size(); i4 >= 0; i4--)
      {
        RecyclerView.ViewHolder localViewHolder1 = (RecyclerView.ViewHolder)localArrayList2.get(i4);
        ViewCompat.setAlpha(localViewHolder1.itemView, 1.0F);
        dispatchAnimationFinished(localViewHolder1);
        localArrayList2.remove(i4);
        if (localArrayList2.isEmpty()) {
          this.mAdditionsList.remove(localArrayList2);
        }
      }
    }
    for (int i2 = -1 + this.mChangesList.size(); i2 >= 0; i2--)
    {
      ArrayList localArrayList1 = (ArrayList)this.mChangesList.get(i2);
      for (int i3 = -1 + localArrayList1.size(); i3 >= 0; i3--)
      {
        endChangeAnimationIfNecessary((ChangeInfo)localArrayList1.get(i3));
        if (localArrayList1.isEmpty()) {
          this.mChangesList.remove(localArrayList1);
        }
      }
    }
    cancelAll(this.mRemoveAnimations);
    cancelAll(this.mMoveAnimations);
    cancelAll(this.mAddAnimations);
    cancelAll(this.mChangeAnimations);
    dispatchAnimationsFinished();
  }
  
  public final boolean isRunning()
  {
    return (!this.mPendingAdditions.isEmpty()) || (!this.mPendingChanges.isEmpty()) || (!this.mPendingMoves.isEmpty()) || (!this.mPendingRemovals.isEmpty()) || (!this.mMoveAnimations.isEmpty()) || (!this.mRemoveAnimations.isEmpty()) || (!this.mAddAnimations.isEmpty()) || (!this.mChangeAnimations.isEmpty()) || (!this.mMovesList.isEmpty()) || (!this.mAdditionsList.isEmpty()) || (!this.mChangesList.isEmpty());
  }
  
  public final void runPendingAnimations()
  {
    int i;
    int j;
    label24:
    int k;
    if (!this.mPendingRemovals.isEmpty())
    {
      i = 1;
      if (this.mPendingMoves.isEmpty()) {
        break label72;
      }
      j = 1;
      if (this.mPendingChanges.isEmpty()) {
        break label77;
      }
      k = 1;
      label36:
      if (this.mPendingAdditions.isEmpty()) {
        break label82;
      }
    }
    label72:
    label77:
    label82:
    for (int m = 1;; m = 0)
    {
      if ((i != 0) || (j != 0) || (m != 0) || (k != 0)) {
        break label88;
      }
      return;
      i = 0;
      break;
      j = 0;
      break label24;
      k = 0;
      break label36;
    }
    label88:
    Iterator localIterator = this.mPendingRemovals.iterator();
    while (localIterator.hasNext())
    {
      final RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localIterator.next();
      final ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1 = ViewCompat.animate(localViewHolder.itemView);
      this.mRemoveAnimations.add(localViewHolder);
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2 = localViewPropertyAnimatorCompat1.setDuration(this.mRemoveDuration).alpha(0.0F);
      VpaListenerAdapter local4 = new VpaListenerAdapter(localViewHolder)
      {
        public final void onAnimationEnd(View paramAnonymousView)
        {
          localViewPropertyAnimatorCompat1.setListener(null);
          ViewCompat.setAlpha(paramAnonymousView, 1.0F);
          DefaultItemAnimator.this.dispatchAnimationFinished(localViewHolder);
          DefaultItemAnimator.this.mRemoveAnimations.remove(localViewHolder);
          DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }
        
        public final void onAnimationStart(View paramAnonymousView) {}
      };
      localViewPropertyAnimatorCompat2.setListener(local4).start();
    }
    this.mPendingRemovals.clear();
    Runnable local1;
    label268:
    Runnable local2;
    label348:
    final ArrayList localArrayList3;
    Runnable local3;
    long l1;
    label423:
    long l2;
    if (j != 0)
    {
      final ArrayList localArrayList1 = new ArrayList();
      localArrayList1.addAll(this.mPendingMoves);
      this.mMovesList.add(localArrayList1);
      this.mPendingMoves.clear();
      local1 = new Runnable()
      {
        public final void run()
        {
          Iterator localIterator = localArrayList1.iterator();
          while (localIterator.hasNext())
          {
            DefaultItemAnimator.MoveInfo localMoveInfo = (DefaultItemAnimator.MoveInfo)localIterator.next();
            DefaultItemAnimator localDefaultItemAnimator = DefaultItemAnimator.this;
            RecyclerView.ViewHolder localViewHolder = localMoveInfo.holder;
            int i = localMoveInfo.fromX;
            int j = localMoveInfo.fromY;
            int k = localMoveInfo.toX;
            int m = localMoveInfo.toY;
            View localView = localViewHolder.itemView;
            int n = k - i;
            int i1 = m - j;
            if (n != 0) {
              ViewCompat.animate(localView).translationX(0.0F);
            }
            if (i1 != 0) {
              ViewCompat.animate(localView).translationY(0.0F);
            }
            ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(localView);
            localDefaultItemAnimator.mMoveAnimations.add(localViewHolder);
            localViewPropertyAnimatorCompat.setDuration(localDefaultItemAnimator.mMoveDuration).setListener(new DefaultItemAnimator.6(localDefaultItemAnimator, localViewHolder, n, i1, localViewPropertyAnimatorCompat)).start();
          }
          localArrayList1.clear();
          DefaultItemAnimator.this.mMovesList.remove(localArrayList1);
        }
      };
      if (i != 0) {
        ViewCompat.postOnAnimationDelayed(((MoveInfo)localArrayList1.get(0)).holder.itemView, local1, this.mRemoveDuration);
      }
    }
    else
    {
      if (k != 0)
      {
        final ArrayList localArrayList2 = new ArrayList();
        localArrayList2.addAll(this.mPendingChanges);
        this.mChangesList.add(localArrayList2);
        this.mPendingChanges.clear();
        local2 = new Runnable()
        {
          public final void run()
          {
            Iterator localIterator = localArrayList2.iterator();
            if (localIterator.hasNext())
            {
              DefaultItemAnimator.ChangeInfo localChangeInfo = (DefaultItemAnimator.ChangeInfo)localIterator.next();
              DefaultItemAnimator localDefaultItemAnimator = DefaultItemAnimator.this;
              RecyclerView.ViewHolder localViewHolder1 = localChangeInfo.oldHolder;
              View localView1;
              label47:
              RecyclerView.ViewHolder localViewHolder2;
              if (localViewHolder1 == null)
              {
                localView1 = null;
                localViewHolder2 = localChangeInfo.newHolder;
                if (localViewHolder2 == null) {
                  break label234;
                }
              }
              label234:
              for (View localView2 = localViewHolder2.itemView;; localView2 = null)
              {
                if (localView1 != null)
                {
                  ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2 = ViewCompat.animate(localView1).setDuration(localDefaultItemAnimator.mChangeDuration);
                  localDefaultItemAnimator.mChangeAnimations.add(localChangeInfo.oldHolder);
                  localViewPropertyAnimatorCompat2.translationX(localChangeInfo.toX - localChangeInfo.fromX);
                  localViewPropertyAnimatorCompat2.translationY(localChangeInfo.toY - localChangeInfo.fromY);
                  localViewPropertyAnimatorCompat2.alpha(0.0F).setListener(new DefaultItemAnimator.7(localDefaultItemAnimator, localChangeInfo, localViewPropertyAnimatorCompat2)).start();
                }
                if (localView2 == null) {
                  break;
                }
                ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1 = ViewCompat.animate(localView2);
                localDefaultItemAnimator.mChangeAnimations.add(localChangeInfo.newHolder);
                localViewPropertyAnimatorCompat1.translationX(0.0F).translationY(0.0F).setDuration(localDefaultItemAnimator.mChangeDuration).alpha(1.0F).setListener(new DefaultItemAnimator.8(localDefaultItemAnimator, localChangeInfo, localViewPropertyAnimatorCompat1, localView2)).start();
                break;
                localView1 = localViewHolder1.itemView;
                break label47;
              }
            }
            localArrayList2.clear();
            DefaultItemAnimator.this.mChangesList.remove(localArrayList2);
          }
        };
        if (i == 0) {
          break label485;
        }
        ViewCompat.postOnAnimationDelayed(((ChangeInfo)localArrayList2.get(0)).oldHolder.itemView, local2, this.mRemoveDuration);
      }
      if (m == 0) {
        break label493;
      }
      localArrayList3 = new ArrayList();
      localArrayList3.addAll(this.mPendingAdditions);
      this.mAdditionsList.add(localArrayList3);
      this.mPendingAdditions.clear();
      local3 = new Runnable()
      {
        public final void run()
        {
          Iterator localIterator = localArrayList3.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localIterator.next();
            DefaultItemAnimator localDefaultItemAnimator = DefaultItemAnimator.this;
            ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(localViewHolder.itemView);
            localDefaultItemAnimator.mAddAnimations.add(localViewHolder);
            localViewPropertyAnimatorCompat.alpha(1.0F).setDuration(localDefaultItemAnimator.mAddDuration).setListener(new DefaultItemAnimator.5(localDefaultItemAnimator, localViewHolder, localViewPropertyAnimatorCompat)).start();
          }
          localArrayList3.clear();
          DefaultItemAnimator.this.mAdditionsList.remove(localArrayList3);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label513;
      }
      if (i == 0) {
        break label495;
      }
      l1 = this.mRemoveDuration;
      if (j == 0) {
        break label501;
      }
      l2 = this.mMoveDuration;
      label433:
      if (k == 0) {
        break label507;
      }
    }
    label485:
    label493:
    label495:
    label501:
    label507:
    for (long l3 = this.mChangeDuration;; l3 = 0L)
    {
      long l4 = l1 + Math.max(l2, l3);
      ViewCompat.postOnAnimationDelayed(((RecyclerView.ViewHolder)localArrayList3.get(0)).itemView, local3, l4);
      return;
      local1.run();
      break label268;
      local2.run();
      break label348;
      break;
      l1 = 0L;
      break label423;
      l2 = 0L;
      break label433;
    }
    label513:
    local3.run();
  }
  
  private static final class ChangeInfo
  {
    public int fromX;
    public int fromY;
    public RecyclerView.ViewHolder newHolder;
    public RecyclerView.ViewHolder oldHolder;
    public int toX;
    public int toY;
    
    private ChangeInfo(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
    {
      this.oldHolder = paramViewHolder1;
      this.newHolder = paramViewHolder2;
    }
    
    private ChangeInfo(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramViewHolder1, paramViewHolder2);
      this.fromX = paramInt1;
      this.fromY = paramInt2;
      this.toX = paramInt3;
      this.toY = paramInt4;
    }
    
    public final String toString()
    {
      return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
    }
  }
  
  private static final class MoveInfo
  {
    public int fromX;
    public int fromY;
    public RecyclerView.ViewHolder holder;
    public int toX;
    public int toY;
    
    private MoveInfo(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.holder = paramViewHolder;
      this.fromX = paramInt1;
      this.fromY = paramInt2;
      this.toX = paramInt3;
      this.toY = paramInt4;
    }
  }
  
  private static class VpaListenerAdapter
    implements ViewPropertyAnimatorListener
  {
    public void onAnimationCancel(View paramView) {}
    
    public void onAnimationEnd(View paramView) {}
    
    public void onAnimationStart(View paramView) {}
  }
}


/* Location:           F:\apktool\apktool\Google_Play_Store6.0.5\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator
 * JD-Core Version:    0.7.0.1
 */