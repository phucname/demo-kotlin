package com.example.myapplication.lazy_img

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class pagi(var liner:LinearLayoutManager): RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        var visibeitemcount=liner.childCount
        var totaitemcount=liner.itemCount
        var findfistitem=liner.findFirstVisibleItemPosition()
        if(isLoading()||isLasst()){
            return
        }
        if(findfistitem>=0&&(visibeitemcount+findfistitem)>=totaitemcount){
            loadMoreitem()
        }
    }

    abstract fun  loadMoreitem()
    abstract fun isLoading():Boolean
    abstract fun isLasst():Boolean
}