package com.example.bootcounterapp.di

import android.content.Context
import androidx.work.WorkManager
import com.example.bootcounterapp.domain.notifications.NotificationsRepository
import com.example.bootcounterapp.domain.worker.BackgroundWorkManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.bootcounterapp.data.worker.BackgroundWorkManager as BackgroundWorkManagerImpl
import com.example.bootcounterapp.data.notification.NotificationsRepository as NotificationsRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
internal object AppModule {

    @Provides
    @Singleton
    fun provideWorkManager(@ApplicationContext app: Context): WorkManager =
        WorkManager.getInstance(app)

    @Provides
    @Singleton
    fun provideBackgroundWorkManager(backgroundWorkManager: BackgroundWorkManagerImpl): BackgroundWorkManager =
        backgroundWorkManager

    @Provides
    @Singleton
    fun provideNotificationsRepositoryImpl(): NotificationsRepositoryImpl = NotificationsRepositoryImpl()

    @Provides
    @Singleton
    fun provideNotificationsRepository(impl: NotificationsRepositoryImpl): NotificationsRepository = impl

}