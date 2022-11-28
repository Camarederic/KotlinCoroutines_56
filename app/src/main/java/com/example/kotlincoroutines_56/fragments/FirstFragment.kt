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

    private val scope = CoroutineScope(CoroutineName("MyScope"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val mainJob = scope.launch {
            val job1 = launch {
                while (true){
                    yield()
                    Log.d("Coroutine", "Job 1 running...")
                }
            }

            val job2 = launch {
                Log.d("Coroutine", "Job 2 running...")
            }

            delay(1000L)
            Log.d("Coroutine", "Canceling...")
            job2.cancelAndJoin()
            Log.d("Coroutine", "Job 2 canceled...")
        }

        runBlocking {
            delay(2000L)
            Log.d("Coroutine", "Canceling...")
            mainJob.cancelAndJoin()
            Log.d("Coroutine", "Main Job CANCELLED")
        }

        view.buttonGo.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        return view
    }




}