package com.spring.mvc.psi.entities;

import com.google.errorprone.annotations.Immutable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "T_INVENTORY_2")
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
    
    @Column(name = "AVERAGE_OF_COST")
    private Integer averageOfCost;
    
    @Column(name = "AVERAGE_OF_SALE")
    private Integer averageOfSale;
    
    @Column(name = "SALE_PRICE1")
    private Integer salePrice1;
    
    @Column(name = "SALE_PRICE2")
    private Integer salePrice2;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getRemainQuantity() {
        return remainQuantity;
    }

    public void setRemainQuantity(Integer remainQuantity) {
        this.remainQuantity = remainQuantity;
    }

    public Integer getAverageOfCost() {
        return averageOfCost;
    }

    public void setAverageOfCost(Integer averageOfCost) {
        this.averageOfCost = averageOfCost;
    }

    public Integer getAverageOfSale() {
        return averageOfSale;
    }

    public void setAverageOfSale(Integer averageOfSale) {
        this.averageOfSale = averageOfSale;
    }

    public Integer getSalePrice1() {
        return salePrice1;
    }

    public void setSalePrice1(Integer salePrice1) {
        this.salePrice1 = salePrice1;
    }

    public Integer getSalePrice2() {
        return salePrice2;
    }

    public void setSalePrice2(Integer salePrice2) {
        this.salePrice2 = salePrice2;
    }
    
    
}
