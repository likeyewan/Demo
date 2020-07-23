package com.shoulashou.demo.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.shoulashou.demo.R;
import com.shoulashou.demo.tcp.ClientThread;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2020/7/22 9:56.
 **/
public class RunFragment extends Fragment {
    private ClientThread mClientThread;
    private Handler mHandler,nHandler;

    private View mView;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> adapter2;
    private static final String[] m={"A型","B型","O型","AB型","其他"};
    private static final String[] n={"A型","B型","C型","D型","其他"};
    private static final String[] fileName={"A","B","C","D","其他"};
    @BindView(R.id.spinner1)
    Spinner spinner1;
    @BindView(R.id.spinner2)
    Spinner spinner2;
    @BindView(R.id.spinner3)
    Spinner spinner3;
    @BindView(R.id.stop)
    ImageButton ibStop;
    @BindView(R.id.start)
    ImageButton ibStart;
    @BindView(R.id.pause)
    ImageButton ibPause;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_run, container, false);
        ButterKnife.bind(this,mView);
        //显示从服务器获取的信息
        mHandler=new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0) {
                    //tvMain.append("\n"+"Server:"+ msg.obj.toString());
                }
            }
        };
        //显示与服务器连接的信息
        nHandler=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                //连接成功
                if(msg.what==1){
                    // tvMain.append("\n"+msg.obj.toString());
                }
                //连接失败
                else if (msg.what==0){
                    // tvMain.append("\n"+msg.obj.toString());
                }
            }
        };
        init();
        return mView;
    }
    private void init() {
        mClientThread = new ClientThread(mHandler, nHandler, "192.168.3.240", 9987);
        new Thread(mClientThread).start();
        spinnerModel(m,spinner1);
        spinnerModel(n,spinner2);
        spinnerModel(fileName,spinner3);
        //开始按钮点击事件
        ibStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Message msg1 = new Message();
                    msg1.what = 1;
                    msg1.obj = "likeye";
                    Log.d("Run","msg="+msg1.what+"msg.obj="+msg1.obj);
                    //tvMain.append("\n"+"Client:"+ msg.obj.toString());
                    mClientThread.revHandler.sendMessage(msg1);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        //暂停按钮点击事件
        ibPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //停止按钮点击事件
        ibStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void spinnerModel(String[] strings,Spinner spinner) {
        //将可选内容与ArrayAdapter连接起来
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mView.getContext(), android.R.layout.simple_spinner_item, strings);

        //设置下拉列表的风格
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //将adapter 添加到spinner中
        spinner.setAdapter(adapter);

        //添加事件Spinner事件监听
        spinner.setOnItemSelectedListener(new SpinnerSelectedListener());

        //设置默认值
        spinner.setVisibility(View.VISIBLE);
    }
    //使用数组形式操作
    class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
           // Toast.makeText(mView.getContext(),"你的血型是："+m[arg2],Toast.LENGTH_SHORT).show();
        }

        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }
}