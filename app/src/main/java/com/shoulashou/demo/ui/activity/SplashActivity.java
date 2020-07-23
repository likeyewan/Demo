package com.shoulashou.demo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.shoulashou.demo.tcp.ClientThread;

import static java.lang.Thread.sleep;

/**
 * Created by Administrator on 2020/7/22 8:44.
 **/
public class SplashActivity extends AppCompatActivity {
    private ClientThread mClientThread;
    private Handler mHandler,nHandler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        new Thread( new Runnable( ) {
            @Override
            public void run() {
                //mClientThread = new ClientThread(mHandler,nHandler,"192.168.3.240",9987);
               // new Thread(mClientThread).start();
                //耗时任务，比如加载网络数据
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // 这里可以睡几秒钟，如果要放广告的话
                        try {
                            sleep(1000);
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                        SplashActivity.this.finish();
                        startActivity(intent);
                    }
                });
            }
        } ).start();
    }
}






















