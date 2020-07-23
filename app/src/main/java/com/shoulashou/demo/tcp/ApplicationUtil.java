package com.shoulashou.demo.tcp;

/**
 * Created by likeye on 2020/7/23 9:59.
 **/
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Application;

public class ApplicationUtil extends Application{

    private Socket socket;
    private DataOutputStream out = null;
    private DataInputStream in = null;


    public void init() throws IOException, Exception{
        this.socket = new Socket("192.168.3.240",9987);
        this.out = new DataOutputStream(socket.getOutputStream());
        this.in = new DataInputStream(socket.getInputStream());
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public DataOutputStream getOut() {
        return out;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }

    public DataInputStream getIn() {
        return in;
    }

    public void setIn(DataInputStream in) {
        this.in = in;
    }

}
