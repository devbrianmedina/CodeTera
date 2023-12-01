package com.dercide.codetera.models

data class Topic(
    val idTopic:Int,
    val name:String,
    val videos:ArrayList<Video>,
){}