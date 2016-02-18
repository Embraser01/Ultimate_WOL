package com.embraser01.android.ultimate_wol.model;


import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;

public class Computer implements Parcelable {

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

    private Computer(Parcel in) {
        id = in.readInt();
        name = in.readString();
        mac = in.readString();
        ip = in.readString();
        port = in.readString();
        last_used = in.readString();
        used_cnt = in.readInt();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(mac);
        dest.writeString(ip);
        dest.writeString(port);
        dest.writeString(last_used);
        dest.writeInt(used_cnt);
    }

    public static final Parcelable.Creator<Computer> CREATOR = new Parcelable.Creator<Computer>() {
        public Computer createFromParcel(Parcel in) {
            return new Computer(in);
        }

        public Computer[] newArray(int size) {
            return new Computer[size];
        }
    };


}
