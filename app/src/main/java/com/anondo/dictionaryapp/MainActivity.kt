package com.anondo.dictionaryapp

import android.content.Context
import android.database.Cursor
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anondo.dictionaryapp.databinding.ActivityMainBinding
import com.anondo.dictionaryapp.databinding.ItemBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.ModelLoader.LoadData
import kotlinx.coroutines.flow.combine

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    companion object{
        lateinit var dabase : DataBaseOpenHelper
        lateinit var instance: MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dabase = DataBaseOpenHelper(this)

        instance = this

        LoadData(dabase.getAllData())

        binding.edSearch.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var key : String = binding.edSearch.text.toString()

                LoadData(dabase.searchData(key))
            }

            override fun afterTextChanged(p0: Editable?) {

            }


        })

    }

    fun LoadData(cursor : Cursor){

        var arrayList = ArrayList<DataClass>()

        if (cursor!=null  && cursor.count>0){

            while (cursor.moveToNext()){
                var id : Int = cursor.getInt(0)
                var word : String = cursor.getString(1)
                var meaning : String = cursor.getString(2)
                var partsofSpeach : String = cursor.getString(3)
                var example : String = cursor.getString(4)
                var isFav : Int = cursor.getInt(5)

                arrayList.add(
                    DataClass(id , word , meaning , partsofSpeach , example , isFav)
                )
            }

            arrayList.sortByDescending { it.isfav }

            binding.tvRec.layoutManager=LinearLayoutManager(this)
            binding.tvRec.adapter= NameAdapter(this , arrayList)

        }
        else{
            Toast.makeText(this , "No Data" , Toast.LENGTH_SHORT).show()
        }

//===============================================================================================

    }


}