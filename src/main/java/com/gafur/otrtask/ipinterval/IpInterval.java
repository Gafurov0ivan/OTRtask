package com.gafur.otrtask.ipinterval;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * Find all ip addresses in the interval
 *
 * @author igafurov
 * @since 05.12.2016
 */
public class IpInterval {
    private static final Pattern PATTERN = Pattern.compile(
            "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    /**
     * Find all ip addresses in the interval
     *
     * @param firstIp  first ip address
     * @param secondIp second ip address
     * @return ipList with ip addresses
     */
    public ArrayList<String> findInterval(String firstIp, String secondIp) {
        if (validate(firstIp) && validate(secondIp)) {
            ArrayList<String> ipList = new ArrayList<String>();
            long first = host2Long(firstIp);
            long second = host2Long(secondIp);
            if (first >= second) {
                ipList.add(firstIp);
                ipList.add(secondIp);
                System.out.println("Please enter correct interval");
                return ipList;
            }
            for (long i = first + 1; i <= second - 1; i++) {
                ipList.add(long2Dotted(i));
                System.out.println(long2Dotted(i));
            }
            return ipList;
        } else {
            System.out.println("Ip address is not valid");
        }
        return null;
    }

    private static boolean validate(final String ip) {
        return PATTERN.matcher(ip).matches();
    }

    private static long host2Long(String host) {
        long ip = 0;
        if (!Character.isDigit(host.charAt(0))) return -1;
        int[] address = ip2Intarray(host);
        if (address == null) return -1;
        for (int i = 0; i < address.length; ++i) {
            ip += ((long) (address[i] >= 0 ? address[i] : 0)) << 8 * (3 - i);
        }
        return ip;
    }

    private static int[] ip2Intarray(String host) {
        int[] address = {-1, -1, -1, -1};
        int i = 0;
        StringTokenizer tokenizer = new StringTokenizer(host, ".");
        if (tokenizer.countTokens() > 4) return null;
        while (tokenizer.hasMoreTokens()) {
            try {
                address[i++] = Integer.parseInt(tokenizer.nextToken()) & 0xFF;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Illegal number format");
            }
        }
        return address;
    }

    private static String long2Dotted(long address) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0, shift = 24; i < 4; i++, shift -= 8) {
            long value = (address >> shift) & 0xFF;
            sb.append(value);
            if (i != 3) {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}
