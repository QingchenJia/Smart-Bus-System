package SmartBusSystem.service.navigation;

import SmartBusSystem.pojo.Stop;
import SmartBusSystem.pojo.mediator.RouteGuideRow;
import SmartBusSystem.pojo.mediator.RouteStopLink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<String, Stop> stops;
    private Map<String, RouteGuideRow> routeGuideRows;
    private Map<String, List<RouteStopLink>> adjacencyList;

    public Graph() {
        this.stops = new HashMap<>();
        this.routeGuideRows = new HashMap<>();
        this.adjacencyList = new HashMap<>();
    }

    public void addStop(Stop stop) {
        stops.put(stop.getID(), stop);
        adjacencyList.put(stop.getID(), new ArrayList<>());
    }

    public void addRouteGuideRow(RouteGuideRow routeGuideRow) {
        routeGuideRows.put(routeGuideRow.getRouteId(), routeGuideRow);
    }

    public void addRouteStopLink(String routeId, String currentStopId, String nextStopId, int sequence) {
        RouteStopLink link = new RouteStopLink(routeId, currentStopId, nextStopId, sequence);
        adjacencyList.get(currentStopId).add(link);
    }

    public Stop getStop(String id) {
        return stops.get(id);
    }

    public RouteGuideRow getRouteGuideRow(String id) {
        return routeGuideRows.get(id);
    }

    public List<RouteStopLink> getAdjacencyList(String stopId) {
        return adjacencyList.get(stopId);
    }
}
