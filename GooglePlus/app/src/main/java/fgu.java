import android.os.Binder;
import android.os.Parcel;

public abstract class fgu
  extends Binder
  implements fgt
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
    a(fjr.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     fgu
 * JD-Core Version:    0.7.0.1
 */