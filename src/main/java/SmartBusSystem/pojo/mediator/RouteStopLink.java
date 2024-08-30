package SmartBusSystem.pojo.mediator;

public class RouteStopLink {
    private String routeId;
    private String currentStopId;
    private String nextStopId;
    private int sequence;

    public RouteStopLink(String routeId, String currentStopId, String nextStopId, int sequence) {
        this.routeId = routeId;
        this.currentStopId = currentStopId;
        this.nextStopId = nextStopId;
        this.sequence = sequence;
    }

    public String getRouteId() {
        return routeId;
    }

    public String getCurrentStopId() {
        return currentStopId;
    }

    public String getNextStopId() {
        return nextStopId;
    }

    public int getSequence() {
        return sequence;
    }
}