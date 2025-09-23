package smartdevices;

public class SmartBulb extends SmartDevice {
    private boolean isOn;
    
    public SmartBulb(String brand, String deviceId) {
        super(brand, deviceId);
        this.isOn = false;
    }
    
    public void turnOn() {
        isOn = true;
        System.out.println(brand + " Smart Bulb " + deviceId + " is now ON");
    }
    
    public void turnOff() {
        isOn = false;
        System.out.println(brand + " Smart Bulb " + deviceId + " is now OFF");
    }
    
    public boolean isOn() {
        return isOn;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("=== Smart Bulb Information ===");
        System.out.println("Brand: " + brand);
        System.out.println("Device ID: " + deviceId);
        System.out.println("Power Usage: " + usageValue + " watts");
        System.out.println("Status: " + (isOn ? "ON" : "OFF"));
        System.out.println("==============================");
    }
}