package com.oneandone.snmpman.configuration;

import com.oneandone.snmpman.configuration.modifier.Counter32Modifier;
import com.oneandone.snmpman.configuration.modifier.Modifier;
import com.oneandone.snmpman.configuration.type.ModifierProperties;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DeviceTest {

    @Test
    public void testInitialization() throws Exception {
        final Device device = new Device("Test", new Modifier[0], null);
        
        assertEquals(device.getName(), "Test");
        assertTrue(device.getModifiers().isEmpty());
    }

    @Test(expectedExceptions = { UnsupportedOperationException.class })
    public void testImmutability() throws Exception {
        final Device device = new Device("Test", new Modifier[0], null);

        device.getModifiers().add(new Modifier(".1.2.3", Counter32Modifier.class.getName(), new ModifierProperties()));
    }
    
}