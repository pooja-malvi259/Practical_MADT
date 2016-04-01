package com.example.jenis_000.practical4;

/**
 * Created by Jenis_000 on 3/12/2016.
 */
public class DataProvider {
    private int img_res;
    private String s_name;

    public DataProvider(int img_res,String s_name){
        this.setImg_res(img_res);
        this.setS_name(s_name);
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public int getImg_res() {
        return img_res;
    }

    public void setImg_res(int img_res) {
        this.img_res = img_res;
    }

}
