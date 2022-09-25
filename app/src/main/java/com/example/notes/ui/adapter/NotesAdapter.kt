package com.example.notes.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.Model.Notes
import com.example.notes.R
import com.example.notes.databinding.ItemNotesBinding
import com.example.notes.ui.fragment.HomeFragmentDirections

class NotesAdapter(val requireContext: Context,val noteslist: List<Notes>) : RecyclerView.Adapter<NotesAdapter.notesViewHolder>() {

    class notesViewHolder(val binding: ItemNotesBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
       return notesViewHolder(ItemNotesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
        val data = noteslist[position]
        holder.binding.noteTitle.text = data.title
        holder.binding.noteSubtitle.text = data.subtitle
        holder.binding.notesdate.text = data.date

        when (data.priority){
            "1" -> {
                holder.binding.viewPriority.setBackgroundResource(R.drawable.teal_dot)
            }
            "2" -> {
                holder.binding.viewPriority.setBackgroundResource(R.drawable.purple_dot)
            }
            "3" -> {
                holder.binding.viewPriority.setBackgroundResource(R.drawable.purple2_dot)
            }
        }

        holder.binding.root.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToEditNotesFragment2(data)
            Navigation.findNavController(it).navigate(action)

        }


    }

    override fun getItemCount()= noteslist.size
    }
