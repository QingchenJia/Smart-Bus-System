package SmartBusSystem.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bus {
    private String licenseNumber;
    private int status;
    private String RID;

    public Bus() {
    }

    public Bus(String licenseNumber, int status, String RID) {
        this.licenseNumber = licenseNumber;
        this.status = status;
        this.RID = RID;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "licenseNumber='" + licenseNumber + '\'' +
                ", status=" + status +
                ", RID='" + RID + '\'' +
                '}';
    }
}
