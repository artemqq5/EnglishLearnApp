package com.entenses.sesnethsilgne.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.entenses.sesnethsilgne.R
import com.entenses.sesnethsilgne.databinding.RecyclerItemBinding
import com.entenses.sesnethsilgne.domain.models.Lesson

class AdapterRecycler(
    private val listLessons: List<Lesson>,
    private val transition: (Lesson) -> Unit
) :
    RecyclerView.Adapter<AdapterRecycler.VHolder>() {

    inner class VHolder(view: View) : ViewHolder(view) {
        private val binding = RecyclerItemBinding.bind(view)

        fun bindItem(item: Lesson) {
            binding.labelText.text = item.label
            binding.shortDescText.text = item.shortDesc
            binding.root.setOnClickListener {
                transition(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        return VHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.bindItem(item = listLessons[position])
    }

    override fun getItemCount() = listLessons.size
}