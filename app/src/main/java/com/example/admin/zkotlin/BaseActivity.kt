package com.example.admin.zkotlin


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.RelativeLayout
import android.widget.TextView

import java.util.*


abstract class BaseActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = "BaseActivity"
    private var lyHeader: RelativeLayout? = null
    private var tvBack: TextView? = null
    private var tvTitle: TextView? = null
    private var mTimer: Timer? = null
    private var mLastActionTime: Long? = null



    private val HOST = "118.24.55.19"  //服务器的ip地址
    private val PORT = 20201            ///指定的端口号
    private var isConnectedToServer = false
    //5分钟未操作
    private val operationTime = 1000 * 60 * 5



    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        mLastActionTime = System.currentTimeMillis()
        return super.dispatchTouchEvent(ev)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        initHeader()
        initViews()
        initEvents()
        hideBottomUIMenu()

        window.decorView.setOnSystemUiVisibilityChangeListener { visibility ->
            if ((visibility and View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {

            } else {
                hideBottomUIMenu()
            }
        }
    }

    private fun hideBottomUIMenu() {
        if ((Build.VERSION.SDK_INT > 11) and (Build.VERSION.SDK_INT < 19)) {
            val v = this.window.decorView
            v.systemUiVisibility = View.GONE
        } else if (Build.VERSION.SDK_INT >= 19) {
            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            val decorView = window.decorView
            val uiOptions = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
            decorView.systemUiVisibility = uiOptions
        }
    }

    open fun initHeader() {

    }

    open fun setHeadTitle(title: String) {
        tvTitle!!.text = title
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun finish() {
        super.finish()
    }

    override fun onClick(v: View) {

    }



    abstract fun initViews()

    abstract fun initEvents()

}