public final class nfq
  extends qan<nfq>
{
  public nej a = null;
  public String b = null;
  private nee c = null;
  
  static
  {
    new qao(11, nfq.class, (int)495639866L, false);
  }
  
  public nfq()
  {
    this.aj = null;
    this.ak = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    if (this.a != null)
    {
      nej localnej = this.a;
      int i1 = qal.d(8);
      int i2 = localnej.a();
      localnej.ak = i2;
      i += i1 + (i2 + qal.d(i2));
    }
    if (this.b != null)
    {
      String str = this.b;
      int m = qal.d(16);
      int n = qal.a(str);
      i += m + (n + qal.d(n));
    }
    if (this.c != null)
    {
      nee localnee = this.c;
      int j = qal.d(24);
      int k = localnee.a();
      localnee.ak = k;
      i += j + (k + qal.d(k));
    }
    return i;
  }
  
  public final void a(qal paramqal)
  {
    if (this.a != null)
    {
      nej localnej = this.a;
      paramqal.c(10);
      if (localnej.ak < 0) {
        localnej.ak = localnej.a();
      }
      paramqal.c(localnej.ak);
      localnej.a(paramqal);
    }
    if (this.b != null)
    {
      String str = this.b;
      paramqal.c(18);
      paramqal.a(str);
    }
    if (this.c != null)
    {
      nee localnee = this.c;
      paramqal.c(26);
      if (localnee.ak < 0) {
        localnee.ak = localnee.a();
      }
      paramqal.c(localnee.ak);
      localnee.a(paramqal);
    }
    super.a(paramqal);
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     nfq
 * JD-Core Version:    0.7.0.1
 */