package com.google.android.apps.plus.settings;

import aaw;
import android.os.Bundle;
import android.view.MenuItem;
import dnw;
import doi;
import efj;
import git;
import gjp;
import gpl;
import gpm;
import gpq;
import gpr;
import idy;
import java.util.ArrayList;
import lzw;
import mbb;
import mbp;
import tp;

public class ContactsSettingsActivity
  extends mbp
  implements gpq
{
  public ContactsSettingsActivity()
  {
    gjp localgjp = new gjp(this, this.n);
    this.m.a(git.class, localgjp);
    new idy(this, this.n, "android_settings_gmh");
    new lzw(this, this.n);
    new dnw(this, this, this.n);
  }
  
  protected final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    gpm localgpm = new gpm(this, this.n, efj.wT);
    this.m.a(gpl.class, localgpm);
    if (localgpm.b.contains(this)) {
      throw new IllegalStateException("Attempt to add ActionBarListener twice");
    }
    localgpm.b.add(this);
    localgpm.c();
    ((gpm)localgpm);
  }
  
  public final void a(gpr paramgpr)
  {
    paramgpr.a(aaw.b, new doi());
  }
  
  public final void a(tp paramtp) {}
  
  public final boolean a(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public final void b(tp paramtp) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(efj.tl);
  }
}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     com.google.android.apps.plus.settings.ContactsSettingsActivity
 * JD-Core Version:    0.7.0.1
 */