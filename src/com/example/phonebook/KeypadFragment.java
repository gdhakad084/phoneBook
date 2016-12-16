package com.example.phonebook;
import java.io.InputStream;
import java.util.ArrayList;




import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class KeypadFragment extends android.support.v4.app.Fragment{
	String str1="";
	EditText e1;
	 Bitmap orignal;
	AutoCompleteTextView auto;
	private static final int SELECT_PICTURE = 1;
	 private String selectedImagePath;
	 private ImageButton img;
	 private static int RESULT_LOAD_IMG = 1;
	RadioGroup rg1;
	Context c;
	public KeypadFragment(Context c)
	{
		this.c=c;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 
		View view= inflater.inflate(R.layout.activity_keypad_page, container,false);
		e1= (EditText)view.findViewById(R.id.editText1);
		
		
		Button b1= (Button)view.findViewById(R.id.button1);
		Button b2= (Button)view.findViewById(R.id.button2);
		assert b1 != null;
		Button b3= (Button)view.findViewById(R.id.button3);
		Button b4= (Button)view.findViewById(R.id.button11);
		Button b5= (Button)view.findViewById(R.id.button12);
		Button b6= (Button)view.findViewById(R.id.button13);
		Button b7= (Button)view.findViewById(R.id.button14);
		Button b8= (Button)view.findViewById(R.id.button15);
		Button b9= (Button)view.findViewById(R.id.button16);
		Button b10= (Button)view.findViewById(R.id.button17);
		Button b11= (Button)view.findViewById(R.id.button18);
		Button b12= (Button)view.findViewById(R.id.button19);
		Button b13= (Button)view.findViewById(R.id.button20);
		Button b14= (Button)view.findViewById(R.id.button21);
		Button b15= (Button)view.findViewById(R.id.button22);
		ImageButton b0=(ImageButton)view.findViewById(R.id.button0);
		auto = (AutoCompleteTextView)view.findViewById(R.id.autoCompleteTextView1);
		DBHelper sb = new DBHelper(c);
		ArrayList<String > alist = sb.viewAll();
		int n= alist.size();
		   String array1[]= new String[n];
		   String array2[]= new String[n];
		   for(int i=0;i<n;i++)
		   {
			   String s1= alist.get(i);
			   int a1=s1.indexOf('|');
			   String s2=s1.substring(0, a1);
			   String s3= s1.substring(a1+1);
			   array1[i]=s2;
			   array2[i]=s3;
		   }
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, array1);
		auto.setAdapter(adapter);
		auto.setThreshold(3);
		b0.setOnClickListener(new View.OnClickListener() {
		
			
			@Override
			public void onClick(View v) {
			try{
				String str4=auto.getText().toString();		
		        DBHelper obj=new DBHelper(c);
				 ArrayList<String> record=obj.search(str4);
				 
				 Intent i=new Intent(c, DisplayASingleRecord.class);
				 i.putStringArrayListExtra("id", record);
				 startActivity(i);		
			}
			catch(Exception e){
				}
			Toast.makeText(c, "Enter name to search", Toast.LENGTH_LONG).show();
			}
		                         	
			});
		
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final Dialog dialog=new Dialog(c);
				
                dialog.setContentView(R.layout.custom);
                dialog.setTitle("Add new Contact");
                ImageButton c1= (ImageButton)dialog.findViewById(R.id.imagebuttonimage);
                Button d1=(Button)dialog.findViewById(R.id.button2);
                Button d2=(Button)dialog.findViewById(R.id.button1); 
                final AutoCompleteTextView bp= (AutoCompleteTextView)dialog.findViewById(R.id.AutoCompleteTextView11);
                 String s1[] = {"friends","family","classmate","business","office","school","college","neighbours","others"};
                 ArrayAdapter<String> sc= new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, s1);
                 bp.setAdapter(sc);
                 bp.setThreshold(2);
                final EditText ea= (EditText)dialog.findViewById(R.id.editText11);
                final EditText eb= (EditText)dialog.findViewById(R.id.editText12);
                final EditText ec= (EditText)dialog.findViewById(R.id.editText13);
                eb.setText(str1); 
               c1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					Intent i=new Intent();
	                i.setAction(Intent.ACTION_GET_CONTENT);
	                i.addCategory(Intent.CATEGORY_OPENABLE);
	                i.setType("image/*");
	                startActivityForResult(i, RESULT_LOAD_IMG);

				}
			});
               

                               d2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    	DBHelper db;
                        db = new DBHelper(c);
                    String s1= ea.getText().toString();
                    String s2= eb.getText().toString();
                    String s3= ec.getText().toString();
                    String s4= bp.getText().toString();
                    db.save(s1, s2, s3, s4);
                    Toast.makeText(c, " Contact added", Toast.LENGTH_LONG).show();
           		    ea.setText(null);
           		   eb.setText(null);
           		   ec.setText(null);
                  bp.setText(null);
                    }
                });
                
                
                d1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        
                    ea.setText(null);
                    eb.setText(null);
                    ec.setText(null);
                    }
                }); 
               
               

          Button d=(Button)dialog.findViewById(R.id.button3);

                d.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
	          			
				}
		});
		
		
       b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try{
				long l = Long.parseLong(str1);
				Toast.makeText(c, "asdfadf", Toast.LENGTH_LONG).show();
				Intent i = new Intent(Intent.ACTION_DIAL,Uri.parse("tel://"+l));
		        startActivity(i);}
				catch(Exception e){}
				}
		 });
       b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(str1.length()==0)
		           {
		        	   
		           }
		           else
		           {
		           int len=str1.length();
		            str1=str1.substring(0,len-1);
		    		e1.setText(str1);
		           }
				}
		 });
       
       b4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				str1= str1+"1";
				e1.setText(str1);
				}
		});
       b5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				str1= str1+"2";
				e1.setText(str1);
				}
		});
       b6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				str1= str1+"3";
				e1.setText(str1);
				}
		});
       b7.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				str1= str1+"4";
				e1.setText(str1);
				}
		});
       b8.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				str1= str1+"5";
				e1.setText(str1);
				}
		});
       b9.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				str1= str1+"6";
				e1.setText(str1);
				}
		});
       b10.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				str1= str1+"7";
				e1.setText(str1);
				}
		});
       b11.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				str1= str1+"8";
				e1.setText(str1);
				}
		});
       b12.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				str1= str1+"9";
				e1.setText(str1);
				}
		});
       b13.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				str1= str1+"*";
				e1.setText(str1);
				}
		});
       b14.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				str1= str1+"0";
				e1.setText(str1);
				}
		});
       b15.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				str1= str1+"#";
				e1.setText(str1);
				}
		});
		return view;
		
	}

	 

}
