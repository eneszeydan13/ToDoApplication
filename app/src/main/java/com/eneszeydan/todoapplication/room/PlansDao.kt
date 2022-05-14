package com.eneszeydan.todoapplication.room

import androidx.room.*
import com.eneszeydan.todoapplication.entity.Plans

@Dao
interface PlansDao {

    @Query("Select * from plans")
    suspend fun getAllPlans(): List<Plans>

    @Insert
    suspend fun addNewPlan(plan: Plans)

    @Delete
    suspend fun removePlan(plan:Plans)

    @Update
    suspend fun updatePlan(plan: Plans)

    @Query("Select * from plans where plan_caption like '%'||:query||'%'")
    suspend fun searchPlans(query: String): List<Plans>

}