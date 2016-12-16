package com.example.phonebook;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class FavListAdapter extends BaseAdapter
{
    Activity context;
    String title[];
    
 
    public FavListAdapter(Activity context, String[] title) {
        super();
        this.context = context;
        this.title = title;
        
    }
 
    public int getCount() {
        // TODO Auto-generated method stub
        return title.length;
    }
 
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }
 
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
 
    private class ViewHolder {
        TextView txtViewTitle;
        ImageView imgview23;
        ImageView imgview234;
        
    }
 
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        ViewHolder holder;
        LayoutInflater inflater =  context.getLayoutInflater();
 
        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.fav_list_view, null);
            holder = new ViewHolder();
            holder.txtViewTitle = (TextView) convertView.findViewById(R.id.text1234);
            holder.imgview234 =(ImageView)convertView.findViewById(R.id.image12345);
            holder.imgview23 =(ImageView)convertView.findViewById(R.id.image1234);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
 
        holder.txtViewTitle.setText(title[position]);
        
 
    return convertView;
    }
 
}