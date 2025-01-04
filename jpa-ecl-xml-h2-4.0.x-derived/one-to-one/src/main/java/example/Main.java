package example;

import example.entity.Device;
import example.entity.Subscription;
import example.repository.DeviceRepository;
import example.repository.SubscriptionRepository;

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
            JsonPrinter.print(dev);
        }

        subscription.setDevice(null);

        SubscriptionRepository subscriptionRepository = new SubscriptionRepository();
        subscriptionRepository.update(subscription);


    }

}
