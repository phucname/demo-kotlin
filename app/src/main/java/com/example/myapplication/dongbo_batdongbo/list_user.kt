package com.example.myapplication.dongbo_batdongbo


class list_user {
    var  page=""
    var per_page=""
    var total=""
    var  total_pages=""
    lateinit var data:ArrayList<data1>

    constructor(
        page: String,
        per_page: String,
        total: String,
        total_pages: String,
        data: ArrayList<data1>
    ) {
        this.page = page
        this.per_page = per_page
        this.total = total
        this.total_pages = total_pages
        this.data = data
    }

    class data1{
        var  id=""
        var email=""
        var first_name=""
        var last_name=""
        var  avatar=""

        constructor(
            id: String,
            email: String,
            first_name: String,
            last_name: String,
            avatar: String
        ) {
            this.id = id
            this.email = email
            this.first_name = first_name
            this.last_name = last_name
            this.avatar = avatar
        }
    }
}