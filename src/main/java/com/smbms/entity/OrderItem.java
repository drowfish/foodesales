package com.smbms.entity;

public class OrderItem {
    private Integer id;

    private Integer foodsId;

    private Integer orderId;

    private Integer num;

    private Integer totalFee;

    public OrderItem(Integer id, Integer foodsId, Integer orderId, Integer num, Integer totalFee) {
        this.id = id;
        this.foodsId = foodsId;
        this.orderId = orderId;
        this.num = num;
        this.totalFee = totalFee;
    }

    public OrderItem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFoodsId() {
        return foodsId;
    }

    public void setFoodsId(Integer foodsId) {
        this.foodsId = foodsId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }
}