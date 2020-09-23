package com.example.kidsy;

public class DeliverData {

    String delid;
    String orderid;
    String delfirst;
    String deladdress;
    String delqty;
    String deldate;

    public DeliverData() {
    }

    public DeliverData(String delid, String orderid, String delfirst, String deladdress,String delqty, String deldate) {
        this.delid = delid;
        this.orderid = orderid;
        this.delfirst = delfirst;
        this.deladdress = deladdress;
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



    public String getDeladdress() {
        return deladdress;
    }

    public void setDeladdress(String deladdress) {
        this.deladdress = deladdress;
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
