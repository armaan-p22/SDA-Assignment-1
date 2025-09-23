package usage;

import smartdevices.SmartDevice;

public class LockUsageFactory extends UsageDataFactory {
    @Override
    public void setUsageData(SmartDevice device) {
        String key = device.getBrand() + "_lock";
        double batteryLevel = readUsageFromFile(key);
        device.setUsageValue(batteryLevel);
        System.out.println("Battery level data loaded for " + device.getBrand() + 
                         " lock: " + batteryLevel + "%");
    }
}