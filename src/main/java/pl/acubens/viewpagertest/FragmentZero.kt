package pl.acubens.viewpagertest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentZero : Fragment()
{
    companion object
    {
        const val FRAGMENT_NAME = "Zero"

        fun newInstance(): FragmentZero
        {
            return FragmentZero()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View?
    {
        return inflater.inflate(R.layout.fragment_zero, container, false)
    }
}