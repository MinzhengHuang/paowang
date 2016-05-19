package com.example.textviewdel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 自定义TextView删除线
 * 
 * @author wu
 * 
 */
public class TextViewDel extends TextView {
	private boolean flag;

	public TextViewDel(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
//		if (flag) {
			Paint paint = new Paint();
			// 设置直线的颜色
			paint.setColor(Color.GREEN);
			// 设置直线没有锯齿
			paint.setAntiAlias(true);
			// 设置线宽
			paint.setStrokeWidth((float) 3.0);
			// 设置直线位置
			canvas.drawLine(0, this.getHeight() / 2, this.getWidth(),
					this.getHeight() / 2, paint);
//		}
	}

	/**
	 * true显示删除线 false不显示删除线
	 * 
	 * @param flag
	 * @return flag
	 */
	public boolean setTv(boolean flag) {
		this.flag = flag;
		return flag;
	}
}
