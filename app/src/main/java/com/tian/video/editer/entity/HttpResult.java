package com.tian.video.editer.entity;
/**
 * 泛型封装（统一返回结果）
 * @param <T>
 */
public class HttpResult<T> {

    private int Status;

    private String Msg;

    private T Content;


    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public T getContent() {
        return Content;
    }

    public void setContent(T content) {
        Content = content;
    }


    @Override
    public String toString() {
        return "HttpResult{" +
                "Status='" + Status + '\'' +
                ", Msg='" + Msg + '\'' +
                ", Content=" + Content +
                '}';
    }
}