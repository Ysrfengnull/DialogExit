package com.ysr.dialogexit;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ysr.dialogexit.utils.GuideView2;
import com.ysr.dialogexit.view.BadgeView;

import java.io.IOException;

import pl.droidsonroids.gif.AnimationListener;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends Activity {
    protected static final int UI = 100;
    protected static final int UIEND = 101;
    protected static final int PLAYGIF = 102;
    protected static final int DELETEView = 103;
    private String TextDemo = "恭喜您！收到一封感谢信。。。";
    private TextView text, tvEnd;
    private ImageView iv_msg;
    private GifImageView giv;
    private Context mContext;
    private char[] charArrays;
    private RelativeLayout rl_base;
    //    private String len = "";
    private ForegroundColorSpan redSpan;
    private SpannableStringBuilder builder;
    private PathMeasure mPathMeasure;
    private float[] mCurrentPosition = new float[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mContext = this;
        text = (TextView) findViewById(R.id.cTextView);
        tvEnd = (TextView) findViewById(R.id.tvEnd);
        iv_msg = (ImageView) findViewById(R.id.iv_msg);
        giv = (GifImageView) findViewById(R.id.giv);
        rl_base = (RelativeLayout) findViewById(R.id.rl_base);
        text.setText(TextDemo);
        String[] values = new String[3];


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


        TextView iv = new TextView(this);
        new GuideView2.Builder(this)
                .setTargetView(tvEnd)    // 必须调用，设置需要Guide的View
                .setCustomGuideView(iv)  // 必须调用，设置GuideView
                // 设置GuideView 相对于TargetView的位置，默认在屏幕左上角
                .setDirction(GuideView2.Direction.LEFT_BOTTOM)
                .setRadius(32)          // 设置圆形透明区域半径，默认是targetView的显示矩形的半径
                .setCenter(300, 300)    // 设置圆心，默认是targetView的中心
                .setOffset(200, 60)     // 设置偏移，一般用于微调GuideView的位置
                .showOnce()             // 设置首次显示，设置后，显示一次后，不再显示
                .build()                // 必须调用，Buider模式，返回GuideView实例
                .show();
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
                    Animation shake = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
                    shake.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Log.e("onAnimationEnd", "onAnimationEnd");
                            handler.sendEmptyMessage(PLAYGIF);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
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


                    iv_msg.setImageResource(R.mipmap.daxie_normal);
                    iv_msg.setVisibility(View.VISIBLE);
                    iv_msg.startAnimation(shake);

//                    Glide.with(MainActivity.this).load(R.mipmap.ganxiexin_open).asGif().into(iv_msg);

                    break;
                case PLAYGIF:
//                    Glide.with(MainActivity.this)
//                            .load(R.mipmap.ganxiexin_open)
//                            .placeholder(R.mipmap.daxie_normal)
//                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                            .listener(new RequestListener<Integer, GlideDrawable>() {
//
//                                @Override
//                                public boolean onException(Exception arg0, Integer arg1,
//                                                           Target<GlideDrawable> arg2, boolean arg3) {
//                                    return false;
//                                }
//
//                                @Override
//                                public boolean onResourceReady(GlideDrawable resource,
//                                                               Integer model, Target<GlideDrawable> target,
//                                                               boolean isFromMemoryCache, boolean isFirstResource) {
//                                    int duration=0;
//                                    // 计算动画时长
//                                    GifDrawable drawable = (GifDrawable) resource;
//                                    GifDecoder decoder = drawable.getDecoder();
//                                    for (int i = 0; i < drawable.getFrameCount(); i++) {
//                                        duration += decoder.getDelay(i);
//                                    }
//                                    Log.e("duration==", "" + duration);
////                                    handler.sendEmptyMessageDelayed(DELETEView, duration+300);
//                                    resource.setLoopCount(1);
//                                    resource.start();
//                                    return false;
//                                }
//                            }) //仅仅加载一次gif动画
////                            .into(iv_msg);
//                            .into(new GlideDrawableImageViewTarget(iv_msg, 1));

                    final Resources resources = getResources();
                    final String resourceTypeName = resources.getResourceTypeName(R.mipmap.ganxiexin_open);
                    try {
                        GifDrawable gifPath = new GifDrawable(resources, R.mipmap.ganxiexin_open);
                        gifPath.setLoopCount(1);
                        gifPath.addAnimationListener(new AnimationListener() {
                            @Override
                            public void onAnimationCompleted(int i) {
                                Log.e("wangcheng", "wangcheng" + i);
                                addCart();
                            }
                        });
                        giv.setImageDrawable(gifPath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    break;
                case DELETEView:
                    iv_msg.setVisibility(View.GONE);
                    break;
                default:
                    break;
            }
        }

    };

    private void addCart() {
        //图片缩放使用 picwidth,picheight来控制
//        final ScaleAnimation animation = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f,
//                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        animation.setDuration(6000);//设置动画持续时间
//        final RotateAnimation animation2 =new RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,
//                0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//        animation2.setDuration(6000);
//        iv_msg.startAnimation(animation);
//        iv_msg.startAnimation(animation2);
        iv_msg.setVisibility(View.INVISIBLE);

        int parent[] = new int[2];
        rl_base.getLocationInWindow(parent);
        Log.e("tag", parent[0] + "@" + parent[1]);
        int startLoc[] = new int[2];
        iv_msg.getLocationInWindow(startLoc);

        Log.e("wangcheng", "图片各个角Left：" + iv_msg.getLeft() + "Right：" + iv_msg.getRight() + "Top：" + iv_msg.getTop() + "Bottom：" + iv_msg.getBottom());


        int endLoc[] = new int[2];
        tvEnd.getLocationInWindow(endLoc);
        final ImageView goods = new ImageView(getApplicationContext());
        goods.setImageDrawable(iv_msg.getDrawable());
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(200, 200);
//        RelativeLayout.LayoutParams params =
//                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
//                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams params =
                new RelativeLayout.LayoutParams(iv_msg.getDrawable().getMinimumWidth() / 2, iv_msg.getDrawable().getMinimumHeight() / 2);
//        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
//        params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        rl_base.addView(goods, params);
//        rl_base.addView(goods);

        float startX = startLoc[0];
        float startY = startLoc[1] - parent[1];
        float toX = endLoc[0] + tvEnd.getWidth() / 3;
        float toY = endLoc[1];


        Path path = new Path();
        path.moveTo(startX, startY);
        path.quadTo((startX + toX) / 2, startY, toX, toY);
        mPathMeasure = new PathMeasure(path, false);


        //属性动画实现
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, mPathMeasure.getLength());
        valueAnimator.setDuration(1000);
        // 匀速插值器
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (Float) animation.getAnimatedValue();
                // 获取当前点坐标封装到mCurrentPosition
                mPathMeasure.getPosTan(value, mCurrentPosition, null);
                goods.setTranslationX(mCurrentPosition[0]);
                goods.setTranslationY(mCurrentPosition[1]);
            }
        });
        valueAnimator.start();


        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.e("wangcheng", "animation结束");
                BadgeView badgeView = new BadgeView(mContext);
                badgeView.setTargetView(tvEnd);
                badgeView.setText("");
                startActivity(new Intent(MainActivity.this, MainLookActivity.class));
//                badgeView.hide();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });


    }

    public void setSharedPreference(String key, String[] values) {
        String regularEx = "#";
        String str = "";
        SharedPreferences sp = mContext.getSharedPreferences("data", Context.MODE_PRIVATE);
        if (values != null && values.length > 0) {
            for (String value : values) {
                str += value;
                str += regularEx;
            }
            Editor et = sp.edit();
            et.putString(key, str);
            et.commit();
        }
    }
    public String[] getSharedPreference(String key) {
        String regularEx = "#";
        String[] str = null;
        SharedPreferences sp = mContext.getSharedPreferences("data", Context.MODE_PRIVATE);
        String values;
        values = sp.getString(key, "");
        str = values.split(regularEx);

        return str;
    }
    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();


    }

}
