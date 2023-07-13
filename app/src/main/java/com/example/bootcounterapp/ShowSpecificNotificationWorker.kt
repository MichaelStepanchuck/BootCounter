package com.example.bootcounterapp

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import com.example.bootcounterapp.domain.notifications.NotificationsRepository

@HiltWorker
class ShowSpecificNotificationWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val notificationsRepository: NotificationsRepository,
) : Worker(context, workerParams) {
    override fun doWork(): Result {
        notificationsRepository.showSpecificNotification()

        return Result.success()
    }

    override fun onStopped() {
        notificationsRepository.cancelSpecificNotification()
    }
}
