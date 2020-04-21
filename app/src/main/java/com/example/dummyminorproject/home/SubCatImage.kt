package com.example.dummyminorproject.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.dummyminorproject.R
import kotlinx.android.synthetic.main.fragment_sub_cat_image.*

/**
 * A simple [Fragment] subclass.
 */
class SubCatImage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sub_cat_image, container, false)
    }

}
