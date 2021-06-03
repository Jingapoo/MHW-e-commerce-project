package com.example.mhwequipment;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="jingapoo_equipment") // need to specify the name of the table.
public class PalicoWeapons {

    @Id  // indicating te member field below is the primary key of current entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // to configure the way of increment of the specified column (field) = auto_increment in MySQL
    private long id;
    @NotEmpty(message = "Please enter weapon name")
    private String name;
    @NotNull
    private int rarity;
    @NotEmpty
    private String attackType;
    @NotEmpty
    private String elementDamage;
    @NotEmpty
    private String craftingMaterial;
    @NotNull
    private double price;

    protected PalicoWeapons() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public String getElementDamage() {
        return elementDamage;
    }

    public void setElementDamage(String elementDamage) {
        this.elementDamage = elementDamage;
    }

    public String getCraftingMaterial() {
        return craftingMaterial;
    }

    public void setCraftingMaterial(String craftingMaterial) {
        this.craftingMaterial = craftingMaterial;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
