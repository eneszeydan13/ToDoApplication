package com.eneszeydan.todoapplication.adapter

import androidx.recyclerview.widget.RecyclerView
import com.eneszeydan.todoapplication.databinding.PlanRowBinding

class PlansViewHolder(binding: PlanRowBinding): RecyclerView.ViewHolder(binding.root) {
    var binding: PlanRowBinding
    init {
        this.binding = binding
    }
}