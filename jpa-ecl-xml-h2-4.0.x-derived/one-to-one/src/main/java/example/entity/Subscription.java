package example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class Subscription {

    private int id;
    private String billing;
    @JsonBackReference
    private Device device;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBilling() {
        return billing;
    }

    public void setBilling(String billing) {
        this.billing = billing;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

}
