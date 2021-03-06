package com.google.android.finsky.layout.play;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.play.cardview.CardViewGroupDelegate;
import com.google.android.play.layout.PlayCardLabelView;
import com.google.android.play.layout.PlayCardViewMedium;

public class PlayCardViewBundleItemMedium
  extends PlayCardViewMedium
  implements PlayCardViewBundleItem
{
  private int mCardType;
  
  public PlayCardViewBundleItemMedium(Context paramContext)
  {
    super(paramContext);
  }
  
  public PlayCardViewBundleItemMedium(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getCardType()
  {
    return this.mCardType;
  }
  
  public CardViewGroupDelegate getCardViewGroupDelegate()
  {
    return FlatCardViewGroupDelegate.INSTANCE;
  }
  
  public final void hideLabelIfNotOwned()
  {
    if ((!this.mIsItemOwned) && (this.mLabel != null)) {
      this.mLabel.setVisibility(8);
    }
  }
  
  public void setCardType(int paramInt)
  {
    this.mCardType = paramInt;
  }
}


/* Location:           F:\apktool\apktool\Google_Play_Store6.0.5\classes-dex2jar.jar
 * Qualified Name:     com.google.android.finsky.layout.play.PlayCardViewBundleItemMedium
 * JD-Core Version:    0.7.0.1
 */