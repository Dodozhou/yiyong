package com.star.entity;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hp on 2017/9/8.
 */
@Entity
@Table(name = "my_thing",schema = "yiyong")
public class MyThing {
    private int id;
    private String name;
    private String desc;   //物品的描述
    private String category;   //物品类别
    private float lowP;          //价格区间的下限
    private float highP;          //价格区间的上限
    private String picPath;      //保存的图片路径

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name="description")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    @Column(name = "lp")
    public float getLowP() {
        return lowP;
    }

    public void setLowP(float lowP) {
        this.lowP = lowP;
    }
    @Column(name = "hp")
    public float getHighP() {
        return highP;
    }

    public void setHighP(float highP) {
        this.highP = highP;
    }
    @Column(name = "pic_path")
    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}
