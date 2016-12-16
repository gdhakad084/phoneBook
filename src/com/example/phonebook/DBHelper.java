package com.example.phonebook;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


class DBHelper extends SQLiteOpenHelper 
{
    
	 public static int dbVersion=1;
    public static String tableName="newtableap";
    public static String dbName="newdatabase4.db";
    public static String query5="create table newtableap(_id integer primary key autoincrement,name text,phone text,email text,category text)";
	public static String column1="name";
	public static String column2="phone";
	public static String column3="email";
	public static String column4="category";
    public static String TAG="MYDB";
    SQLiteDatabase db;
    
	public DBHelper(Context context)
	{
		super(context, dbName, null, dbVersion); //to create the database
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(query5);//it will create a table automatically
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	

	
	
	public void save(String uname,String number,String emailid, String type1)
	{
		db=getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put(column1, uname);
		cv.put(column2, number);
		cv.put(column3, emailid);
		cv.put(column4, type1);
		long i=db.insert(tableName, null, cv);
		System.out.println("value of i is:"+i);
		db.close();
	}
	
	public int delete(String u)
	{
		
		db=getWritableDatabase();
		String value[]={u};
		
		int i=db.delete(tableName, "username=?",value);
		
		db.close();
		
		return i;
		
	}
	public int deleteAll()
	{
		db=getWritableDatabase();
	    int i=db.delete(tableName, null, null);
	    db.close();
	    return i;
	}
	
	public int update(String u1,String p1,String c1)
	{
		db=getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put(column2, p1);
		cv.put(column3, c1);
		
		int i=db.update(tableName, cv, "name=?", new String[]{u1});
		db.close();
		return i;	
	}
	
	//to fetch all the records from the database
	public ArrayList<String> viewAll()
	{
		db=getWritableDatabase();
		ArrayList<String> alist=new ArrayList<String>();
	    Cursor c=db.query(tableName, null, null, null, null, null, "name");
	    Cursor d=db.query(tableName, null, null, null, null, null, "phone");
		int count1=c.getColumnCount();
		if(c!=null&&d!=null)//
		{
			while(c.moveToNext()&&d.moveToNext())//
			{   
				String name1=c.getString(1);
				String number=c.getString(2);
				  //fetching the values from second column
				
				alist.add(name1+"|"+number);//
			}
			
		}
		
		db.close();
		
		return alist;
	}
	
	public ArrayList<String> search(String name )
	{
		ArrayList<String> alist=new ArrayList<String>();
		db=getWritableDatabase();
		Cursor c=db.query(tableName, null, "name=?", new String[]{name}, null, null, null);
		
		int count=c.getColumnCount();
		if(c!=null)
		{
			c.moveToNext();
			int id=c.getInt(0);
			String name1=c.getString(1);
			String mobile=c.getString(2);
			String mail=c.getString(3);
            String categ = c.getString(4); 
			//alist.add(String.valueOf(id));
			alist.add(name1);
			alist.add(mobile);
			alist.add(mail);
			alist.add(categ);
		}
		db.close();
		return alist;
	}
	public ArrayList<String> viewCategory()
	{
		db=getWritableDatabase();
		ArrayList<String> alistx=new ArrayList<String>();
	    Cursor l=db.query(tableName, null, null, null, null, null, "name");
	    Cursor m=db.query(tableName, null, null, null, null, null, "category");
		int count1=l.getColumnCount();
		if(l!=null&&m!=null)
		{
			while(l.moveToNext()&&m.moveToNext())
			{   
				String name2=l.getString(1);
				String type1=m.getString(4);
				  //fetching the values from second column
				
				alistx.add(name2+"|"+type1);
			}
			
		}
		
		db.close();
		
		return alistx;
	}
	
	
   
}







