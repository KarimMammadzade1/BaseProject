package rteam.project.mainproject.BaseAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T> : RecyclerView.Adapter<BaseRecyclerViewHolder>() {
    var list = ArrayList<T>()
    fun setData(l: ArrayList<T>) {
        list.clear()
        list.addAll(l)
        notifyDataSetChanged()
    }

    abstract fun getLayout(): Int
    abstract override fun onBindViewHolder(holder: BaseRecyclerViewHolder, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(getLayout(), parent, false)
        return BaseRecyclerViewHolder(view)
    }

    override fun getItemCount() = list.size
}

class BaseRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view)
