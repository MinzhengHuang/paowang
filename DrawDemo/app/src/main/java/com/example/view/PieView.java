package com.example.view;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class PieView extends View {
	//�뾶
	private float mRadius=0.0f;	
	//СԲ�뾶
	private float mSmallRadius=0.0f;
	protected RectF mRectF = null;	
	private Point center = null;
	
	private Paint mPaintArc = null;  
	//���α߿�
	protected Paint mPaintArcBorder = null;
	
	
	private Paint mSamllPaint = null;
	//Բ���ּ�����
	private XChartCalc xcalc = new XChartCalc();					
    
	
	public PieView(Context context) {
		super(context);
	}
	public PieView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public PieView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int width = measureWidth(widthMeasureSpec);
		int height = measureHeight(heightMeasureSpec);
		setMeasuredDimension(measureWidth(widthMeasureSpec),
	    measureHeight(heightMeasureSpec));
		mRadius = Math.min(width,height)/2; //���԰�İ뾶
		mSmallRadius = mRadius/8;
		center = new Point(getWidth()/2, getHeight()/2);
		mRectF = new RectF(center.x-mRadius, center.y-mRadius, center.x+mRadius, center.y+mRadius);
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
	
	/**
	* ����Ӳ������.
	* ԭ��:android��3.0������Ӳ�����٣���ʹ��GPU���л�ͼ,�������������Ƶ�֧�����еĻ�ͼ��
	* ͨ������Ϊ����(��Rect��Path)���ɼ����쳣����Ⱦ�����������˱�֤ͼ���������ʾ��ǿ�ƽ��õ�.
	*/		
	@SuppressLint("NewApi")
	protected void disableHardwareAccelerated()
	{					
		if(SysinfoHelper.getInstance().supportHardwareAccelerated())
		{		
			//�Ƿ�����Ӳ������,�翪���������
			if(!isHardwareAccelerated())
			{
				setLayerType(View.LAYER_TYPE_SOFTWARE,null);
			}
		}
	}
	@Override
	protected void onDraw(Canvas canvas) {
		mPaintArc = new Paint();  
		mPaintArc.setAntiAlias(true);
		
		mPaintArcBorder = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaintArcBorder.setStyle(Style.STROKE);
		mPaintArcBorder.setColor(Color.WHITE);
		
		mSamllPaint = new Paint();
		mSamllPaint.setAntiAlias(true);
		mSamllPaint.setColor(Color.parseColor("#ffffff"));
		//setTextSize()����spΪ��λ
		//��һ��Բ��
		mPaintArc.setColor(Color.parseColor("#f17100")); // �������ε���ɫ   
		canvas.drawArc(mRectF, -90, 120, true, mPaintArc); // ����Բ��     ���ξ�������  ����ʼ�Ƕ� ��ִ�нǶ� ������
		
		
		mPaintArc.setColor(Color.parseColor("#ffffff")); // �����������ɫ   		
		mPaintArc.setTextSize(25);
		xcalc.CalcArcEndPointXY(center.x, center.y, mRadius/4*3, -90 + 120/2);	            
        canvas.drawText(Float.toString(33)+"%", xcalc.getPosX(),xcalc.getPosY(),mPaintArc);  

		//�ڶ���Բ��
		mPaintArc.setColor(Color.parseColor("#007100")); // �����������ɫ   	
		canvas.drawArc(mRectF, 30, 120, true, mPaintArc); // ����Բ��     ���ξ�������  ����ʼ�Ƕ� ��ִ�нǶ� ������
		
		mPaintArc.setColor(Color.parseColor("#ffffff")); // �����������ɫ   		
		mPaintArc.setTextSize(25);
		xcalc.CalcArcEndPointXY(center.x, center.y, mRadius/4*3, 30 + 120/2);	            
        canvas.drawText(Float.toString(33)+"%", xcalc.getPosX(),xcalc.getPosY(),mPaintArc);  
        
		
        //������Բ��
		mPaintArc.setColor(Color.parseColor("#000071")); // �������ε���ɫ   
		canvas.drawArc(mRectF, 150, 120, true, mPaintArc); // ����Բ��     ���ξ�������  ����ʼ�Ƕ� ��ִ�нǶ� ������
		
		mPaintArc.setColor(Color.parseColor("#ffffff")); // �����������ɫ   		
		mPaintArc.setTextSize(25);
		xcalc.CalcArcEndPointXY(center.x, center.y, mRadius/4*3, 150 + 120/2);	            
        canvas.drawText(Float.toString(33)+"%", xcalc.getPosX(),xcalc.getPosY(),mPaintArc);  
        
        //��СԲ
        canvas.drawCircle(center.x,center.y, mSmallRadius, mSamllPaint);
	}
}
