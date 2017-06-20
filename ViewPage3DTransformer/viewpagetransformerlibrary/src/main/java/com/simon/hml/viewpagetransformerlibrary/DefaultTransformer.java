package com.simon.hml.viewpagetransformerlibrary;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/***
 * Created by hml on 2017/6/20.
 *
 * 默认切换样式
 *
 */
public class DefaultTransformer implements PageTransformer {

	/**
	 * position参数指明给定页面相对于屏幕中心的位置。它是一个动态属性，会随着页面的滚动而改变，区间是[-1，1]。当一个页面填充整个屏幕是，它的值是0，
	 * 当一个页面刚刚离开屏幕的右边时，它的值是1。当两个也页面分别滚动到一半时，其中一个页面的位置是-0.5，另一个页面的位置是0.5。基于屏幕上页面的位置
	 * ，通过使用诸如setAlpha()、setTranslationX()、或setScaleY()方法来设置页面的属性，来创建自定义的滑动动画。
	 */

	@Override
	public void transformPage(View view, float position) {
		//		此为源码设置方法，默认切换效果
		int pageWidth = view.getWidth();
		int pageHeight = view.getHeight();
		
		ViewHelper.setAlpha(view, 1);
		ViewHelper.setTranslationX(view, 0);
		ViewHelper.setTranslationY(view, 0);
		ViewHelper.setPivotX(view, pageWidth / 2);
		ViewHelper.setPivotY(view, pageHeight / 2);
		ViewHelper.setScaleX(view, 1);
		ViewHelper.setScaleY(view, 1);
		ViewHelper.setRotation(view, 0);
	}

}
