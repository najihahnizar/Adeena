package ilyana.aziera.adeena.Zikr


import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import ilyana.aziera.adeena.R

class TuesdayActivity : AppCompatActivity() {

    internal var txt: TextView
    internal var txts: TextView? = null
    internal var images: ImageView
    internal var btn: Button
    //ImageView image;
    internal var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuesday)

        txt = findViewById<View>(R.id.kiraan) as TextView
        images = findViewById<View>(R.id.imageView) as ImageView
        btn = findViewById<View>(R.id.reset) as Button
        val mp = MediaPlayer.create(this, R.raw.beepbeep)

        txt.setOnClickListener {
            counter++
            txt.text = Integer.toString(counter)
            mp.start()
        }

    }

    fun reset(v: View) {
        counter = 0
        txt.text = counter.toString()
    }
}
