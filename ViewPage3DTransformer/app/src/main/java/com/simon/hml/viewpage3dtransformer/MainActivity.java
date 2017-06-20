package com.simon.hml.viewpage3dtransformer;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.simon.hml.viewpagetransformerlibrary.AccordionTransformer;
import com.simon.hml.viewpagetransformerlibrary.CubeTransformer;
import com.simon.hml.viewpagetransformerlibrary.DefaultTransformer;
import com.simon.hml.viewpagetransformerlibrary.DepthPageTransformer;
import com.simon.hml.viewpagetransformerlibrary.InRightDownTransformer;
import com.simon.hml.viewpagetransformerlibrary.InRightUpTransformer;
import com.simon.hml.viewpagetransformerlibrary.RotateTransformer;
import com.simon.hml.viewpagetransformerlibrary.ThreeDTransformer;
import com.simon.hml.viewpagetransformerlibrary.ThreeeDAndScaleTransformer;
import com.simon.hml.viewpagetransformerlibrary.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager = null;
    private MyAdapter mAdapter = null;
    private List<View> mData = new ArrayList<View>();
    private ArrayAdapter<String> adapter = null;
    private int[] ImageIds = new int[] { R.drawable.icon_1, R.drawable.icon_2,
            R.drawable.icon_3, R.drawable.icon_4, R.drawable.icon_5,
            R.drawable.icon_6, R.drawable.icon_7, R.drawable.icon_8,
            R.drawable.icon_9, R.drawable.icon_10, };
    private String[] effectType = { "默认", "深入浅出", "立方体", "旋转","左右折叠", "右上角进入" , "右下角进入", "淡入淡出","3D无缩放","3D有缩放"};

    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner = (Spinner) findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, effectType);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//选项有CheckBox样式
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(ISelectedListener);

        mViewPager = (ViewPager) findViewById(R.id.main_page);
        resetView();
    }

    private void getData(List<View> data) {
        data.clear();
        for (int i = 0; i < ImageIds.length; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.layout_image,null);
            ImageView image = (ImageView) view.findViewById(R.id.imgv_item);
            LinearLayout ll_item = (LinearLayout) view.findViewById(R.id.ll_item);
            TextView tv_pisotion_item = (TextView) view.findViewById(R.id.tv_pisotion_item);
            image.setImageResource(ImageIds[i]);
            String color = i % 2 == 0? "#00ff00" : "#00ffff" ;
            ll_item.setBackgroundColor(Color.parseColor(color));
            tv_pisotion_item.setText(i+1+"");

            final String j = i+1+"";
            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,j, Toast.LENGTH_SHORT).show();
                }
            });

            data.add(view);
        }
    }

    AdapterView.OnItemSelectedListener ISelectedListener = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int position, long id) {
            resetView();
            switch (position) {
//			"默认", "深入浅出", "立方体", "旋转","左右折叠", "右上角进入" , "右下角进入", "淡入淡出","3D无缩放","3D有缩放"
                case 0:
                    mViewPager.setPageTransformer(true, new DefaultTransformer());
                    break;
                case 1:
                    mViewPager.setPageTransformer(true, new DepthPageTransformer());
                    break;
                case 2:
                    mViewPager.setPageTransformer(true, new CubeTransformer());
                    break;
                case 3:
                    mViewPager.setPageTransformer(true, new RotateTransformer());
                    break;
                case 4:
                    mViewPager.setPageTransformer(true, new AccordionTransformer());
                    break;
                case 5:
                    mViewPager.setPageTransformer(true, new InRightUpTransformer());
                    break;
                case 6:
                    mViewPager.setPageTransformer(true, new InRightDownTransformer());
                    break;
                case 7:
                    mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
                    break;
                case 8:
                    mViewPager.setPageTransformer(true, new ThreeDTransformer());
                    break;
                case 9:
                    mViewPager.setPageTransformer(true, new ThreeeDAndScaleTransformer());
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }

    };

    private void resetView(){
        mViewPager.removeAllViews();
        getData(mData);
        mAdapter = new MyAdapter(mData);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(mData.size() / 2);
        mViewPager.setPageTransformer(true, new DefaultTransformer());
    }

    public void toTestActivity(View v) {
        startActivity(new Intent(MainActivity.this , TestActivity.class));
//		mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);

    }
}
