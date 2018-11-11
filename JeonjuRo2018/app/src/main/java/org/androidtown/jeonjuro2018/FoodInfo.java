package org.androidtown.jeonjuro2018;

/**
 * Created by starf on 2018-11-08.
 */

public class FoodInfo {
    public String storeImg;
    public String storeName;
    public String storeAddr;
    public String Menu;
    public String storeOpen;
    public String holiday;
    public String openTime;

    public FoodInfo(String storeImg, String storeName, String storeAddr, String Menu, String storeOpen, String holiday, String openTime) {
        this.storeImg = storeImg;
        this.storeAddr = storeAddr;
        this.Menu = Menu;
        this.storeName = storeName;
        this.storeOpen = storeOpen;
        this.holiday = holiday;
        this.openTime = openTime;
    }

    public String getStoreImg() {return storeImg;}

    public void setStoreImg() {this.storeImg = storeImg;}

    public String getStoreName() {return storeName;}

    public void setStoreName() {this.storeName = storeName;}

    public String getStoreAddr() {return storeAddr;}

    public void setStoreAddr() {this.storeAddr = storeAddr;}

    public String getMenu() {return Menu;}

    public void setMenu() {this.Menu = Menu;}

    public String getstoreOpen() {return storeOpen;}

    public void setstoreOpen() {this.storeOpen = storeOpen;}

    public String getholiday() {return storeOpen;}

    public void setholiday() {this.holiday = holiday;}

    public String getopenTime() {return openTime;}

    public void setopenTime() {this.openTime = openTime;}
}
