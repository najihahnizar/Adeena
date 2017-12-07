package ilyana.aziera.adeena.Zikr

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView

import ilyana.aziera.adeena.R

/**
 * Created by aziera_ilyana on 4/12/2017.
 */

class DuaSevenActivity : AppCompatActivity() {

    internal var txt: TextView
    internal var images: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dua_seven)

        txt = findViewById<View>(R.id.textView2)
        images = findViewById<View>(R.id.imageView13)

    }

}