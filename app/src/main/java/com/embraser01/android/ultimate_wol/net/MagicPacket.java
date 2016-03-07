package com.embraser01.android.ultimate_wol.net;

import java.util.concurrent.ExecutionException;

/**
 * Static WOL magic packet class
 */
public class MagicPacket {

    private static final String TAG = "MagicPacket";


    public static byte[] validateMac(String mac) throws IllegalArgumentException {
        byte[] bytes = new byte[6];
        String[] hex = mac.split("(:|\\-)");
        if (hex.length != 6) throw new IllegalArgumentException("Invalid MAC address.");

        try {
            for (int i = 0; i < 6; i++) bytes[i] = (byte) Integer.parseInt(hex[i], 16);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid hex digit in MAC address.");
        }

        return bytes;
    }

    public static String send(String mac, String ip, int port) {


        byte[] macBytes = validateMac(mac);
        byte[] frame = new byte[6 + 16 * macBytes.length];


        for (int i = 0; i < 6; i++) frame[i] = (byte) 0xff;
        for (int i = 6; i < frame.length; i += macBytes.length) System.arraycopy(macBytes, 0, frame, i, macBytes.length);
        
        // create socket to IP
        try {
            new NetTask(ip, frame, port).execute().get();
        } catch (ExecutionException e) {
            return e.getMessage();
        } catch (InterruptedException e) {
            return e.getMessage();
        }
        return null;
    }
}