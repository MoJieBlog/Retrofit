package com.lzp.retrofit.net;

import java.io.Serializable;

/**
 * 这里采用如下格式
 * {
 * "status": 1,
 * "msg":"返回描述"
 * "content": {
 * "from": "en-EU",
 * "to": "zh-CN",
 * "out": "示例",
 * "vendor": "ciba",
 * "err_no": 0
 * }
 * }
 *
 * @author Li Xiaopeng
 * @date 2018/10/22
 */
public class BaseNetModel<T> implements Serializable {

    public static final int STATUS_OK = 1;

    protected int status;
    protected String msg;

    private T content;

    /**
     * 网络请求是否成功
     * @return
     */
    public boolean getDataSuccess() {
        return status == STATUS_OK;
    }

    /**********************get和set方法*************************/
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return content;
    }

    public void setData(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BaseNetModel{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", content=" + content.toString() +
                '}';
    }
}
