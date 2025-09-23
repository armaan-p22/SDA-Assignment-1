package smartdevices;

public class SmartLock extends SmartDevice {
    private boolean isLocked;
    
    public SmartLock(String brand, String deviceId) {
        super(brand, deviceId);
        this.isLocked = true; // Default to locked
    }
    
    public void lock() {
        isLocked = true;
        System.out.println(brand + " Smart Lock " + deviceId + " is now LOCKED");
    }
    
    public void unlock() {
        isLocked = false;
        System.out.println(brand + " Smart Lock " + deviceId + " is now UNLOCKED");
    }
    
    public boolean isLocked() {
        return isLocked;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("=== Smart Lock Information ===");
        System.out.println("Brand: " + brand);
        System.out.println("Device ID: " + deviceId);
        System.out.println("Battery Level: " + usageValue + "%");
        System.out.println("Status: " + (isLocked ? "LOCKED" : "UNLOCKED"));
        System.out.println("==============================");
    }
}