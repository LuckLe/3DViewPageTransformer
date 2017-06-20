package com.simon.hml.viewpagetransformerlibrary;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/***
 * Created by hml on 2017/6/20.
 *
 * 右上进入，左下退出，样式
 */
public class InRightUpTransformer implements PageTransformer {

	@Override
	public void transformPage(View view, float position) {
		int pageHeight = view.getHeight();
		if (position < -1) {
		} else if (position <= 0) {// [-1,0]
//			position * 0.5f,使得切换时更具层次感。类似视察动画
			 ViewHelper.setTranslationY(view, pageHeight * -position * 0.5f);
			 ViewHelper.setAlpha(view, 1 + position);
		} else if (position <= 1) {// (0,1]
			 ViewHelper.setTranslationY(view, pageHeight * -position);
			 ViewHelper.setAlpha(view, 1 - position);
		} else {
		}
	}

}
