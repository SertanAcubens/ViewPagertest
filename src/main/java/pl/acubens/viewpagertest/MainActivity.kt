package pl.acubens.viewpagertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import pl.acubens.viewpagertest.ui.PagerDiffUtil

class MainActivity : AppCompatActivity()
{
    // ViewPager adapter
    private val mAdapter = Adapter(this)

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
            setSupportActionBar(toolbar)

        val actionBar: ActionBar? = supportActionBar
            actionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
            }

        val viewPager = findViewById<ViewPager2>(R.id.viewpager)
        val tabLayout = findViewById<TabLayout>(R.id.tabs)

        viewPager.adapter = mAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = mAdapter.getPageTitle(position)
        }.attach()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int)
            {
                //Set AppBarLayout expanded on position 0
                findViewById<AppBarLayout>(R.id.appbar).apply {
                    if (position == 0) {
                        setExpanded(true, true)
                    } else {
                        setExpanded(false, true)
                    }
                }
            }
        })

        mAdapter.apply {
            addFragment(FragmentLoader.FRAGMENT_NAME)
        }

        Handler(Looper.getMainLooper()).postDelayed({
            addFragments()
        }, 2000)
    }


    private fun addFragments()
    {
        val oldItems = mAdapter.getFragmentNames()
        val newItems = arrayListOf<String>().apply {
            add(FragmentZero.FRAGMENT_NAME)
            add(FragmentOne.FRAGMENT_NAME)
            add(FragmentTwo.FRAGMENT_NAME)
            add(FragmentThree.FRAGMENT_NAME)
            add(FragmentFour.FRAGMENT_NAME)
        }

        mAdapter.apply {
            val callback = PagerDiffUtil(oldItems, newItems)
            val diff = DiffUtil.calculateDiff(callback)
            addFragments(newItems)
            diff.dispatchUpdatesTo(this)
        }
    }

    private inner class Adapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
        private val mFragmentNames = ArrayList<String>()


        override fun createFragment(position: Int): Fragment
        {
            return when (position) {
                0 -> {
                    return when (mFragmentNames[0]) {
                        FragmentLoader.FRAGMENT_NAME -> {
                            FragmentLoader.newInstance()
                        }
                        else -> {
                            FragmentZero.newInstance()
                        }
                    }
                }

                1 -> {
                    FragmentOne.newInstance()
                }

                2 -> {
                    FragmentTwo.newInstance()
                }

                3 -> {
                    FragmentThree.newInstance()
                }

                4 -> {
                    FragmentFour.newInstance()
                }

                else -> {
                    throw IllegalStateException("Fragment $position is not correct")
                }
            }
        }


        override fun getItemId(position: Int): Long {
            return mFragmentNames[position].hashCode().toLong()
        }


        override fun containsItem(itemId: Long): Boolean {
            return mFragmentNames.any { it.hashCode().toLong() == itemId }
        }


        override fun getItemCount(): Int {
            return mFragmentNames.size
        }


        fun addFragment(name: String) {
            mFragmentNames.add(name)
            notifyDataSetChanged()
        }


        fun getPageTitle(position: Int): CharSequence {
            return mFragmentNames[position]
        }


        fun getFragmentNames(): ArrayList<String> {
            return mFragmentNames
        }


        fun addFragments(fragmentNames: ArrayList<String>) {
            mFragmentNames.clear()
            mFragmentNames.addAll(fragmentNames)
        }
    }
}
