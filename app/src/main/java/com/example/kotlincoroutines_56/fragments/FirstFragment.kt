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
import kotlinx.coroutines.*


class FirstFragment : Fragment() {

    private val scope = CoroutineScope(Dispatchers.IO + CoroutineName("MyScope"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_first, container, false)

        GlobalScope.launch {
           while (true){
               delay(1000L)
               Log.d("Coroutine", "Running...")
           }
        }

        view.buttonGo.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        return view
    }

    override fun onPause() {
        Log.d("Coroutine", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Coroutine", "onStop")
        super.onStop()
    }

    override fun onResume() {
        Log.d("Coroutine", "onResume")
        super.onResume()
    }

    override fun onDestroy() {
        Log.d("Coroutine", "onDestroy")
        super.onDestroy()
    }


}