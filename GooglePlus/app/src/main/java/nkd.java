public final class nkd
  extends qan<nkd>
{
  private String a = null;
  private String b = null;
  private Long c = null;
  
  public nkd()
  {
    this.aj = null;
    this.ak = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    if (this.a != null)
    {
      String str2 = this.a;
      int m = qal.d(8);
      int n = qal.a(str2);
      i += m + (n + qal.d(n));
    }
    if (this.b != null)
    {
      String str1 = this.b;
      int j = qal.d(16);
      int k = qal.a(str1);
      i += j + (k + qal.d(k));
    }
    if (this.c != null)
    {
      long l = this.c.longValue();
      i += qal.d(24) + qal.b(l);
    }
    return i;
  }
  
  public final void a(qal paramqal)
  {
    if (this.a != null)
    {
      String str2 = this.a;
      paramqal.c(10);
      paramqal.a(str2);
    }
    if (this.b != null)
    {
      String str1 = this.b;
      paramqal.c(18);
      paramqal.a(str1);
    }
    if (this.c != null)
    {
      long l = this.c.longValue();
      paramqal.c(24);
      paramqal.a(l);
    }
    super.a(paramqal);
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     nkd
 * JD-Core Version:    0.7.0.1
 */