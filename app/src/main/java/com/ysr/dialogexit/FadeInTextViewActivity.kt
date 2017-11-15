package com.ysr.dialogexit

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_fade_in_text_view.*


class FadeInTextViewActivity : AppCompatActivity() {
    var animaition: AnimationDrawable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fade_in_text_view)
//        fadeintext.text="fesaszgdrgxdgrxdgdrgxdrgdxrdawdwadaZ金佛iaSJEFoIJfioJfiojasIOFdawdwadaZ金佛iaSJEFoIJfioJfiojasIOFdawdwadaZ金佛iaSJEFoIJfioJfiojasIOFdawdwadaZ金佛iaSJEFoIJfioJfiojasIOFdawdwadaZ金佛iaSJEFoIJfioJfiojasIOF 费AS【as9jfzs[jifizsejfzsiojefzsoijfezsoijfgd"
        fadeintext.setTextString("房屋色粉战神联盟孤芳自赏干劲十足晓得不晓得分钟收费")
        fadeintext.startFadeInAnimation()
        fadeintext.setTextAnimationListener { Log.e("animationFinish", "animationFinish") }
        imageView2.setBackgroundResource(R.drawable.gift_open)
        animaition = imageView2.background as AnimationDrawable
        animaition!!.start()
    }
}
