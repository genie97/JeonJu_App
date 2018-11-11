package org.androidtown.jeonjuro2018;

import android.media.Image;
import android.widget.ImageView;

public class TourInfo {
    private String url;
    public String tourName;
    public String tourLocation;
    public String dataContent;
    public String homepage;

    public TourInfo(String url, String tourName, String tourLocation, String dataContent, String homepage) {
        this.url = url;
        this.tourLocation = tourLocation;
        this.tourName = tourName;
        this.dataContent = dataContent;
        this.homepage = homepage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getTourLocation() {
        return tourLocation;
    }

    public void setTourLocation(String tourLocation) {
        this.tourLocation = tourLocation;
    }

    public String getDataContent() {
        return dataContent;
    }

    public void setDataContent(String dataContent) {
        this.dataContent = dataContent;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
}


