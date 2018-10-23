package com.lzp.retrofit;

/**
 * @author Li Xiaopeng
 * @date 2018/10/22
 */
public class TestModel {
    private String from;
    private String to;
    private String out;
    private String vendor;
    private String err_no;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getErr_no() {
        return err_no;
    }

    public void setErr_no(String err_no) {
        this.err_no = err_no;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", out='" + out + '\'' +
                ", vendor='" + vendor + '\'' +
                ", err_no='" + err_no + '\'' +
                '}';
    }
}
