package br.com.imd.edb2.nataly.tree;

public class Node {

    private Integer character;
    private Integer quantity;
    private Node left;
    private Node right;

    public Node() {
        this.left = null;
        this.right = null;
    }

    public Node(Integer c, Integer x) {
        this.character = c;
        this.quantity = x;
        this.left = null;
        this.right = null;
    }

    public Node(Integer x, Node left, Node right) {
        this.quantity = x;
        this.left = left;
        this.right = right;

    }

    public Integer getCharacter() {
        return character;
    }

    public void setCharacter(Integer character) {
        this.character = character;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}