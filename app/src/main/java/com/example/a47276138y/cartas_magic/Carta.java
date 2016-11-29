package com.example.a47276138y.cartas_magic;

import java.io.Serializable;

/**
 * Created by 47276138y on 17/10/16.
 */

public class Carta implements Serializable{

    private String imgURL;
    private String name;
    private String tipus;
    private String rarity;
    private String color;
    private String resistencia;
    private String descrip;

    public String getImgURL() {return imgURL;}
    public void setImgURL(String imgURL) {this.imgURL = imgURL;}
    public String getName() { return name; }
    public void setName(String name) {this.name = name;}
    public String getTipus() {return tipus;}
    public void setTipus(String tipus) {this.tipus = tipus;}
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
    public String getRarity() { return rarity; }
    public void setRarity(String rarity) { this.rarity = rarity; }
    public String getResistencia() { return resistencia; }
    public void setResistencia(String resistencia) { this.resistencia = resistencia; }
    public String getDescrip() { return descrip; }
    public void setDescrip(String descrip) {this.descrip = descrip;}



    @Override
    public String toString(){
        return  "\n\t\t" + name + "\n\t\t" + rarity +  "\n\t\t" + tipus + "\n\t\t " + color;
    }

}
