package com.example.dummyminorproject.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.dummyminorproject.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.fragment_home2.*
import kotlinx.android.synthetic.main.item_list.*

/**
 * A simple [Fragment] subclass.
 */
class Home : Fragment(),View.OnClickListener {

    private lateinit var navController: NavController
    private lateinit var database : FirebaseFirestore
    private lateinit var Storage: FirebaseStorage
    private lateinit var mStorageReference: StorageReference
    private var catlist : ArrayList<CatModel>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home2, container, false)
    }


        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            navController = Navigation.findNavController(view)
            view.findViewById<FloatingActionButton>(R.id.addCategory).setOnClickListener(this)
           // view.findViewById<CardView>(R.id.card_view).setOnClickListener(this)
            initUi()


            activity!!.menu.setOnItemSelectedListener {
                when (it) {
                    R.id.profile -> navController.navigate(R.id.action_home2_to_userProfile)
                    R.id.timeline -> navController.navigate(R.id.action_home2_to_timeline)
                }
            }

           // childFragmentManager.beginTransaction().replace(R.id.card_view,SubCatImage.getInstance()).commit()
        }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.addCategory -> navController.navigate(R.id.action_home2_to_adddetail)
          // R.id.card_view -> navController.navigate(R.id.action_home2_to_subCatImage)
        }
    }

//    private val Imagefolder: View.OnClickListener = View.OnClickListener { view ->
//        when (view.id) {
//            R.id.card_view -> navController.navigate(R.id.action_home2_to_subCatImage)
//        }
//    }

    private fun initUi() {

        database = FirebaseFirestore.getInstance()
        Storage  = FirebaseStorage.getInstance()
        mStorageReference = Storage.reference.child("Category")

       // val recycler = view?.findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = GridLayoutManager(this.context,2)
        recycler.setHasFixedSize(true)
        catlist = ArrayList()
        catlist = loaddata()

    }

    fun loaddata(): ArrayList<CatModel>{

        val item : ArrayList<CatModel> = ArrayList()

        database.collection("Category")
            .get()
            .addOnCompleteListener{task ->
                if(task.isSuccessful){
                    for (document in task.result!!){
                       // var id : String = document.id
                        var imageTitle = document.data.get("ImageTitle").toString()
                        var imageUrl = document.data.get("ImageUrl").toString()

                        val add = item.add(CatModel(imageTitle,imageUrl))

                    }
                    val CategoryAdapter = context?.let { CategoryAdapter(it,catlist!!) }
                    recycler.adapter= CategoryAdapter
                }
            }

        return  item

    }
}
