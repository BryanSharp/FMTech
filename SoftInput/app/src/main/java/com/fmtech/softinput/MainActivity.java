package com.fmtech.softinput;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity implements FMLinearLayout.OnSizeChangedListener {

    private FMLinearLayout mFMLinearLayout;
    private ScrollView mScrollView;
    private FrameLayout mTitleBar;
    private View mPaddingView;

    private int inputViewOffset = 0;
    private int keyboardHeight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_signup_step2);
        mFMLinearLayout = (FMLinearLayout)findViewById(R.id.container);
        mScrollView = (ScrollView) findViewById(R.id.scrollview);
        mTitleBar = (FrameLayout) findViewById(R.id.singup_navigator_step2);
        mPaddingView = findViewById(R.id.paddingView);

        mFMLinearLayout.setOnSizeChangedListener(this);
        mScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                mFMLinearLayout.getWindowVisibleDisplayFrame(r);
//                mScrollView.getWindowVisibleDisplayFrame(r);
                //getRootView ---Finds the topmost view in the current view hierarchy
                int containerHeight = mFMLinearLayout.getHeight();
                int screenHeight = mScrollView.getRootView().getHeight();
                //mInputView的top到rootView的top的差值
                keyboardHeight = containerHeight - (r.bottom - r.top);
//                int heightDifference = screenHeight - (r.bottom - r.top);
                /*if (inputViewOffset == 0) {
                    // 拿到inputView初始化高度
                    inputViewOffset = heightDifference;
                } else if (inputViewOffset != heightDifference) {//界面发生改变了
                    keyboardHeight = Math.abs(inputViewOffset - heightDifference);//最初的差值与改变后的差值即键盘的高度
//                    isShowKeyBord = true;
                    if(keyboardHeight > 100){
                        mPaddingView.getLayoutParams().height = keyboardHeight;
                    }else{
                        mPaddingView.getLayoutParams().height = 0;
                    }
                } else {
//                    isShowKeyBord = false;
                }*/

                System.out.println("-------mFMLinearLayout Height: " + mFMLinearLayout.getHeight());
                System.out.println("-------KeyBoardHeight: " + keyboardHeight);

//                mScrollView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                System.out.println("-------mScrollViewHeight1: "+mScrollView.getHeight());

                System.out.println("-------mScrollView Content Height: "+mScrollView.getChildAt(0).getHeight());

                if(keyboardHeight > 100){
                    mPaddingView.getLayoutParams().height = keyboardHeight;
                }else{
                    mPaddingView.getLayoutParams().height = 0;
                }
            }
        });

        mTitleBar.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
//                mScrollView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                System.out.println("-------mTitleBarHeight: "+mTitleBar.getHeight());
            }
        });
    }

    @Override
    public void sizeChanged(int widthDiff, int heightDiff) {
        System.out.println("-------heightDiff: "+heightDiff);
        System.out.println("-------mScrollViewHeight2: "+mScrollView.getHeight());
        System.out.println("-------mFMLinearLayout: "+mFMLinearLayout.getHeight());
    }
}
