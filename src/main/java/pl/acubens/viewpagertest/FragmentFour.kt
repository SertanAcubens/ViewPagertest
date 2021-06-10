package pl.acubens.viewpagertest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentFour : Fragment()
{
    companion object
    {
        const val FRAGMENT_NAME = "Four"

        fun newInstance(): FragmentFour
        {
            return FragmentFour()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View?
    {
        return inflater.inflate(R.layout.fragment_four, container, false)
    }

}