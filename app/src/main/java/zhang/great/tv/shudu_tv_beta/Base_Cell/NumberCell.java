package zhang.great.tv.shudu_tv_beta.Base_Cell;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import zhang.great.tv.shudu_tv_beta.InterFace.IAllClick;
import zhang.great.tv.shudu_tv_beta.InterFace.IcellCallBackNum;
import zhang.great.tv.shudu_tv_beta.R;

/**
 * Created by Administrator on 2017/12/18.
 */

public class NumberCell extends FrameLayout {

    private IAllClick callBackNum;
    public SDSUView rootView;
    public ImageView number;
    private NineCell cell;
    public int isRedColor = 0;
    public int color;
    private NumberCell numberCell;
    public static final int BG_GRAY = R.mipmap.bg_gary;
    public static final int BG_BLUR = R.mipmap.bg_blue;
    public static final int BG_RED = R.mipmap.bg_red;
    public int NUM = 0;
    public int [] XYposition;
    public boolean isAuto = false;
    private int [] blacknumbers = {R.mipmap.black_1,R.mipmap.black_2,R.mipmap.black_3,R.mipmap.black_4,R.mipmap.black_5,R.mipmap.black_6,R.mipmap.black_7,R.mipmap.black_8,R.mipmap.black_9};
    public int [] rednumbers = {R.mipmap.red_1,R.mipmap.red_2,R.mipmap.red_3,R.mipmap.red_4,R.mipmap.red_5,R.mipmap.red_6,R.mipmap.red_7,R.mipmap.red_8,R.mipmap.red_9};
    private int [] bluenumber = {R.mipmap.blue_1,R.mipmap.blue_2,R.mipmap.blue_3,R.mipmap.blue_4,R.mipmap.blue_5,R.mipmap.blue_6,R.mipmap.blue_7,R.mipmap.blue_8,R.mipmap.blue_9};

    public NumberCell(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NumberCell(@NonNull Context context) {
        this(context,null);
    }

    public NumberCell(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        numberCell = this;
        cell  = new NineCell(context);
        number = new ImageView(context);
        cell.setVisibility(INVISIBLE);
        this.addView(cell);
        this.addView(number);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                callBackNum.itemClick(numberCell);
            }
        });
//        this.setOnFocusChangeListener(new OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                callBackNum.sellchange((NumberCell) v,hasFocus);
//            }
//        });
    }

    public void setRootView(SDSUView view){
        rootView = view;
    }

    public void setListrener(IAllClick listrener){
        callBackNum = listrener;
    }

    public void setBlackNumber(int num){
        number.setImageResource(blacknumbers[num]);
        NUM = num+1;
    }
    public void setBlueNumber(int num){
        if(cell.getVisibility() == VISIBLE){
            cell.setVisibility(GONE);
            cell.hidenAll();
            NUM = 0;
            number.setVisibility(VISIBLE);        }
        if(number.getVisibility() == GONE){
            number.setVisibility(VISIBLE);
        }
        if(isRedColor == num+1){
            return;
        }else{
            isRedColor = 0;
        }
        number.setImageResource(bluenumber[num]);
        NUM = num+1;
    }
    public void setRedNumber(int num){
        if(cell.getVisibility() == VISIBLE){
            cell.setVisibility(GONE);
            cell.hidenAll();
            NUM = 0;
        }
        if(number.getVisibility() == GONE){
            number.setVisibility(VISIBLE);
        }
        isRedColor = num+1;
        number.setImageResource(rednumbers[num]);
        NUM = num+1;
    }
    public void clearNum(){
        number.setVisibility(GONE);
        NUM = 0;
    }

    public void setSmallNum(int position){
        if(number.getVisibility() == VISIBLE){
            number.setVisibility(GONE);
            cell.setVisibility(VISIBLE);
        }
        cell.takeCell(position);
    }


    public void setBGClolor(int color){
            this.color = color;
            numberCell.setBackgroundResource(color);
    }



}
