package ilyana.aziera.adeena.Gratitude

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.database.Cursor
import android.graphics.Color
import android.support.v4.widget.SimpleCursorAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

import ilyana.aziera.adeena.R

class GratitudeActivity : AppCompatActivity() {
    private var dbManager: DBGManager? = null

    private var listView: ListView? = null

    private var adapter: SimpleCursorAdapter? = null

    internal val from = arrayOf(DBGHelper._ID, DBGHelper.SUBJECT, DBGHelper.DESC, DBGHelper.DATE)


    internal val to = intArrayOf(R.id.id, R.id.title, R.id.desc, R.id.date)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fragment_emp_list)

        dbManager = DBGManager(this)
        dbManager!!.open()
        val cursor = dbManager!!.fetch()

        listView = findViewById<View>(R.id.list_view) as ListView
        listView!!.emptyView = findViewById(R.id.empty)

        adapter = object : SimpleCursorAdapter(this, R.layout.activity_view_gratitude, cursor, from, to, 0) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                // Get the current item from ListView
                val view = super.getView(position, convertView, parent)
                if (position % 2 == 1) {
                    // Set a background color for ListView regular row/item
                    view.setBackgroundColor(Color.parseColor("#DE8BAB"))
                } else {
                    // Set the background color for alternate row/item
                    view.setBackgroundColor(Color.parseColor("#F0CBD9"))
                }
                return view
            }
        }

        adapter!!.notifyDataSetChanged()

        listView!!.adapter = adapter

        // OnCLickListiner For List Items
        listView!!.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, viewId ->
            val idTextView = view.findViewById<View>(R.id.id) as TextView
            val titleTextView = view.findViewById<View>(R.id.title) as TextView
            val descTextView = view.findViewById<View>(R.id.desc) as TextView
            val dateTextView = view.findViewById<View>(R.id.date) as TextView

            val id = idTextView.text.toString()
            val title = titleTextView.text.toString()
            val desc = descTextView.text.toString()
            val date = dateTextView.text.toString()

            val modify_intent = Intent(applicationContext, ModifyGratitude::class.java)
            modify_intent.putExtra("title", title)
            modify_intent.putExtra("desc", desc)
            modify_intent.putExtra("id", id)
            modify_intent.putExtra("date", date)

            startActivity(modify_intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_gratitude, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId
        if (id == R.id.add_gratitude) {

            val add_gra = Intent(this, AddGratitude::class.java)
            startActivity(add_gra)

        }

        if (id == R.id.information) {
            val alertDialog = AlertDialog.Builder(this).create()

            // Setting Dialog Title
            alertDialog.setTitle("My Gratitude Info")

            // Setting Dialog Message
            alertDialog.setMessage("My Gratitude is a platform to express our gratitude. We usually ignore many things that are readily available to us; they are incredible reasons to be grateful. Our family, friends, body, health, job, leisure time, education, food, wisdom, smiles, children and even the painful lessons that life teaches us (and the list goes on) are tremendous blessings to be grateful for. If you do not have the same feeling, just close your eyes and imagine one of these blessings vanishing from your life. This is exactly why you need to be thankful every moment, each day.\n" + "\n“And [remember] when your Lord proclaimed, ‘If you are grateful, I will surely increase you [in favor].” [Qur’an: Chapter 14, Verse 7]\n")

            // Setting OK Button
            alertDialog.setButton("OK") { dialog, which -> dialog.dismiss() }

            // Showing Alert Message
            alertDialog.show()
        }
        return super.onOptionsItemSelected(item)
    }
}
