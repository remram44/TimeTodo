package fr.remram.timetodo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TaskManager {

    private static final String TASKS_TABLE = "tasks";

    private static final String DATABASE_NAME = "TimeTodo";
    private static final int DATABASE_VERSION = 1;

    public static final String TASK_NAME = "name";
    public static final String TASK_PERIOD = "period";

    class SQLHelper extends SQLiteOpenHelper {

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(
                    "CREATE TABLE " + TASKS_TABLE + " (" +
                    "    _id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "    " + TASK_NAME + " TEXT NOT NULL," +
                    "    " + TASK_PERIOD + " INTEGER NOT NULL" +
                    ");");
            // DEBUG
            db.execSQL(
                    "INSERT INTO " + TASKS_TABLE +
                    "(" + TASK_NAME + ", " + TASK_PERIOD + ")" +
                    "VALUES('First task', 3600);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            // No versions yet
        }

        SQLHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

    }

    private SQLHelper database;

    public TaskManager(Context context)
    {
        database = new SQLHelper(context);
    }

    public Cursor getTasksCursor()
    {
        SQLiteDatabase db = database.getReadableDatabase();
        return db.query(
                TASKS_TABLE,                            // table
                null,                                   // columns
                null,                                   // selection
                null,                                   // selectionArgs
                null,                                   // groupBy
                null,                                   // having
                TASK_NAME);                             // orderBy
    }

}
