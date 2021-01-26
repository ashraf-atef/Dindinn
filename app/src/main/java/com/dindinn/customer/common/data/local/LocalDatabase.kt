package com.dindinn.customer.common.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dindinn.customer.common.data.CuisineItem

@Database(
    entities = [CuisineItem::class],
    version = 1
)
abstract class LocalDatabase : RoomDatabase() {


    companion object {

        lateinit var instance: LocalDatabase

        fun getInstance(context: Context): LocalDatabase {
            synchronized(LocalDatabase::class) {
                if (!::instance.isInitialized) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LocalDatabase::class.java,
                        "dindinn-database.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}