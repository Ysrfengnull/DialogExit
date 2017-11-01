package com.ysr.dialogexit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.ysr.dialogexit.utils.GuideView
import com.ysr.dialogexit.utils.guilde.Controller
import com.ysr.dialogexit.utils.guilde.HighLight
import com.ysr.dialogexit.utils.guilde.NewbieGuide
import com.ysr.dialogexit.utils.guilde.OnGuideChangedListener
import kotlinx.android.synthetic.main.activity_guilde.*

class GuildeActivity : AppCompatActivity() {
    var guideView: GuideView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guilde)
//        setGuide(1)
        setGuideView(1)

    }

    private fun setGuideView(type: Int) {
        val iv = ImageView(this)
        iv.setImageResource(getTypeImage(type))
        val params = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        iv.layoutParams = params
        guideView = GuideView.Builder
                .newInstance(this)
                .setTargetView(getTypeView(type))//设置目标
                .setCustomGuideView(iv)
                .setDirction(getTypeDirection(type))
                .setShape(GuideView.MyShape.CIRCULAR)   // 设置圆形显示区域，
                .setBgColor(resources.getColor(R.color.shadow))
                .setOnclickListener {
                    if (type == 3) {
                        guideView!!.hide()
                    } else {
                        var i = type + 1
                        guideView!!.hide()
                        setGuideView(i)
                    }
                }
                .build()
        guideView!!.show()
    }

    private fun setGuide(type: Int) {
        NewbieGuide.with(this)//传入activity
                .setLabel("guide1")//设置引导层标示，必传！否则报错
                .addHighLight(getTypeView(type), HighLight.Type.CIRCLE)//添加需要高亮的view
                .setOnGuideChangedListener(object : OnGuideChangedListener {
                    override fun onRemoved(controller: Controller?) {

                        if (type == 4) {

                        } else {
                            var i = type + 1
                            setGuide(i)
                        }
                        Log.e("NewbieGuide", "onRemoved")
                    }

                    override fun onShowed(controller: Controller?) {

                    }

                })
                .setLayoutRes(R.layout.sign_guide)//自定义的提示layout，不要添加背景色，引导层背景色通过setBackgroundColor()设置
                .alwaysShow(true)//总是显示
                .show()//直接显示引导层
    }

    /**
     * 返回控件
     */
    private fun getTypeView(type: Int): View? {
        return when (type) {
            1 -> send
            2 -> chat
            3 -> person
            4 -> sign
            else -> null
        }

    }

    /**
     * 提示图片
     */
    private fun getTypeImage(type: Int): Int {
        return when (type) {
            1 -> R.mipmap.xindefatiefangshi
            2 -> R.mipmap.kaliaobanjiadaozhelile
            3 -> R.mipmap.gerenzhongxinbanjia
            4 -> R.mipmap.qiandaoduodaozheli
            else -> R.mipmap.xindefatiefangshi
        }

    }
    private fun getTypeDirection(type: Int): GuideView.Direction {
        return when (type) {
            1 -> GuideView.Direction.LEFT_TOP
            2 -> GuideView.Direction.LEFT_BOTTOM
            3 -> GuideView.Direction.LEFT_TOP
            4 -> GuideView.Direction.LEFT_BOTTOM
            else -> GuideView.Direction.LEFT_TOP
        }

    }
}
