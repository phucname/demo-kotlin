
package com.example.myapplication.push_notifi

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat

import com.example.myapplication.R
import com.example.myapplication.push_notifi.Push_Notification
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.nio.file.attribute.AclEntry

var channelid="channel"
var channel_name="com.example.kotlin_lam"
class MyFirebaseMessagingService :FirebaseMessagingService() {
    override fun onMessageReceived(remessage: RemoteMessage) {
        if(remessage.notification!=null){
            getnotificatio(remessage.notification!!.title!!,remessage.notification!!.body!!)
        }
    }
    fun getRemoteView(title: String,message: String): RemoteViews {
        var remoteViews=RemoteViews("com.example.kotlin_lam", R.layout.item_notification)
        remoteViews.setTextViewText(R.id.title,title)
        remoteViews.setTextViewText(R.id.message,message)
        return  remoteViews
    }
    fun getnotificatio(title:String,message:String){
        var intent= Intent(this, Push_Notification::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("Mess","Tôi vừa bấm vào ")
        var pending= PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT)
        var build=NotificationCompat.Builder(applicationContext, channelid)
            .setSmallIcon(R.drawable.co4)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000,1000,1000,1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pending)
        build=build.setContent(getRemoteView(title,message))
        val notificationManager=getSystemService(Context.NOTIFICATION_SERVICE)as NotificationManager
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val notificationChannel=NotificationChannel(channelid, channel_name,NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)

        }
        notificationManager.notify(0,build.build())
    }
}

