public final class nsb
  extends qan<nsb>
{
  private static volatile nsb[] a;
  private String b = null;
  
  public nsb()
  {
    this.aj = null;
    this.ak = -1;
  }
  
  public static nsb[] b()
  {
    if (a == null) {}
    synchronized (qar.a)
    {
      if (a == null) {
        a = new nsb[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int i = super.a();
    if (this.b != null)
    {
      String str = this.b;
      int j = qal.d(8);
      int k = qal.a(str);
      i += j + (k + qal.d(k));
    }
    return i;
  }
  
  public final void a(qal paramqal)
  {
    if (this.b != null)
    {
      String str = this.b;
      paramqal.c(10);
      paramqal.a(str);
    }
    super.a(paramqal);
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     nsb
 * JD-Core Version:    0.7.0.1
 */