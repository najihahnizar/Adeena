package ilyana.aziera.adeena.Gratitude

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import java.text.DateFormat
import java.util.Date

import ilyana.aziera.adeena.Gratitude.GratitudeActivity
import ilyana.aziera.adeena.R

class AddGratitude : Activity(), View.OnClickListener {

    private var addTodoBtn: Button? = null
    private var subjectEditText: EditText? = null
    private var descEditText: EditText? = null
    private var dateText: TextView? = null
    private var dbManager: DBGManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "Add Gratitude"

        setContentView(R.layout.activity_add_gratitude)

        subjectEditText = findViewById<View>(R.id.subject_edittext) as EditText
        descEditText = findViewById<View>(R.id.description_edittext) as EditText

        dateText = findViewById<View>(R.id.date) as TextView

        addTodoBtn = findViewById<View>(R.id.add_record) as Button

        dbManager = DBGManager(this)
        dbManager!!.open()
        addTodoBtn!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.add_record -> {

                val name = subjectEditText!!.text.toString()
                val desc = descEditText!!.text.toString()
                val date = DateFormat.getDateInstance().format(Date())
                dateText!!.text = date

                dbManager!!.insert(name, desc, date)

                val main = Intent(this@AddGratitude, GratitudeActivity::class.java)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

                startActivity(main)
            }
        }
    }

}
