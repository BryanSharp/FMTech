package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface ILicenseResultListener
  extends IInterface
{
  public abstract void verifyLicense(int paramInt, String paramString1, String paramString2)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements ILicenseResultListener
  {
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.android.vending.licensing.ILicenseResultListener");
        return true;
      }
      paramParcel1.enforceInterface("com.android.vending.licensing.ILicenseResultListener");
      verifyLicense(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      return true;
    }
    
    private static final class Proxy
      implements ILicenseResultListener
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final void verifyLicense(int paramInt, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.android.vending.licensing.ILicenseResultListener");
          localParcel.writeInt(paramInt);
          localParcel.writeString(paramString1);
          localParcel.writeString(paramString2);
          this.mRemote.transact(1, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}


/* Location:           F:\apktool\apktool\Google_Play_Store6.0.5\classes-dex2jar.jar
 * Qualified Name:     com.android.vending.licensing.ILicenseResultListener
 * JD-Core Version:    0.7.0.1
 */