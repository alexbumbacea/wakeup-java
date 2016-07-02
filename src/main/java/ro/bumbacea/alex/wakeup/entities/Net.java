package ro.bumbacea.alex.wakeup.entities;

import java.net.InetAddress;

/**
 * Created by abumbacea on 01/07/16.
 */
public class Net {
    protected InetAddress IP;
    protected short mask;

    public Net(InetAddress IP, short mask)
    {
        this.IP = IP;
        this.mask = mask;
    }
    public short getMask() {
        return mask;
    }

    public void setMask(short mask) {
        this.mask = mask;
    }

    public InetAddress getIP() {
        return IP;
    }

    public void setIP(InetAddress IP) {
        this.IP = IP;
    }

}
