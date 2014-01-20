package fr.remram.timetodo.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class SQLHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TimeTodo";
    private static final int DATABASE_VERSION = 1;

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(
                "CREATE TABLE tasks (" +
                "    id INTEGER NOT NULL PRIMARY KEY," +
                "    name TEXT NOT NULL," +
                "    period INTEGER NOT NULL" +
                ");");
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

public class DataManager {

    private SQLHelper database;

    public DataManager(Context context)
    {
        database = new SQLHelper(context);
    }

    public Iterable<Task> getTasks()
    {
        // TODO : Get tasks from database
        return null;
    }

}
