package usage;

import smartdevices.SmartDevice;
import smartdevices.SmartBulb;
import smartdevices.SmartLock;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class UsageDataFactory {
    // Simulated database of usage values
    protected static final Map<String, Double> usageDatabase = new HashMap<>();
    
    static {
        // Simulate reading from external database
        Random random = new Random(42); // Fixed seed for consistent results
        usageDatabase.put("Brand A_bulb", 25.0 + random.nextDouble() * 35.0); // 25-60 watts
        usageDatabase.put("Brand B_bulb", 20.0 + random.nextDouble() * 40.0); // 20-60 watts
        usageDatabase.put("Brand A_lock", 60.0 + random.nextDouble() * 35.0); // 60-95% battery
        usageDatabase.put("Brand B_lock", 65.0 + random.nextDouble() * 30.0); // 65-95% battery
    }
    
    public abstract void setUsageData(SmartDevice device);
    
    protected double readUsageFromFile(String deviceKey) {
        return usageDatabase.getOrDefault(deviceKey, 0.0);
    }
    
    // Factory Method to create appropriate usage factory
    public static UsageDataFactory createUsageFactory(SmartDevice device) {
        if (device instanceof SmartBulb) {
            return new BulbUsageFactory();
        } else if (device instanceof SmartLock) {
            return new LockUsageFactory();
        }
        throw new IllegalArgumentException("Unsupported device type");
    }
}