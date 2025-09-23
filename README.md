Smart Device Factory System - Design Patterns Assignment
//Overview
This project implements a smart home device factory system using two key design patterns:

Abstract Factory Pattern: For creating families of related smart devices (Brand A and Brand B)
Factory Method Pattern: For setting usage data (power consumption for bulbs, battery level for locks)

The system allows creation of smart bulbs and smart locks from different brands, with usage data loaded from a simulated external database.
//Repository Structure
smart-device-factory/
│
├── README.md                           # This file
├── .gitignore                          # Git ignore file
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── smartdevices/           # Core device classes
│   │       │   ├── SmartDevice.java        # Abstract base class
│   │       │   ├── SmartBulb.java          # Concrete bulb implementation
│   │       │   └── SmartLock.java          # Concrete lock implementation
│   │       │
│   │       ├── factory/                # Abstract Factory pattern
│   │       │   ├── SmartDeviceFactory.java # Abstract factory interface
│   │       │   ├── BrandAFactory.java      # Concrete factory for Brand A
│   │       │   └── BrandBFactory.java      # Concrete factory for Brand B
│   │       │
│   │       └── usage/                  # Factory Method pattern
│   │           ├── UsageDataFactory.java   # Abstract creator
│   │           ├── BulbUsageFactory.java   # Concrete creator for bulbs
│   │           └── LockUsageFactory.java   # Concrete creator for locks
│   │
│   └── test/
│       └── java/                       # Test classes
│           ├── TestSmartDeviceSystem.java      # Main assignment demo
│           ├── PatternDemonstrationTest.java   # Pattern-focused tests
│           └── PerformanceTest.java            # Performance testing

Folder Contents:

src/main/java/: Contains all source code organized by package

smartdevices: Product hierarchy (SmartDevice, SmartBulb, SmartLock)
factory: Abstract Factory implementation for device creation
usage: Factory Method implementation for usage data management


src/test/java/: Contains comprehensive test suites

Main assignment demonstration
Design pattern focused tests
Performance and stress tests


docs/: Documentation including UML diagrams and design explanations
build/: Compilation scripts and build utilities
screenshots/: Visual proof of test execution and system functionality

Design Patterns Implementation
Abstract Factory Pattern
Purpose: Creates families of related objects (smart devices) without specifying their concrete classes.
Components:

SmartDeviceFactory (Abstract Factory Interface)
BrandAFactory, BrandBFactory (Concrete Factories)
SmartDevice (Abstract Product)
SmartBulb, SmartLock (Concrete Products)

Benefits:

Easy to add new brands without modifying existing code
Ensures consistency within device families
Encapsulates object creation logic

Factory Method Pattern
Purpose: Handles setting usage data for devices after creation, with different behavior for different device types.
Components:

UsageDataFactory (Abstract Creator)
BulbUsageFactory, LockUsageFactory (Concrete Creators)
setUsageData() (Factory Method)

Benefits:

Separates usage data logic from device creation
Extensible for new device types
Simulates reading from external data sources

Test Methods Description
1. TestSmartDeviceSystem.java
Main Assignment Demonstration
This is the primary test class that demonstrates the specific requirements from the assignment.
Test Methods:
testBrandABulb()

Purpose: Creates and tests a Brand A Smart Bulb (Assignment Requirement 1)
Process:

Creates a Brand A factory using Abstract Factory pattern
Creates a smart bulb using the factory
Sets usage data using Factory Method pattern
Displays device information and tests functionality


Expected Output:

  Creating Brand A Smart Bulb...
  Power usage data loaded for Brand A bulb: XX.X watts
  === Smart Bulb Information ===
  Brand: Brand A
  Device ID: BULB-A001
  Power Usage: XX.X watts
  Status: OFF
  ==============================
  Brand A Smart Bulb BULB-A001 is now ON
  Brand A Smart Bulb BULB-A001 is now OFF
testBrandBLock()

Purpose: Creates and tests a Brand B Smart Lock (Assignment Requirement 2)
Process:

Creates a Brand B factory using Abstract Factory pattern
Creates a smart lock using the factory
Sets usage data using Factory Method pattern
Displays device information and tests functionality


