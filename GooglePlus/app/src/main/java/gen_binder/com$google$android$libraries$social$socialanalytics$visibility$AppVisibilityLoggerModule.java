package gen_binder;

import android.content.Context;
import com.google.android.apps.common.proguard.UsedByReflection;
import java.util.HashMap;
import kui;
import mbb;
import mbk;

@UsedByReflection
public final class com$google$android$libraries$social$socialanalytics$visibility$AppVisibilityLoggerModule
  implements mbk
{
  private HashMap<String, Integer> a;
  
  public final void a(Context paramContext, Class<?> paramClass, mbb parammbb)
  {
    if (this.a == null)
    {
      this.a = new HashMap(2);
      this.a.put(kui.a, Integer.valueOf(0));
      this.a.put(kui.b, Integer.valueOf(1));
    }
    Integer localInteger = (Integer)this.a.get(paramClass.getName());
    if (localInteger == null) {
      return;
    }
    switch (localInteger.intValue())
    {
    default: 
      return;
    case 0: 
      kui.a(parammbb);
      return;
    }
    kui.b(parammbb);
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     gen_binder.com.google.android.libraries.social.socialanalytics.visibility.AppVisibilityLoggerModule
 * JD-Core Version:    0.7.0.1
 */