package com.example.admin.zkotlin


import android.app.Activity
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.json.JSONObject
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_staff_detail.*


class  MainActivity : BaseActivity() ,View.OnClickListener {
    override fun initViews() {
    }

    override fun initEvents() {
    }

    lateinit var ICCardDialog: AutoHideBottomUIDialog
    private val dialogHeight = 460f
    lateinit var ivRFIDAnim: ImageView
    lateinit var tvRecordRFIDResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_detail)
        initICCardDialog()

        tvBindRFID.setOnClickListener(this)
    }

    private fun initICCardDialog() {
        ICCardDialog = AutoHideBottomUIDialog(this)
        ICCardDialog.setContentView(R.layout.dialog_entry_ic_card)
        ICCardDialog.setDialogHeight(dialogHeight)
        ivRFIDAnim = ICCardDialog.findViewById(R.id.ivAnim)
        tvRecordRFIDResult = ICCardDialog.findViewById(R.id.tvRecordResult)


        ICCardDialog.setOnDismissListener(DialogInterface.OnDismissListener { dialog ->
            Log.i("TAG", "cancel  ICCardDialog dismiss")
        })

    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.tvBindRFID -> {
                tvRecordRFIDResult.text = "等待录入···"
                ICCardDialog.show()
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (ICCardDialog.isShowing) {
            ICCardDialog.dismiss()
        }

    }
}