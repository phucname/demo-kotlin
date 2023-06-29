package com.example.myapplication.dongbo_batdongbo

class list_resource {
    lateinit var page:String
    lateinit var per_page:String
    lateinit  var total:String
    lateinit var total_pages:String
    lateinit var data:ArrayList<resource>
    class resource{
        lateinit  var  id:String
        lateinit var name:String
        lateinit  var year:String
        lateinit var color:String
        lateinit var pantone_value:String
    }

}