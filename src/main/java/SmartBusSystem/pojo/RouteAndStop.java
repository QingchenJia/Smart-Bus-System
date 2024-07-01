package SmartBusSystem.pojo;

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

    public String getRID() {
        return RID;
    }

    public void setRID(String RID) {
        this.RID = RID;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "RouteAndStop{" + "RID='" + RID + '\'' + ", SID='" + SID + '\'' + ", order=" + order + '}';
    }
}
