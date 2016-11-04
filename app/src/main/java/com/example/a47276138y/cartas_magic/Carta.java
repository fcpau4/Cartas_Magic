package com.example.a47276138y.cartas_magic;

/**
 * Created by 47276138y on 17/10/16.
 */

public class Carta {

    private String name;
    private String rarity;
    private String tipus;
    private String imgURL;

    public String getName() { return name; }
    public void setName(String name) {this.name = name;}
    public String getRarity() { return rarity; }
    public void setRarity(String rarity) { this.rarity = rarity; }
    public String getTipos() { return tipus; }
    public void setTipos(String tipos) { this.tipus = tipos; }
    public String getImgURL() {return imgURL;}
    public void setImgURL(String imgURL) {this.imgURL = imgURL;}



    @Override
    public String toString(){
        return  "\n\t\t" + name + "\n\t\t" + rarity +  "\n\t\t" + tipus;
    }

}
