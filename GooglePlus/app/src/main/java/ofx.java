public final class ofx
  extends qan<ofx>
{
  private static volatile ofx[] a;
  private int b = -2147483648;
  private oqx c = null;
  
  public ofx()
  {
    this.aj = null;
    this.ak = -1;
  }
  
  public static ofx[] b()
  {
    if (a == null) {}
    synchronized (qar.a)
    {
      if (a == null) {
        a = new ofx[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int i = super.a();
    int i1;
    int i2;
    if (this.b != -2147483648)
    {
      int n = this.b;
      i1 = qal.d(8);
      if (n >= 0) {
        i2 = qal.d(n);
      }
    }
    for (int j = i + (i2 + i1);; j = i)
    {
      if (this.c != null)
      {
        oqx localoqx = this.c;
        int k = qal.d(16);
        int m = localoqx.a();
        localoqx.ak = m;
        j += k + (m + qal.d(m));
      }
      return j;
      i2 = 10;
      break;
    }
  }
  
  public final void a(qal paramqal)
  {
    if (this.b != -2147483648)
    {
      int i = this.b;
      paramqal.c(8);
      paramqal.a(i);
    }
    if (this.c != null)
    {
      oqx localoqx = this.c;
      paramqal.c(18);
      if (localoqx.ak < 0) {
        localoqx.ak = localoqx.a();
      }
      paramqal.c(localoqx.ak);
      localoqx.a(paramqal);
    }
    super.a(paramqal);
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     ofx
 * JD-Core Version:    0.7.0.1
 */