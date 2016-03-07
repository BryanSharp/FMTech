package com.mpfa.empf;

import android.app.Application;

import com.mpfa.empf.utils.PreferenceUtils;

/**
 * ==================================================================
 * Copyright (C) 2016 Mtelnet All Rights Reserved.
 *
 * @author Drew.Chiang
 * @version v1.0.0
 * @email chiangchuna@gmail.com
 * @create_date 2016/1/5 14:34
 * @description ${todo}
 * <p/>
 * Modification History:
 * Date            Author            Version         Description
 * -----------------------------------------------------------------
 * 2016/1/5 14:34  Drew.Chiang       v1.0.0          create
 * <p/>
 * ==================================================================
 */

public class FMApplication extends Application{

    private static FMApplication mContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        PreferenceUtils.init(mContext);
    }

    public static FMApplication getApplication(){
        return mContext;
    }


}
