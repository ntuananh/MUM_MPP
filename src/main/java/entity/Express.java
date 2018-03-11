package main.java.entity;

import main.java.Utils.Const;

public class Express extends Service {
    public Express() {
        this.setId(Const.SERVICE_EXPRESS);
        this.setName("Express");
        this.setBaseRate(2.0);
    }
}
