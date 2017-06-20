package com.simon.hml.viewpage3dtransformer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.nineoldandroids.view.ViewHelper;

public class TestActivity extends Activity {
	private ImageView imageView1;

	private float rotationY = 0;
	private float rotationX = 0;
	private float rotation = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);

		imageView1 = (ImageView) findViewById(R.id.imageView1);


	}

	//	绕Y轴顺时针旋转, 角度递减 ↓
	public void RotationYS(View v) {
		rotationY -= 15;
		ViewHelper.setRotationY(imageView1, rotationY);
	}

	//	绕Y轴逆时针旋转, 角度递增 ↑
	public void RotationYN(View v) {
		rotationY += 15;
		ViewHelper.setRotationY(imageView1, rotationY);
	}

	//	绕Z轴顺时针旋转, 角度递增 ↑
	public void RotationZS(View v) {
		rotation += 15;
		ViewHelper.setRotation(imageView1, rotation);
	}

	//	绕Z轴逆时针旋转, 角度递减 ↓
	public void RotationZN(View v) {
		rotation -= 15;
		ViewHelper.setRotation(imageView1, rotation);
	}

	//	绕Y轴顺时针旋转, 角度递增 ↑
	public void RotationXS(View v) {
		rotationX += 15;
		ViewHelper.setRotationX(imageView1, rotationX);
	}

	//	绕Y轴逆时针旋转, 角度递减 ↓
	public void RotationXN(View v) {
		rotationX -= 15;
		ViewHelper.setRotationX(imageView1, rotationX);
	}













}
