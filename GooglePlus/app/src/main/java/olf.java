public final class olf
  extends qan<olf>
{
  private String a = null;
  private String b = null;
  
  public olf()
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
    super.a(paramqal);
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     olf
 * JD-Core Version:    0.7.0.1
 */