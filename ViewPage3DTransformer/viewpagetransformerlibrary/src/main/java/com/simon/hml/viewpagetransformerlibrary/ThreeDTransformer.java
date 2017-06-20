package com.simon.hml.viewpagetransformerlibrary;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/***
 * Created by hml on 2017/6/20.
 *
 * 3D不带缩放
 */
public class ThreeDTransformer implements PageTransformer {

	/**
	 * position参数指明给定页面相对于屏幕中心的位置。它是一个动态属性，会随着页面的滚动而改变。当一个页面填充整个屏幕是，它的值是0，
	 * 当一个页面刚刚离开屏幕的右边时，它的值是1。当两个也页面分别滚动到一半时，其中一个页面的位置是-0.5，另一个页面的位置是0.5。基于屏幕上页面的位置
	 * ，通过使用诸如setAlpha()、setTranslationX()、或setScaleY()方法来设置页面的属性，来创建自定义的滑动动画。
	 */
	@Override
	public void transformPage(View view, float position) {

		Transformer3D(view, position);
	}

	/*
	 * 3D,切换，180度时，页面显示成另一个
	 *
	 *  view.setVisibility(View.GONE); 和 view.setVisibility(View.VISIBLE);的作用
	 * 从代码中可以看到，当后一页面淡出时，只是设置了alpha值，并没有使这个页面失效，因此两个页面就重叠在一起了，
	 * 点击事件就会混乱，此时，vp_change.setPageTransformer(true, new ThreeDTransformer());设置切换动画时，会导致后一个界面的点击效果失效。
	 */
	private void Transformer3D(View view, float position){
		int pageWidth = view.getWidth();
		int pageHeight = view.getHeight();

		if (position < -1) {
		} else if (position <= 0) {	// [-1,0],  先有 0，再到 -1， 0~-1
			//从右向左滑动为当前View
			if (position <= -0.5) {
				ViewHelper.setAlpha(view,0);
				view.setVisibility(View.GONE);
			}else {
				ViewHelper.setAlpha(view,1);
				view.setVisibility(View.VISIBLE);
			}
			//设置旋转中心点；
			ViewHelper.setPivotX(view, pageWidth);
			ViewHelper.setPivotY(view, pageHeight / 2);

			//只在Y轴做旋转操作
			ViewHelper.setRotationY(view, 180f * position);
		} else if (position <= 1) {	// (0,1] 先有 0，再到 1， 0~1
			if (position <= 0.5) {
				ViewHelper.setAlpha(view,1);
				view.setVisibility(View.VISIBLE);
			}else {
				ViewHelper.setAlpha(view,0);
				view.setVisibility(View.GONE);
			}
			//			从左向右滑动为当前View
			ViewHelper.setPivotX(view, 0);
			ViewHelper.setPivotY(view, pageHeight / 2);
			ViewHelper.setRotationY(view, 180f * position);
		}else {
		}
	}

}
