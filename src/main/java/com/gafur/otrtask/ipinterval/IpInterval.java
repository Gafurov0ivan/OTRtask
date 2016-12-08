package com.gafur.otrtask.ipinterval;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class IpInterval {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstIp = reader.readLine();
        String secondIp = reader.readLine();

        ArrayList<String> ipList = new ArrayList<String>();
        long first = host2Long(firstIp);
        long second = host2Long(secondIp);
        for (long i = first + 1; i <= second - 1; i++) {
            System.out.println(first);
        }
    }

    private static long host2Long(String host) {
        long ip = 0;
        int[] address = ip2Intarray(host);
        for (int i = 0; i < address.length; ++i) {
            ip += ((long) (address[i] >= 0 ? address[i] : 0)) << 8 * (3 - i);
        }
        return ip;
    }

    private static int[] ip2Intarray(String host) throws NumberFormatException {
        int[] address = {-1, -1, -1, -1};
        int i = 0;
        StringTokenizer tokenizer = new StringTokenizer(host, ".");

        while (tokenizer.hasMoreTokens()) {
            address[i++] = Integer.parseInt(tokenizer.nextToken()) & 0xFF;
        }
        return address;
    }
}
