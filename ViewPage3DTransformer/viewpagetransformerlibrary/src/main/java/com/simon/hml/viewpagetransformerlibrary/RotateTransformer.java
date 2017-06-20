package com.simon.hml.viewpagetransformerlibrary;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/***
 * Created by hml on 2017/6/20.
 *
 * 旋转
 */
public class RotateTransformer implements PageTransformer {
	
	@Override
	public void transformPage(View view, float position) {
		if (position < -1) {
		} else if (position <= 0) {	// [-1,0]
			ViewHelper.setScaleX(view, 1 + position);
			ViewHelper.setScaleY(view, 1 + position);
//			setRotation的度数递增↑则是顺时针旋转，递减↓则是逆时针旋转，和setRotationX相同，和setRotationY相反
			ViewHelper.setRotation(view, 360 * position);
		} else if (position <= 1) {	// (0,1]
			ViewHelper.setScaleX(view, 1 - position);
			ViewHelper.setScaleY(view, 1 - position);
			ViewHelper.setRotation(view, 360 * position);
		} else {
		}
	}

}
