package com.example.dummyminorproject.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.dummyminorproject.HomePage
import com.example.dummyminorproject.MainActivity
import com.example.dummyminorproject.R
import com.squareup.picasso.Picasso


class CategoryAdapter( private val context : Context ,private val catlist:List<CatModel>) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    lateinit var TitleText : TextView
    lateinit var  CatImage : ImageView
//    private lateinit var navController: NavController

//    private var context : Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
       // context = parent.context
        val itemView=
            LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
//        navController = Navigation.findNavController(itemView)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return catlist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.data()

//        holder.cardView.setOnClickListener(View.OnClickListener {
//
//          var SubCatImage : Fragment = SubCatImage()
//            val bundle = Bundle()
//            bundle.putString("id",catlist.get(position).id)
//            Log.e("exe123", "exe")
//            R.id.card_view ->
//            navController.navigate(R.id.action_home2_to_subCatImage)
          //  (context as HomePage).supportFragmentManager.beginTransaction().replace(R.id.CatHome,SubCatImage).commit()
       //     activity!!.supportFragmentManager.beginTransaction()
       // })

//        val current = catlist[position]
//        val catModel:CatModel = catlist[position]
//        holder.TitleText.text = catModel.imageTitle
//        holder.ImPicasso.get().load(catModel.imageUrl).centerCrop().into(CatImage)

    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



        fun data (){
            TitleText = itemView.findViewById(R.id.cattitle)
            CatImage = itemView.findViewById(R.id.thumbnail)

            val catModel = catlist.get(adapterPosition)


            TitleText.text = catModel.imageTitle

            Picasso.get().load(catModel.imageUrl).resize(250,250).centerCrop().into(CatImage)
        }

      //  var cardView:CardView = itemView.findViewById<CardView>(R.id.card_view)



//        val  TitleText = itemView.findViewById(R.id.cattitle) as TextView
//        val CatImage = itemView.findViewById(R.id.thumbnail) as ImageView

    }


}


