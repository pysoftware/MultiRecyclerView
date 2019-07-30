package com.magere.multirecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.magere.multirecyclerview.adapters.HorizontalRecyclerViewAdapter
import com.magere.multirecyclerview.adapters.VerticalRecyclerViewAdapter
import com.magere.multirecyclerview.models.HorizontalModel
import com.magere.multirecyclerview.models.VerticalModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var arrayListVertical = ArrayList<VerticalModel>()
    private lateinit var mAdapter: VerticalRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mOnItemClickListener = object : OnItemClickListener {
            override fun OnItemClick(position: Int) {
                Toast.makeText(applicationContext, "$position", Toast.LENGTH_LONG).show()
            }
        }
        mAdapter = VerticalRecyclerViewAdapter(mOnItemClickListener)
        rv_main.setHasFixedSize(true)
        rv_main.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        setData()
        rv_main.adapter = mAdapter

    }
    private fun setData() {
        for (i in 1..100) {
            val arrayList = ArrayList<HorizontalModel>()
            for (j in 1..100) {

                val horizontalModel = HorizontalModel("Name $j", "Description $j")
                arrayList.add(horizontalModel)

            }
            val verticalModel = VerticalModel("Title $i", arrayList)
            verticalModel.arrayList = arrayList
            arrayListVertical.add(verticalModel)
        }

        mAdapter.setData(arrayListVertical)
    }
}
