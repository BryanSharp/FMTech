package gen_binder;

import android.content.Context;
import com.google.android.apps.common.proguard.UsedByReflection;
import java.util.HashMap;
import kak;
import mbb;
import mbk;

@UsedByReflection
public final class com$google$android$libraries$social$profile$viewer$header$ProfileHeaderModule
  implements mbk
{
  private HashMap<String, Integer> a;
  
  public final void a(Context paramContext, Class<?> paramClass, mbb parammbb)
  {
    if (this.a == null)
    {
      this.a = new HashMap(3);
      this.a.put(kak.a, Integer.valueOf(0));
      this.a.put(kak.b, Integer.valueOf(1));
      this.a.put(kak.c, Integer.valueOf(2));
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
      kak.a(paramContext, parammbb);
      return;
    case 1: 
      kak.b(paramContext, parammbb);
      return;
    }
    kak.c(paramContext, parammbb);
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     gen_binder.com.google.android.libraries.social.profile.viewer.header.ProfileHeaderModule
 * JD-Core Version:    0.7.0.1
 */