package com.oneandone.network.snmpman.configuration.modifier;

import com.oneandone.network.snmpman.configuration.type.ModifierProperties;
import org.snmp4j.smi.Counter32;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Counter32ModifierTest {

    @Test
    public void testModify() throws Exception {
        final ModifierProperties modifierProperties = new ModifierProperties();
        modifierProperties.put("minimum", 0);
        modifierProperties.put("maximum", 3000);
        modifierProperties.put("minimumStep", 1);
        modifierProperties.put("maximumStep", 10);

        final Counter32Modifier modifier = new Counter32Modifier();
        modifier.init(modifierProperties);

        final Counter32 counter32 = new Counter32(0);
        assertEquals(counter32.getValue(), 0);

        final Counter32 modifiedVariable = modifier.modify(counter32);
        assertNotEquals(modifiedVariable.getValue(), 0);
    }
    
}