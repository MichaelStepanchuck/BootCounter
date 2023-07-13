package com.example.bootcounterapp.data.worker

import android.annotation.SuppressLint
import androidx.work.BackoffPolicy
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.bootcounterapp.domain.worker.BackgroundWorkManager
import com.example.bootcounterapp.ShowSpecificNotificationWorker
import dagger.Lazy
import java.time.Duration
import java.time.temporal.ChronoUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BackgroundWorkManager @Inject constructor(
    private val workManager: Lazy<WorkManager>,
) : BackgroundWorkManager {
    @SuppressLint("NewApi")
    override fun scheduleTaskFor15Min() {
        workManager.get().enqueueUniquePeriodicWork(
            SHOW_SPECIFIC_NOTIFICATION_WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            PeriodicWorkRequestBuilder<ShowSpecificNotificationWorker>(DURATION_15_MINUTES)
                .setBackoffCriteria(
                    backoffPolicy = BackoffPolicy.LINEAR,
                    duration = DURATION_15_MINUTES,
                )
                .build(),
        )
    }

    private companion object {
        private const val SHOW_SPECIFIC_NOTIFICATION_WORK_NAME = "ShowSpecificNotification"
        private val DURATION_15_MINUTES = Duration.of(15, ChronoUnit.MINUTES)
    }

}