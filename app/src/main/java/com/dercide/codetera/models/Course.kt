package com.dercide.codetera.models

data class Course(
    val id: Int,
    val name: String,
    val briefDescription: String,
    val description: String,
    val topics: ArrayList<Topic>,
    val price: Double,
    val qualification: Double,
    val creator: String,
    val creatorImgUrl: String,
    val creatorJob: String,
    val comments: ArrayList<Comment>,
    val iconUrl: String,
    val bannerUrl: String,
) {}