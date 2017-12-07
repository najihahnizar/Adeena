package ilyana.aziera.adeena.Dua

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import java.text.DateFormat
import java.util.Date

import ilyana.aziera.adeena.MainActivity
import ilyana.aziera.adeena.R

class ModifyDua : Activity(), View.OnClickListener {

    private var titleText: EditText? = null
    private var updateBtn: Button? = null
    private var deleteBtn: Button? = null
    private var descText: EditText? = null


    private var dateText: TextView? = null
    private var _id: Long = 0

    private var dbManager: DGDManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "Modify Gratitude"

        setContentView(R.layout.activity_modify_dua)

        dbManager = DGDManager(this)
        dbManager!!.open()

        titleText = findViewById<View>(R.id.subject_edittext) as EditText
        descText = findViewById<View>(R.id.description_edittext) as EditText

        dateText = findViewById<View>(R.id.date) as TextView

        updateBtn = findViewById<View>(R.id.btn_update) as Button
        deleteBtn = findViewById<View>(R.id.btn_delete) as Button

        val intent = intent
        val id = intent.getStringExtra("id")
        val name = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")
        val date = intent.getStringExtra("date")
        _id = java.lang.Long.parseLong(id)


        titleText!!.setText(name)
        descText!!.setText(desc)
        dateText!!.text = date

        updateBtn!!.setOnClickListener(this)
        deleteBtn!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_update -> {
                val title = titleText!!.text.toString()
                val desc = descText!!.text.toString()
                val date = DateFormat.getDateInstance().format(Date())
                dateText!!.text = date

                dbManager!!.update(_id, title, desc, date)
                this.returnHome()
            }

            R.id.btn_delete -> {
                dbManager!!.delete(_id)
                this.returnHome()
            }
        }
    }

    fun returnHome() {
        val home_intent = Intent(applicationContext, DuaActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(home_intent)
    }
}

