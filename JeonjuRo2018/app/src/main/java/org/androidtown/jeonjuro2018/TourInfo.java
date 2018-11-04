package org.androidtown.jeonjuro2018;

public class TourInfo {
    public int drawableId;
    public String tourName;
    public String tourLocation;
    public TourInfo(int drawableId, String tourName, String tourLocation){
        this.drawableId=drawableId;
        this.tourLocation=tourLocation;
        this.tourName=tourName;
    }
}
