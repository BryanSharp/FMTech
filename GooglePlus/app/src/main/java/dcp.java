import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

public final class dcp
  implements ibz
{
  private final Context a;
  
  public dcp(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final ica a(Intent paramIntent)
  {
    if (!"com.google.android.apps.plus.LOCATION_PLUS_SETTINGS".equals(paramIntent.getAction())) {
      return null;
    }
    Parcelable localParcelable = paramIntent.getParcelableExtra("account");
    if ((localParcelable instanceof Account))
    {
      paramIntent.setPackage(this.a.getPackageName());
      ((fpo)mbb.a(this.a, fpo.class)).a(this.a, paramIntent, new fpp(((Account)localParcelable).name, null));
      return new dcr();
    }
    return new dcq();
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     dcp
 * JD-Core Version:    0.7.0.1
 */