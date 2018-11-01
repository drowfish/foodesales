package com.smbms.entity;

public class Img {
    private Integer id;

    private String url;

    private String md5;

    public Img(Integer id, String url, String md5) {
        this.id = id;
        this.url = url;
        this.md5 = md5;
    }

    public Img() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5 == null ? null : md5.trim();
    }
}