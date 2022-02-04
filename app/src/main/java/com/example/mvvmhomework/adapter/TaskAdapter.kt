package com.example.mvvmhomework.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmhomework.databinding.RowItemBinding
import com.example.mvvmhomework.fragments.HomeFragmentDirections
import com.example.mvvmhomework.model.Task
import com.example.mvvmhomework.viewmodel.HomeViewModel
import com.google.android.material.snackbar.Snackbar

class TaskAdapter(
    var mContext: Context,
    var taskList: List<Task>,
    var viewModel: HomeViewModel,
) : RecyclerView.Adapter<TaskAdapter.CardViewHolder>() {

    inner class CardViewHolder(rowItemBinding: RowItemBinding) :
        RecyclerView.ViewHolder(rowItemBinding.root) {
        var binding: RowItemBinding

        init {
            this.binding = rowItemBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding = RowItemBinding.inflate(layoutInflater, parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val currentTask = taskList[position]
        val t = holder.binding
        t.task = currentTask

        t.cardViewTask.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToUpdateFragment(currentTask)
            Navigation.findNavController(it).navigate(action)
        }

        t.imageViewDelete.setOnClickListener {
            Snackbar.make(it, "${currentTask.title} deleted?", Snackbar.LENGTH_LONG)
                .setAction("YES") {
                    viewModel.delete(currentTask.id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

}