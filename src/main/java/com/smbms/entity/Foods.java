package com.smbms.entity;

public class Foods {
    private Integer id;

    private String name;

    private Integer img;

    private Float price;

    private Integer classification;

    private Integer stock;

    private Integer salesvolume;

    public Foods(Integer id, String name, Integer img, Float price, Integer classification, Integer stock, Integer salesvolume) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.classification = classification;
        this.stock = stock;
        this.salesvolume = salesvolume;
    }

    public Foods() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSalesvolume() {
        return salesvolume;
    }

    public void setSalesvolume(Integer salesvolume) {
        this.salesvolume = salesvolume;
    }

    @Override
    public String toString() {
        return "Foods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img=" + img +
                ", price=" + price +
                ", classification=" + classification +
                ", stock=" + stock +
                ", salesvolume=" + salesvolume +
                '}';
    }
}