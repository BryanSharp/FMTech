public final class ndx
  extends qan<ndx>
{
  public String a = null;
  public ndr b = null;
  private ndv c = null;
  
  public ndx()
  {
    this.aj = null;
    this.ak = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    if (this.a != null)
    {
      String str = this.a;
      int i1 = qal.d(8);
      int i2 = qal.a(str);
      i += i1 + (i2 + qal.d(i2));
    }
    if (this.c != null)
    {
      ndv localndv = this.c;
      int m = qal.d(16);
      int n = localndv.a();
      localndv.ak = n;
      i += m + (n + qal.d(n));
    }
    if (this.b != null)
    {
      ndr localndr = this.b;
      int j = qal.d(24);
      int k = localndr.a();
      localndr.ak = k;
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
    if (this.c != null)
    {
      ndv localndv = this.c;
      paramqal.c(18);
      if (localndv.ak < 0) {
        localndv.ak = localndv.a();
      }
      paramqal.c(localndv.ak);
      localndv.a(paramqal);
    }
    if (this.b != null)
    {
      ndr localndr = this.b;
      paramqal.c(26);
      if (localndr.ak < 0) {
        localndr.ak = localndr.a();
      }
      paramqal.c(localndr.ak);
      localndr.a(paramqal);
    }
    super.a(paramqal);
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     ndx
 * JD-Core Version:    0.7.0.1
 */