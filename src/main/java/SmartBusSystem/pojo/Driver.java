package SmartBusSystem.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Driver {
    private String ID;
    private String password;
    private String name;
    private int drivingYears;
    private String phoneNum;

    public Driver() {
    }

    public Driver(String ID, String password, String name, int drivingYears, String phoneNum) {
        this.ID = ID;
        this.password = password;
        this.name = name;
        this.drivingYears = drivingYears;
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Driver{" + "ID='" + ID + '\'' + ", password='" + password + '\'' + ", name='" + name + '\'' + ", drivingYears=" + drivingYears + ", phoneNum='" + phoneNum + '\'' + '}';
    }
}
