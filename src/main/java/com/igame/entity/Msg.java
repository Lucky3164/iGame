package com.igame.entity;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-09 10:58
 */
public class Msg {

    private String code;

    private String info;

    private Map<String, Object> extend = new LinkedHashMap<>();

    public Msg() {
    }

    public Msg(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public static Msg success(String info){
        Msg msg = new Msg();
        msg.setCode("200");
        msg.setInfo(info);
        return msg;
    }
    public static Msg fail(String info){
        Msg msg = new Msg();
        msg.setCode("400");
        msg.setInfo(info);
        return msg;
    }

    public Msg add(String key, Object value){
        extend.put(key, value);
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
