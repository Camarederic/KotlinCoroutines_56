package com.example.kotlincoroutines_56.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.kotlincoroutines_56.R
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.coroutines.*


class FirstFragment : Fragment() {


    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_first, container, false)

        runBlocking {

            GlobalScope.launch {
                Log.d("Coroutine", "Coroutine 1")
                delay(5000L)
            }

            GlobalScope.launch {
                Log.d("Coroutine", "Coroutine 2")
                delay(5000L)
            }
        }
        Log.d("Coroutine", "runBlocking Completed")

        view.buttonGo.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        return view
    }


}