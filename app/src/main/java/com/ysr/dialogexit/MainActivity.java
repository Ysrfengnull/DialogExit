package com.ysr.dialogexit;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    protected static final int UI = 100;
    protected static final int UIEND = 101;
    private String TextDemo = "恭喜您！收到一封感谢信。。。";
    private TextView text;
    private ImageView iv_msg;
    private char[] charArrays;
    //    private String len = "";
    ForegroundColorSpan redSpan;
    SpannableStringBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                    Animation shake = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
                    shake.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Log.e("onAnimationEnd", "onAnimationEnd");


                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    iv_msg.setImageResource(R.mipmap.daxie_normal);
                    iv_msg.startAnimation(shake);
                    break;

                default:
                    break;
            }
        }

    };
}
