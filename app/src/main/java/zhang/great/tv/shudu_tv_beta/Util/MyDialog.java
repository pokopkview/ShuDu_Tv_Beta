package zhang.great.tv.shudu_tv_beta.Util;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import zhang.great.tv.shudu_tv_beta.R;

/**
 * Created by Administrator on 2017/12/29.
 */

public class MyDialog extends Dialog {

    public boolean ischeat = false;
    public boolean isclear = false;
    private MyDialog dialog;
    public boolean ismark = false;
    public int selectNum = 0;
    public boolean ischeck = false;

    public MyDialog(@NonNull Context context) {
        this(context,0);
    }

    public MyDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialoglayout);
        dialog = this;
        Button bt_fillin,bt_mark,bt_cheat,bt_clear;
        ImageView iv_1,iv_2,iv_3,iv_4,iv_5,iv_6,iv_7,iv_8,iv_9;
        final RelativeLayout numItem = findViewById(R.id.rl_items);
        final RelativeLayout select = findViewById(R.id.rl_select);
        bt_fillin = findViewById(R.id.bt_fillin);
        bt_mark = findViewById(R.id.bt_mark);
        bt_cheat = findViewById(R.id.bt_cheat);
        bt_clear = findViewById(R.id.bt_clear);
        iv_1 = findViewById(R.id.iv_1);
        iv_2 = findViewById(R.id.iv_2);
        iv_3 = findViewById(R.id.iv_3);
        iv_4 = findViewById(R.id.iv_4);
        iv_5 = findViewById(R.id.iv_5);
        iv_6 = findViewById(R.id.iv_6);
        iv_7 = findViewById(R.id.iv_7);
        iv_8 = findViewById(R.id.iv_8);
        iv_9 = findViewById(R.id.iv_9);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ischeck = true;
                String str = (String) v.getTag();
                selectNum = Integer.parseInt(str);
                numItem.setVisibility(View.GONE);
                select.setVisibility(View.VISIBLE);
                dismiss();
            }
        };
        iv_1.setOnClickListener(listener);
        iv_2.setOnClickListener(listener);
        iv_3.setOnClickListener(listener);
        iv_4.setOnClickListener(listener);
        iv_5.setOnClickListener(listener);
        iv_6.setOnClickListener(listener);
        iv_7.setOnClickListener(listener);
        iv_8.setOnClickListener(listener);
        iv_9.setOnClickListener(listener);
        bt_cheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在当前cell内填入一个数字
                ischeck = true;
                ischeat = true;
                cancel();
            }
        });
        bt_mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在空间内标记一个数字
                select.setVisibility(View.GONE);
                numItem.setVisibility(View.VISIBLE);
                ismark = true;
                isclear = false;
                ischeat = false;
            }
        });
        bt_fillin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //填入用户将有选择的数字
                select.setVisibility(View.GONE);
                numItem.setVisibility(View.VISIBLE);
                ismark = false;
                isclear = false;
                ischeat = false;
            }
        });
        bt_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isclear = true;
                ischeck = true;
                cancel();


            }
        });

    }
    public String getInfo(){
        return "ischeat:"+ischeat+",ischeck:"+ischeck+",isclear:"+isclear+",ismark:"+ismark+",selectNum:"+selectNum;
    }
}
