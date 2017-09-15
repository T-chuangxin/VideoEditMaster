package com.tian.video.editer.entity;
/**
 * 泛型封装（统一返回结果）
 * @param <T>
 */
public class SubHttpResult<T> {

    private int Status;

    private String msg;


    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    @Override
    public String toString() {
        return "SubHttpResult{" +
                "Status=" + Status +
                ", msg='" + msg + '\'' +
                '}';
    }
}