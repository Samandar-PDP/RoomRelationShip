package com.example.roomrelationship.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Player::class, Club::class], version = 1, exportSchema = false)
abstract class PlayerDatabase : RoomDatabase() {
    abstract val dao: PlayerDao

    companion object {
        @Volatile
        private var instance: PlayerDatabase? = null
        operator fun invoke(context: Context) = instance ?: synchronized(Any()) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }
        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context,
            PlayerDatabase::class.java,
            "player.db"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}