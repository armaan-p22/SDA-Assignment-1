# Smart Device Factory System

A Java implementation demonstrating Abstract Factory and Factory Method design patterns for creating smart home devices.

## Overview

This project implements a smart home device factory system that creates families of related smart devices (bulbs and locks) for different brands, with usage data management handled through factory methods that simulate reading from external databases.

## Design Patterns Implemented

### Abstract Factory Pattern
- **Purpose**: Creates families of related smart devices without specifying concrete classes
- **Components**:
  - `SmartDeviceFactory` - Abstract factory interface
  - `BrandAFactory`, `BrandBFactory` - Concrete factory implementations
  - `SmartDevice` - Abstract product base class
  - `SmartBulb`, `SmartLock` - Concrete product implementations

### Factory Method Pattern
- **Purpose**: Manages usage data setting for different device types after creation
- **Components**:
  - `UsageDataFactory` - Abstract creator with factory method
  - `BulbUsageFactory`, `LockUsageFactory` - Concrete creators
  - Simulates external database access for power/battery data

## Repository Structure

```
smart-device-factory/
├── README.md
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── smartdevices/           # Product classes
│   │       │   ├── SmartDevice.java
│   │       │   ├── SmartBulb.java
│   │       │   └── SmartLock.java
│   │       ├── factory/                # Abstract Factory implementation
│   │       │   ├── SmartDeviceFactory.java
│   │       │   ├── BrandAFactory.java
│   │       │   └── BrandBFactory.java
│   │       └── usage/                  # Factory Method implementation
│   │           ├── UsageDataFactory.java
│   │           ├── BulbUsageFactory.java
│   │           └── LockUsageFactory.java
│   └── test/
│       └── java/                       # Test classes
│           ├── TestSmartDeviceSystem.java
│           ├── PatternDemonstrationTest.java
│           └── PerformanceTest.java
```

### Folder Contents

- **`src/main/java/`** - Source code organized by package:
  - `smartdevices/` - Product hierarchy and device implementations
  - `factory/` - Abstract Factory pattern for device creation
  - `usage/` - Factory Method pattern for usage data management

- **`src/test/java/`** - Comprehensive test suites:
  - Assignment requirement demonstrations
  - Design pattern focused tests
  - Performance and stress testing

## Test Methods

### 1. TestSmartDeviceSystem.java
**Main assignment demonstration fulfilling project requirements**

#### `testBrandABulb()`
- Creates Brand A Smart Bulb (Assignment Requirement 1)
- Demonstrates Abstract Factory pattern usage
- Shows Factory Method pattern for power usage data
- Tests basic bulb operations (on/off)

#### `testBrandBLock()`
- Creates Brand B Smart Lock (Assignment Requirement 2)
- Demonstrates Abstract Factory pattern usage
- Shows Factory Method pattern for battery level data
- Tests basic lock operations (lock/unlock)

#### `testAllDevices()`
- Comprehensive test of all device/brand combinations
- Validates system scalability and consistency

### 2. PatternDemonstrationTest.java
**Design pattern focused testing**

#### `demonstrateAbstractFactoryPattern()`
- Shows client code working with abstract factory interface
- Demonstrates polymorphism in factory selection

#### `demonstrateFactoryMethodPattern()`
- Shows runtime factory method selection based on device type
- Demonstrates different usage data handling approaches

#### `demonstratePolymorphism()`
- Shows uniform interface across different device implementations
- Validates polymorphic behavior

### 3. PerformanceTest.java
**System performance validation**

#### `performanceTest()`
- Tests creation performance with 1000 devices
- Measures execution time for large-scale operations

#### `stressTest()`
- Simulates multiple concurrent client access
- Validates system stability under load

## Compilation and Execution

### Prerequisites
- Java JDK 8 or higher
- Command line access

### Compilation
```bash
# Navigate to project root
cd smart-device-factory

# Compile main classes
javac -d . src/main/java/smartdevices/*.java src/main/java/factory/*.java src/main/java/usage/*.java

# Compile test classes
javac -cp . src/test/java/*.java
```

### Execution
```bash
# Run main assignment test
java -cp ".;src/test/java" TestSmartDeviceSystem

# Run pattern demonstration
java -cp ".;src/test/java" PatternDemonstrationTest

# Run performance tests
java -cp ".;src/test/java" PerformanceTest
```

## Test Execution Results

### Assignment Requirements Test Output

============================================================
SMART HOME DEVICE FACTORY SYSTEM TEST
============================================================

--- TEST CASE 1: Brand A Smart Bulb ---
Creating Brand A Smart Bulb...
Power usage data loaded for Brand A bulb: 50.464728801150386 watts
=== Smart Bulb Information ===
Brand: Brand A
Device ID: BULB-A001
Power Usage: 50.464728801150386 watts
Status: OFF
==============================
Brand A Smart Bulb BULB-A001 is now ON
Brand A Smart Bulb BULB-A001 is now OFF
✓ Brand A Bulb test completed successfully

--- TEST CASE 2: Brand B Smart Lock ---
Creating Brand B Smart Lock...
Battery level data loaded for Brand B lock: 73.3123547022241%
=== Smart Lock Information ===
Brand: Brand B
Device ID: LOCK-B001
Battery Level: 73.3123547022241%
Status: LOCKED
==============================
Brand B Smart Lock LOCK-B001 is now UNLOCKED
Brand B Smart Lock LOCK-B001 is now LOCKED
✓ Brand B Lock test completed successfully

--- ADDITIONAL COMPREHENSIVE TEST ---

Testing BrandA devices:
Creating Brand A Smart Bulb...
Power usage data loaded for Brand A bulb: 50.464728801150386 watts
Created: Brand A Bulb (ID: BULB-BrandA-001, Power: 50.464728801150386W)
Creating Brand A Smart Lock...
Battery level data loaded for Brand A lock: 70.8051809366431%
Created: Brand A Lock (ID: LOCK-BrandA-001, Battery: 70.8051809366431%)

Testing BrandB devices:
Creating Brand B Smart Bulb...
Power usage data loaded for Brand B bulb: 47.32893887039381 watts
Created: Brand B Bulb (ID: BULB-BrandB-001, Power: 47.32893887039381W)
Creating Brand B Smart Lock...
Battery level data loaded for Brand B lock: 73.3123547022241%
Created: Brand B Lock (ID: LOCK-BrandB-001, Battery: 73.3123547022241%)

============================================================
ALL TESTS COMPLETED SUCCESSFULLY!
============================================================


### Key Features Demonstrated

1. Abstract Factory Pattern: Different factories create consistent device families
2. Factory Method Pattern: Usage data handled differently for bulbs (watts) vs locks (battery %)
3. Polymorphism: Uniform interface across different brands and device types
4. Simulated External Data: Usage values loaded from simulated database
5. Extensibility: Easy addition of new brands or device types

### Success Criteria Met

- Brand A Smart Bulb created and tested (Requirement 1)
- Brand B Smart Lock created and tested (Requirement 2)
- Abstract Factory pattern properly implemented
- Factory Method pattern properly implemented
- Usage data loaded from simulated external source
- Comprehensive test coverage with multiple test classes
- Clean separation of concerns with package structure

## Architecture Benefits

- Extensibility: New brands can be added without modifying existing code
- Consistency: Factory pattern ensures related products work together
- Separation of Concerns: Clear distinction between device creation and usage data management
- Testability: Comprehensive test coverage validates pattern implementation
- Maintainability: Well-organized package structure supports long-term maintenance
