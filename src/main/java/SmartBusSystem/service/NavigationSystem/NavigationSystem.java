package SmartBusSystem.service.NavigationSystem;

import SmartBusSystem.pojo.Stop;
import SmartBusSystem.service.TableRow.RouteGuideRow;
import SmartBusSystem.service.function.UserHomePage;
import SmartBusSystem.service.function.UserSearchStop;

import java.util.*;

public class NavigationSystem {
    private static final Graph graph = new Graph();

    private static void initializeSampleData(List<Stop> stops, List<RouteGuideRow> routeGuideRows) {
        for (Stop stop : stops) {   // 存放所有站点
            graph.addStop(stop);
        }

        for (RouteGuideRow routeGuideRow : routeGuideRows) {
            graph.addRouteGuideRow(routeGuideRow);  // 存放所有线路

            int count = 0;
            List<Stop> stopsInRoute = routeGuideRow.getStops();

            // 正向
            for (int i = 0; i < stopsInRoute.size() - 1; i++) {
                graph.addRouteStopLink(routeGuideRow.getRouteId(), stopsInRoute.get(i).getID(), stopsInRoute.get(i + 1).getID(), ++count);
            }

            // 反向
            for (int i = stopsInRoute.size() - 1; i > 0; i--) {
                graph.addRouteStopLink(routeGuideRow.getRouteId(), stopsInRoute.get(i).getID(), stopsInRoute.get(i - 1).getID(), ++count);
            }
        }
    }

    public static List<String> findRoute(String startStopId, String endStopId) {
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

    public static List<String> getNavigationGuide(String startStopName, String endStopName) {
        List<Stop> stops = UserSearchStop.showAllStop();
        List<RouteGuideRow> routeGuideRows = UserHomePage.getAllRouteGuideRow();
        initializeSampleData(stops, routeGuideRows);

        String startStopId = UserSearchStop.getStopByName(startStopName).getID();
        String endStopId = UserSearchStop.getStopByName(endStopName).getID();

        List<String> guide = findRoute(startStopId, endStopId);

        String title = "从 " + startStopName + " 到 " + endStopName + " 的导航路线";
        List<String> navigation = new ArrayList<>();
        navigation.add(title);
        navigation.addAll(guide);

        return navigation;
    }
}
