# ViewPagertest
Strange VewPager2 behaviour 

Start app, when fragments are displayed in ViewPager2 tap on tab three. ViewPager swaps immediately to tab (and fragment) four. 
If you tap any other tab everything works fine. 
The only thing I discovered is that when you comment out line addItems(listItems) in FragmentOne

adapter = RecyclerViewAdapter().apply {
 //   addItems(listItems)
}

ViewPager2 works with no issues.

I would appreciate any help on that issue as it spoils my real application and drives me crazy.
