package com.example.myapplication.lazy_img


import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory

import android.os.AsyncTask
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R

import com.squareup.picasso.Picasso
import java.io.IOException
import java.io.InputStream
import java.net.URL

class adapter_list(var context: Context,var list:ArrayList<class_item> ):
    RecyclerView.Adapter<adapter_list.viewhodel>() {
    lateinit var  ma:Map<String,Bitmap>
    class viewhodel(itemView: View): RecyclerView.ViewHolder(itemView) {
        var img=itemView.findViewById<ImageView>(R.id.item_img_lazy)
        var title=itemView.findViewById<TextView>(R.id.text_lazy)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewhodel {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.item_listview_lazy,parent,false)

        return viewhodel(view)
    }

    override fun onBindViewHolder(holder: viewhodel, position: Int) {
        var item=list[position]
        holder.title.text=item.title
        Picasso.get().load(item.img).into(holder.img);
//Glide.with(context).load(item.img).into(holder.img)
        Log.d("M","Lod:${item.title}")
    }

    override fun getItemViewType(position: Int): Int {
        return  when(list[position]){
            is class_item ->0
            else ->1
        }

    }
    override fun getItemCount(): Int {
        return list.size
    }

//    class ays: AsyncTask<class_item, Void, Bitmap>() {
//        lateinit var bitmap:Bitmap
//
//        override fun doInBackground(vararg params: class_item?): Bitmap {
//
//           var itemc=params[0]
//            var scr=itemc?.img
//            var inputStream:InputStream?=null
//
//               var URL=URL(scr)
//               inputStream= URL.content as InputStream?
//               bitmap=BitmapFactory.decodeStream(inputStream)
//
//               if(inputStream!=null){
//                       inputStream.close()
//                     }
//
//           return bitmap
//        }
//
//        override fun onPostExecute(result: Bitmap) {
//            super.onPostExecute(result)
//
//        }
//
//    }
}