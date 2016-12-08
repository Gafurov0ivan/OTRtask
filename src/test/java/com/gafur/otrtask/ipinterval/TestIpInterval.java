package com.gafur.otrtask.ipinterval;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class TestIpInterval {

    @Test
    public void checkInterval(){
        IpInterval ipInterval = new IpInterval();
        ArrayList<String> check = ipInterval.findInterval("192.168.10.0", "192.168.10.3");
        assertEquals(2, check.size());
    }
}
