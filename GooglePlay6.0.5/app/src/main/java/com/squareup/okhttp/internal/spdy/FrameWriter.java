package com.squareup.okhttp.internal.spdy;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import okio.Buffer;

public abstract interface FrameWriter
  extends Closeable
{
  public abstract void ackSettings(Settings paramSettings)
    throws IOException;
  
  public abstract void connectionPreface()
    throws IOException;
  
  public abstract void data(boolean paramBoolean, int paramInt1, Buffer paramBuffer, int paramInt2)
    throws IOException;
  
  public abstract void flush()
    throws IOException;
  
  public abstract void goAway(int paramInt, ErrorCode paramErrorCode, byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract int maxDataLength();
  
  public abstract void ping(boolean paramBoolean, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void rstStream(int paramInt, ErrorCode paramErrorCode)
    throws IOException;
  
  public abstract void settings(Settings paramSettings)
    throws IOException;
  
  public abstract void synStream(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<Header> paramList)
    throws IOException;
  
  public abstract void windowUpdate(int paramInt, long paramLong)
    throws IOException;
}


/* Location:           F:\apktool\apktool\Google_Play_Store6.0.5\classes-dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.internal.spdy.FrameWriter
 * JD-Core Version:    0.7.0.1
 */