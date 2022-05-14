package com.eneszeydan.todoapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.eneszeydan.todoapplication.entity.Plans
import com.eneszeydan.todoapplication.repo.NotesDaoRepository

class HomepageViewModel(application: Application): AndroidViewModel(application) {
    private val nrepo = NotesDaoRepository(application)
    var plansList = MutableLiveData<List<Plans>>()

    init {
        loadPlans()
        plansList = nrepo.getPlans()
    }

    fun search(query: String){
        nrepo.searchPlan(query)
    }

    fun delete(planId:Int){
        nrepo.deletePlan(planId)
    }

    fun loadPlans(){
        nrepo.getAllPlans()
    }
}