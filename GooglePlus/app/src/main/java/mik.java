public final class mik
  extends qan<mik>
{
  private static volatile mik[] b;
  public int a = -2147483648;
  
  public mik()
  {
    this.aj = null;
    this.ak = -1;
  }
  
  public static mik[] b()
  {
    if (b == null) {}
    synchronized (qar.a)
    {
      if (b == null) {
        b = new mik[0];
      }
      return b;
    }
  }
  
  protected final int a()
  {
    int i = super.a();
    if (this.a != -2147483648)
    {
      int j = this.a;
      int k = qal.d(8);
      if (j >= 0) {}
      for (int m = qal.d(j);; m = 10) {
        return i + (m + k);
      }
    }
    return i;
  }
  
  public final void a(qal paramqal)
  {
    if (this.a != -2147483648)
    {
      int i = this.a;
      paramqal.c(8);
      paramqal.a(i);
    }
    super.a(paramqal);
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     mik
 * JD-Core Version:    0.7.0.1
 */