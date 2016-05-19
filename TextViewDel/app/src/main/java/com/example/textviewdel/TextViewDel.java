package com.example.textviewdel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * �Զ���TextViewɾ����
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
			// ����ֱ�ߵ���ɫ
			paint.setColor(Color.GREEN);
			// ����ֱ��û�о��
			paint.setAntiAlias(true);
			// �����߿�
			paint.setStrokeWidth((float) 3.0);
			// ����ֱ��λ��
			canvas.drawLine(0, this.getHeight() / 2, this.getWidth(),
					this.getHeight() / 2, paint);
//		}
	}

	/**
	 * true��ʾɾ���� false����ʾɾ����
	 * 
	 * @param flag
	 * @return flag
	 */
	public boolean setTv(boolean flag) {
		this.flag = flag;
		return flag;
	}
}
