package com.gafur.otrtask.ipinterval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartIpInterval {

    public static void main(String[] args) {
        IpInterval ipInterval = new IpInterval();
        String firstIp = null;
        String secondIp = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstIp = reader.readLine();
            secondIp = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ipInterval.findInterval(firstIp, secondIp);
    }
}
