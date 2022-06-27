package com.google.sps.servlets;

public class Entry {
    public long id;
    public String msg;
    public long timestamp;

    public Entry(long id, String msg, long timestamp) {
        this.id = id;
        this.msg = msg;
        this.timestamp = timestamp;
    }
}
