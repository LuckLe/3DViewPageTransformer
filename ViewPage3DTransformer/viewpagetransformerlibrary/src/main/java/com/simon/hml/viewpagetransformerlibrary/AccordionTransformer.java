package com.simon.hml.viewpagetransformerlibrary;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/***
 * Created by hml on 2017/6/20.
 *
 * 左右折叠
 */
public class AccordionTransformer implements PageTransformer {

	@Override
	public void transformPage(View view, float position) {
		if (position < -1) {
		} else if (position <= 0) {// [-1,0]
			ViewHelper.setPivotX(view, view.getMeasuredWidth());
			ViewHelper.setScaleX(view, 1 + position);
		} else if (position <= 1) {// (0,1]
			ViewHelper.setPivotX(view, 0);
			ViewHelper.setScaleX(view, 1 - position);
		} else {
		}
	}
}
