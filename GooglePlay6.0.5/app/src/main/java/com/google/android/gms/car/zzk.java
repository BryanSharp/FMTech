package com.google.android.gms.car;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzk
  implements Parcelable.Creator<CarMediaBrowserListNode>
{
  static void zza(CarMediaBrowserListNode paramCarMediaBrowserListNode, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzH(paramParcel, 20293);
    zzb.zza$377a007(paramParcel, 1, paramCarMediaBrowserListNode.list, paramInt);
    zzb.zzc(paramParcel, 1000, paramCarMediaBrowserListNode.mVersionCode);
    zzb.zzc(paramParcel, 2, paramCarMediaBrowserListNode.start);
    zzb.zzc(paramParcel, 3, paramCarMediaBrowserListNode.total);
    zzb.zza$2d7953c6(paramParcel, 4, paramCarMediaBrowserListNode.songs, paramInt);
    zzb.zzI(paramParcel, i);
  }
}


/* Location:           F:\apktool\apktool\Google_Play_Store6.0.5\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.car.zzk
 * JD-Core Version:    0.7.0.1
 */