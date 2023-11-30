package com.dercide.codetera.sql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context, databaseName:String, version:Int): SQLiteOpenHelper(context, databaseName, null, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        //db?.execSQL("CREATE TABLE IF NOT EXISTS SD();")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //onCreate(db)
    }
}