package com.example.bootcounterapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.bootcounterapp.domain.worker.BackgroundWorkManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BootReceiver : BroadcastReceiver() {

    @Inject
    lateinit var backgroundWorkManager: BackgroundWorkManager

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.e("TAG", "BOOT COMPLETED")

        backgroundWorkManager.scheduleTaskFor15Min()
    }
}