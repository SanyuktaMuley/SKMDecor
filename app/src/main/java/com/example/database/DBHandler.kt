package com.example.database
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBHandler // creating a constructor for our database handler.
    (context: Context?) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    // below method is for creating a database by running a sqlite query
    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT)")

        db.execSQL(query)
    }

    fun addNewCourse(
        courseName: String?,

    ) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(NAME_COL, courseName)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    companion object {
        private const val DB_NAME = "coursedb"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "mycourses"
        private const val ID_COL = "id"
        private const val NAME_COL = "name"

    }
    fun readCourses(): ArrayList<CourseModel>? {

        val db = this.readableDatabase
        val cursorCourses: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        val courseModelArrayList: ArrayList<CourseModel> = ArrayList()
        if (cursorCourses.moveToFirst()) {
            do {
                courseModelArrayList.add(
                    CourseModel(
                        cursorCourses.getInt(0),
                        cursorCourses.getString(1)
                    )
                )
            } while (cursorCourses.moveToNext())

        }
        cursorCourses.close()
        return courseModelArrayList
    }
    fun deleteCourse(Name: String) {
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "name=?", arrayOf(Name))
        db.close()
    }

}
