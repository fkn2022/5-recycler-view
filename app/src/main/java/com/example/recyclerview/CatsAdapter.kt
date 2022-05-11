package com.example.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.CatViewHolderBinding
import com.example.recyclerview.databinding.KittenViewHolderBinding
import java.lang.IllegalStateException

class CatsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var cats: List<Cat> = listOf()
        set(value) {
            field = value.toList()

            // refresh all set!
            notifyDataSetChanged()
            Log.d("Recycler Project", "new value: $value")
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            KITTEN -> KittenViewHolder(KittenViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            CAT -> CatViewHolder(CatViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw IllegalStateException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is KittenViewHolder -> holder.bind(cats[position])
            is CatViewHolder -> holder.bind(cats[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (cats[position].age) {
            in 0..12 -> KITTEN
            else -> CAT
        }
    }

    override fun getItemCount(): Int = cats.size

    abstract class CommonViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(data: T)
    }

    class KittenViewHolder(private val binding: KittenViewHolderBinding) : CommonViewHolder<Cat>(binding.root) {
        override fun bind(cat: Cat) {
            binding.kittenName.text = cat.name
        }
    }

    class CatViewHolder(private val binding: CatViewHolderBinding) : CommonViewHolder<Cat>(binding.root) {
        override fun bind(cat: Cat) {
            binding.catName.text = cat.name
            binding.catAge.text = cat.age.toString()
        }
    }

    data class Cat(
        val name: String,
        val age: Int,
    )

    companion object Type {
        const val KITTEN = 0
        const val CAT = 1
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)
    }
}