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
    private String text;



    public String getName() { return name; }
    public void setName(String name) {this.name = name;}
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
    public String getRarity() { return rarity; }
    public void setRarity(String rarity) { this.rarity = rarity; }
    public String getTipus() {return tipus;}
    public void setTipus(String tipus) {this.tipus = tipus;}
    public String getImgURL() {return imgURL;}
    public void setImgURL(String imgURL) {this.imgURL = imgURL;}
    public String getResistencia() {return resistencia;}
    public void setResistencia(String resistencia) {this.resistencia = resistencia;}
    public String getText() {return text;}
    public void setText(String text) {this.text = text;}


    @Override
    public String toString(){
        return  "\n\t\t" + name + "\n\t\t" + rarity +  "\n\t\t" + tipus + "\n\t\t " + color;
    }

}
