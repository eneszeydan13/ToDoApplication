package com.eneszeydan.todoapplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.eneszeydan.todoapplication.entity.Plans

@Database(entities = [Plans::class], version = 1)
abstract class PlansDatabase: RoomDatabase() {
    abstract fun plansDao(): PlansDao

    companion object {
        var INSTANCE: PlansDatabase? = null

        fun accessDatabase(context: Context): PlansDatabase?{
            if (INSTANCE == null){
                synchronized(PlansDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, PlansDatabase::class.java, "plans.sqlite").createFromAsset("plans.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}