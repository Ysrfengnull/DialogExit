package com.ysr.dialogexit.view.floatbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.ysr.dialogexit.R;


/**
 *悬浮球展开菜单
 * @author thm
 */
public class FloatItems extends LinearLayout {

    public FloatItems(Context context) {
        super(context);
        init();
    }

    public FloatItems(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_float_items, this);
    }

}
