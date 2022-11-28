package com.example.kotlincoroutines_56.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlincoroutines_56.R
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FirstFragment : Fragment() {

    private val scope = CoroutineScope(Dispatchers.IO + CoroutineName("MyScope"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_first, container, false)

        scope.launch {
            Log.d("Coroutine", this.coroutineContext.toString())
            launch {
                Log.d("Coroutine", this.coroutineContext.toString())
            }
        }

        view.buttonGo.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        return view
    }


}