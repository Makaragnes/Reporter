package com.example.reporter.ui.fragments.testFragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reporter.R
import com.example.reporter.models.ListItemModel
import kotlinx.android.synthetic.main.test_item.view.*

class AdapterForTestListFragment:
    RecyclerView.Adapter<AdapterForTestListFragment.AdapterForeTestFragmentHolder>() {

    private var mList = mutableListOf<ListItemModel>()

    private val num = 5

    class AdapterForeTestFragmentHolder(view: View): RecyclerView.ViewHolder(view) {
        var testtext: TextView = view.test_item

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterForeTestFragmentHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.test_item, parent, false)
        return AdapterForeTestFragmentHolder(view)
    }

    override fun getItemCount(): Int = num // mList.size


    override fun onBindViewHolder(holder: AdapterForeTestFragmentHolder, position: Int) {

        holder.testtext.text = mList[position].question
    }


}