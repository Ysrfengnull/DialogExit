package com.ysr.dialogexit.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.ysr.dialogexit.utils.FloatUtil;

/**
 * @author yangshirong
 * @data 2017/12/22
 * 邮箱 yangshirong@log56.com
 */

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FloatUtil.getInstance().addActivity(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        FloatUtil.getInstance().showFloatView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        FloatUtil.getInstance().stopHandler(this);
    }

    @Override
    public void finish(){
        super.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FloatUtil.getInstance().removeActivity(this);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

}
