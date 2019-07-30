package com.magere.multirecyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.magere.multirecyclerview.OnItemClickListener
import com.magere.multirecyclerview.R
import com.magere.multirecyclerview.models.VerticalModel
import kotlinx.android.synthetic.main.item_vertical.view.*

class VerticalRecyclerViewAdapter(private var mOnItemClickListener: OnItemClickListener) : RecyclerView.Adapter<VerticalRecyclerViewAdapter.ViewHolder>() {

    private var mArrayList = mutableListOf<VerticalModel>()

    fun setData(arrayList: List<VerticalModel>) {
        mArrayList.clear()
        mArrayList.addAll(arrayList)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_vertical, parent, false))
    }

    override fun getItemCount(): Int {
        return mArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(model = mArrayList[position], mOnItemClickListener = mOnItemClickListener)
        holder.itemView.btn_more.setOnClickListener {
            Toast.makeText(holder.itemView.context, mArrayList[position].title, Toast.LENGTH_LONG).show()
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var mAdapterHorizontal: HorizontalRecyclerViewAdapter
        fun bind(model: VerticalModel, mOnItemClickListener: OnItemClickListener) {
            itemView.tv_title.text = model.title

            itemView.rv_one.setHasFixedSize(true)
            itemView.rv_one.layoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
            mAdapterHorizontal = HorizontalRecyclerViewAdapter(mOnItemClickListener)
            mAdapterHorizontal.setData(model.arrayList)
            itemView.rv_one.adapter = mAdapterHorizontal
        }
    }
}