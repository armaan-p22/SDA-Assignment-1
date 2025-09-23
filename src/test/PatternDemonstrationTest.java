import factory.*;
import smartdevices.*;
import usage.*;

/**
 * This test class specifically demonstrates the design patterns
 * used in the Smart Device Factory System
 */
public class PatternDemonstrationTest {
    
    public static void main(String[] args) {
        System.out.println("DESIGN PATTERNS DEMONSTRATION");
        System.out.println("=" .repeat(50));
        
        demonstrateAbstractFactoryPattern();
        demonstrateFactoryMethodPattern();
        demonstratePolymorphism();
    }
    
    /**
     * Demonstrates the Abstract Factory Pattern
     */
    private static void demonstrateAbstractFactoryPattern() {
        System.out.println("\n1. ABSTRACT FACTORY PATTERN DEMONSTRATION");
        System.out.println("-".repeat(45));
        
        System.out.println("Client code works with abstract factory interface:");
        
        // Client code works with abstract type
        SmartDeviceFactory factory1 = getFactory("A");
        SmartDeviceFactory factory2 = getFactory("B");
        
        // Create products without knowing concrete classes
        SmartBulb bulb1 = factory1.createBulb("TEST-001");
        SmartLock lock1 = factory1.createLock("TEST-002");
        
        SmartBulb bulb2 = factory2.createBulb("TEST-003");
        SmartLock lock2 = factory2.createLock("TEST-004");
        
        System.out.println("✓ Abstract Factory Pattern: Created devices without " +
                         "knowing concrete factory classes");
    }
    
    /**
     * Demonstrates the Factory Method Pattern
     */
    private static void demonstrateFactoryMethodPattern() {
        System.out.println("\n2. FACTORY METHOD PATTERN DEMONSTRATION");
        System.out.println("-".repeat(45));
        
        // Create devices
        SmartDevice bulb = new BrandAFactory().createBulb("FM-TEST-001");
        SmartDevice lock = new BrandBFactory().createLock("FM-TEST-002");
        
        System.out.println("Before setting usage data:");
        System.out.println("Bulb usage: " + bulb.getUsageValue());
        System.out.println("Lock usage: " + lock.getUsageValue());
        
        // Factory Method Pattern: Different factories handle usage data differently
        UsageDataFactory bulbUsageFactory = UsageDataFactory.createUsageFactory(bulb);
        UsageDataFactory lockUsageFactory = UsageDataFactory.createUsageFactory(lock);
        
        bulbUsageFactory.setUsageData(bulb);
        lockUsageFactory.setUsageData(lock);
        
        System.out.println("After setting usage data:");
        System.out.println("Bulb usage: " + bulb.getUsageValue() + " watts");
        System.out.println("Lock usage: " + lock.getUsageValue() + "%");
        
        System.out.println("✓ Factory Method Pattern: Usage data set using " +
                         "different factory methods");
    }
    
    /**
     * Demonstrates polymorphism enabled by the patterns
     */
    private static void demonstratePolymorphism() {
        System.out.println("\n3. POLYMORPHISM DEMONSTRATION");
        System.out.println("-".repeat(45));
        
        // Array of different devices
        SmartDevice[] devices = {
            new BrandAFactory().createBulb("POLY-001"),
            new BrandAFactory().createLock("POLY-002"),
            new BrandBFactory().createBulb("POLY-003"),
            new BrandBFactory().createLock("POLY-004")
        };
        
        // Polymorphic behavior
        for (SmartDevice device : devices) {
            UsageDataFactory.createUsageFactory(device).setUsageData(device);
            device.displayInfo(); // Polymorphic method call
        }
        
        System.out.println("✓ Polymorphism: Same interface works with different device types");
    }
    
    /**
     * Factory method to get appropriate factory
     */
    private static SmartDeviceFactory getFactory(String brand) {
        switch (brand.toUpperCase()) {
            case "A":
                return new BrandAFactory();
            case "B":
                return new BrandBFactory();
            default:
                throw new IllegalArgumentException("Unknown brand: " + brand);
        }
    }
}