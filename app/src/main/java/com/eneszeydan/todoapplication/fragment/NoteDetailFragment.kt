package com.eneszeydan.todoapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.eneszeydan.todoapplication.R
import com.eneszeydan.todoapplication.databinding.FragmentNoteDetailBinding
import com.eneszeydan.todoapplication.viewmodel.NoteDetailVMF
import com.eneszeydan.todoapplication.viewmodel.NoteDetailViewModel


class NoteDetailFragment : Fragment() {

    private lateinit var binding: FragmentNoteDetailBinding
    private lateinit var viewModel: NoteDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_note_detail, container, false)

        binding.detailFragment = this

        val bundle : NoteDetailFragmentArgs by navArgs()
        val plan = bundle.plan
        binding.planObject = plan

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : NoteDetailViewModel by viewModels(){
            NoteDetailVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun buttonUpdateClicked(id:Int, caption: String){
        viewModel.update(id, caption)
    }

}