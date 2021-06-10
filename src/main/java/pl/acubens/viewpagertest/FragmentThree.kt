package pl.acubens.viewpagertest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentThree : Fragment()
{
    companion object
    {
        const val FRAGMENT_NAME = "Three"

        fun newInstance(): FragmentThree
        {
            return FragmentThree()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View?
    {
        return inflater.inflate(R.layout.fragment_three, container, false)
    }

}