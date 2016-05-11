package com.example.tabviewtest;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener {
	private ViewPager mViewPager;
	private LinearLayout mlayout1, mlayout2, mlayout3, mlayout4;
	private ImageButton mbtn1, mbtn2, mbtn3, mbtn4;
	// pageView 的适配器
	private PagerAdapter mAdapter;
	private List<View> mViews = new ArrayList<View>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
		initEvents();
	}

	private void initEvents() {
		// TODO Auto-generated method stub
		mlayout1.setOnClickListener(this);
		mlayout2.setOnClickListener(this);
		mlayout3.setOnClickListener(this);
		mlayout4.setOnClickListener(this);
		// tab切换 下面背景也改变
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int i) {
				// TODO Auto-generated method stub
				int currentItem = mViewPager.getCurrentItem();
				resetImg();
				switch (currentItem) {
				case 0:
					mbtn1.setImageResource(R.drawable.tab_address_pressed);
					break;
				case 1:
					mbtn2.setImageResource(R.drawable.tab_find_frd_pressed);
					break;
				case 2:
					mbtn3.setImageResource(R.drawable.tab_settings_pressed);
					break;
				case 3:
					mbtn4.setImageResource(R.drawable.tab_weixin_pressed);
					break;
				default:
					break;
				}
			}

			@Override
			public void onPageScrolled(int i, float f, int j) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int i) {
				// TODO Auto-generated method stub

			}
		});
	}

	@SuppressLint("NewApi")
	public void onClick(View v) {
		// TODO Auto-generated method stub
		resetImg();
		switch (v.getId()) {
		case R.id.layout_1:
			mViewPager.setCurrentItem(0);
			// 在这里写点击后背景的改变
			mbtn1.setImageResource(R.drawable.tab_address_pressed);
			break;
		case R.id.layout_2:
			mViewPager.setCurrentItem(1);
			mbtn2.setImageResource(R.drawable.tab_find_frd_pressed);

			break;
		case R.id.layout_3:
			mViewPager.setCurrentItem(2);
			mbtn3.setImageResource(R.drawable.tab_settings_pressed);
			break;
		case R.id.layout_4:
			mViewPager.setCurrentItem(3);
			mbtn4.setImageResource(R.drawable.tab_weixin_pressed);
			break;
		default:
			break;
		}
	}

	// 把所有图片变暗
	private void resetImg() {
		// TODO Auto-generated method stub
		// 设置初始画的颜色
		mbtn1.setImageResource(R.drawable.tab_address_normal);
		mbtn2.setImageResource(R.drawable.tab_find_frd_normal);
		mbtn3.setImageResource(R.drawable.tab_settings_normal);
		mbtn4.setImageResource(R.drawable.tab_weixin_normal);
	}

	private void initView() {
		// TODO Auto-generated method stub
		mViewPager = (ViewPager) findViewById(R.id.id_viewPager);
		mlayout1 = (LinearLayout) findViewById(R.id.layout_1);
		mlayout2 = (LinearLayout) findViewById(R.id.layout_2);
		mlayout3 = (LinearLayout) findViewById(R.id.layout_3);
		mlayout4 = (LinearLayout) findViewById(R.id.layout_4);
		mbtn1 = (ImageButton) findViewById(R.id.btn_1);
		mbtn2 = (ImageButton) findViewById(R.id.btn_2);
		mbtn3 = (ImageButton) findViewById(R.id.btn_3);
		mbtn4 = (ImageButton) findViewById(R.id.btn_4);
		// 进行适配,把View放入List
		LayoutInflater mInflater = LayoutInflater.from(this);
		View tab1 = mInflater.inflate(R.layout.tab1, null);
		View tab2 = mInflater.inflate(R.layout.tab2, null);
		View tab3 = mInflater.inflate(R.layout.tab3, null);
		View tab4 = mInflater.inflate(R.layout.tab4, null);
		mViews.add(tab1);
		mViews.add(tab2);
		mViews.add(tab3);
		mViews.add(tab4);
		mAdapter = new PagerAdapter() {

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				container.removeView(mViews.get(position));

			}

			@Override
			// 初始化
			public Object instantiateItem(ViewGroup container, int position) {
				View view = mViews.get(position);
				container.addView(view);
				return view;
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				return mViews.size();
			}
		};
		mViewPager.setAdapter(mAdapter);
	}

}
