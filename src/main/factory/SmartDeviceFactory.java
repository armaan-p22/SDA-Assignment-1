package factory;

import smartdevices.SmartBulb;
import smartdevices.SmartLock;

public interface SmartDeviceFactory {
    SmartBulb createBulb(String deviceId);
    SmartLock createLock(String deviceId);
}