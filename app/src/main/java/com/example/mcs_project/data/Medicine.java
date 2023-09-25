package com.example.mcs_project.data;

public class Medicine {

//    private Integer medsImg;
    public String medsName, medsManufacture, medsDescription;
    public int medsImg, medsPrice;

    public Medicine(int medsImg, String medsName, String medsManufacture, int medsPrice, String medsDescription) {
        this.medsName = medsName;
        this.medsManufacture = medsManufacture;
        this.medsImg = medsImg;
        this.medsPrice = medsPrice;
        this.medsDescription = medsDescription;
    }

//        public Integer getMedsImg() {
//        return medsImg;
//    }
//
//    public void setMedsImg(Integer medsImg) {
//        this.medsImg = medsImg;
//    }
//
//    public String getMedsName() {
//        return medsName;
//    }
//
//    public void setMedsName(String medsName) {
//        this.medsName = medsName;
//    }
//
//    public String getMedsManufacture() {
//        return medsManufacture;
//    }
//
//    public void setMedsManufacture(String medsManufacture) {
//        this.medsManufacture = medsManufacture;
//    }
//
//    public String getMedsDescription() {
//        return medsDescription;
//    }
//
//    public void setMedsDescription(String medsDescription) {
//        this.medsDescription = medsDescription;
//    }
    public int getMedsPrice() {
        return medsPrice;
    }

    public void setMedsPrice(int medsPrice) {
        this.medsPrice = medsPrice;
    }
}
