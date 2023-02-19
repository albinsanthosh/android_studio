package first.javapoint.com.empinfosystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHandler extends SQLiteOpenHelper {
    public DataBaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Employee(empId integer primary key, 'empName' varchar(100))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Employee");
        onCreate(db);
    }

    /***
     * to add employee into the table
     */
    void addData(){
        SQLiteDatabase db = this.getWritableDatabase();

        // prepare the data to be written into the table
        ContentValues values = new ContentValues();
        values.put("empId", 102);
        values.put("empName", "Albin");
        db.insert("Employee", null, values);
        db.close();
    }

    /***
     * to retrieve the table content
     * @return table values
     */
    String getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Employee", null);
        String result = "";
        // move the cursor to first row : movetoNext
        while(cursor.moveToNext()){
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            result += id + ":" + name + "\n";
        }
        db.close();
        return result;
    }
}
