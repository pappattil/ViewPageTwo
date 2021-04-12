package hu.itatti.viewpagertwodemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import hu.itatti.viewpagertwodemo.databinding.ActivityMainBinding
import hu.itatti.viewpagertwodemo.pageanim.ZoomOutPageTransformer

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var pageChangeCallback = object : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            Toast.makeText(this@MainActivity, "Selected position: $position",Toast.LENGTH_LONG).show()
        }
    }

    private lateinit var pageNames: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pageNames = resources.getStringArray(R.array.tab_names)

        val fragmentStatePageAdapter = MyFragmentStatePageAdapter(this,2)
        binding.mainViewPager.adapter = fragmentStatePageAdapter

        //binding.mainViewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

        binding.mainViewPager.registerOnPageChangeCallback(pageChangeCallback)

        TabLayoutMediator(binding.tabLayout,binding.mainViewPager){
            tab,position ->
            tab.text = pageNames[position]
        }.attach()

        binding.mainViewPager.setPageTransformer(ZoomOutPageTransformer())
        //binding.mainViewPager.setPageTransformer(DepthPageTransformer())


    }

    override fun onDestroy() {
        binding.mainViewPager.unregisterOnPageChangeCallback(pageChangeCallback)
        super.onDestroy()
    }
}