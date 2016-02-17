package com.embraser01.android.ultimate_wol.model;


import android.text.format.DateFormat;

public class Computer {

    private int id;
    private String name;
    private String mac;
    private String ip;
    private String port;
    private String last_used;
    private int used_cnt;

    public Computer(String name, String mac, String ip, String port) {
        this.id = -1;
        this.name = name;
        this.mac = mac;
        this.ip = ip;
        this.port = port;
        this.last_used = DateFormat.format("yyyy-MM-dd hh:mm", new java.util.Date()).toString();
        this.used_cnt = 0;
    }

    public Computer(int id, String name, String mac, String ip, String port, String last_used, int used_cnt) {
        this.id = id;
        this.name = name;
        this.mac = mac;
        this.ip = ip;
        this.port = port;
        this.last_used = last_used;
        this.used_cnt = used_cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getLast_used() {
        return last_used;
    }

    public void setLast_used(String last_used) {
        this.last_used = last_used;
    }

    public int getUsed_cnt() {
        return used_cnt;
    }

    public void setUsed_cnt(int used_cnt) {
        this.used_cnt = used_cnt;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mac='" + mac + '\'' +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", last_used=" + last_used +
                ", used_cnt=" + used_cnt +
                '}';
    }
}