Expected Output:

  Creating Brand B Smart Lock...
  Battery level data loaded for Brand B lock: XX.X%
  === Smart Lock Information ===
  Brand: Brand B
  Device ID: LOCK-B001
  Battery Level: XX.X%
  Status: LOCKED
  ==============================
  Brand B Smart Lock LOCK-B001 is now UNLOCKED
  Brand B Smart Lock LOCK-B001 is now LOCKED
testAllDevices()

Purpose: Comprehensive test of all device types and brands
Process: Creates and configures all combinations of devices and brands
Expected Output: Summary of all created devices with their properties

2. PatternDemonstrationTest.java
Design Pattern Focused Testing
Test Methods:
demonstrateAbstractFactoryPattern()

Purpose: Shows how client code works with abstract factory interface
Key Points: Demonstrates polymorphism and encapsulation of object creation

demonstrateFactoryMethodPattern()

Purpose: Shows how different factory methods handle usage data differently
Key Points: Demonstrates runtime polymorphism in factory method selection

demonstratePolymorphism()

Purpose: Shows polymorphic behavior across different device types
Key Points: Same interface works with different concrete implementations

3. PerformanceTest.java
Performance and Stress Testing
Test Methods:
performanceTest()

Purpose: Tests creation performance with 1000 devices
Metrics: Measures execution time for large-scale device creation

stressTest()

Purpose: Simulates multiple concurrent clients using the system
Validation: Ensures system stability under load

Compilation and Execution
Prerequisites

Java 8 or higher
Command line access

Compilation Steps

Navigate to project root directory:

bash   cd smart-device-factory

Compile all source files:

bash   # Create build directories
   mkdir -p build/classes

   # Compile main sources
   javac -d build/classes src/main/java/**/*.java

   # Compile test sources
   javac -cp build/classes -d build/classes src/test/java/*.java

Or use the provided script:

bash   chmod +x build/compile.sh
   ./build/compile.sh
Execution Steps

Run main assignment demonstration:

bash   cd build/classes
   java TestSmartDeviceSystem

Run pattern demonstration:

bash   java PatternDemonstrationTest

Run performance tests:

bash   java PerformanceTest
Test Execution Results
Screenshot 1: Main Assignment Test (TestSmartDeviceSystem)
Expected Output:
SMART HOME DEVICE FACTORY SYSTEM TEST


--- TEST CASE 1: Brand A Smart Bulb ---
Creating Brand A Smart Bulb...
Power usage data loaded for Brand A bulb: 45.2 watts
=== Smart Bulb Information ===
Brand: Brand A
Device ID: BULB-A001
Power Usage: 45.2 watts
Status: OFF

Brand A Smart Bulb BULB-A001 is now ON
Brand A Smart Bulb BULB-A001 is now OFF
✓ Brand A Bulb test completed successfully

--- TEST CASE 2: Brand B Smart Lock ---
Creating Brand B Smart Lock...
Battery level data loaded for Brand B lock: 78.5%
=== Smart Lock Information ===
Brand: Brand B
Device ID: LOCK-B001
Battery Level: 78.5%
Status: LOCKED

Brand B Smart Lock LOCK-B001 is now UNLOCKED
Brand B Smart Lock LOCK-B001 is now LOCKED
✓ Brand B Lock test completed successfully

--- ADDITIONAL COMPREHENSIVE TEST ---

Testing BrandA devices:
Creating Brand A Smart Bulb...
Power usage data loaded for Brand A bulb: 45.2 watts
Created: Brand A Bulb (ID: BULB-BrandA-001, Power: 45.2W)
Creating Brand A Smart Lock...
Battery level data loaded for Brand A lock: 82.1%
Created: Brand A Lock (ID: LOCK-BrandA-001, Battery: 82.1%)

Testing BrandB devices:
Creating Brand B Smart Bulb...
Power usage data loaded for Brand B bulb: 38.7 watts
Created: Brand B Bulb (ID: BULB-BrandB-001, Power: 38.7W)
Creating Brand B Smart Lock...
Battery level data loaded for Brand B lock: 78.5%
Created: Brand B Lock (ID: LOCK-BrandB-001, Battery: 78.5%)

ALL TESTS COMPLETED SUCCESSFULLY!
