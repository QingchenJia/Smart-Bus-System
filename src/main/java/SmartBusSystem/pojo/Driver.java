package SmartBusSystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    private String ID;
    private String password;
    private String name;
    private int drivingYears;
    private String phoneNum;
}
