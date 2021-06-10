package pl.acubens.viewpagertest.ui

import androidx.recyclerview.widget.DiffUtil

class PagerDiffUtil(private val oldList: ArrayList<String>, private val newList: ArrayList<String>) : DiffUtil.Callback()
{
    enum class PayloadKey {
        VALUE
    }

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
    {
        return oldList[oldItemPosition].hashCode().toLong() == newList[newItemPosition].hashCode().toLong()
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
    {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any
    {
        return listOf(PayloadKey.VALUE)
    }
}
