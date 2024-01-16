package com.project.estatemanagementsystem.model;

public class PaymentCallback {

    private String txnid;
    private String mihpayid;
    private PaymentMode mode;
    private String status;
    private String hash;

    // Getter and Setter for txnid
    public String getTxnid() {
        return txnid;
    }

    public void setTxnid(String txnid) {
        this.txnid = txnid;
    }

    // Getter and Setter for mihpayid
    public String getMihpayid() {
        return mihpayid;
    }

    public void setMihpayid(String mihpayid) {
        this.mihpayid = mihpayid;
    }

    // Getter and Setter for mode
    public PaymentMode getMode() {
        return mode;
    }

    public void setMode(PaymentMode mode) {
        this.mode = mode;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter and Setter for hash
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
