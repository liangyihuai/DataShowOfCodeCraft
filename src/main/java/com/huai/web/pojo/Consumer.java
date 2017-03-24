package com.huai.web.pojo;

/**
 * Created by liangyh on 3/23/2017.
 */
public class Consumer {
    private String id;
    private String networkId;
    private int requirement;

    public Consumer(String id, String networkId, int requirement) {
        this.id = id;
        this.networkId = networkId;
        this.requirement = requirement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public int getRequirement() {
        return requirement;
    }

    public void setRequirement(int requirement) {
        this.requirement = requirement;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Consumer)) return false;

        Consumer consumer = (Consumer) o;

        if (getRequirement() != consumer.getRequirement()) return false;
        if (getId() != null ? !getId().equals(consumer.getId()) : consumer.getId() != null) return false;
        return getNetworkId() != null ? getNetworkId().equals(consumer.getNetworkId()) : consumer.getNetworkId() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNetworkId() != null ? getNetworkId().hashCode() : 0);
        result = 31 * result + getRequirement();
        return result;
    }
}
