package com.example.stacksonactivityresultsample

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_a.*

class AActivity : AppCompatActivity() {

    val INTENT_REQUEST_CODE_ACACTIVITY = 99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        button_start.setOnClickListener {
            startActivityForResult(Intent(this, BActivity::class.java), INTENT_REQUEST_CODE_ACACTIVITY)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == INTENT_REQUEST_CODE_ACACTIVITY && resultCode == Activity.RESULT_OK){
            if(data == null) return
            Log.e("shohiebsense INT DATA", data.getIntExtra(CActivity.IntentData.INTENT_DATA_A_INT, 0).toString())
            Log.e("shohiebsense ", data.getStringExtra(CActivity.IntentData.INTENT_DATA_C_STRING))
            Log.e("shohiebsense ","long data "+data.getLongExtra(CActivity.IntentData.INTENT_DATA_B_LONG, 0L))
            Log.e("shohiebsense ","boolean data "+data.getBooleanExtra(CActivity.IntentData.INTENT_DATA_D_BOOLEAN, false))
        }
    }
}
