package com.example.todoalternative;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AltOpener extends SQLiteOpenHelper {

    protected final static String gall0417DB = "ToDoDB";
    protected final static int VersionNo = 1;
    public final static String TableName = "ToDoList";
    public final static String ToDoItem = "Name";
    public final static String ColumnID = "_id";

    public AltOpener(Context ctx) { super(ctx, gall0417DB, null, VersionNo); }

    //This is if the DB doesn't exist, this code should create a database
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE" + TableName + " (_id INTERGER PRIMARY KEY AUTOINCREMENT, "
                + ToDoItem + "text);" );
    }

    //This code is called if the db version number is lower than VersionNo
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //This drops the old table
        db.execSQL( "DROP TABLE IF EXISTS " + TableName);

        onCreate(db);
    }
}
