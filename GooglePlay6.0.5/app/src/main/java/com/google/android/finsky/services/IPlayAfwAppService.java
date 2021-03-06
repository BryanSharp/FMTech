package com.google.android.finsky.services;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IPlayAfwAppService
  extends IInterface
{
  public abstract Bundle validateWorkPackageByPlay(String paramString)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IPlayAfwAppService
  {
    public Stub()
    {
      attachInterface(this, "com.google.android.finsky.services.IPlayAfwAppService");
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.finsky.services.IPlayAfwAppService");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.finsky.services.IPlayAfwAppService");
      Bundle localBundle = validateWorkPackageByPlay(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(1);
      localBundle.writeToParcel(paramParcel2, 1);
      return true;
    }
  }
}


/* Location:           F:\apktool\apktool\Google_Play_Store6.0.5\classes-dex2jar.jar
 * Qualified Name:     com.google.android.finsky.services.IPlayAfwAppService
 * JD-Core Version:    0.7.0.1
 */