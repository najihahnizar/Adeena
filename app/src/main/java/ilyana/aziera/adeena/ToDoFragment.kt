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
class ToDoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_to_do, container, false)
    }

    companion object {


        fun newInstance(): ToDoFragment {
            return ToDoFragment()
        }
    }

}
