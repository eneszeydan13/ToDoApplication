package com.eneszeydan.todoapplication.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.eneszeydan.todoapplication.R
import com.eneszeydan.todoapplication.adapter.PlansAdapter
import com.eneszeydan.todoapplication.databinding.FragmentHomepageBinding
import com.eneszeydan.todoapplication.viewmodel.HomepageVMF
import com.eneszeydan.todoapplication.viewmodel.HomepageViewModel

class HomepageFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentHomepageBinding
    private lateinit var adapter: PlansAdapter
    private lateinit var viewModel: HomepageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_homepage, container, false)

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHomepage)
        binding.homepageFragment = this
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.plansList.observe(viewLifecycleOwner) {
            adapter = PlansAdapter(viewModel, it)
            binding.plansAdapter = adapter
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        val temp : HomepageViewModel by viewModels(){
            HomepageVMF(requireActivity().application)
        }
        viewModel = temp
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)

        val item = menu.findItem(R.id.action_search)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadPlans()
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    fun fabClicked(view: View) {
        Navigation.findNavController(view).navigate(R.id.toNewNote)
    }



}