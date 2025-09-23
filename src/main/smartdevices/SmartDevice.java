package smartdevices;

public abstract class SmartDevice {
    protected String brand;
    protected String deviceId;
    protected double usageValue;
    
    public SmartDevice(String brand, String deviceId) {
        this.brand = brand;
        this.deviceId = deviceId;
        this.usageValue = 0.0;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public String getDeviceId() {
        return deviceId;
    }
    
    public double getUsageValue() {
        return usageValue;
    }
    
    public void setUsageValue(double usageValue) {
        this.usageValue = usageValue;
    }
    
    public abstract void displayInfo();
}

