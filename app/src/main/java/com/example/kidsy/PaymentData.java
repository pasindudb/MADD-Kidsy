package com.example.kidsy;

public class PaymentData {

    String payid;
    String payfirstname;
    String payemail;
    String payaddress;
    String paycardnumber;
    String paycardowner;
    String paycardexpiredate;
    String paybookname;
    String payqty;
    String paytotalprice;
    String paydate;

    public PaymentData() {
    }

    public PaymentData(String payid, String payfirstname, String payemail,String payaddress,String paycardnumber, String paycardowner, String paycardexpiredate, String paybookname,String payqty, String paytotalprice, String paydate) {
        this.payid = payid;
        this.payfirstname = payfirstname;
        this.payemail = payemail;
        this.payaddress = payaddress;
        this.paycardnumber = paycardnumber;
        this.paycardowner = paycardowner;
        this.paycardexpiredate = paycardexpiredate;
        this.paybookname = paybookname;
        this.payqty = payqty;
        this.paytotalprice = paytotalprice;
        this.paydate = paydate;
    }

    public String getPayid() {
        return payid;
    }

    public void setPayid(String payid) {
        this.payid = payid;
    }

    public String getPayfirstname() {
        return payfirstname;
    }

    public void setPayfirstname(String payfirstname) {
        this.payfirstname = payfirstname;
    }

    public String getPayemail() {
        return payemail;
    }

    public void setPayemail(String payemail) {
        this.payemail = payemail;
    }

    public String getPayaddress() {
        return payaddress;
    }

    public void setPayaddress(String payaddress) {
        this.payaddress = payaddress;
    }

    public String getPaycardnumber() {
        return paycardnumber;
    }

    public void setPaycardnumber(String paycardnumber) {
        this.paycardnumber = paycardnumber;
    }

    public String getPaycardowner() {
        return paycardowner;
    }

    public void setPaycardowner(String paycardowner) {
        this.paycardowner = paycardowner;
    }

    public String getPaycardexpiredate() {
        return paycardexpiredate;
    }

    public void setPaycardexpiredate(String paycardexpiredate) {
        this.paycardexpiredate = paycardexpiredate;
    }

    public String getPaybookname() {
        return paybookname;
    }

    public void setPaybookname(String paybookname) {
        this.paybookname = paybookname;
    }
    public String getPayqty() {
        return payqty;
    }

    public void setPayqty(String payqty) {
        this.payqty = payqty;
    }

    public String getPaytotalprice() {
        return paytotalprice;
    }

    public void setPaytotalprice(String paytotalprice) {
        this.paytotalprice = paytotalprice;
    }

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }
}
