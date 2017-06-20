package com.simon.hml.viewpage3dtransformer;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/***
 * viewpage适配器
 * @author hml
 *
 */
public class MyAdapter extends PagerAdapter {

	private List<View> mList = null;

	MyAdapter(List<View> list) {
		mList = list;
	}

	@Override
	public int getCount() {
		return Integer.MAX_VALUE ;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		
		View view=mList.get(position % mList.size());
		if (view.getParent() != null) {
			((ViewPager)view.getParent()).removeView(view);
		}
		container.addView(view);
		
		return view;
	}

}
