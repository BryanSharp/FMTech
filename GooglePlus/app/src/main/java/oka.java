public final class oka
  extends qan<oka>
{
  private static volatile oka[] b;
  public String a = null;
  
  public oka()
  {
    this.aj = null;
    this.ak = -1;
  }
  
  public static oka[] b()
  {
    if (b == null) {}
    synchronized (qar.a)
    {
      if (b == null) {
        b = new oka[0];
      }
      return b;
    }
  }
  
  protected final int a()
  {
    int i = super.a();
    if (this.a != null)
    {
      String str = this.a;
      int j = qal.d(8);
      int k = qal.a(str);
      i += j + (k + qal.d(k));
    }
    return i;
  }
  
  public final void a(qal paramqal)
  {
    if (this.a != null)
    {
      String str = this.a;
      paramqal.c(10);
      paramqal.a(str);
    }
    super.a(paramqal);
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     oka
 * JD-Core Version:    0.7.0.1
 */