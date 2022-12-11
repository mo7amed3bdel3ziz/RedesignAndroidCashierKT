package com.tbi.supplierplus.di

import android.content.Context

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
 // @Singleton
 // @Provides
 // fun provideDao(db: SupplierDatabase): SupplierDao = db.dao()

 // @Singleton
 // @Provides
 // fun provideAppDatabase(@ApplicationContext context: Context): SupplierDatabase =
 //     Room.databaseBuilder(
 //         context,
 //         SupplierDatabase::class.java,
 //         "supplier_db"
 //     )
 //         .fallbackToDestructiveMigration()
 //         .build()

}