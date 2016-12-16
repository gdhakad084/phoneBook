package com.example.phonebook;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FavView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fav_view);
	    ListView lv= (ListView)findViewById(R.id.listViewfav);
	    Intent p= getIntent();
	    ArrayList<String> obj1= p.getStringArrayListExtra("id1");
	    final String enter[] = obj1.toArray(new String[obj1.size()]);
	    /*ArrayAdapter<String> abc= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,obj1);
	    lv.setAdapter(abc);
	   lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			String str= arg0.getItemAtPosition(arg2).toString();
			DBHelper obj=new DBHelper(getApplicationContext());
			 ArrayList<String> record=obj.search(str);
				 Intent i=new Intent(getApplicationContext(),DisplayASingleRecord.class);
				 i.putStringArrayListExtra("id", record);
				 startActivity(i);
			
		}
	});*/
	    FavListAdapter rdf= new FavListAdapter(this,enter);
	    lv.setAdapter(rdf);
	    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String str= enter[arg2];
				DBHelper obj=new DBHelper(getApplicationContext());
				 ArrayList<String> record=obj.search(str);
					 Intent i=new Intent(getApplicationContext(),DisplayASingleRecord.class);
					 i.putStringArrayListExtra("id", record);
					 startActivity(i);
					
				
			}
		});
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_fav_view, menu);
		return true;
	}

}
