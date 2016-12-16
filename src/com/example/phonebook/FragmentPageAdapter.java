package com.example.phonebook;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentPageAdapter extends FragmentPagerAdapter 
{
   Context c;
   
	public FragmentPageAdapter(FragmentManager fm,Context c) {
		super(fm);
	this.c=c;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		switch (arg0) {
		case 0:
			return new KeypadFragment(c);
		case 1:
			return new ContactFragment(c);
		case 2:
			return new FavouriteFragment(c);
		default:
			break;
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}

}
