package com.embraser01.android.ultimate_wol.net;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class NetTask extends AsyncTask<String, Integer, InetAddress> {
    private final String ip;
    private final byte[] frame;
    private final int port;

    public NetTask(String ip, byte[] frame, int port) {
        this.ip = ip;
        this.frame = frame;
        this.port = port;
    }

    @Override
    protected InetAddress doInBackground(String... params) {
        InetAddress adr = null;
        try {
            adr = InetAddress.getByName(ip);
            final DatagramPacket packet = new DatagramPacket(frame, 0, frame.length, adr, port);
            final DatagramSocket socket = new DatagramSocket();
            socket.send(packet);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adr;
    }

}
