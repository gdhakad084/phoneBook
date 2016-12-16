package com.example.phonebook;

import java.util.ArrayList;





import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayASingleRecord extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_asingle_record);
       //ListView	lview=(ListView)findViewById(R.id.listView21);
		 TextView tv1= (TextView)findViewById(R.id.textView1111);
		 TextView tv2= (TextView)findViewById(R.id.textView2222);
		 TextView tv3= (TextView)findViewById(R.id.textView3333);
		 TextView tv4= (TextView)findViewById(R.id.textView4444);
		 Button bemail= (Button)findViewById(R.id.button1111);
		 Button bedit= (Button)findViewById(R.id.button2222);
		 Button bcall= (Button)findViewById(R.id.button3333);
		 Button bsms= (Button)findViewById(R.id.button4444);
		 Intent i=getIntent();
		   ArrayList<String> obj=i.getStringArrayListExtra("id");
		 //  ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, obj);
		   //lview.setAdapter(adapter);  
		   int u= obj.size(); 
		   final String valuetaken[] =new String [u]; 
		  
		   for(int k=0;k<u;k++)
		   {
			   valuetaken[k]=obj.get(k); 
			   
		   }
		   tv3.setText(valuetaken[0]);//to set name 
		   tv2.setText(valuetaken[1]);//to set phone no
		   tv1.setText(valuetaken[2]);
		   tv4.setText(valuetaken[3]);
		   bemail.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                final Dialog dialog=new Dialog(DisplayASingleRecord.this);
	                dialog.setContentView(R.layout.custom1);
	                dialog.setTitle("Send An Email");
	             
	                final EditText e1= (EditText)dialog.findViewById(R.id.editText1111);
	               final EditText e2= (EditText)dialog.findViewById(R.id.editText2222);
	               final EditText e3= (EditText)dialog.findViewById(R.id.editText3333);
	               e1.setText(valuetaken[2]);

	          Button d=(Button)dialog.findViewById(R.id.buttonquit);

	                d.setOnClickListener(new View.OnClickListener() {
	                    @Override
	                    public void onClick(View v) {
	                        dialog.dismiss();
	                    }
	                });
	         Button cancel= (Button)dialog.findViewById(R.id.button1cancel);
	             cancel.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						e1.setText(null);
						e2.setText(null);
						e3.setText(null);
						
					}
				});
	         Button sending = (Button)dialog.findViewById(R.id.button143);
	         sending.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					
					
					String To= e1.getText().toString();
					String Subject= e2.getText().toString();
					String Message= e3.getText().toString();
					Intent email= new Intent(Intent.ACTION_SEND);
					email.setType("message/rfc822");
					email.putExtra(Intent.EXTRA_EMAIL, To);
					email.putExtra(Intent.EXTRA_SUBJECT, Subject);
					email.putExtra(Intent.EXTRA_TEXT, Message);
                    
					Intent i= Intent.createChooser(email, "Choose an email client");
					startActivity(i);
					
				}
			});
	                
	                dialog.show();
	            }
	        });

	       bcall.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					try{
						final String callnumber = valuetaken[1];
						long k = Long.parseLong(callnumber);
						Toast.makeText(getApplicationContext(), "call", Toast.LENGTH_LONG).show();
						Intent i = new Intent(Intent.ACTION_DIAL,Uri.parse("tel://"+k));
				        startActivity(i);}
						catch(Exception e){}
						}
					
				}
			);
	      
	       
	       bedit.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					final Dialog dialog1=new Dialog(DisplayASingleRecord.this);
	                dialog1.setContentView(R.layout.custom_dialog_edit);
	                dialog1.setTitle("Edit Your Informatiom");
	                final EditText name= (EditText)dialog1.findViewById(R.id.nameText);
		               final EditText number= (EditText)dialog1.findViewById(R.id.contactText);
		               final EditText email= (EditText)dialog1.findViewById(R.id.emailText);
		               name.setText(valuetaken[0]);

		          Button d1=(Button)dialog1.findViewById(R.id.button142);

		                d1.setOnClickListener(new View.OnClickListener() {
		                    @Override
		                    public void onClick(View v) {
		                        dialog1.dismiss();
		                    }
		                });
				          Button d2=(Button)dialog1.findViewById(R.id.buttontocancel);

			                d2.setOnClickListener(new View.OnClickListener() {
			                    @Override
			                    public void onClick(View v) {
			                       name.setText(null);
			                       number.setText(null);
			                       email.setText(null);
			                    }
			                });
					          Button d3=(Button)dialog1.findViewById(R.id.buttontoupdate);

				                d3.setOnClickListener(new View.OnClickListener() {
				                    @Override
				                    public void onClick(View v) {
				                    	DBHelper obj1=new DBHelper(DisplayASingleRecord.this);
				    					
				                    	String u1=name.getText().toString();
				    					String p1=number.getText().toString();
				    					String c1=email.getText().toString();
				    					int i=obj1.update(u1, p1, c1);
				    					Toast.makeText(getApplicationContext(), i+" record updated!", Toast.LENGTH_LONG).show();
				                    }
				                });
	                
	                dialog1.show();     		
				}
	       });
	       bsms.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					
				}
				}
	       );
	}
}
