package com.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class DrawLine extends View {
    private Paint pRect;
    private int AvgValue;
    private int WidValue;
    private int WidDip = 100;
    private RectF mRect = null;  //��ͼ��������

    public DrawLine(Context context) {
        super(context);
    }

    public DrawLine(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawLine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = measureWidth(widthMeasureSpec);
        int height = measureHeight(heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec),
                measureHeight(heightMeasureSpec));
        mRect = new RectF(0, 0, getWidth(), getHeight());
        AvgValue = (getHeight() - WidDip) / 8;
        WidValue = (getWidth() - WidDip) / 9;
    }

    private int measureWidth(int measureSpec) {
        int result = 100;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) { //fill_parent
            result = specSize;
        } else if (specMode == MeasureSpec.AT_MOST) { //wrap_content
            result = Math.min(result, specSize);
        }
        return result;
    }

    private int measureHeight(int measureSpec) {
        int result = 100;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) { //fill_parent ����ָ������
            result = specSize;
        } else if (specMode == MeasureSpec.AT_MOST) { //wrap_content
            result = Math.min(result, specSize);          //����Сֵ
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);  //���߻���
        // Anti-aliasing
        paint.setAntiAlias(true);
        // Draw the Y��
        paint.setColor(Color.BLACK);
        canvas.drawLine(mRect.left + WidDip, mRect.bottom - WidDip, mRect.left + WidDip, 0, paint);  //startx,starty,stopx,stopy
        // Draw the X��
        paint.setColor(Color.BLACK);
        canvas.drawLine(mRect.left + WidDip, mRect.bottom - WidDip, mRect.right, mRect.bottom - WidDip, paint);


        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);


        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.BLUE);
        PathEffect effects = new DashPathEffect(new float[]{5, 5, 5, 5}, 1);
        p.setPathEffect(effects);


        for (int i = 0; i < 7; i++) {
            Path path = new Path();
            path.moveTo(mRect.left + WidDip, mRect.top + AvgValue * (i + 1));
            path.lineTo(mRect.right, mRect.top + AvgValue * (i + 1));
            canvas.drawPath(path, p);


            paint.setTextSize(WidValue / 4);   //����Ϊ�����


//����  1		   
//		    FontMetrics metrics = paint.getFontMetrics(); //��ȡ������Ϣ
//		    
//		    float fontHeight = metrics.bottom - metrics.top;
//		    
//			canvas.drawText(""+(7-i)*100, 0, mRect.top+AvgValue*(i+1)+fontHeight/4, paint);


//���� 2
            Rect bounds1 = new Rect();
            paint.getTextBounds("" + (7 - i) * 100, 0, 1, bounds1);
            int fontHeight = bounds1.height();
            canvas.drawText("" + (7 - i) * 100, 0, mRect.top + AvgValue * (i + 1) + fontHeight / 2, paint);


//			canvas.drawLine(mRect.left+AvgValue*(i+1), mRect.bottom, mRect.left+AvgValue*(i+1), 0, p);
        }


        Rect bounds = new Rect();
        paint.getTextBounds("��", 0, 1, bounds);
        int fontHeight = bounds.height();
        canvas.drawText("��", 30, mRect.top + fontHeight, paint);

        //������
        pRect = new Paint();
        pRect.setAntiAlias(true);// ���û��ʵľ��Ч�� true��ȥ����һ��Ч���������
        pRect.setColor(Color.GREEN);
        pRect.setStyle(Paint.Style.FILL);//��������
        for (int i = 0; i < 4; i++) {

            Log.i("left top  right bottom", "" + WidValue * (2 * i + 1) + "  " + (4 - i) * getHeight() / 4 + "  " + WidValue * (2 * i) + " "
                    + " " + getHeight());
            canvas.drawRect(WidValue * (2 * i + 1) + WidDip, (3 - i) * (getHeight() - WidDip) / 4 - WidDip, WidValue * (2 * i + 2) + WidDip, getHeight() - WidDip, pRect);// ������


            if (i == 2) {
                paint.setTextSize(WidValue / 4);   //����Ϊ�����
                canvas.drawText("˼������", WidValue * (2 * i + 1) + WidDip, getHeight() - 20, paint);
            } else {
                paint.setTextSize(WidValue / 2);   //����Ϊ�����
                canvas.drawText("��ѧ", WidValue * (2 * i + 1) + WidDip, getHeight() - 20, paint);
            }
        }

    }

}
