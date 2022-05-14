package com.eneszeydan.todoapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.eneszeydan.todoapplication.R
import com.eneszeydan.todoapplication.databinding.FragmentNewNoteBinding
import com.eneszeydan.todoapplication.viewmodel.NewNoteVMF
import com.eneszeydan.todoapplication.viewmodel.NewNoteViewModel

class NewNoteFragment : Fragment() {

    private lateinit var binding: FragmentNewNoteBinding
    private lateinit var viewModel: NewNoteViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_note, container, false)

        binding.newNoteFragment = this

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : NewNoteViewModel by viewModels(){
            NewNoteVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun buttonSaveClicked(caption:String){
        viewModel.save(caption)
    }

}