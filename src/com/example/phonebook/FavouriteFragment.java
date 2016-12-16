package com.example.phonebook;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.w3c.dom.Text;

import android.R.integer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FavouriteFragment extends android.support.v4.app.Fragment {
	Context cs;
	ListView ls1;
	public FavouriteFragment(Context cs)
	{
		this.cs= cs;
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View viewfrag= inflater.inflate(R.layout.activity_favourite, container,false);
	    ls1=(ListView)viewfrag.findViewById(R.id.listViewtest);		
	    DBHelper db= new DBHelper(cs);
	    
	    ArrayList<String> als= db.viewCategory();
	    int n1= als.size();
	     String arr1[]= new String[n1];//contain all name
	    String arr12[]= new String[n1];
	     String arr2[]= new String[]{"friends","family","classmate","business","office","school","college","neighbours","others"};
	     
	    
	     int friends=0,family=0,classmate=0,business=0,others=0,office=0,school=0,college=0,neighbours=0;
	    for(int j=0;j<n1;j++)
	    {
	    	 String s12= als.get(j);
	    	 int getIndex= s12.indexOf('|');
	    	 String s13= s12.substring(0,getIndex);
	    	 String s14=s12.substring(getIndex+1);
	    	 arr1[j]=s13;//all name stored
	    	 arr12[j]=s14;// all category stored
	         }
	    
	    for(int k=0;k<n1;k++)
	    {
            if(arr12[k].equalsIgnoreCase("friends"))
	    	{
	    		friends= friends+1;
	         }
            else if(arr12[k].equalsIgnoreCase("family"))
            {
            	family=family+1;
            }
            else if(arr12[k].equalsIgnoreCase("classmate"))
            {
            	classmate= classmate +1;
            }
            else if(arr12[k].equalsIgnoreCase("business"))
            {
            	business = business+1;
            }
            else if(arr12[k].equalsIgnoreCase("office"))
            {
            	office =office+1;
            }
            else if(arr12[k].equalsIgnoreCase("school"))
            {
            	school = school+1;
            }
            else if(arr12[k].equalsIgnoreCase("college"))
            {
            	college =college+1;
            }
            else if(arr12[k].equalsIgnoreCase("neighbours"))
            {
            	neighbours =neighbours+1;
            }
            else 
            {
            	others=others+1;
            }
          }
	      final String friend[] = new String[friends];
	      final  String family1[] = new String[family];
	      final String classmate1 [] = new String[classmate];
	      final String business1[] = new String[business];
	      final String office1[] = new String[office];
	      final String school1[] = new String[school];
	      final String college1[] = new String[college];
	      final String neighbours1[] = new String[neighbours];
	      final String others1[] = new String[others];
	      int e1=0,e2=0,e3=0,e4=0,e5=0,e6=0,e7=0,e8=0,e9=0;
	      
	      for(int u=0; u<n1; u++)
	      { 
	    	if(arr12[u].equalsIgnoreCase("friends"))
	    	{
	    		friend[e1]=arr1[u];
	    		e1++;
	    	}
	    	else if(arr12[u].equalsIgnoreCase("family"))
	    	{
	    		family1[e2]=arr1[u];
	    		e2++;
	    	}
	    	else if(arr12[u].equalsIgnoreCase("classmate"))
	    	{
	    		classmate1[e3]=arr1[u];
	    		e3++;
	    	}
	    	else if(arr12[u].equalsIgnoreCase("business"))
	    	{
	    		business1[e4]=arr1[u];
	    		e4++;
	    	}
	    	else if(arr12[u].equalsIgnoreCase("office"))
	    	{
	    		office1[e5]=arr1[u];
	    		e5++;
	    	}
	    	else if(arr12[u].equalsIgnoreCase("school"))
	    	{
	    		school1[e6]=arr1[u];
	    		e6++;
	    	}
	    	else if(arr12[u].equalsIgnoreCase("college"))
	    	{
	    		college1[e7]=arr1[u];
	    		e7++;
	    	}
	    	else if(arr12[u].equalsIgnoreCase("neighbours"))
	    	{
	    		neighbours1[e8]=arr1[u];
	    		e8++;
	    	}
	    	else
	    	{
	    		others1[e9]=arr1[u];
	    		e9++;
	    	}
	    	
	      } 
	    
	    String otherp[]= new String [9];
	    otherp[0]=Integer.toString(friends);
	    otherp[1]=Integer.toString(family);
	    otherp[2]=Integer.toString(classmate);
	    otherp[3]=Integer.toString(business);
	    otherp[4]=Integer.toString(office);
	    otherp[5]=Integer.toString(school);
	    otherp[6]=Integer.toString(college);
	    otherp[7]=Integer.toString(neighbours);
	    otherp[8]=Integer.toString(others);
	    FavListViewAdapter flva= new FavListViewAdapter(getActivity(), arr2, otherp);
	    ls1.setAdapter(flva);
	    ls1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
				
				if(arg2==0){
					ArrayList<String> f1 = new ArrayList<String>(Arrays.asList(friend));
					Intent i= new Intent(cs, FavView.class);
			    i.putStringArrayListExtra("id1",f1);
				startActivity(i);
				}
				else if(arg2==1){
					ArrayList<String> f1 = new ArrayList<String>(Arrays.asList(family1));
					Intent i= new Intent(cs, FavView.class);
			    i.putStringArrayListExtra("id1",f1);
				startActivity(i);
				}
				else if(arg2==2){
					ArrayList<String> f1 = new ArrayList<String>(Arrays.asList(classmate1));
					Intent i= new Intent(cs, FavView.class);
			    i.putStringArrayListExtra("id1",f1);
				startActivity(i);
				}
				else if(arg2==3){
					ArrayList<String> f1 = new ArrayList<String>(Arrays.asList(business1));
					Intent i= new Intent(cs, FavView.class);
			    i.putStringArrayListExtra("id1",f1);
				startActivity(i);
				}
				else if(arg2==2){
					ArrayList<String> f1 = new ArrayList<String>(Arrays.asList(office1));
					Intent i= new Intent(cs, FavView.class);
			    i.putStringArrayListExtra("id1",f1);
				startActivity(i);
				}
				else if(arg2==2){
					ArrayList<String> f1 = new ArrayList<String>(Arrays.asList(school1));
					Intent i= new Intent(cs, FavView.class);
			    i.putStringArrayListExtra("id1",f1);
				startActivity(i);
				}
				else if(arg2==2){
					ArrayList<String> f1 = new ArrayList<String>(Arrays.asList(college1));
					Intent i= new Intent(cs, FavView.class);
			    i.putStringArrayListExtra("id1",f1);
				startActivity(i);
				}
				else if(arg2==2){
					ArrayList<String> f1 = new ArrayList<String>(Arrays.asList(neighbours1));
					Intent i= new Intent(cs, FavView.class);
			    i.putStringArrayListExtra("id1",f1);
				startActivity(i);
				}
				else{
					ArrayList<String> f1 = new ArrayList<String>(Arrays.asList(neighbours1));
					Intent i= new Intent(cs, FavView.class);
			    i.putStringArrayListExtra("id1",f1);
				startActivity(i);
					
				}
				
			}
	
	    });
	    /*ArrayAdapter<String> adb= new ArrayAdapter<String>(cs, android.R.layout.simple_dropdown_item_1line, arr2);
	    ls1.setAdapter(adb);*/
		return viewfrag;
	        
	}
}
