package com.example.phonebook;

import java.util.ArrayList;



import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;




public class ContactFragment extends Fragment   {
	Context c;
	public ContactFragment(Context c){
		this.c=c;
	}
	ListView lview;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_contact_page, container,false);
		lview= (ListView)view.findViewById(R.id.listView11); 
        	   
		DBHelper cb= new DBHelper(c);
	   ArrayList<String> alist = cb.viewAll();
	   int n= alist.size();
	   final String array1[]= new String[n];
	   final String array2[]= new String[n];
	   for(int i=0;i<n;i++)
	   {
		   String s1= alist.get(i);
		  int a1=s1.indexOf('|');
		   String s2=s1.substring(0, a1);
		   String s3= s1.substring(a1+1);
		   array1[i]=s2;
		  array2[i]=s3;
	   }
	   
	   
	 //  ArrayAdapter<String> adp = new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line,alist);
	   /*CustomArrayAdapter obj = new CustomArrayAdapter(c, array1,array2);
	    lview.setAdapter(obj);
	   */ 
	   ListViewAdapter lv= new ListViewAdapter(getActivity(), array1, array2);
	  lview.setAdapter(lv);
	  lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			String str=array1[arg2];
			//int position1= str.indexOf('|');
			//String str1= str.substring(0, position1);
			  //Toast.makeText(c, "ur selection is:"+str, Toast.LENGTH_LONG).show();
			 DBHelper obj=new DBHelper(c);
		 ArrayList<String> record=obj.search(str);
			 Intent i=new Intent(c,DisplayASingleRecord.class);
			 i.putStringArrayListExtra("id", record);
			 startActivity(i);
			
		}
	});
	 //  lview.setOnItemClickListener(this);
			    return view;     
	}
	
	/*@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	String str=arg0.getItemAtPosition(arg2).toString();
	int position1= str.indexOf('|');
	String str1= str.substring(0, position1);
	  //Toast.makeText(c, "ur selection is:"+str, Toast.LENGTH_LONG).show();
	 DBHelper obj=new DBHelper(c);
 ArrayList<String> record=obj.search(str1);
	 Intent i=new Intent(c,DisplayASingleRecord.class);
	 i.putStringArrayListExtra("id", record);
	 startActivity(i);
	
	
		
	}*/
	
}
