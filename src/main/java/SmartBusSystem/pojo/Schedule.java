package SmartBusSystem.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Schedule {
    private String DID;
    private String Time;
    private String licenseNumber;

    public Schedule() {
    }

    public Schedule(String DID, String time, String licenseNumber) {
        this.DID = DID;
        Time = time;
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "DID='" + DID + '\'' +
                ", Time='" + Time + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                '}';
    }
}
