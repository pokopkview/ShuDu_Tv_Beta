package zhang.great.tv.shudu_tv_beta;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import zhang.great.tv.shudu_tv_beta.Util.Sudo;

public class IndexActivity extends AppCompatActivity implements View.OnClickListener{

    private MainShuDuView view;
    private LinearLayout main_container;
    private ImageView iv_pause;
    private TextView tv_newgame,tv_time,tv_record;
    private boolean isPause = false;
    private Sudo sudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_index);
        main_container = findViewById(R.id.main_container);
        iv_pause = findViewById(R.id.iv_pause);
        tv_newgame = findViewById(R.id.tv_newgame);
        tv_time = findViewById(R.id.tv_time);
        tv_record = findViewById(R.id.tv_record);
        iv_pause.setOnClickListener(this);
        tv_record.setOnClickListener(this);
        tv_time.setOnClickListener(this);
        tv_newgame.setOnClickListener(this);
        view = new MainShuDuView(this);
        sudo = new Sudo();
        sudo.genSudo(60);
        view.initView(sudo);
        main_container.addView(view);

    }


    private void refrush(){
        if(view != null){
            main_container.removeView(view);
            view = null;
            view = new MainShuDuView(IndexActivity.this);
            view.initView(sudo);
            main_container.addView(view);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_pause:
                if(isPause) {
                    iv_pause.setImageResource(R.mipmap.play48);
                    isPause = false;
                }else{
                    iv_pause.setImageResource(R.mipmap.stop23);
                    isPause = true;
                }
                break;
            case R.id.tv_level:


                break;
            case R.id.tv_newgame:
                System.out.println("点击新游戏");
                showpopWindow();

                break;
            case R.id.tv_record:


                break;
            case R.id.tv_time:


                break;
        }
    }

    private void showpopWindow(){
        TextView tv_level1,tv_level2,tv_level3,tv_level4,tv_level5,tv_level6;
        LinearLayout ll_reload;
        RelativeLayout container = (RelativeLayout) LayoutInflater.from(IndexActivity.this).inflate(R.layout.popuplayout,null);
        final PopupWindow popupWindow = new PopupWindow();
        popupWindow.setContentView(container);
        ll_reload = container.findViewById(R.id.ll_reload);
        tv_level1 = container.findViewById(R.id.textView6);
        tv_level2 = container.findViewById(R.id.textView7);
        tv_level3 = container.findViewById(R.id.textView8);
        tv_level4 = container.findViewById(R.id.textView9);
        tv_level5 = container.findViewById(R.id.textView10);
        tv_level6 = container.findViewById(R.id.textView11);

        ll_reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sudo.data = view.answer1;
                refrush();
                popupWindow.dismiss();
            }
        });
        tv_level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sudo = new Sudo();
                sudo.genSudo(54);
                refrush();
                popupWindow.dismiss();
            }
        });
        tv_level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sudo = new Sudo();
                sudo.genSudo(46);
                refrush();
                popupWindow.dismiss();
            }
        });
        tv_level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sudo = new Sudo();
                sudo.genSudo(38);
                refrush();
                popupWindow.dismiss();
            }
        });
        tv_level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sudo = new Sudo();
                sudo.genSudo(32);
                refrush();
                popupWindow.dismiss();
            }
        });
        tv_level5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sudo = new Sudo();
                sudo.genSudo(26);
                refrush();
                popupWindow.dismiss();
            }
        });
        tv_level6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sudo = new Sudo();
                sudo.genSudo(20);
                refrush();
                popupWindow.dismiss();
            }
        });
        popupWindow.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        Drawable drawable = IndexActivity.this.getDrawable(R.drawable.colorback);
        popupWindow.setBackgroundDrawable(drawable);
        popupWindow.showAtLocation(view,Gravity.BOTTOM, 0, 0);

    }
}
