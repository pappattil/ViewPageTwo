package hu.itatti.viewpagertwodemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
class FragmentPageTwo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_page_two, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentPageTwo()
    }
}