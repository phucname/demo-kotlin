
package com.example.myapplication.push_notifi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

import com.google.firebase.messaging.FirebaseMessaging


class Push_Notification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_push_notification)
        var intent = intent
        if(intent.getStringExtra("Mess")!=null){
            Log.d("Mess",intent.getStringExtra("Mess").toString())
        }
        FirebaseMessaging.getInstance().subscribeToTopic("web_app")
            .addOnCompleteListener { task ->
                var msg = "Done"
                Log.d("Mess",msg)
                if (!task.isSuccessful) {
                    msg = "Failed"
                }
            }

    }
}