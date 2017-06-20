package com.simon.hml.viewpagetransformerlibrary;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/***
 * Created by hml on 2017/6/20.
 *
 * 立方体切换样式
 */
public class CubeTransformer implements PageTransformer {

	@Override
	public void transformPage(View view, float position) {
		int pageWidth = view.getWidth();
		int pageHeight = view.getHeight();

		if (position < -1) {
		} else if (position <= 0) {	// [-1,0]
			//从右向左滑动为当前View
			//设置旋转中心点；
			ViewHelper.setPivotX(view, pageWidth);
			ViewHelper.setPivotY(view, pageHeight / 2);
			//只在Y轴做旋转操作
			ViewHelper.setRotationY(view, 90f * position);
		} else if (position <= 1) {	// (0,1]
			//从左向右滑动为当前View
			ViewHelper.setPivotX(view, 0);
			ViewHelper.setPivotY(view, pageHeight / 2);
			ViewHelper.setRotationY(view, 90f * position);
		} else {
		}
	}





}
