package ro.bumbacea.alex.wakeup.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Computer")
public class Computer {
    @Column()
    protected String name = "localhost";
    @Column()
    protected String IP = "127.0.0.1";

    @Id
    @Column()
    protected String MAC = "00:00:00:00:00:00:00";
    @Column()
    protected String type = "Windows";


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
