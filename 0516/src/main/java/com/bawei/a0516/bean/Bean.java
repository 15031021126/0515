package com.bawei.a0516.bean;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class Bean {
    private String name;
    private String imageUrl;
    private String summary;

    public Bean(String name, String imageUrl, String summary) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }

    public Bean() {
    }
}
