package com.eneszeydan.todoapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.eneszeydan.todoapplication.R
import com.eneszeydan.todoapplication.databinding.PlanRowBinding
import com.eneszeydan.todoapplication.entity.Plans
import com.eneszeydan.todoapplication.fragment.HomepageFragmentDirections
import com.eneszeydan.todoapplication.viewmodel.HomepageViewModel
import com.google.android.material.snackbar.Snackbar

class PlansAdapter(var viewModel: HomepageViewModel, var plansList:List<Plans>) : RecyclerView.Adapter<PlansViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlansViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : PlanRowBinding = DataBindingUtil.inflate(layoutInflater, R.layout.plan_row, parent, false)
        return PlansViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlansViewHolder, position: Int) {
        val plan = plansList[position]
        holder.binding.apply {
            planObject = plan

            imageViewDelete.setOnClickListener {
                Snackbar.make(it, "Plan silinsin mi?", Snackbar.LENGTH_LONG)
                    .setAction("EVET") {
                        viewModel.delete(plan.planId)
                    }.show()
            }

            rowCard.setOnClickListener {
                val nav = HomepageFragmentDirections.toDetail(plan)
                Navigation.findNavController(it).navigate(nav)
            }
        }
    }

    override fun getItemCount(): Int {
        return plansList.size
    }

}