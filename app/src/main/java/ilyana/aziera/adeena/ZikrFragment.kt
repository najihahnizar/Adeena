package ilyana.aziera.adeena

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import ilyana.aziera.adeena.Gratitude.AddGratitude
import ilyana.aziera.adeena.Zikr.DuaEightActivity
import ilyana.aziera.adeena.Zikr.DuaFiveActivity
import ilyana.aziera.adeena.Zikr.DuaFourActivity
import ilyana.aziera.adeena.Zikr.DuaNineActivity
import ilyana.aziera.adeena.Zikr.DuaOneActivity
import ilyana.aziera.adeena.Zikr.DuaSevenActivity
import ilyana.aziera.adeena.Zikr.DuaSixActivity
import ilyana.aziera.adeena.Zikr.DuaThreeActivity
import ilyana.aziera.adeena.Zikr.DuaTwoActivity
import ilyana.aziera.adeena.Zikr.FridayActivity
import ilyana.aziera.adeena.Zikr.MondayActivity
import ilyana.aziera.adeena.Zikr.SaturdayActivity
import ilyana.aziera.adeena.Zikr.SundayActivity
import ilyana.aziera.adeena.Zikr.ThursdayActivity
import ilyana.aziera.adeena.Zikr.TuesdayActivity
import ilyana.aziera.adeena.Zikr.WednesdayActivity

/**
 * A simple [Fragment] subclass.
 */
class ZikrFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_zikr, container, false)

        val monday = v.findViewById<View>(R.id.bMonday) as Button
        monday.setOnClickListener {
            val intent = Intent(activity, MondayActivity::class.java)
            startActivity(intent)
        }

        val tuesday = v.findViewById<View>(R.id.bTuesday) as Button
        tuesday.setOnClickListener {
            val intent = Intent(activity, TuesdayActivity::class.java)
            startActivity(intent)
        }

        val wednesday = v.findViewById<View>(R.id.bWednesday) as Button
        wednesday.setOnClickListener {
            val intent = Intent(activity, WednesdayActivity::class.java)
            startActivity(intent)
        }

        val thursday = v.findViewById<View>(R.id.bThursday) as Button
        thursday.setOnClickListener {
            val intent = Intent(activity, ThursdayActivity::class.java)
            startActivity(intent)
        }

        val friday = v.findViewById<View>(R.id.bFriday) as Button
        friday.setOnClickListener {
            val intent = Intent(activity, FridayActivity::class.java)
            startActivity(intent)
        }

        val saturday = v.findViewById<View>(R.id.bSaturday) as Button
        saturday.setOnClickListener {
            val intent = Intent(activity, SaturdayActivity::class.java)
            startActivity(intent)
        }

        val sunday = v.findViewById<View>(R.id.bSunday) as Button
        sunday.setOnClickListener {
            val intent = Intent(activity, SundayActivity::class.java)
            startActivity(intent)
        }

        val duaOne = v.findViewById<View>(R.id.bDuaFatimah) as Button
        duaOne.setOnClickListener {
            val intent = Intent(activity, DuaOneActivity::class.java)
            startActivity(intent)
        }

        val duaTwo = v.findViewById<View>(R.id.bDuaPeriod) as Button
        duaTwo.setOnClickListener {
            val intent = Intent(activity, DuaTwoActivity::class.java)
            startActivity(intent)
        }

        val duaThree = v.findViewById<View>(R.id.bDuaKhadhijah) as Button
        duaThree.setOnClickListener {
            val intent = Intent(activity, DuaThreeActivity::class.java)
            startActivity(intent)
        }

        val duaFour = v.findViewById<View>(R.id.bDuaTask) as Button
        duaFour.setOnClickListener {
            val intent = Intent(activity, DuaFourActivity::class.java)
            startActivity(intent)
        }

        val duaFive = v.findViewById<View>(R.id.bDuaHappiness) as Button
        duaFive.setOnClickListener {
            val intent = Intent(activity, DuaFiveActivity::class.java)
            startActivity(intent)
        }

        val duaSix = v.findViewById<View>(R.id.bDuaGoodness) as Button
        duaSix.setOnClickListener {
            val intent = Intent(activity, DuaSixActivity::class.java)
            startActivity(intent)
        }

        val duaSeven = v.findViewById<View>(R.id.bDuaForgivenss) as Button
        duaSeven.setOnClickListener {
            val intent = Intent(activity, DuaSevenActivity::class.java)
            startActivity(intent)
        }

        val duaEight = v.findViewById<View>(R.id.bDuaSolehah) as Button
        duaEight.setOnClickListener {
            val intent = Intent(activity, DuaEightActivity::class.java)
            startActivity(intent)
        }

        val duaNine = v.findViewById<View>(R.id.bDuaLife) as Button
        duaNine.setOnClickListener {
            val intent = Intent(activity, DuaNineActivity::class.java)
            startActivity(intent)
        }
        return v
    }

    companion object {


        fun newInstance(): ZikrFragment {
            return ZikrFragment()
        }
    }


}