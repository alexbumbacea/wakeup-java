package ro.bumbacea.alex.wakeup.services;

import org.apache.commons.net.util.SubnetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.bumbacea.alex.wakeup.entities.Net;

import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.ExecutorService;

@Service
public class Discovery {

    private Manager manager;
    private ExecutorService executor;
    @Autowired
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Autowired
    public void setExecutor(ExecutorService executor) {
        this.executor = executor;
    }


    public void autodiscover() {

        try {
            for(Net n:getNetworks()) {
                SubnetUtils utils = new SubnetUtils(n.getIP().getHostAddress()+"/"+n.getMask());
                String[] allIps = utils.getInfo().getAllAddresses();
                for (String IP: allIps) {
                    executor.execute(new CheckIp(IP, this.manager));
                }
            }


        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        }

    }

    private ArrayList<Net> getNetworks() throws UnknownHostException, SocketException {
        ArrayList<Net> nets = new ArrayList<>();
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

        while (networkInterfaces.hasMoreElements()) {

            NetworkInterface networkInterface = networkInterfaces.nextElement();
            if (networkInterface.isLoopback()) {
                continue;
            }

            for (InterfaceAddress address : networkInterface.getInterfaceAddresses()) {

                if (!(address.getAddress() instanceof Inet4Address)) {
                    continue;
                }
                nets.add(new Net(address.getAddress(), address.getNetworkPrefixLength()));
            }
        }

        return nets;
    }
}
