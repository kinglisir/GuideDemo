package com.example.gudiedemo;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ArrayList list = new ArrayList<>();
	private Button btn_login;
	private Button btn_register;
	private ViewPager vp_guide;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();
	}

	private void initData() {
		vp_guide.setAdapter(new GuidePagerAdapter());
		vp_guide.setOnPageChangeListener(new OnPageChangeListener() {
			
			//指滑动到了哪一页 参数指滑动到的页数
			public void onPageSelected(int arg0) {
				//当滑动到 最后一页时  隐藏登录 注册 按钮
				if(arg0==3){
					btn_login.setVisibility(View.VISIBLE);
					btn_register.setVisibility(View.VISIBLE);
				}else{
					btn_login.setVisibility(View.GONE);
					btn_register.setVisibility(View.GONE);
				}
				
			}
			
			//滑动页面是会一直调用该方法
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			//该方法执行三次 按下 滑动 抬起
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void initView() {
		ImageView imageview = new ImageView(this);
		imageview.setImageResource(R.drawable.guide01);
		list.add(imageview);
		ImageView imageview1 = new ImageView(this);
		imageview1.setImageResource(R.drawable.guide02);
		list.add(imageview1);
		ImageView imageview2 = new ImageView(this);
		imageview2.setImageResource(R.drawable.guide03);
		list.add(imageview2);
		ImageView imageview3 = new ImageView(this);
		imageview3.setImageResource(R.drawable.guide04);
		list.add(imageview3);
		vp_guide = (ViewPager) findViewById(R.id.vp_guide);
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_register = (Button) findViewById(R.id.btn_register);
		btn_login.setVisibility(View.GONE);
		btn_register.setVisibility(View.GONE);
}
	class GuidePagerAdapter extends PagerAdapter{

		//viewpager中有多少页
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		// 来判断显示的是否是同一张图片，这里我们将两个参数相比较返回即可
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}
		
		 // 当要显示的图片可以进行缓存的时候，会调用这个方法进行显示图片的初始化，我们将要显示的ImageView加入到ViewGroup中，然后作为返回值返回即可
		public Object instantiateItem(ViewGroup container, int position) {
			//获取集合中对应的图片
			ImageView view = (ImageView) list.get(position);
			//将view 加到viewgroup
			container.addView(view);
			return view;
		}
		
		 // PagerAdapter只缓存三张要显示的图片，如果滑动的图片超出了缓存的范围，就会调用这个方法，将图片销毁
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
		
	}
}