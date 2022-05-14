package com.eneszeydan.todoapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.eneszeydan.todoapplication.repo.NotesDaoRepository

class NewNoteViewModel(application: Application): AndroidViewModel(application) {
    val nrepo = NotesDaoRepository(application)

    fun save(planCaption:String){
        nrepo.addNewPlan(planCaption)
    }
}