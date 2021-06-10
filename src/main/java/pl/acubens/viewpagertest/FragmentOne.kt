package pl.acubens.viewpagertest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentOne : Fragment()
{
    companion object
    {
        const val FRAGMENT_NAME = "One"

        fun newInstance(): FragmentOne
        {
            return FragmentOne()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View?
    {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val headerText = "Header"

        val listItems = arrayListOf(
            "One",
            "Two",
            "Three",
            "Four",
            "Five"
        )

        val container: LinearLayout = view.findViewById(R.id.container)

        for(i in 0..2) {
            val blockLayout = requireActivity().layoutInflater.inflate(
                R.layout.block_view, container, false
            )

            blockLayout.findViewById<TextView>(R.id.header).text = headerText

            blockLayout.findViewById<RecyclerView>(R.id.list).apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(requireContext())
                adapter = RecyclerViewAdapter().apply {
                    addItems(listItems)
                }
            }

            container.addView(blockLayout)
        }
    }


    private inner class RecyclerViewAdapter :
        RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>()
    {
        private var mItems = arrayListOf<String>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
        {
            val view = requireActivity().layoutInflater.inflate(
                R.layout.list_item, parent, false
            )

            return ViewHolder(view)
        }


        override fun onBindViewHolder(holder: ViewHolder, position: Int)
        {
            holder.name.text = getItem(position)
        }


        override fun getItemCount(): Int
        {
            return mItems.size
        }


        fun addItems(items: ArrayList<String>)
        {
            mItems.addAll(items)
        }


        fun getItem(pos: Int): String
        {
            return mItems[pos]
        }


        private inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
        {
            val name: TextView = view.findViewById(R.id.item_name)
        }
    }
}