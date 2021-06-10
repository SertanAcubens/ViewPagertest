# ViewPagertest
ViewPager2 with TabLayout strange behaviour 

Start app, when fragments are displayed in ViewPager2 tap on tab three. ViewPager swipes immediately to tab (and fragment) four. 
If you tap any other tab everything works fine. 
The only thing I discovered is when you comment out line addItems(listItems) in FragmentOne

adapter = RecyclerViewAdapter().apply {
 //   addItems(listItems)
}

ViewPager2 works with no issues.

I would appreciate any help on that problem as it spoils my real application and drives me crazy.

Seems like it affects at least devices with Android 9. On some devices with Android 11 it works OK.
