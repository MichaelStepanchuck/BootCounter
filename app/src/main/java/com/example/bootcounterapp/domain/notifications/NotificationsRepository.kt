package com.example.bootcounterapp.domain.notifications

interface NotificationsRepository {
    fun showSpecificNotification()
    fun cancelSpecificNotification()
}
