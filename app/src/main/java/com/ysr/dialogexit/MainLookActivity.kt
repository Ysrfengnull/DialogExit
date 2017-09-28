package com.ysr.dialogexit

import android.app.Activity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import kotlinx.android.synthetic.main.activity_main_look.*

class MainLookActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_look)
        content_letter.movementMethod = ScrollingMovementMethod.getInstance()
    }
}
