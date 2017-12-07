package ilyana.aziera.adeena.Dua

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase

class DGDManager(private val context: Context) {
    private var dbHelper: DBDHelper? = null
    private var database: SQLiteDatabase? = null

    @Throws(SQLException::class)
    fun open(): DGDManager {
        dbHelper = DBDHelper(context)
        database = dbHelper!!.writableDatabase
        return this
    }

    fun close() {
        dbHelper!!.close()
    }


    fun insert(name: String, desc: String, date: String) {

        val contentValue = ContentValues()
        contentValue.put(DBDHelper.SUBJECT, name)
        contentValue.put(DBDHelper.DESC, desc)
        contentValue.put(DBDHelper.DATE, date)
        database!!.insert(DBDHelper.TABLE_NAME, null, contentValue)
    }

    fun fetch(): Cursor? {
        val columns = arrayOf(DBDHelper._ID, DBDHelper.SUBJECT, DBDHelper.DESC, DBDHelper.DATE)
        val cursor = database!!.query(DBDHelper.TABLE_NAME, columns, null, null, null, null, null, null)
        cursor?.moveToFirst()
        return cursor
    }

    fun update(_id: Long, name: String, desc: String, date: String): Int {
        val contentValues = ContentValues()
        contentValues.put(DBDHelper.SUBJECT, name)
        contentValues.put(DBDHelper.DESC, desc)
        contentValues.put(DBDHelper.DATE, date)
        return database!!.update(DBDHelper.TABLE_NAME, contentValues, DBDHelper._ID + " = " + _id, null)
    }

    fun delete(_id: Long) {
        database!!.delete(DBDHelper.TABLE_NAME, DBDHelper._ID + "=" + _id, null)
    }
}
