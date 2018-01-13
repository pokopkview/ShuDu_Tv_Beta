package zhang.great.tv.shudu_tv_beta.Base_Cell;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/12/13.
 */

public class BaseCell extends View {

    private Context mContext;
    //public static final int TEXT_ALIGN_CENTER            = 0x00000000;
    public static final int TEXT_ALIGN_LEFT              = 0x00000001;
    public static final int TEXT_ALIGN_RIGHT             = 0x00000010;
    public static final int TEXT_ALIGN_CENTER_VERTICAL   = 0x00000100;
    public static final int TEXT_ALIGN_CENTER_HORIZONTAL = 0x00001000;
    public static final int TEXT_ALIGN_TOP               = 0x00010000;
    public static final int TEXT_ALIGN_BOTTOM            = 0x00100000;


    /** 文本中轴线X坐标 */
    private float textCenterX;
    /** 文本baseline线Y坐标 */
    private float textBaselineY;

    /** 控件的宽度 */
    private int viewWidth;
    /** 控件的高度 */
    private int viewHeight;
    /** 控件画笔 */
    private Paint paint;

    /** 要显示的文字 */
    private String text;
    /** 文字的颜色 */
    private int textColor;
    /** 文字的大小 */
    private int textSize;
    /** 文字的方位 */
    private int textAlign;

    private Paint.FontMetrics fm;


    private int BLACK = 0xFF000000;    //全黑
    private int BLACK_1 = 0xFFCFCFCF;   //全灰
    private int BLACK_2 = 0x5A0000FF;   //透明灰
    private int BLUE = 0xFF0066CC;         //全蓝色
    private int BLUE_1 = 0x640000FF;        //透明蓝色


    public BaseCell(Context context) {
        super(context);
        this.mContext = context;
        paint = new Paint(); //
        paint.setColor(BLUE_1);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(3);
        fm = paint.getFontMetrics();

    }



    @Override
    protected void onDraw(Canvas canvas) {
        paint.setTextSize(40);
        canvas.drawText("1",0,(fm.bottom - fm.top) / 2,paint);
    }

    private void setTextLocation() {
        paint.setTextSize(textSize);
        paint.setColor(textColor);
        fm = paint.getFontMetrics();
        //文本的宽度
        float textWidth = paint.measureText(text);
        float textCenterVerticalBaselineY = viewHeight / 2 - fm.descent + (fm.descent - fm.ascent) / 2;
        switch (textAlign) {
            case TEXT_ALIGN_CENTER_HORIZONTAL | TEXT_ALIGN_CENTER_VERTICAL:
                textCenterX = (float)viewWidth / 2;
                textBaselineY = textCenterVerticalBaselineY;
                break;
            case TEXT_ALIGN_LEFT | TEXT_ALIGN_CENTER_VERTICAL:
                textCenterX = textWidth / 2;
                textBaselineY = textCenterVerticalBaselineY;
                break;
            case TEXT_ALIGN_RIGHT | TEXT_ALIGN_CENTER_VERTICAL:
                textCenterX = viewWidth - textWidth / 2;
                textBaselineY = textCenterVerticalBaselineY;
                break;
            case TEXT_ALIGN_BOTTOM | TEXT_ALIGN_CENTER_HORIZONTAL:
                textCenterX = viewWidth / 2;
                textBaselineY = viewHeight - fm.bottom;
                break;
            case TEXT_ALIGN_TOP | TEXT_ALIGN_CENTER_HORIZONTAL:
                textCenterX = viewWidth / 2;
                textBaselineY = -fm.ascent;
                break;
            case TEXT_ALIGN_TOP | TEXT_ALIGN_LEFT:
                textCenterX = textWidth / 2;
                textBaselineY = -fm.ascent;
                break;
            case TEXT_ALIGN_BOTTOM | TEXT_ALIGN_LEFT:
                textCenterX = textWidth / 2;
                textBaselineY = viewHeight - fm.bottom;
                break;
            case TEXT_ALIGN_TOP | TEXT_ALIGN_RIGHT:
                textCenterX = viewWidth - textWidth / 2;
                textBaselineY = -fm.ascent;
                break;
            case TEXT_ALIGN_BOTTOM | TEXT_ALIGN_RIGHT:
                textCenterX = viewWidth - textWidth / 2;
                textBaselineY = viewHeight - fm.bottom;
                break;
        }
    }

    /**
     * 设置文本内容
     * @param text
     */
    public void setText(String text) {
        this.text = text;
        invalidate();
    }
    /**
     * 设置文本大小
     * @param textSizeSp 文本大小，单位是sp
     */
    public void setTextSize(int textSizeSp) {
        this.textSize = textSizeSp;
        invalidate();
    }
    /**
     * 设置文本的方位
     */
    public void setTextAlign(int textAlign) {
        this.textAlign = textAlign;
        invalidate();
    }
    /**
     * 设置文本的颜色
     * @param textColor
     */
    public void setTextColor(int textColor) {
        this.textColor = textColor;
        invalidate();
    }
}
