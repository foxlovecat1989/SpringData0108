package com.spring.mvc.psi.entities;

import com.google.errorprone.annotations.Immutable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "T_INVENTORY")
public class Inventory {
    
    @Id
    private Integer id;
    
    @Column
    private String name;
    
    @Column(name = "image", columnDefinition = "clob") // clob 大字串, blob 大二進位
    @Lob
    private String image; // base64 String for image
    
    @Column(name = "PU_QUANTITY")
    private Integer pu_quantity;
    
    @Column(name = "PU_AMOUNT")
    private Integer pu_amount;
    
    @Column(name = "SA_QUANTITY")
    private Integer sa_quantity;
    
    @Column(name = "SA_AMOUNT")
    private Integer sa_amount;

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

    public Integer getPu_quantity() {
        return pu_quantity;
    }

    public void setPu_quantity(Integer pu_quantity) {
        this.pu_quantity = pu_quantity;
    }

    public Integer getPu_amount() {
        return pu_amount;
    }

    public void setPu_amount(Integer pu_amount) {
        this.pu_amount = pu_amount;
    }

    public Integer getSa_quantity() {
        return sa_quantity;
    }

    public void setSa_quantity(Integer sa_quantity) {
        this.sa_quantity = sa_quantity;
    }

    public Integer getSa_amount() {
        return sa_amount;
    }

    public void setSa_amount(Integer sa_amount) {
        this.sa_amount = sa_amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
