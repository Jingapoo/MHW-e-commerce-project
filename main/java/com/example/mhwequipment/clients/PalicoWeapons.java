package com.example.mhwequipment.clients;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="jingapoo_equipment") // need to specify the name of the table.
public class PalicoWeapons {

    @Id  // indicating te member field below is the primary key of current entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // to configure the way of increment of the specified column (field) = auto_increment in MySQL
    private long id;

    @NotEmpty(message = "Weapon name cannot be empty!")
    @Size(min=1, max=50, message = "Weapon name must between {min} and {max} long ")
    private String name;

    @NotNull(message = "Please choose the rarity level!")
    @Min(0)
    private int rarity;

    @NotEmpty(message = "Please provide the attack type or None")
    @Size(min=1, max=8, message = "Attack Type must between {min} and {max} long ")
    private String attackType;

    @NotEmpty(message = "Please provide the Element Damage or None")
    @Size(min=1,max=20,message = "Element Damage must between {min} and {max} long ")
    private String elementDamage;

    @NotEmpty(message = "Crafting Material cannot be None!")
    @Size(min=1,max=100,message = "Crafting Material must between {min} and {max} long ")
    private String craftingMaterial;

    @DecimalMin(value = "0.01", message = "The price of weapon must be higher than ${value}")
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
