package com.example.a47276138y.cartas_magic;

/**
 * Created by 47276138y on 17/10/16.
 */

public class Carta {

    public Carta(){

    };

    private String name;
    private String rarity;
    private String tipus; //Una carta pot formar aprt de superTipus, tipus i subTipus. Aquesta propietat els inclourà tots.
    private String numeroCarta; //L'API indica que alguns numeros de carta poden ser lletres.
    private String poder; //
    private String imageURL;
    // Algunes cartes tenen com a poder 1+, per tant la propietat ha de ser de tipus String.


    public String getName() { return name; }
    public void setName(String name) {this.name = name;}
    public String getRarity() { return rarity; }
    public void setRarity(String rarity) { this.rarity = rarity; }
    public String getTipos() { return tipus; }
    public void setTipos(String tipos) { this.tipus = tipos; }
    public String getNumeroCarta() { return numeroCarta; }
    public void setNumeroCarta(String numeroCarta) { this.numeroCarta = numeroCarta; }
    public String getPoder() { return poder; }
    public void setPoder(String poder) { this.poder = poder; }


    @Override
    public String toString(){
        return  "\n\t\t" + name + "\n\t\t" + rarity +  "\n\t\t" + tipus +  "\n\t\t" + numeroCarta +  "\n\t\t" + poder;
    }


}
