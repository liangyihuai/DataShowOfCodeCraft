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

        if (getSource() != null ? !getSource().equals(that.getSource()) : that.getSource() != null) return false;
        return getTarget() != null ? getTarget().equals(that.getTarget()) : that.getTarget() == null;

    }

    @Override
    public int hashCode() {
        int result = getSource() != null ? getSource().hashCode() : 0;
        result = 31 * result + (getTarget() != null ? getTarget().hashCode() : 0);
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
