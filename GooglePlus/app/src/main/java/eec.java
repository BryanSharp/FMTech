import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;

public abstract class eec
  extends Binder
  implements eeb
{
  public eec()
  {
    attachInterface(this, "com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
    if (paramParcel1.readInt() != 0) {}
    for (Status localStatus = (Status)Status.CREATOR.createFromParcel(paramParcel1);; localStatus = null)
    {
      a(localStatus);
      return true;
    }
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     eec
 * JD-Core Version:    0.7.0.1
 */