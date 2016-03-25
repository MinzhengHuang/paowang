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
	//半径
	private float mRadius=0.0f;	
	//小圆半径
	private float mSmallRadius=0.0f;
	protected RectF mRectF = null;	
	private Point center = null;
	
	private Paint mPaintArc = null;  
	//扇形边框
	protected Paint mPaintArcBorder = null;
	
	
	private Paint mSamllPaint = null;
	//圆弧字计算类
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
		mRadius = Math.min(width,height)/2; //算出园的半径
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
		
		if (specMode == MeasureSpec.EXACTLY) { //fill_parent 或者指定常量
			result = specSize;
		} else if (specMode == MeasureSpec.AT_MOST) { //wrap_content
			result = Math.min(result, specSize);          //找最小值
		}			
		return result;
	}
	
	/**
	* 禁用硬件加速.
	* 原因:android自3.0引入了硬件加速，即使用GPU进行绘图,但它并不能完善的支持所有的绘图，
	* 通常表现为内容(如Rect或Path)不可见，异常或渲染错误。所以类了保证图表的正常显示，强制禁用掉.
	*/		
	@SuppressLint("NewApi")
	protected void disableHardwareAccelerated()
	{					
		if(SysinfoHelper.getInstance().supportHardwareAccelerated())
		{		
			//是否开启了硬件加速,如开启将其禁掉
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
		//setTextSize()是以sp为单位
		//第一个圆弧
		mPaintArc.setColor(Color.parseColor("#f17100")); // 设置扇形的颜色   
		canvas.drawArc(mRectF, -90, 120, true, mPaintArc); // 画出圆环     扇形矩形区域  、起始角度 、执行角度 、画笔
		
		
		mPaintArc.setColor(Color.parseColor("#ffffff")); // 设置字体的颜色   		
		mPaintArc.setTextSize(25);
		xcalc.CalcArcEndPointXY(center.x, center.y, mRadius/4*3, -90 + 120/2);	            
        canvas.drawText(Float.toString(33)+"%", xcalc.getPosX(),xcalc.getPosY(),mPaintArc);  

		//第二个圆弧
		mPaintArc.setColor(Color.parseColor("#007100")); // 设置字体的颜色   	
		canvas.drawArc(mRectF, 30, 120, true, mPaintArc); // 画出圆环     扇形矩形区域  、起始角度 、执行角度 、画笔
		
		mPaintArc.setColor(Color.parseColor("#ffffff")); // 设置字体的颜色   		
		mPaintArc.setTextSize(25);
		xcalc.CalcArcEndPointXY(center.x, center.y, mRadius/4*3, 30 + 120/2);	            
        canvas.drawText(Float.toString(33)+"%", xcalc.getPosX(),xcalc.getPosY(),mPaintArc);  
        
		
        //第三个圆弧
		mPaintArc.setColor(Color.parseColor("#000071")); // 设置扇形的颜色   
		canvas.drawArc(mRectF, 150, 120, true, mPaintArc); // 画出圆环     扇形矩形区域  、起始角度 、执行角度 、画笔
		
		mPaintArc.setColor(Color.parseColor("#ffffff")); // 设置字体的颜色   		
		mPaintArc.setTextSize(25);
		xcalc.CalcArcEndPointXY(center.x, center.y, mRadius/4*3, 150 + 120/2);	            
        canvas.drawText(Float.toString(33)+"%", xcalc.getPosX(),xcalc.getPosY(),mPaintArc);  
        
        //画小圆
        canvas.drawCircle(center.x,center.y, mSmallRadius, mSamllPaint);
	}
}
