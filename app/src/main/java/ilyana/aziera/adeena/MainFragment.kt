package ilyana.aziera.adeena


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import ilyana.aziera.adeena.Dua.DuaActivity
import ilyana.aziera.adeena.Gratitude.GratitudeActivity
import ilyana.aziera.adeena.R


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_main, container, false)

        val gratitude = v.findViewById<View>(R.id.bGratitude) as Button
        gratitude.setOnClickListener {
            val intent = Intent(activity, GratitudeActivity::class.java)
            startActivity(intent)
        }

        val dua = v.findViewById<View>(R.id.bDua) as Button
        dua.setOnClickListener {
            val intent = Intent(activity, DuaActivity::class.java)
            startActivity(intent)
        }
        return v
    }

    companion object {

        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}
