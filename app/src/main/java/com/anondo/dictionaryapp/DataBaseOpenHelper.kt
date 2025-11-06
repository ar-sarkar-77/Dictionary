package com.anondo.dictionaryapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

class DataBaseOpenHelper(context: Context?) : SQLiteAssetHelper(context , "dictionary.db" , null, 1) {

    fun getAllData() : Cursor{

        var db : SQLiteDatabase = this.readableDatabase

        var cursor : Cursor = db.rawQuery("select * from Dictionary" , null)
        return cursor
    }

    fun searchData(key : String) : Cursor{

        var db : SQLiteDatabase = this.readableDatabase

        var cursor : Cursor = db.rawQuery("select * from Dictionary where word like '%"+key+"%'" , null)
        return cursor
    }

    fun updateData(isFav: Int?, id: String?): Int {

        val  db : SQLiteDatabase =this.writableDatabase

        val conval = ContentValues()
        conval.put("isFavorite", isFav)

        return db.update("Dictionary", conval , "id = ?" , arrayOf(id.toString()))
    }

}