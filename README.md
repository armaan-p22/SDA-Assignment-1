## Members  
- Caren Eissa : 100920554  
- Shagufta Shaikh : 100924656  
- Armaan Parmar : 100877218  

---

# Smart Device Factory System  

A Java implementation demonstrating Abstract Factory and Factory Method design patterns for creating smart home devices.  

## Design Patterns  
- Abstract Factory Pattern: `BrandAFactory` and `BrandBFactory` create device families  
- Factory Method Pattern: `UsageDataFactory` with `BulbUsageFactory` and `LockUsageFactory` set usage data after creation-

# Abstract Factory Pattern:
-SmartDeviceFactory: Abstract factory interface

-BrandAFactory & BrandBFactory: Concrete factories

-SmartDevice: Abstract product

-SmartBulb & SmartLock: Concrete products

# Factory Method Pattern:
-UsageDataFactory: Abstract creator for setting usage data

-BulbUsageFactory & LockUsageFactory: Concrete creators

-setUsageData(): Factory method that varies by subclass


---


## Repository Structure  

```text
smart-device-factory/
├── README.md
├── src/
│   ├── main/
│   │   ├── smartdevices/               # Product classes
│   │   │   ├── SmartDevice.java
│   │   │   ├── SmartBulb.java
│   │   │   └── SmartLock.java
│   │   ├── factory/                    # Abstract Factory
│   │   │   ├── SmartDeviceFactory.java
│   │   │   ├── BrandAFactory.java
│   │   │   └── BrandBFactory.java
│   │   └── usage/                      # Factory Method
│   │       ├── UsageDataFactory.java
│   │       ├── BulbUsageFactory.java
│   │       └── LockUsageFactory.java
│   └── test/                           # Test classes
│       ├── TestSmartDeviceSystem.java
│       ├── PatternDemonstrationTest.java
│       └── PerformanceTest.java
````

---

## How to Run the Code

### Prerequisites

* Java JDK 8 or higher
* Command line or IDE (IntelliJ / Eclipse)

### Compilation

```bash
# Navigate to project root
cd smart-device-factory

# Compile all main and test classes
javac -d bin $(find src/main/java -name "*.java") $(find src/test/java -name "*.java")
```

### Execution

```bash
# Run assignment demo
java -cp bin TestSmartDeviceSystem

# Run pattern demonstration
java -cp bin PatternDemonstrationTest

# Run performance tests
java -cp bin PerformanceTest
```

---

## Test Methods Description

### 1. TestSmartDeviceSystem.java

**Main Assignment Demonstration** – demonstrates the assignment requirements.

#### `testBrandABulb()`

* **Purpose**: Creates and tests a Brand A Smart Bulb (Assignment Requirement 1)
* **Process**:

  * Create Brand A factory (Abstract Factory pattern)
  * Create smart bulb with the factory
  * Set usage data (Factory Method pattern)
  * Display device information and test functionality
* **Expected Output**:

```text
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
```

#### `testBrandBLock()`

* **Purpose**: Creates and tests a Brand B Smart Lock (Assignment Requirement 2)
* **Expected Output**:

```text
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
```

#### `testAllDevices()`

* **Purpose**: Comprehensive test of all device types and brands
* **Expected Output**: Summary of all created devices with their properties

---

### 2. PatternDemonstrationTest.java

**Design Pattern Focused Testing**

* `demonstrateAbstractFactoryPattern()` – Shows how client code works with abstract factory interface
* `demonstrateFactoryMethodPattern()` – Shows how different factory methods handle usage data differently
* `demonstratePolymorphism()` – Shows polymorphic behavior across device types

---

### 3. PerformanceTest.java

**Performance and Stress Testing**

* `performanceTest()` – Creates 1000 devices, measures execution time
* `stressTest()` – Simulates multiple concurrent clients to ensure stability

---

## Output Screenshots

![Demo Output](<Screenshot 2025-09-22 191526.png>)
![Pattern Demonstration](<Screenshot 2025-09-22 191621.png>)
![Performance Test](<Screenshot 2025-09-22 191654-1.png>)

---

## UML Class Diagram

![](<Screenshot 2025-09-22 at 9.13.04 PM.png>) 

```
