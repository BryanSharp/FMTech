public final class nwa
  extends qan<nwa>
{
  public nwm a = null;
  public nvz[] b = nvz.b();
  
  public nwa()
  {
    this.aj = null;
    this.ak = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    if (this.a != null)
    {
      nwm localnwm = this.a;
      int i1 = qal.d(8);
      int i2 = localnwm.a();
      localnwm.ak = i2;
      i += i1 + (i2 + qal.d(i2));
    }
    if ((this.b != null) && (this.b.length > 0))
    {
      int j = i;
      for (int k = 0; k < this.b.length; k++)
      {
        nvz localnvz = this.b[k];
        if (localnvz != null)
        {
          int m = qal.d(16);
          int n = localnvz.a();
          localnvz.ak = n;
          j += m + (n + qal.d(n));
        }
      }
      i = j;
    }
    return i;
  }
  
  public final void a(qal paramqal)
  {
    if (this.a != null)
    {
      nwm localnwm = this.a;
      paramqal.c(10);
      if (localnwm.ak < 0) {
        localnwm.ak = localnwm.a();
      }
      paramqal.c(localnwm.ak);
      localnwm.a(paramqal);
    }
    if ((this.b != null) && (this.b.length > 0)) {
      for (int i = 0; i < this.b.length; i++)
      {
        nvz localnvz = this.b[i];
        if (localnvz != null)
        {
          paramqal.c(18);
          if (localnvz.ak < 0) {
            localnvz.ak = localnvz.a();
          }
          paramqal.c(localnvz.ak);
          localnvz.a(paramqal);
        }
      }
    }
    super.a(paramqal);
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     nwa
 * JD-Core Version:    0.7.0.1
 */