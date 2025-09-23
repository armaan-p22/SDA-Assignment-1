package usage;

import smartdevices.SmartDevice;

public class BulbUsageFactory extends UsageDataFactory {
    @Override
    public void setUsageData(SmartDevice device) {
        String key = device.getBrand() + "_bulb";
        double powerUsage = readUsageFromFile(key);
        device.setUsageValue(powerUsage);
        System.out.println("Power usage data loaded for " + device.getBrand() + 
                         " bulb: " + powerUsage + " watts");
    }
}