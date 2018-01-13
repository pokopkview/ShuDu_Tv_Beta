package zhang.great.tv.shudu_tv_beta;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import zhang.great.tv.shudu_tv_beta.Base_Cell.NumberCell;
import zhang.great.tv.shudu_tv_beta.Base_Cell.SDSUView;
import zhang.great.tv.shudu_tv_beta.InterFace.IAllClick;
import zhang.great.tv.shudu_tv_beta.Util.MyDialog;
import zhang.great.tv.shudu_tv_beta.Util.ShuDuUtil;
import zhang.great.tv.shudu_tv_beta.Util.Sudo;

public class MainShuDuView extends RelativeLayout implements IAllClick {

    public  int[][] answer1;
    private View.OnClickListener listener;
    private MyDialog dialogs;
    private Context mContext;
    private List<Integer> list,list1,list2,list3,list4,list5,list6,list7,list8;
    private List<SDSUView> sdsuViewList = new ArrayList<>();
    private SDSUView sdsuView,sdsuView1,sdsuView2,sdsuView3,sdsuView4,sdsuView5,sdsuView6,sdsuView7,sdsuView8;
    private NumberCell [] [] numberCells = new NumberCell [9] [9];
    public List<NumberCell> ones,twos,threes,fours,fives,sixs,sevens,eights,nines;
    private List<List<NumberCell>> twolist = new ArrayList<>();
    private List<Integer> templist;
    private int[][] array = {
            {0, 1, 2, 0, 1, 2, 0, 1, 2},
            {3, 4, 5, 3, 4, 5, 3, 4, 5},
            {6, 7, 8, 6, 7, 8, 6, 7, 8},
            {0, 1, 2, 0, 1, 2, 0, 1, 2},
            {3, 4, 5, 3, 4, 5, 3, 4, 5},
            {6, 7, 8, 6, 7, 8, 6, 7, 8},
            {0, 1, 2, 0, 1, 2, 0, 1, 2},
            {3, 4, 5, 3, 4, 5, 3, 4, 5},
            {6, 7, 8, 6, 7, 8, 6, 7, 8}
    };



    private List<int[]> one,two,three,four,five,six,seven,eight,nine;

    public MainShuDuView(Context context) {
        this(context,null);
    }

