package com.ysr.dialogexit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    protected static final int UI = 100;
    protected static final int UIEND = 101;
    private String TextDemo = "恭喜您！收到一封感谢信。。。";
    private TextView text;
    private ImageView iv_msg;
    private Context mContext;
    private char[] charArrays;
    //    private String len = "";
    ForegroundColorSpan redSpan;
    SpannableStringBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        text = (TextView) findViewById(R.id.cTextView);
        iv_msg = (ImageView) findViewById(R.id.iv_msg);
        text.setText(TextDemo);

        builder = new SpannableStringBuilder(text.getText().toString());
        redSpan = new ForegroundColorSpan(Color.rgb(255, 255, 255));
        new Thread() {
            public void run() {
                try {
                    charArrays = TextDemo.toCharArray();
                    for (int i = 0; i <= charArrays.length; i++) {
                        builder.setSpan(redSpan, 0, i, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//                        len = charArrays[i] + "";
                        handler.sendEmptyMessage(UI);
                        sleep(200);
                    }
                    handler.sendEmptyMessage(UIEND);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case UI:
//                    text.append(len);
                    text.setText(builder);
                    break;
                case UIEND:
                    //抖动效果
//                    Animation shake = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
//                    shake.setAnimationListener(new Animation.AnimationListener() {
//                        @Override
//                        public void onAnimationStart(Animation animation) {
//
//                        }
//
//                        @Override
//                        public void onAnimationEnd(Animation animation) {
//                            Log.e("onAnimationEnd", "onAnimationEnd");
//
//
//                        }
//
//                        @Override
//                        public void onAnimationRepeat(Animation animation) {
//
//                        }
//                    });
                     /*
                参数解释：
                    第一个参数：X轴水平缩放起始位置的大小（fromX）。1代表正常大小
                    第二个参数：X轴水平缩放完了之后（toX）的大小，0代表完全消失了
                    第三个参数：Y轴垂直缩放起始时的大小（fromY）
                    第四个参数：Y轴垂直缩放结束后的大小（toY）
                    第五个参数：pivotXType为动画在X轴相对于物件位置类型
                    第六个参数：pivotXValue为动画相对于物件的X坐标的开始位置
                    第七个参数：pivotXType为动画在Y轴相对于物件位置类型
                    第八个参数：pivotYValue为动画相对于物件的Y坐标的开始位置

                   （第五个参数，第六个参数），（第七个参数,第八个参数）是用来指定缩放的中心点
                    0.5f代表从中心缩放
             */
//                    AnimationSet aset_3 = new AnimationSet(true);
////                    ScaleAnimation aa_3 = new ScaleAnimation(1, 0.9f, 1, 0.9f,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//                    ScaleAnimation aa_3 = new ScaleAnimation(1, 1, 0, 1, Animation.RELATIVE_TO_SELF, 1, Animation.RELATIVE_TO_SELF, 1);
////                    aa_3.setRepeatCount(2);
//                    aa_3.setDuration(1000);
//                    aset_3.addAnimation(aa_3);
//
//                    iv_msg.setImageResource(R.mipmap.daxie_normal);
//                    iv_msg.setVisibility(View.VISIBLE);
//                    iv_msg.startAnimation(aa_3);


//                    iv_msg.setImageResource(R.mipmap.daxie_normal);
//                    iv_msg.setVisibility(View.VISIBLE);
//                    iv_msg.startAnimation(shake);

                    break;

                default:
                    break;
            }
        }

    };

    @Override
    protected void onResume() {
        super.onResume();
       
}

    @Override
    protected void onPause() {
        super.onPause();


    }
}
