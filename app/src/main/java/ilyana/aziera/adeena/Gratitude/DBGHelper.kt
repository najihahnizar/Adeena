package ilyana.aziera.adeena.Gratitude

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBGHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    companion object {

        // Table Name
        val TABLE_NAME = "GRATITUDE"
        // Table columns
        val _ID = "_id"
        val SUBJECT = "subject"
        val DESC = "description"
        val DATE = "date"

        // Database Information
        internal val DB_NAME = "MYGRATITUDE.DB"

        // database version
        internal val DB_VERSION = 1

        // Creating table query
        private val CREATE_TABLE = ("create table " + TABLE_NAME + "(" + _ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SUBJECT + " TEXT NOT NULL, " + DESC + " TEXT, " + DATE + " DATETIME DEFAULT CURRENT_DATE );")
    }
}

