package com.smbms.entity;

public class FoodList {
    private Integer id;

    private String name;

    private Img img;

    private Float price;

    private Classification classification;

    private Integer stock;

    private Integer salesvolume;

    public FoodList(Integer id, String name, Img img, Float price, Classification classification, Integer stock, Integer salesvolume) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.classification = classification;
        this.stock = stock;
        this.salesvolume = salesvolume;
    }

    public FoodList(){super();}

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
        this.name = name;
    }

    public Img getImg() {
        return img;
    }

    public void setImg(Img img) {
        this.img = img;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
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
        return "FoodList{" +
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
