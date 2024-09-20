package SmartBusSystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
    private String licenseNumber;
    private int status;
    private String RID;
}
