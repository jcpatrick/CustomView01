package com.example.customview01;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	private RelativeLayout rl_level1, rl_level2, rl_level3;
	private ImageView img_icon0, img_icon2;
	float start_angle = 0.0f, end_angle = 180.0f;

	boolean isLevel1 = true, isLevel2 = true, isLevel3 = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		rl_level3 = (RelativeLayout) findViewById(R.id.rl_level3);
		rl_level2 = (RelativeLayout) findViewById(R.id.rl_level2);
		rl_level1 = (RelativeLayout) findViewById(R.id.rl_level1);

		img_icon2 = (ImageView) findViewById(R.id.img_icon2);
		img_icon0 = (ImageView) findViewById(R.id.img_icon0);
		img_icon0.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (isLevel2) {
					hideView(rl_level2, 0);
					isLevel2 = false;
					if (isLevel3) {
						hideView(rl_level3, 100);
						isLevel3 = false;
					}
				} else {
					showView(rl_level2,0);
					showView(rl_level3,100);
					isLevel2 = isLevel3 = true;
				}
			}

		});

		img_icon2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (isLevel3) {
					hideView(rl_level3,0);
					isLevel3 = false;
				} else {
					showView(rl_level3,0);
					isLevel3 = true;
				}
			}
		});
	}
	/**
	 * hide the view
	 * @param view 
	 * @param duration
	 */
	private void hideView(RelativeLayout view, int delay) {
		RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				1.0f);
		rotateAnimation.setDuration(500);//持续的事件
		rotateAnimation.setStartOffset(delay);//延迟的事件
		rotateAnimation.setFillAfter(true);// 让该View停留在旋转后的状态
		view.startAnimation(rotateAnimation);
		int childCount = view.getChildCount();
		for(int i= 0; i < childCount; i++){
			view.getChildAt(i).setEnabled(false);//让子view全部都不能点击
		}
	}
	/**
	 * show the view
	 * @param view
	 * @param duration
	 */
	private void showView(RelativeLayout view, int delay) {
		RotateAnimation rotateAnimation = new RotateAnimation(-180.0f, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				1.0f);
		rotateAnimation.setDuration(500);
		rotateAnimation.setStartOffset(delay);
		rotateAnimation.setFillAfter(true);// 让该View停留在旋转后的状态
		view.startAnimation(rotateAnimation);
		int childCount = view.getChildCount();
		for(int i= 0; i < childCount; i++){
			/**
			 * enable：false直接不能点击，直接变灰
			 * clickable：false表示程序不能自己去点击按键
			 */
			view.getChildAt(i).setEnabled(true);
		}
	}
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		/**
		 * 如果点击的菜单按钮，根据条件隐藏或显示这些View
		 */
		if(keyCode == KeyEvent.KEYCODE_MENU){
			if(isLevel1){
				hideView(rl_level1, 0);
				isLevel1 = false;
				if(isLevel2){
					hideView(rl_level2, 100);
					isLevel2 = false;
				}
				if(isLevel3){
					hideView(rl_level3, 200);
					isLevel3 = false;
				}
			}else{
				showView(rl_level1, 0);
				isLevel1 = true;
				showView(rl_level2, 100);
				isLevel2 = true;
				showView(rl_level3, 200);
				isLevel3 = true;
			}
		}
		return true;
	}
}
