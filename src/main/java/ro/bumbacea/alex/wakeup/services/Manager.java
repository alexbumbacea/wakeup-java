package ro.bumbacea.alex.wakeup.services;

import org.springframework.stereotype.Service;
import ro.bumbacea.alex.wakeup.entities.Computer;
import java.util.ArrayList;
import java.util.List;

@Service
public class Manager {

    List<Computer> data = new ArrayList<Computer>();

    public Manager() {
    }


    public void add(Computer computer) {
        data.add(computer);
    }

    public List<Computer> getList() {
        return data;
    }

    public void wakeUp(Computer computer) {

    }
}
