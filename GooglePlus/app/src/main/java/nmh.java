import java.nio.ByteBuffer;

public final class nmh
  extends qan<nmh>
{
  private static volatile nmh[] a;
  private int b = -2147483648;
  private Boolean c = null;
  
  public nmh()
  {
    this.aj = null;
    this.ak = -1;
  }
  
  public static nmh[] b()
  {
    if (a == null) {}
    synchronized (qar.a)
    {
      if (a == null) {
        a = new nmh[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int i = super.a();
    int m;
    int n;
    if (this.b != -2147483648)
    {
      int k = this.b;
      m = qal.d(8);
      if (k >= 0) {
        n = qal.d(k);
      }
    }
    for (int j = i + (n + m);; j = i)
    {
      if (this.c != null)
      {
        this.c.booleanValue();
        j += 1 + qal.d(16);
      }
      return j;
      n = 10;
      break;
    }
  }
  
  public final void a(qal paramqal)
  {
    if (this.b != -2147483648)
    {
      int j = this.b;
      paramqal.c(8);
      paramqal.a(j);
    }
    if (this.c != null)
    {
      boolean bool = this.c.booleanValue();
      paramqal.c(16);
      if (bool) {}
      byte b1;
      for (int i = 1;; i = 0)
      {
        b1 = (byte)i;
        if (paramqal.a.hasRemaining()) {
          break;
        }
        throw new qam(paramqal.a.position(), paramqal.a.limit());
      }
      paramqal.a.put(b1);
    }
    super.a(paramqal);
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     nmh
 * JD-Core Version:    0.7.0.1
 */