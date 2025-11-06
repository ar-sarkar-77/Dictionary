package com.anondo.dictionaryapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anondo.dictionaryapp.MainActivity.Companion.dabase
import com.anondo.dictionaryapp.MainActivity.Companion.instance
import com.anondo.dictionaryapp.databinding.ItemBinding
import com.bumptech.glide.Glide


class NameAdapter(var context: Context, var arrayData : ArrayList<DataClass>): RecyclerView.Adapter<NameAdapter.ViewHolder>(){

    class ViewHolder(val binding : ItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent , false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arrayData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var allData = arrayData[position]

        holder.binding.tvWord.text = allData.word
        holder.binding.tvPartsOfSpeech.text = "("+allData.partsofs+")"
        holder.binding.tvMeaning.text = allData.meaning
        holder.binding.tvExample.text = allData.example

        var num : Int = allData.isfav
        var id : Int = allData.id

        if (num==1){
            Glide
                .with(context)
                .load(R.drawable.heart_icon)
                .into(holder.binding.ivFavorite)
        }
        else if (num==0){
            Glide
                .with(context)
                .load(R.drawable.love_icon)
                .into(holder.binding.ivFavorite)
        }

        holder.binding.ivFavorite.setOnClickListener{

            if (num == 1){
                dabase.updateData(0 , ""+id)
                Glide
                    .with(context)
                    .load(R.drawable.love_icon)
                    .into(holder.binding.ivFavorite)

                instance.LoadData(dabase.getAllData())
            }
            else if (num == 0){
                dabase.updateData(1 , ""+id)
                Glide
                    .with(context)
                    .load(R.drawable.heart_icon)
                    .into(holder.binding.ivFavorite)

                instance.LoadData(dabase.getAllData())
            }

        }

    }

}