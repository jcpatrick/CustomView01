###旧版优酷菜单界面

* 在布局文件中，排好这些icon（注意：RelativeLayout中多个布局先后顺序，后面的会挡住前面的，如果有涉及到子布局的点击时间的话，一定要注意xml中顺序）
* 旋转动画，实现View围绕自己旋转
	* RotateAnimation的setFillAfter：保留在旋转后的位置
	* RotateAnimation的setStartOffset：延迟开始的时间
* 控件的点击事件
	* setEnabled：false--不可点击（灰色），true--可点击
	* setClickable：false--程序自身不能调用该view的点击方法（用户点击还是会有反应）
* Menu按钮点击事件
	* Activity中重写onKeyDown()方法，keycode如果为KeyEvent.KEYCODE_MENU则表示点击了Menu按钮，KeyEvent.KEYCODE_BACK表示点击返回按钮