    public MainShuDuView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MainShuDuView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.layout,this);
    }


    public void initView(Sudo sudo) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        //设置全屏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.layout);

        FrameLayout layout = findViewById(R.id.cell_container);
        int[][] answer = sudo.data;
        answer1 = ShuDuUtil.copyArrays(answer);
        sudo.solveSudo();
        int[][] answers = sudo.data;
        /**
         * 1
         */
        sdsuView = findViewById(R.id.sd_1);
        /**
         * 4
         */
        sdsuView1 = findViewById(R.id.sd_2);
        /**
         * 7
         */
        sdsuView2 = findViewById(R.id.sd_3);
        /**
         * 2
         */
        sdsuView3 = findViewById(R.id.sd_4);
        /**
         * 5
         */
        sdsuView4 = findViewById(R.id.sd_5);
        /**
         * 8
         */
        sdsuView5 = findViewById(R.id.sd_6);
        /**
         * 3
         */
        sdsuView6 = findViewById(R.id.sd_7);
        /**
         * 6
         */
        sdsuView7 = findViewById(R.id.sd_8);
        /**
         * 9
         */
        sdsuView8 = findViewById(R.id.sd_9);

        sdsuViewList.add(sdsuView);
        sdsuViewList.add(sdsuView1);
        sdsuViewList.add(sdsuView2);
        sdsuViewList.add(sdsuView3);
        sdsuViewList.add(sdsuView4);
        sdsuViewList.add(sdsuView5);
        sdsuViewList.add(sdsuView6);
        sdsuViewList.add(sdsuView7);
        sdsuViewList.add(sdsuView8);

        for(SDSUView views : sdsuViewList){
            views.setClick(this);
        }

        list = new ArrayList<>();
        list1 = new ArrayList<>();
        list2= new ArrayList<>();
        list3 = new ArrayList<>();
        list4 = new ArrayList<>();
        list5 = new ArrayList<>();
        list6 = new ArrayList<>();
        list7 = new ArrayList<>();
        list8 = new ArrayList<>();
        for(int a = 0;a<9;a++){
            for(int b = 0;b<9;b++){
                if(answer1[a][b] != 0){
                    /**
                     * 将生成的数独添加进入布局当中
                     */
                    if(a<3 && b<3){
                        sdsuView.setAutoPosition(array[a][b],answer1[a][b]);
                    }else if(2<a && a<6 && b<3){
                        sdsuView3.setAutoPosition(array[a][b],answer1[a][b]);
                    }else if(5<a && a<9 && b<3){
                        sdsuView6.setAutoPosition(array[a][b],answer1[a][b]);
                    }else if(a<3 && 2<b && b<6){
                        sdsuView1.setAutoPosition(array[a][b],answer1[a][b]);
                    }else if(2<a && a<6 && 2<b && b<6){
                        sdsuView4.setAutoPosition(array[a][b],answer1[a][b]);
                    }else if(5<a && a<9 && 2<b && b<6){
                        sdsuView7.setAutoPosition(array[a][b],answer1[a][b]);
                    }else if(a<3 && 5<b && b<9){
                        sdsuView2.setAutoPosition(array[a][b],answer1[a][b]);
                    }else if(2<a && a<6 && 5<b && b<9){
                        sdsuView5.setAutoPosition(array[a][b],answer1[a][b]);
                    }else if(5<a && a<9 && 5<b && b<9){
                        sdsuView8.setAutoPosition(array[a][b],answer1[a][b]);
                    }
                }
            }
        }


        /**
         * 0 3 6
         * 1 4 7
         * 2 5 8
         *
         */

        for(int a = 0;a<9;a++){
            for(int b = 0;b<9;b++){
                    if(a<3 && b<3){
                        numberCells[a][b] = sdsuView.numberCellList.get(array[a][b]);
                        sdsuView.position = new int []{0,3,0,3};
                    }else if(2<a && a<6 && b<3){
                        numberCells[a][b] = sdsuView3.numberCellList.get(array[a][b]);
                        sdsuView3.position = new int []{3,6,0,3};
                    }else if(5<a && a<9 && b<3){
                        numberCells[a][b] = sdsuView6.numberCellList.get(array[a][b]);
                        sdsuView6.position = new int []{6,9,0,3};
                    }else if(a<3 && 2<b && b<6){
                        numberCells[a][b] = sdsuView1.numberCellList.get(array[a][b]);
                        sdsuView1.position = new int []{0,3,3,6};
                    }else if(2<a && a<6 && 2<b && b<6){
                        numberCells[a][b] = sdsuView4.numberCellList.get(array[a][b]);
                        sdsuView4.position = new int []{3,6,3,6};
                    }else if(5<a && a<9 && 2<b && b<6){
                        numberCells[a][b] = sdsuView7.numberCellList.get(array[a][b]);
                        sdsuView7.position = new int []{6,9,3,6};
                    }else if(a<3 && 5<b && b<9){
                        numberCells[a][b] = sdsuView2.numberCellList.get(array[a][b]);
                        sdsuView2.position = new int []{0,3,6,9};
                    }else if(2<a && a<6 && 5<b && b<9){
                        numberCells[a][b] = sdsuView5.numberCellList.get(array[a][b]);
                        sdsuView5.position = new int []{3,6,6,9};
                    }else if(5<a && a<9 && 5<b && b<9){
                        numberCells[a][b] = sdsuView8.numberCellList.get(array[a][b]);
                        sdsuView8.position = new int []{5,9,5,9};
                    }
                numberCells[a][b].XYposition = new int[]{a,b};
            }
        }
        checkAllcell();
        ViewGroup viewGroup = (ViewGroup) ((Activity)mContext).getWindow().getDecorView().getRootView();
        ViewTreeObserver observer = viewGroup.getViewTreeObserver();
        observer.addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
            @Override
            public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                SDSUView temp,temp1;
                if(oldFocus != null && oldFocus instanceof NumberCell &&  newFocus instanceof NumberCell && newFocus != null){
                    temp = checkFrom((NumberCell) oldFocus);
                    temp1 = checkFrom((NumberCell) newFocus);
                    if(temp != null && temp1 != null){
                        if(temp == temp1){
//                            同一个SDview之内
                            disSameCellcolor(((NumberCell) oldFocus).NUM);
                            setVor0(((NumberCell) oldFocus).XYposition[1]);
                            setHor0(((NumberCell) oldFocus).XYposition[0]);
                            setHor(((NumberCell) newFocus).XYposition[0]);
                            setVor(((NumberCell) newFocus).XYposition[1]);
                            temp1.setBackGround();
                            setSameCellcolor(((NumberCell) newFocus).NUM);
                            ((NumberCell) oldFocus).setBGClolor(NumberCell.BG_GRAY);
                            ((NumberCell) newFocus).setBGClolor(NumberCell.BG_BLUR);
                        }else{
                            disSameCellcolor(((NumberCell) oldFocus).NUM);
                            temp.clearBackGround();
                            setVor0(((NumberCell) oldFocus).XYposition[1]);
                            setHor0(((NumberCell) oldFocus).XYposition[0]);
                            setHor(((NumberCell) newFocus).XYposition[0]);
                            setVor(((NumberCell) newFocus).XYposition[1]);
                            temp1.setBackGround();
                            setSameCellcolor(((NumberCell) newFocus).NUM);
                            ((NumberCell) newFocus).setBGClolor(NumberCell.BG_BLUR);
                        }
                    }


                }else if(oldFocus ==null && newFocus !=null && newFocus instanceof NumberCell){
                    clearAll();
                    System.out.println(newFocus.getClass());
                    temp = checkFrom((NumberCell) newFocus);
                    if(temp == null){
                        return;
                    }
                    setHor(((NumberCell) newFocus).XYposition[0]);
                    setVor(((NumberCell) newFocus).XYposition[1]);
                    /**
                     * clear all  需要添加的方法+
                     */
                    if(newFocus != sdsuView){
                        sdsuView.clearBackGround();
                    }
                    temp.setBackGround();

                    ((NumberCell) newFocus).setBGClolor(NumberCell.BG_BLUR);
                    if(((NumberCell) newFocus).NUM != 0) {
                        setSameCellcolor(((NumberCell) newFocus).NUM);
                    }
                    temp = null;
                }
            }
        });
        dialogs = new MyDialog(mContext);
    }

    /**
     *设置相同颜色的背景
     * @param num
     */
    private void setSameCellcolor(int num){
        if(num == 0){
            return;
        }
        for(NumberCell cell : twolist.get(num-1)){
            if(cell.isRedColor == 0) {
                cell.setBGClolor(NumberCell.BG_GRAY);
            }else{
                cell.setBGClolor(NumberCell.BG_RED);
            }
        }
    }

    /**
     * 取消相同数字的背景色
     * @param num
     */
    private void disSameCellcolor(int num){
        if(num == 0){
            return;
        }
        for(NumberCell cell : twolist.get(num-1)){
            if(cell.isAuto == true){
                cell.setBGClolor(0);
            }else{
                cell.setBGClolor(0);
                cell.setBlueNumber(cell.NUM-1);
            }
        }
    }

    private void checkAllcell(){
        ones = new ArrayList<>();
        twolist.add(ones);
        twos = new ArrayList<>();
        twolist.add(twos);
        threes = new ArrayList<>();
        twolist.add(threes);
        fours = new ArrayList<>();
        twolist.add(fours);
        fives = new ArrayList<>();
        twolist.add(fives);
        sixs = new ArrayList<>();
        twolist.add(sixs);
        sevens = new ArrayList<>();
        twolist.add(sevens);
        eights = new ArrayList<>();
        twolist.add(eights);
        nines = new ArrayList<>();
        twolist.add(nines);
        for(int a = 0;a<9;a++){
            for(int b =0;b<9;b++){
                if(numberCells[a][b].NUM == 1) {
                    ones.add(numberCells[a][b]);
                }else if(numberCells[a][b].NUM == 2){
                    twos.add(numberCells[a][b]);
                }else if(numberCells[a][b].NUM == 3){
                    threes.add(numberCells[a][b]);
                }else if(numberCells[a][b].NUM == 4){
                    fours.add(numberCells[a][b]);
                }else if(numberCells[a][b].NUM == 5){
                    fives.add(numberCells[a][b]);
                }else if(numberCells[a][b].NUM == 6){
                    sixs.add(numberCells[a][b]);
                }else if(numberCells[a][b].NUM == 7){
                    sevens.add(numberCells[a][b]);
                }else if(numberCells[a][b].NUM == 8){
                    eights.add(numberCells[a][b]);
                }else if(numberCells[a][b].NUM == 9){
                    nines.add(numberCells[a][b]);
                }
            }
        }


    }



    /**
     * 新开始一句默认焦点在中心位置
     */


    private SDSUView checkFrom(NumberCell cell){
        for(SDSUView view : sdsuViewList){
            if(view.numberCellList.contains(cell)){
                return view;
            }
        }

        return null;
    }


    private void setHor(int x){
        templist = new ArrayList<Integer>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);}};
        for(int i = 0;i<9;i++){
            numberCells[x][i].setBGClolor(NumberCell.BG_GRAY);
            if(!templist.remove(new Integer(numberCells[x][i].NUM)) && numberCells[x][i].NUM!=0){
                if(!numberCells[x][i].isAuto) {
                    numberCells[x][i].setBGClolor(NumberCell.BG_RED);
                }
            }
        }
    }

    private boolean checkHor(NumberCell cells){
        for(int b = 0;b<9;b++){
            System.out.println(numberCells[cells.XYposition[0]][b].NUM+"_"+cells.NUM);
            if(numberCells[cells.XYposition[0]][b] != cells && numberCells[cells.XYposition[0]][b].NUM == cells.NUM && cells.NUM != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean checkVor(NumberCell cells){
            for(int b = 0;b<9;b++){
                if(numberCells[b][cells.XYposition[1]] != cells && numberCells[b][cells.XYposition[1]].NUM == cells.NUM && cells.NUM != 0) {
                    return false;
                }
            }
        return true;
    }
    private void setVor(int y){
        templist = new ArrayList<Integer>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);}};
        for(int i = 0;i<9;i++){
            numberCells[i][y].setBGClolor(NumberCell.BG_GRAY);
            if(!templist.remove(new Integer(numberCells[i][y].NUM)) && numberCells[i][y].NUM!=0){
                if(!numberCells[i][y].isAuto) {
                    numberCells[i][y].setBGClolor(NumberCell.BG_RED);
                }
            }
        }
    }

    /**
     * 清除X
     * @param x
     */
    private void setHor0(int x){
        for(int i = 0;i<9;i++){
            numberCells[x][i].setBGClolor(0);
        }
    }

    /**
     * 清除Y
     * @param y
     */
    private void setVor0(int y){
        for(int i = 0;i<9;i++){
            numberCells[i][y].setBGClolor(0);
        }
    }

    private void clearAll(){
        for(int a = 0;a<9;a++) {
            for (int b = 0; b < 9; b++) {
                numberCells[a][b].setBGClolor(0);
            }
        }
    }

    /**
     * 处理输入的数字
     * @param cell
     */
    private NumberCell tempCell = null;
    @Override
    public void itemClick(final NumberCell cell) {
        /**
         * 添加一个写好的九个数字的View
         * 并选取添加方式，标记or填写
         */

            if(tempCell!=null && tempCell == cell && !cell.isAuto) {
                dialogs.show();
                dialogs.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        System.out.println(dialogs.getInfo());
                        if (dialogs.ischeck) {
                            if (!dialogs.ischeat && !dialogs.isclear) {
                                if (dialogs.ismark) {
                                    cell.setSmallNum(dialogs.selectNum);
                                } else {
                                    cell.NUM = dialogs.selectNum;
                                    if (checkHor(cell) && checkVor(cell)) {
                                        cell.rootView.setCellNum(cell, dialogs.selectNum);
                                    } else {
                                        cell.setRedNumber(dialogs.selectNum - 1);
                                    }
                                    twolist.get(dialogs.selectNum - 1).add(cell);
                                    setHor(cell.XYposition[0]);
                                    setVor(cell.XYposition[1]);
                                }
                            } else if (dialogs.isclear) {
                                twolist.get(cell.NUM - 1).remove(cell);
                                cell.rootView.clearCell(cell);
                            } else if (dialogs.ischeat) {

                            }
                        }

                        if(checkItem()){
                            System.out.println("游戏成功!");
                        }

                    }
                });
            }else{
                tempCell = cell;
                cell.setFocusable(true);
                cell.setFocusableInTouchMode(true);
                cell.requestFocus();
                cell.requestFocusFromTouch();
            }


    }

    private boolean checkItem(){
        int count = 0;
        for(List<NumberCell> cells : twolist){
            count = count+cells.size();
            System.out.println(count);
            if(count == 81){
                //数独填满81格了，如果
                return checkRedNum();
            }
        }
        return false;
    }

    private boolean checkRedNum(){
        for(List<NumberCell> cells : twolist){
            for(NumberCell cell : cells){
                System.out.println(cell.isRedColor);
                if(cell.isRedColor != 0){
                    return false;
                }
            }
        }
        return true;
    }
}
