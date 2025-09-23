import factory.*;
import smartdevices.*;
import usage.*;

/**
 * Performance and stress test for the Smart Device Factory System
 */
public class PerformanceTest {
    
    public static void main(String[] args) {
        System.out.println("PERFORMANCE TEST");
        System.out.println("=" .repeat(30));
        
        performanceTest();
        stressTest();
    }
    
    private static void performanceTest() {
        System.out.println("\nTesting creation performance...");
        long startTime = System.currentTimeMillis();
        
        SmartDeviceFactory[] factories = {
            new BrandAFactory(),
            new BrandBFactory()
        };
        
        for (int i = 0; i < 1000; i++) {
            SmartDeviceFactory factory = factories[i % 2];
            SmartDevice device = (i % 2 == 0) ? 
                factory.createBulb("PERF-" + i) : 
                factory.createLock("PERF-" + i);
            
            UsageDataFactory.createUsageFactory(device).setUsageData(device);
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("Created 1000 devices in " + (endTime - startTime) + "ms");
    }
    
    private static void stressTest() {
        System.out.println("\nStress testing with concurrent access simulation...");
        
        // Simulate multiple clients using the factory
        for (int client = 0; client < 5; client++) {
            System.out.println("Client " + (client + 1) + " creating devices...");
            
            SmartDeviceFactory factory = (client % 2 == 0) ? 
                new BrandAFactory() : new BrandBFactory();
            
            SmartBulb bulb = factory.createBulb("CLIENT-" + client + "-BULB");
            SmartLock lock = factory.createLock("CLIENT-" + client + "-LOCK");
            
            UsageDataFactory.createUsageFactory(bulb).setUsageData(bulb);
            UsageDataFactory.createUsageFactory(lock).setUsageData(lock);
        }
        
        System.out.println("✓ Stress test completed successfully");
    }
}