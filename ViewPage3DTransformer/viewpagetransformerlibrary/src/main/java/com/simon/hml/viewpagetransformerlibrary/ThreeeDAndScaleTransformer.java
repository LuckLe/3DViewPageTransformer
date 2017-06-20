package com.simon.hml.viewpagetransformerlibrary;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/***
 * Created by hml on 2017/6/20.
 * 3D,切换加强版，在Z轴伸缩,样式
 * @author hml
 *
 */
public class ThreeeDAndScaleTransformer implements PageTransformer {

	@Override
	public void transformPage(View view, float position) {
		Transformer3D2(view, position);
	}
	
	/*
	 * 3D,切换加强版，在Z轴伸缩
	 */
	private void Transformer3D2(View view, float position) {
		int pageWidth = view.getWidth();
		int pageHeight = view.getHeight();
		
		if (position < -1) { 
			//			ViewHelper.setAlpha(view,0);
		} else if (position <= 0) {	// [-1,0],  先有 0，再到 -1， 0~-1
			//从右向左滑动为当前View
			if (position <= -0.5) {
				ViewHelper.setAlpha(view,0);
			}else {
				ViewHelper.setAlpha(view,1);
			}
			//设置旋转中心点；
			ViewHelper.setPivotX(view, pageWidth / 2);
			ViewHelper.setPivotY(view, pageHeight / 2);
			//抵消默认滑动转换
			ViewHelper.setTranslationX(view , pageWidth * -position);
			//只在Y轴做旋转操作
			ViewHelper.setRotationY(view, 180f * position);
			//设置伸缩
			//此处使用的是position的三次方，使伸缩使得动画幅度更大，你也可以使用平方，四次方等，只不过效果不是很理想，下同
			float scaleFactor = (1 + position) * (1 + position) * (1 + position);//scaleFactor范围[1,0]
			ViewHelper.setScaleX(view,scaleFactor);
			ViewHelper.setScaleY(view,scaleFactor);
		} else if (position <= 1) {	// (0,1] 先有 0，再到 1， 0~1
			if (position <= 0.5) {
				ViewHelper.setAlpha(view,1);
			}else {
				ViewHelper.setAlpha(view,0);
			}
			ViewHelper.setPivotX(view, pageWidth / 2);
			ViewHelper.setPivotY(view, pageHeight / 2);
			ViewHelper.setTranslationX(view,pageWidth * -position * 1f);
			ViewHelper.setRotationY(view, 180f * position);
			float scaleFactor =(1 - position) * (1 - position) * (1 - position); //[1,0]
			ViewHelper.setScaleX(view,scaleFactor);
			ViewHelper.setScaleY(view,scaleFactor);
		}else {
			//			ViewHelper.setAlpha(view,0);
		}
	}

}
