package com.mpfa.empf.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * ==================================================================
 * Copyright (C) 2015 Mtelnet All Rights Reserved.
 *
 * @author Drew.Chiang
 * @version v1.0.0
 * @email chiangchuna@gmail.com
 * @create_date 2015/12/16 11:06
 * @description ${todo}
 * <p/>
 * Modification History:
 * Date            Author            Version         Description
 * -----------------------------------------------------------------
 * 2015/12/16 11:06  Drew.Chiang       v1.0.0          create
 * <p/>
 * ==================================================================
 */

public class SplashActivity extends BaseActivity {

    private final static int MSG_TO_LANGUAGE_PAGE = 1;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == MSG_TO_LANGUAGE_PAGE){
                Intent intent = new Intent(SplashActivity.this, SelectLanguageActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.mpfa.empf.R.layout.activity_splash);
        mHandler.sendEmptyMessageDelayed(MSG_TO_LANGUAGE_PAGE, 3000);
    }
}
