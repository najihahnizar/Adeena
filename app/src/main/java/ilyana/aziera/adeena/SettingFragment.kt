package ilyana.aziera.adeena


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ilyana.aziera.adeena.R


/**
 * A simple [Fragment] subclass.
 */
class SettingFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_setting, container, false)
    }

    companion object {


        fun newInstance(): SettingFragment {
            return SettingFragment()
        }
    }

}
