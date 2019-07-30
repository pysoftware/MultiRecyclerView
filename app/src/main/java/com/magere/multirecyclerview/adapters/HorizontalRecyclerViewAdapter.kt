package com.magere.multirecyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.magere.multirecyclerview.OnItemClickListener
import com.magere.multirecyclerview.R
import com.magere.multirecyclerview.models.HorizontalModel
import kotlinx.android.synthetic.main.item_horizontal.view.*

class HorizontalRecyclerViewAdapter(private var mOnItemClickListener: OnItemClickListener) : RecyclerView.Adapter<HorizontalRecyclerViewAdapter.ViewHolder>() {
    private var mArrayList = mutableListOf<HorizontalModel>()

    fun setData(arrayList: List<HorizontalModel>) {
        mArrayList.clear()
        mArrayList.addAll(arrayList)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_horizontal, parent, false))
    }

    override fun getItemCount(): Int {
        return mArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(model = mArrayList[position])
        holder.itemView.setOnClickListener{
            mOnItemClickListener.OnItemClick(position)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: HorizontalModel) {
            itemView.tv_item_title.text = model.name
        }
    }
}