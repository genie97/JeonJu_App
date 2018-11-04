package net.software.jeonju;

/**
 * Created by starf on 2018-11-03.
 */

public class Place {
    final static String placeList[] = {"안압지","한옥마을","전주","그리드뷰"};
    final static int imglist[] = {R.drawable.pocket,};

    private  String name;
    private int imgno;

    public Place (String name, int imgno) {
        this.name = name;
        this.imgno = imgno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImagno() {
        return imgno;
    }

    public void setImgno(int imgno) {
        this.imgno = imgno;
    }
}
