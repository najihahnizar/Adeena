package ilyana.aziera.adeena.Zikr

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView

import ilyana.aziera.adeena.R

class DuaTwoActivity : AppCompatActivity() {

    internal var txt: TextView
    internal var images: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dua_two)

        txt = findViewById<View>(R.id.textView2)
        images = findViewById<View>(R.id.imageView8)

    }

}