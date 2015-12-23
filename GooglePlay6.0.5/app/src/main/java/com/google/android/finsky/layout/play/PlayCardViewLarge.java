package com.google.android.finsky.layout.play;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.play.layout.PlayCardViewBase;

public class PlayCardViewLarge
  extends PlayCardViewBase
{
  public PlayCardViewLarge(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PlayCardViewLarge(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getCardType()
  {
    return 11;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    measureThumbnailSpanningWidth(paramInt1);
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           F:\apktool\apktool\Google_Play_Store6.0.5\classes-dex2jar.jar
 * Qualified Name:     com.google.android.finsky.layout.play.PlayCardViewLarge
 * JD-Core Version:    0.7.0.1
 */