package zhang.great.tv.shudu_tv_beta.Base_Cell;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import zhang.great.tv.shudu_tv_beta.R;

/**
 * Created by Administrator on 2017/12/13.
 */

public class NineCell extends LinearLayout {

    private ImageView iv_cell_1,iv_cell_2,iv_cell_3,iv_cell_4,iv_cell_5,iv_cell_6,iv_cell_7,iv_cell_8,iv_cell_9;
    private List<ImageView> viewList;
    /**
     * 九宫格，九个cell
     */

    public NineCell(Context context)  {
        super(context);
        viewList = new ArrayList<>();
        LayoutInflater.from(context).inflate(R.layout.layout_9cell, this);
        iv_cell_1 = this.findViewById(R.id.cell_1);
        iv_cell_2 = this.findViewById(R.id.cell_2);
        iv_cell_3 = this.findViewById(R.id.cell_3);
        iv_cell_4 = this.findViewById(R.id.cell_4);
        iv_cell_5 = this.findViewById(R.id.cell_5);
        iv_cell_6 = this.findViewById(R.id.cell_6);
        iv_cell_7 = this.findViewById(R.id.cell_7);
        iv_cell_8 = this.findViewById(R.id.cell_8);
        iv_cell_9 = this.findViewById(R.id.cell_9);
        viewList.add(iv_cell_1);
        viewList.add(iv_cell_2);
        viewList.add(iv_cell_3);
        viewList.add(iv_cell_4);
        viewList.add(iv_cell_5);
        viewList.add(iv_cell_6);
        viewList.add(iv_cell_7);
        viewList.add(iv_cell_8);
        viewList.add(iv_cell_9);

    }
    protected void takeCell(int position){
        System.out.println("position:"+position);
        if(viewList.get(position-1).getVisibility() == VISIBLE){
            viewList.get(position-1).setVisibility(INVISIBLE);
        }else{
            viewList.get(position-1).setVisibility(VISIBLE);
        }
    }
    protected void hidenAll(){
        for(ImageView view : viewList){
            view.setVisibility(INVISIBLE);
        }

    }
}
