package com.ysr.dialogexit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ysr.dialogexit.utils.SpeechUtils
import kotlinx.android.synthetic.main.activity_voice.*

class VoiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voice)
        button.setOnClickListener({
            SpeechUtils.getInstance(this).speakText("支付宝到账1561")
        })
    }
}
