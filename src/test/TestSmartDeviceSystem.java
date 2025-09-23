import factory.*;
import smartdevices.*;
import usage.*;

public class TestSmartDeviceSystem {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("SMART HOME DEVICE FACTORY SYSTEM TEST");
        System.out.println("=".repeat(60));
        
        // Test Case 1: Brand A Bulb (as requested in assignment)
        System.out.println("\n--- TEST CASE 1: Brand A Smart Bulb ---");
        testBrandABulb();
        
        // Test Case 2: Brand B Lock (as requested in assignment)
        System.out.println("\n--- TEST CASE 2: Brand B Smart Lock ---");
        testBrandBLock();
        
        // Additional comprehensive test
        System.out.println("\n--- ADDITIONAL COMPREHENSIVE TEST ---");
        testAllDevices();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("ALL TESTS COMPLETED SUCCESSFULLY!");
        System.out.println("=".repeat(60));
    }
    
    /**
     * Test Case 1: Creates and tests a Brand A Smart Bulb
     * Demonstrates Abstract Factory and Factory Method patterns
     */
    private static void testBrandABulb() {
        // Abstract Factory Pattern: Create Brand A factory
        SmartDeviceFactory brandAFactory = new BrandAFactory();
        
        // Create a Brand A bulb
        SmartBulb bulb = brandAFactory.createBulb("BULB-A001");
        
        // Factory Method Pattern: Set usage data
        UsageDataFactory usageFactory = UsageDataFactory.createUsageFactory(bulb);
        usageFactory.setUsageData(bulb);
        
        // Test bulb functionality
        bulb.displayInfo();
        bulb.turnOn();
        bulb.turnOff();
        
        System.out.println("✓ Brand A Bulb test completed successfully");
    }
    
    /**
     * Test Case 2: Creates and tests a Brand B Smart Lock
     * Demonstrates Abstract Factory and Factory Method patterns
     */
    private static void testBrandBLock() {
        // Abstract Factory Pattern: Create Brand B factory
        SmartDeviceFactory brandBFactory = new BrandBFactory();
        
        // Create a Brand B lock
        SmartLock lock = brandBFactory.createLock("LOCK-B001");
        
        // Factory Method Pattern: Set usage data
        UsageDataFactory usageFactory = UsageDataFactory.createUsageFactory(lock);
        usageFactory.setUsageData(lock);
        
        // Test lock functionality
        lock.displayInfo();
        lock.unlock();
        lock.lock();
        
        System.out.println("✓ Brand B Lock test completed successfully");
    }
    
    /**
     * Comprehensive test of all device types and brands
     */
    private static void testAllDevices() {
        SmartDeviceFactory[] factories = {
            new BrandAFactory(),
            new BrandBFactory()
        };
        
        for (SmartDeviceFactory factory : factories) {
            String brandName = factory.getClass().getSimpleName().replace("Factory", "");
            System.out.println("\nTesting " + brandName + " devices:");
            
            // Test bulb
            SmartBulb bulb = factory.createBulb("BULB-" + brandName + "-001");
            UsageDataFactory.createUsageFactory(bulb).setUsageData(bulb);
            System.out.println("Created: " + bulb.getBrand() + " Bulb (ID: " + 
                             bulb.getDeviceId() + ", Power: " + bulb.getUsageValue() + "W)");
            
            // Test lock
            SmartLock lock = factory.createLock("LOCK-" + brandName + "-001");
            UsageDataFactory.createUsageFactory(lock).setUsageData(lock);
            System.out.println("Created: " + lock.getBrand() + " Lock (ID: " + 
                             lock.getDeviceId() + ", Battery: " + lock.getUsageValue() + "%)");
        }
    }
}