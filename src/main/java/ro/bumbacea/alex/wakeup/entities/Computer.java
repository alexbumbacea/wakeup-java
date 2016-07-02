package ro.bumbacea.alex.wakeup.entities;


public class Computer {
    protected Integer id;
    protected String name = "localhost";
    protected String IP = "127.0.0.1";
    protected String MAC = "00:00:00:00:00:00:00";
    protected String type = "Windows";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
