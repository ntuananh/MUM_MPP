package main.java.entity;

import main.java.Utils.Const;

public class Regular extends Service {
    public Regular() {
        this.setId(Const.SERVICE_REGULAR);
        this.setName("Regular");
        this.setBaseRate(1.5);
    }
}
