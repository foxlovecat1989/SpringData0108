package com.spring.mvc.psi.entities;

import com.google.errorprone.annotations.Immutable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "T_INVENTORY2")
@Immutable
public class Inventory2 {
    
    @Id
    private Integer id;
    
    @Column
    private String name;
    
    @Column(name = "image", columnDefinition = "clob") // clob 大字串, blob 大二進位
    @Lob
    private String image; // base64 String for image
    
    @Column(name = "REMAIN_QUANTITY")
    private Integer remainQuantity;
    
    @Column(name = "COST")
    private Integer cost;
    
    @Column(name = "price1")
    private Integer price1;
    
    @Column(name = "price2")
    private Integer price2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRemainQuantity() {
        return remainQuantity;
    }

    public void setRemainQuantity(Integer remainQuantity) {
        this.remainQuantity = remainQuantity;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getPrice1() {
        return price1;
    }

    public void setPrice1(Integer price1) {
        this.price1 = price1;
    }

    public Integer getPrice2() {
        return price2;
    }

    public void setPrice2(Integer price2) {
        this.price2 = price2;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
