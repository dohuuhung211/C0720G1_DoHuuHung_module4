package com.example.model;
public class Email {
    private String languages;
    private int pageSize;
    private String signature;

    public Email() {
    }

    public Email(String languages, int pageSize, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
