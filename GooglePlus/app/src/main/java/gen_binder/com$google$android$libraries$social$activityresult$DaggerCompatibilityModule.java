package gen_binder;

import android.content.Context;
import com.google.android.apps.common.proguard.UsedByReflection;
import guv;
import java.util.HashMap;
import mbb;
import mbk;

@UsedByReflection
public final class com$google$android$libraries$social$activityresult$DaggerCompatibilityModule
  implements mbk
{
  private HashMap<String, Integer> a;
  
  public final void a(Context paramContext, Class<?> paramClass, mbb parammbb)
  {
    if (this.a == null)
    {
      this.a = new HashMap(1);
      this.a.put(guv.a, Integer.valueOf(0));
    }
    Integer localInteger = (Integer)this.a.get(paramClass.getName());
    if (localInteger == null) {
      return;
    }
    switch (localInteger.intValue())
    {
    default: 
      return;
    }
    guv.a(parammbb);
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     gen_binder.com.google.android.libraries.social.activityresult.DaggerCompatibilityModule
 * JD-Core Version:    0.7.0.1
 */