package example;

import example.entity.Device;
import example.entity.Subscription;
import example.repository.DeviceRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Device device = new Device();
        device.setBrand("Samsung");
        device.setModel("S22");

        Subscription subscription = new Subscription();
        subscription.setBilling("free");
        subscription.setDevice(device);

        device.setSubscription(subscription);

        DeviceRepository deviceRepository = new DeviceRepository();
        deviceRepository.insertDevice(device);

        List<Device> devices = deviceRepository.selectAll();
        for (Device dev : devices) {
            System.out.println("Id: " + dev.getId());
            System.out.println("Brand: " + dev.getBrand());
            System.out.println("Model: " + dev.getModel());
            if (dev.getSubscription() != null) {
                System.out.println("Billing: " + dev.getSubscription().getBilling());
            }
        }
    }

}
