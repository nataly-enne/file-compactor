package br.com.imd.edb2.nataly.entities;

public class Char {
    private Integer character;
    private Integer quantity;

    public Char(Integer character, Integer quantity) {
        this.character = character;
        this.quantity = quantity;
    }
    public Char(Integer quantity) {
        this.character = null;
        this.quantity = quantity;
    }

    public Integer getCharacter() {return character;}

    public void setCharacter(Integer character) {this.character = character;}

    public Integer getQuantity() {return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}



}