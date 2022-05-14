package com.eneszeydan.todoapplication.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.eneszeydan.todoapplication.entity.Plans
import com.eneszeydan.todoapplication.room.PlansDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesDaoRepository(var application: Application) {

    var plansList: MutableLiveData<List<Plans>>
    var db : PlansDatabase

    init {
        plansList = MutableLiveData()
        db = PlansDatabase.accessDatabase(application)!!
    }

    fun getPlans(): MutableLiveData<List<Plans>>{
        return plansList
    }

    fun addNewPlan(planCaption:String){
        CoroutineScope(Dispatchers.Main).launch {
            val plan = Plans(0, planCaption)
            db.plansDao().addNewPlan(plan)
        }
    }

    fun updatePlan(planId:Int, planCaption:String){
        CoroutineScope(Dispatchers.Main).launch {
            val plan = Plans(planId, planCaption)
            db.plansDao().updatePlan(plan)
        }
    }

    fun searchPlan(query:String){
        CoroutineScope(Dispatchers.Main).launch {
            db.plansDao().searchPlans(query)
        }
    }

    fun deletePlan(planId:Int){
        CoroutineScope(Dispatchers.Main).launch {
            val planToDelete = Plans(planId, "")
            db.plansDao().removePlan(planToDelete)
            getAllPlans()
        }
    }

    fun getAllPlans(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            plansList.value = db.plansDao().getAllPlans()
        }
    }

}