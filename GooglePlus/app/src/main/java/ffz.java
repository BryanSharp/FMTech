import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class ffz
  extends Binder
  implements ffy
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      ffs localffs = a();
      paramParcel2.writeNoException();
      IBinder localIBinder2 = null;
      if (localffs != null) {
        localIBinder2 = localffs.asBinder();
      }
      paramParcel2.writeStrongBinder(localIBinder2);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      int j = paramParcel1.readInt();
      Bundle localBundle2 = null;
      if (j != 0) {
        localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      a(localBundle2);
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      b();
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      c();
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      d();
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      e();
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      int i = paramParcel1.readInt();
      Bundle localBundle1 = null;
      if (i != 0) {
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      b(localBundle1);
      paramParcel2.writeNoException();
      if (localBundle1 != null)
      {
        paramParcel2.writeInt(1);
        localBundle1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      euz localeuz = f();
      paramParcel2.writeNoException();
      IBinder localIBinder1 = null;
      if (localeuz != null) {
        localIBinder1 = localeuz.asBinder();
      }
      paramParcel2.writeStrongBinder(localIBinder1);
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
    a(fin.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     ffz
 * JD-Core Version:    0.7.0.1
 */