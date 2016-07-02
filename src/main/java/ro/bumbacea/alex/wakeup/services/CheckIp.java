package ro.bumbacea.alex.wakeup.services;

import ro.bumbacea.alex.wakeup.entities.Computer;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;


public class CheckIp implements Runnable {
    private final Manager manager;
    protected String IP;

    public CheckIp(String ip, Manager manager) {
        this.IP = ip;
        this.manager = manager;
    }

    @Override
    public void run() {
        //check port on IP
        System.out.println(this.IP);
        Computer c = new Computer();
        c.setIP(this.IP);

        for (Map.Entry<String, Integer> port : getPortMapping().entrySet()) {
            try {
                if (portIsOpen(this.IP, port.getValue(), 5000)) {
                    c.setType(port.getKey());
                    c.setMAC(this.getMacByIp(this.IP));
                    c.setName(getHostNameByIp(this.IP));
                    this.manager.add(c);
                    break;
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }

    private String getHostNameByIp(String ip) throws UnknownHostException {
        InetAddress addr = null;
        addr = InetAddress.getByName(ip);
        return addr.getHostName();
    }


    private Map<String, Integer> getPortMapping() {
        Map<String, Integer> ports = new HashMap<>();
        ports.put("Windows", 3389);
        ports.put("SSH", 22);
        ports.put("HTTP", 80);
        ports.put("HTTPS", 443);
        ports.put("PING", 0);
        return ports;
    }

    private String getMacByIp(String ip) {
        return ip;
    }

    public boolean portIsOpen(String ip, int port, int timeout)  {
        if (port == 0) {
            return checkPing(ip);
        }

        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), timeout);
            socket.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean checkPing(String ip) {
        try {
            InetAddress addr = InetAddress.getByName(ip);
            addr.isReachable(5000);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
