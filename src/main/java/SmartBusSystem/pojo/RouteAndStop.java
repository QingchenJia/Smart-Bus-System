package SmartBusSystem.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RouteAndStop {
    private String RID;
    private String SID;
    private int order;

    public RouteAndStop() {
    }

    public RouteAndStop(String RID, String SID, int order) {
        this.RID = RID;
        this.SID = SID;
        this.order = order;
    }

    @Override
    public String toString() {
        return "RouteAndStop{" +
                "RID='" + RID + '\'' +
                ", SID='" + SID + '\'' +
                ", order=" + order +
                '}';
    }
}
