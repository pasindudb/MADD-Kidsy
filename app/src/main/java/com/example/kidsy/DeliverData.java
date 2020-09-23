package com.example.kidsy;

public class DeliverData {

    String delid;
    String orderid;
    String delfirst;
    String dellast;
    String deladdress;
    String delzip;
    String delemail;
    String delqty;
    String deldate;

    public DeliverData() {
    }

    public DeliverData(String delid, String orderid, String delfirst, String dellast, String deladdress, String delzip, String delemail,String delqty, String deldate) {
        this.delid = delid;
        this.orderid = orderid;
        this.delfirst = delfirst;
        this.dellast = dellast;
        this.deladdress = deladdress;
        this.delzip = delzip;
        this.delemail = delemail;
        this.delqty=delqty;
        this.deldate = deldate;
    }

    public String getDelid() {
        return delid;
    }

    public void setDelid(String delid) {
        this.delid = delid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getDelfirst() {
        return delfirst;
    }

    public void setDelfirst(String delfirst) {
        this.delfirst = delfirst;
    }

    public String getDellast() {
        return dellast;
    }

    public void setDellast(String dellast) {
        this.dellast = dellast;
    }

    public String getDeladdress() {
        return deladdress;
    }

    public void setDeladdress(String deladdress) {
        this.deladdress = deladdress;
    }

    public String getDelzip() {
        return delzip;
    }

    public void setDelzip(String delzip) {
        this.delzip = delzip;
    }

    public String getDelemail() {
        return delemail;
    }

    public void setDelemail(String delemail) {
        this.delemail = delemail;
    }
    public String getDelqty() {
        return delqty;
    }

    public void setDelqty(String delqty) {
        this.delqty = delqty;
    }

    public String getDeldate() {
        return deldate;
    }

    public void setDeldate(String deldate) {
        this.deldate = deldate;
    }
}
