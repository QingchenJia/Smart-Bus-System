package NavigationSystem;

import SmartBusSystem.pojo.Stop;
import SmartBusSystem.pojo.TableRow.RouteGuideRow;
import SmartBusSystem.service.function.UserHomePage;
import SmartBusSystem.service.function.UserSearchStop;

import java.util.*;

public class GuideRoute {
    private Graph graph;

    public GuideRoute() {
        this.graph = new Graph();
        initializeSampleData();
    }

    private void initializeSampleData() {
        List<Stop> stops = UserSearchStop.showAllStop();
        List<RouteGuideRow> routeGuideRows = UserHomePage.getAllRouteGuideRow();

        for (Stop stop : stops) {
            graph.addStop(stop);
        }

        for (RouteGuideRow routeGuideRow : routeGuideRows) {
            graph.addRouteGuideRow(routeGuideRow);
            int count = 0;
            List<Stop> stopsInRoute = routeGuideRow.getStops();
            for (int i = 0; i < stopsInRoute.size() - 1; i++) {
                graph.addRouteStopLink(routeGuideRow.getRouteId(), stopsInRoute.get(i).getID(), stopsInRoute.get(i + 1).getID(), ++count);
            }
        }

        for (RouteGuideRow routeGuideRow : routeGuideRows) {
            int count = 0;
            List<Stop> stopsInRoute = routeGuideRow.getStops();
            for (int i = stopsInRoute.size() - 1; i > 0; i--) {
                graph.addRouteStopLink(routeGuideRow.getRouteId(), stopsInRoute.get(i).getID(), stopsInRoute.get(i - 1).getID(), ++count);
            }
        }
    }

    public List<String> findRoute(String startStopId, String endStopId) {
        // BFS setup
        Queue<String> queue = new LinkedList<>();
        Map<String, String> prev = new HashMap<>();
        queue.add(startStopId);
        prev.put(startStopId, null);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(endStopId)) break;

            for (RouteStopLink link : graph.getAdjacencyList(current)) {
                String nextStopId = link.getNextStopId();
                if (!prev.containsKey(nextStopId)) {
                    queue.add(nextStopId);
                    prev.put(nextStopId, current);
                }
            }
        }

        // Construct path
        List<String> path = new ArrayList<>();
        if (!prev.containsKey(endStopId)) {
            return Collections.singletonList("无法找到路径");
        }

        for (String at = endStopId; at != null; at = prev.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);

        // Generate detailed route
        List<String> detailedRoute = new ArrayList<>();
        for (int i = 0; i < path.size() - 1; i++) {
            String from = path.get(i);
            String to = path.get(i + 1);
            String fromName = graph.getStop(from).getName();
            String toName = graph.getStop(to).getName();
            List<String> routeId = UserSearchStop.listRoute2listRouteId(UserSearchStop.searchPassByRoute(fromName));

            detailedRoute.add(routeId + "从 " + fromName + " 到 " + toName);
        }
        return detailedRoute;
    }

    public static void main(String[] args) {
        GuideRoute system = new GuideRoute();

        String startStopId = "S053";
        String endStopId = "S017";
        List<String> guide = system.findRoute(startStopId, endStopId);

        // Print the route
        System.out.println("从站点" + startStopId + " 到 站点" + endStopId + " 的导航路线:");
        for (String step : guide) {
            System.out.println(step);
        }
        System.out.println();

        // Test finding route from stop 5 to stop 1
        guide = system.findRoute(endStopId, startStopId);

        // Print the route
        System.out.println("从站点" + endStopId + " 到 站点" + startStopId + " 的导航路线:");
        for (String step : guide) {
            System.out.println(step);
        }
    }
}

class Graph {
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

class RouteStopLink {
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
