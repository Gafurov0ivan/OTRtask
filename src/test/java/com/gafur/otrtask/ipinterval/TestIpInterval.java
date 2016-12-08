package com.gafur.otrtask.ipinterval;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestIpInterval {
    private static final Class IPINTERVAL_CLASS = IpInterval.class;
    private IpInterval ipInterval = null;

    @Before
    public void before() throws IllegalAccessException, InstantiationException {
        ipInterval = (IpInterval) IPINTERVAL_CLASS.newInstance();
    }

    @After
    public void after() {
        ipInterval = null;
    }

    @Test
    public void checkInterval() {
        IpInterval ipInterval = new IpInterval();
        ArrayList<String> check = ipInterval.findInterval("192.168.10.0", "192.168.10.3");
        assertEquals(2, check.size());
        assertEquals("192.168.10.1", check.get(0));
    }
}
