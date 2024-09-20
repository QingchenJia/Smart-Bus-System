package SmartBusSystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteAndStop {
    private String RID;
    private String SID;
    private int order;
}
