package zhang.great.tv.shudu_tv_beta.Base_Cell;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import zhang.great.tv.shudu_tv_beta.InterFace.IAllClick;
import zhang.great.tv.shudu_tv_beta.R;

/**
 * Created by Administrator on 2017/12/18.
 */

public class SDSUView extends RelativeLayout {

    private SDSUView sdsuView;
    private Context mContext;
    private NumberCell numberCellOne,numberCellTow,numberCellThree,numberCellFour,numberCellFive,numberCellSix,numberCellSeven,numberCellEight,numberCellNine;
    public List<NumberCell> numberCellList = new ArrayList<>();
    private List<Integer> total = new ArrayList<>(9);
    public int [] position = new int[4];
    public int NUM = 0;

    public SDSUView(Context context) {
        this(context,null);
    }

    public SDSUView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SDSUView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.sdsu_layout,this);
        sdsuView = this;
        intView(this);

    }

    private void intView(View view){
        numberCellOne = view.findViewById(R.id.num_cell_1);
        numberCellTow = view.findViewById(R.id.num_cell_2);
        numberCellThree = view.findViewById(R.id.num_cell_3);
        numberCellFour = view.findViewById(R.id.num_cell_4);
        numberCellFive = view.findViewById(R.id.num_cell_5);
        numberCellSix = view.findViewById(R.id.num_cell_6);
        numberCellSeven= view.findViewById(R.id.num_cell_7);
        numberCellEight = view.findViewById(R.id.num_cell_8);
        numberCellNine = view.findViewById(R.id.num_cell_9);
        numberCellOne.setRootView(sdsuView);
        numberCellTow.setRootView(sdsuView);
        numberCellThree.setRootView(sdsuView);
        numberCellFour.setRootView(sdsuView);
        numberCellFive.setRootView(sdsuView);
        numberCellSix.setRootView(sdsuView);
        numberCellSeven.setRootView(sdsuView);
        numberCellEight.setRootView(sdsuView);
        numberCellNine.setRootView(sdsuView);
        numberCellList.add(numberCellOne);
        numberCellList.add(numberCellTow);
        numberCellList.add(numberCellThree);
        numberCellList.add(numberCellFour);
        numberCellList.add(numberCellFive);
        numberCellList.add(numberCellSix);
        numberCellList.add(numberCellSeven);
        numberCellList.add(numberCellEight);
        numberCellList.add(numberCellNine);
        Integer len [] = {0,0,0,0,0,0,0,0,0};
        total = Arrays.asList(len);
    }

    public void setClick(IAllClick click){
        for(NumberCell cell : numberCellList){
            cell.setListrener(click);
        }
    }

    public void setAutoPosition(int position,int num){
        total.set(position,num);
        numberCellList.get(position).setBlackNumber(num-1);
        numberCellList.get(position).isAuto = true;
    }

    public void setCellNum(NumberCell cell,int num){
        if(numberCellList.contains(cell)){
            if(!total.contains(num)){
                cell.setBlueNumber(num-1);
                total.set(numberCellList.indexOf(cell),num);
            }else{
                cell.setRedNumber(num-1);
                numberCellList.get(total.indexOf(num)).setBGClolor(NumberCell.BG_RED);
            }
        }
    }

    public void clearCell(NumberCell cell){
        total.set(numberCellList.indexOf(cell),0);
        cell.clearNum();
    }


    public void setposition(int position,int num){
        if(!total.contains(num)) {
            numberCellList.get(position).setBlueNumber(num-1);
            total.set(position,num);
        }else{
            numberCellList.get(position).setRedNumber(num-1);
            numberCellList.get(total.indexOf(num)).setBGClolor(NumberCell.BG_RED);

        }
    }

    public void setBackGround(){
            for (NumberCell cell1 : numberCellList) {
                    cell1.setBGClolor(NumberCell.BG_GRAY);
            }
    }
    public void clearBackGround(){
        for (NumberCell cell1 : numberCellList) {
                cell1.setBGClolor(0);
        }
    }
}
