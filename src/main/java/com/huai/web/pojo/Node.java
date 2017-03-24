package com.huai.web.pojo;

/**
 * Created by liangyh on 3/23/2017.
 */
public class Node {
    private int category;
    private String name;
    private int value;

    public Node(int category, String name, int value) {
        this.category = category;
        this.name = name;
        this.value = value;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;

        if (getCategory() != node.getCategory()) return false;
        if (getValue() != node.getValue()) return false;
        if (getName() != null ? !getName().equals(node.getName()) : node.getName() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getCategory();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getValue();
        return result;
    }
}
