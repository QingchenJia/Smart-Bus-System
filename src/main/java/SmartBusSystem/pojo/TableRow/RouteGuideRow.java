package SmartBusSystem.pojo.TableRow;

public class RouteGuideRow {
    private String routeId;
    private String routeName;
    private String stopNameResults;

    public RouteGuideRow() {
    }

    public RouteGuideRow(String routeId, String routeName, String stopNameResults) {
        this.routeId = routeId;
        this.routeName = routeName;
        this.stopNameResults = stopNameResults;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getStopNameResults() {
        return stopNameResults;
    }

    public void setStopNameResults(String stopNameResults) {
        this.stopNameResults = stopNameResults;
    }

    @Override
    public String toString() {
        return "RouteGuideRow{" + "routeId='" + routeId + '\'' + ", routeName='" + routeName + '\'' + ", stopNameResults='" + stopNameResults + '\'' + '}';
    }
}
