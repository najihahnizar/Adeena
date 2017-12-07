package ilyana.aziera.adeena.Gratitude

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase

class DBGManager(private val context: Context) {
    private var dbHelper: DBGHelper? = null
    private var database: SQLiteDatabase? = null

    @Throws(SQLException::class)
    fun open(): DBGManager {
        dbHelper = DBGHelper(context)
        database = dbHelper!!.writableDatabase
        return this
    }

    fun close() {
        dbHelper!!.close()
    }


    fun insert(name: String, desc: String, date: String) {

        val contentValue = ContentValues()
        contentValue.put(DBGHelper.SUBJECT, name)
        contentValue.put(DBGHelper.DESC, desc)
        contentValue.put(DBGHelper.DATE, date)
        database!!.insert(DBGHelper.TABLE_NAME, null, contentValue)
    }

    fun fetch(): Cursor? {
        val columns = arrayOf(DBGHelper._ID, DBGHelper.SUBJECT, DBGHelper.DESC, DBGHelper.DATE)
        val cursor = database!!.query(DBGHelper.TABLE_NAME, columns, null, null, null, null, null, null)
        cursor?.moveToFirst()
        return cursor
    }

    fun update(_id: Long, name: String, desc: String, date: String): Int {
        val contentValues = ContentValues()
        contentValues.put(DBGHelper.SUBJECT, name)
        contentValues.put(DBGHelper.DESC, desc)
        contentValues.put(DBGHelper.DATE, date)
        return database!!.update(DBGHelper.TABLE_NAME, contentValues, DBGHelper._ID + " = " + _id, null)
    }

    fun delete(_id: Long) {
        database!!.delete(DBGHelper.TABLE_NAME, DBGHelper._ID + "=" + _id, null)
    }
}


