package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

public abstract class GsonInternalAccess
{
  public static GsonInternalAccess INSTANCE;
  
  public abstract <T> TypeAdapter<T> getNextAdapter(Gson paramGson, TypeAdapterFactory paramTypeAdapterFactory, TypeToken<T> paramTypeToken);
}


/* Location:           F:\apktool\apktool\Google_Play_Store6.0.5\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.GsonInternalAccess
 * JD-Core Version:    0.7.0.1
 */