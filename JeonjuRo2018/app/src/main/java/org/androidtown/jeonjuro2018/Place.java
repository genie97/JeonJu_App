package org.androidtown.jeonjuro2018;

/**
 * Created by starf on 2018-11-03.
 */

public class Place {
    public   String name;
    public String imgno;

    public Place (String name, String imgno) {
        this.name = name;
        this.imgno = imgno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagno() {
        return imgno;
    }

    public void setImgno(String imgno) {
        this.imgno = imgno;
    }
}
