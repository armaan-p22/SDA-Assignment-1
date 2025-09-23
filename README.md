//Members:
Caren Eissa : 100920554
Shagufta Shaikh : 100924656
Armaan Parmar : 100877218

// Repository Structure
smart-device-factory/
├── README.md
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── smartdevices/           # Product classes
│   │       │   ├── SmartDevice.java
│   │       │   ├── SmartBulb.java
│   │       │   └── SmartLock.java
│   │       ├── factory/                # Abstract Factory
│   │       │   ├── SmartDeviceFactory.java
│   │       │   ├── BrandAFactory.java
│   │       │   └── BrandBFactory.java
│   │       └── usage/                  # Factory Method
│   │           ├── UsageDataFactory.java
│   │           ├── BulbUsageFactory.java
│   │           └── LockUsageFactory.java
│   └── test/
│       └── java/                       # Test classes
│           ├── TestSmartDeviceSystem.java
│           ├── PatternDemonstrationTest.java
│           └── PerformanceTest.java
──────────────────────────────────────────────
 How to Run the Code

//Prerequisites

- Java JDK 8 or higher
- Command line or IDE (IntelliJ / Eclipse)

Compilation

```bash
Navigate to project root
cd smart-device-factory

# Compile all main and test classes
javac -d bin $(find src/main/java -name "*.java") $(find src/test/java -name "*.java")

//Execution

```bash
# Run assignment demo
java -cp bin TestSmartDeviceSystem

# Run pattern demonstration
java -cp bin PatternDemonstrationTest

# Run performance tests
java -cp bin PerformanceTest


// Tests

TestSmartDeviceSystem.java

- Creates Brand A Smart Bulb and Brand B Smart Lock
- Demonstrates Abstract Factory & Factory Method usage
- Validates device operations (on/off, lock/unlock)

PatternDemonstrationTest.java

- Demonstrates abstract factory pattern polymorphism
- Demonstrates factory method runtime data handling
- Shows polymorphism across brands and devices

PerformanceTest.java

- Measures large-scale device creation performance
-Stress tests with concurrent operations

// Output



## UML Class Diagram 


