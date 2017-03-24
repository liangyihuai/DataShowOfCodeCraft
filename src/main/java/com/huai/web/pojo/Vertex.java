package com.huai.web.pojo;

/**
 * Created by liangyh on 3/23/2017.
 */
public class Vertex {
    private String id;
    private int volume;
    private int cost;

    public Vertex(String id, int volume, int cost) {
        this.id = id;
        this.volume = volume;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;

        Vertex vertex = (Vertex) o;

        if (getVolume() != vertex.getVolume()) return false;
        if (getCost() != vertex.getCost()) return false;
        return getId() != null ? getId().equals(vertex.getId()) : vertex.getId() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getVolume();
        result = 31 * result + getCost();
        return result;
    }
}
