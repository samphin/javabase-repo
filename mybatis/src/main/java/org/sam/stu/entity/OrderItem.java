package org.sam.stu.entity;

import java.util.Date;

public class OrderItem {
    private Long itemId;

    private Long orderId;

    private String orderNumber;

    private Byte orderStatus;

    private Long formatId;

    private Long buyerId;

    private Byte buyerStatus;

    private Date buyerFinishTime;

    private Long deliveryId;

    private Byte deliveryType;

    private Byte deliveryStatus;

    private Long deliveryMoney;

    private Long sellerId;

    private Byte sellerStatus;

    private Date sellerFinishTime;

    private String remark;

    private Long goodsNumberOld;

    private Long goodsNumber;

    private Long goodsPrice;

    private Long goodsAmount;

    private Date createTime;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getFormatId() {
        return formatId;
    }

    public void setFormatId(Long formatId) {
        this.formatId = formatId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Byte getBuyerStatus() {
        return buyerStatus;
    }

    public void setBuyerStatus(Byte buyerStatus) {
        this.buyerStatus = buyerStatus;
    }

    public Date getBuyerFinishTime() {
        return buyerFinishTime;
    }

    public void setBuyerFinishTime(Date buyerFinishTime) {
        this.buyerFinishTime = buyerFinishTime;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Byte getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Byte deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Byte getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(Byte deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Long getDeliveryMoney() {
        return deliveryMoney;
    }

    public void setDeliveryMoney(Long deliveryMoney) {
        this.deliveryMoney = deliveryMoney;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Byte getSellerStatus() {
        return sellerStatus;
    }

    public void setSellerStatus(Byte sellerStatus) {
        this.sellerStatus = sellerStatus;
    }

    public Date getSellerFinishTime() {
        return sellerFinishTime;
    }

    public void setSellerFinishTime(Date sellerFinishTime) {
        this.sellerFinishTime = sellerFinishTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getGoodsNumberOld() {
        return goodsNumberOld;
    }

    public void setGoodsNumberOld(Long goodsNumberOld) {
        this.goodsNumberOld = goodsNumberOld;
    }

    public Long getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Long goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Long getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Long goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Long getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Long goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}