package factory;

import smartdevices.SmartBulb;
import smartdevices.SmartLock;

public class BrandAFactory implements SmartDeviceFactory {
    private static final String BRAND_NAME = "Brand A";
    
    @Override
    public SmartBulb createBulb(String deviceId) {
        System.out.println("Creating " + BRAND_NAME + " Smart Bulb...");
        return new SmartBulb(BRAND_NAME, deviceId);
    }
    
    @Override
    public SmartLock createLock(String deviceId) {
        System.out.println("Creating " + BRAND_NAME + " Smart Lock...");
        return new SmartLock(BRAND_NAME, deviceId);
    }
}
