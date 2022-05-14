package com.eneszeydan.todoapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.eneszeydan.todoapplication.repo.NotesDaoRepository

class NoteDetailViewModel(application: Application): AndroidViewModel(application) {
    val nrepo = NotesDaoRepository(application)

    fun update(planId: Int, planCaption: String){
        nrepo.updatePlan(planId, planCaption)
    }
}