package com.example.myapplication.lazy_img

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.myapplication.R
import com.google.firebase.database.*

class lazy_img_main : AppCompatActivity() {
    lateinit var recy: RecyclerView
    var list=ArrayList<class_item >()
    var arrayString=ArrayList<String>()
    lateinit var data: DatabaseReference
    lateinit var progressBar: ProgressBar
    var isload:Boolean=false
    var islast:Boolean=false
    var currentpase=1
    var total=5
    var vitri=5
    var tong:Int = 0
    lateinit var adapterList:adapter_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layzy_img_main)
        recy=findViewById(R.id.recy_lazy)
        progressBar=findViewById(R.id.progress)
        data=FirebaseDatabase.getInstance().getReference()
        data.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                tong= snapshot.childrenCount.toInt()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        list= arrayListOf()
        arrayString= arrayListOf()
        getarray()
        getlisst()
//setContent {
//    FlowerList(list = arrayString)
//}
        var linearLayoutManager= LinearLayoutManager(applicationContext)
        recy.layoutManager=linearLayoutManager
        recy.addOnScrollListener(object : pagi(linearLayoutManager){
            override fun loadMoreitem() {
                isload=true
                progressBar.visibility= View.VISIBLE
                var runnable= Runnable {

                    currentpase++
                    getdata(vitri)
                    adapterList.notifyDataSetChanged()
                    progressBar.visibility=View.INVISIBLE
                    isload=false
                    if(vitri>=tong){
                        islast=true
                    }
                    Log.d("MM","aa"+list.size)
                }
                var handler= Handler(Looper.getMainLooper())
                handler.postDelayed(runnable,2000)





            }

            override fun isLoading(): Boolean {
                return isload
            }

            override fun isLasst(): Boolean {
                return islast
            }

        })
//        recy.addOnScrollListener(object : RecyclerView.OnScrollListener (){
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//
//                var runnable= Runnable {
//
//
//                   getdata(vitri)
//
//                    progressBar.visibility = View.INVISIBLE
//                }
//                var handler=Handler(Looper.getMainLooper())
//             if(vitri<=tong){
//                 progressBar.visibility=View.VISIBLE
//
//                 handler.postDelayed(runnable,2000)
//                 Log.d("TAG","Số lượng cuộn dọc:$dy")
//             }
//
//
//            }
//        })


        adapterList=adapter_list(applicationContext,list,)
        recy.adapter=adapterList

    }
    fun getdata(v:Int){


        var qury:Query=data.limitToFirst(v)

        qury.addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var sl=1
                for ( s in snapshot.children){
                    if(sl>=v-5&&sl<=v){
                        list.add(class_item(s.child("img").getValue().toString(),s.child("title").getValue().toString()))
                        Log.d("DA","TTT:${snapshot.childrenCount}"+"T$vitri")
                        adapterList.notifyDataSetChanged()

                    }
                    sl++

                }
                vitri=vitri+5

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })


    }


    fun getarray(){

        for (i:Int in 0..5){
            arrayString.add("aaaaaaaa:$i")
        }




    }
    fun getlisst(){
        list.add(class_item("https://firebasestorage.googleapis.com/v0/b/doan-f52ef.appspot.com/o/vRIQP" +
                "XSsOARkCYZM31EQ3zVDhrK2%2FimgMonAn%2F-NWNMssPxWkQ407Z3FA0" +
                "?alt=media&token=2e61855f-3922-47ee-88db-dfacebcf6cd2","piza90a"))
        list.add(class_item("https://firebasestorage.googleapis.com/v0/b/doan-f52ef.appspot.com/o/vRIQP" +
                "XSsOARkCYZM31EQ3zVDhrK2%2FimgMonAn%2F-NWNMssPxWkQ407Z3FA0" +
                "?alt=media&token=2e61855f-3922-47ee-88db-dfacebcf6cd2","pi5678zaa"))
        list.add(class_item("https://firebasestorage.googleapis.com/v0/b/doan-f52ef.appspot.com/o/vRIQP" +
                "XSsOARkCYZM31EQ3zVDhrK2%2FimgMonAn%2F-NWNMssPxWkQ407Z3FA0" +
                "?alt=media&token=2e61855f-3922-47ee-88db-dfacebcf6cd2","piz44aa"))
        list.add(class_item("https://firebasestorage.googleapis.com/v0/b/doan-f52ef.appspot.com/o/vRIQP" +
                "XSsOARkCYZM31EQ3zVDhrK2%2FimgMonAn%2F-NWNMssPxWkQ407Z3FA0" +
                "?alt=media&token=2e61855f-3922-47ee-88db-dfacebcf6cd2","piza23a"))
        list.add(class_item("https://firebasestorage.googleapis.com/v0/b/doan-f52ef.appspot.com/o/vRIQP" +
                "XSsOARkCYZM31EQ3zVDhrK2%2FimgMonAn%2F-NWNMssPxWkQ407Z3FA0" +
                "?alt=media&token=2e61855f-3922-47ee-88db-dfacebcf6cd2","pizaa1"))
        list.add(class_item("https://firebasestorage.googleapis.com/v0/b/doan-f52ef.appspot.com/o/vRIQP" +
                "XSsOARkCYZM31EQ3zVDhrK2%2FimgMonAn%2F-NWNMssPxWkQ407Z3FA0" +
                "?alt=media&token=2e61855f-3922-47ee-88db-dfacebcf6cd2","pizaa1"))

    }
}