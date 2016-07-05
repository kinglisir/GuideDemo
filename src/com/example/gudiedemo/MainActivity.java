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
			
			//ָ����������һҳ ����ָ��������ҳ��
			public void onPageSelected(int arg0) {
				//�������� ���һҳʱ  ���ص�¼ ע�� ��ť
				if(arg0==3){
					btn_login.setVisibility(View.VISIBLE);
					btn_register.setVisibility(View.VISIBLE);
				}else{
					btn_login.setVisibility(View.GONE);
					btn_register.setVisibility(View.GONE);
				}
				
			}
			
			//����ҳ���ǻ�һֱ���ø÷���
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			//�÷���ִ������ ���� ���� ̧��
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

		//viewpager���ж���ҳ
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		// ���ж���ʾ���Ƿ���ͬһ��ͼƬ���������ǽ�����������ȽϷ��ؼ���
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}
		
		 // ��Ҫ��ʾ��ͼƬ���Խ��л����ʱ�򣬻�����������������ʾͼƬ�ĳ�ʼ�������ǽ�Ҫ��ʾ��ImageView���뵽ViewGroup�У�Ȼ����Ϊ����ֵ���ؼ���
		public Object instantiateItem(ViewGroup container, int position) {
			//��ȡ�����ж�Ӧ��ͼƬ
			ImageView view = (ImageView) list.get(position);
			//��view �ӵ�viewgroup
			container.addView(view);
			return view;
		}
		
		 // PagerAdapterֻ��������Ҫ��ʾ��ͼƬ�����������ͼƬ�����˻���ķ�Χ���ͻ���������������ͼƬ����
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
		
	}
}