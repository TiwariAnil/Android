package com.yourpanache.crmpanache.aModel;

/**
 * Created by user on 11-Jun-16.
 */
public class Appointment {
    private String userName, userPhone, serviceId, originaPrice, finalPrice, serviceTax, comments, bookingTime, timeStamp, packageId, panacheDiscount, panacheOffer;
    private int bookingId, salonId, bookingStatus, offerId;

    public Appointment(){}

    public Appointment(String userName, String serviceId, String  finalPrice) {
        this.userName = userName;
        this.serviceId = serviceId;
        this.finalPrice = finalPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getOriginaPrice() {
        return originaPrice;
    }

    public void setOriginaPrice(String originaPrice) {
        this.originaPrice = originaPrice;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getServiceTax() {
        return serviceTax;
    }

    public void setServiceTax(String serviceTax) {
        this.serviceTax = serviceTax;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getPanacheDiscount() {
        return panacheDiscount;
    }

    public void setPanacheDiscount(String panacheDiscount) {
        this.panacheDiscount = panacheDiscount;
    }

    public String getPanacheOffer() {
        return panacheOffer;
    }

    public void setPanacheOffer(String panacheOffer) {
        this.panacheOffer = panacheOffer;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getSalonId() {
        return salonId;
    }

    public void setSalonId(int salonId) {
        this.salonId = salonId;
    }

    public int getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(int bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }
}


