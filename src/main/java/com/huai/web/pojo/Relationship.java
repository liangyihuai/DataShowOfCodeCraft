package com.huai.web.pojo;

/**
 * Created by liangyh on 3/23/2017.
 */
public class Relationship {
    private String source;
    private String target;
    private String name;
    private int weight;//volume
    private int cost;

    public Relationship() {
    }

    public Relationship(String source, String target, String name) {
        this.source = source;
        this.target = target;
        this.name = name;
    }

    public Relationship(String source, String target, String name, int weight, int cost) {
        this.source = source;
        this.target = target;
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Relationship)) return false;

        Relationship that = (Relationship) o;

        if (getWeight() != that.getWeight()) return false;
        if (getCost() != that.getCost()) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (target != null ? !target.equals(that.target) : that.target != null) return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;

    }

    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + (target != null ? target.hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getWeight();
        result = 31 * result + getCost();
        return result;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
