package SmartBusSystem.service.navigation;

import SmartBusSystem.pojo.Stop;
import SmartBusSystem.pojo.mediator.RouteGuideRow;
import SmartBusSystem.pojo.mediator.RouteStopLink;
import SmartBusSystem.service.homepage.UserHomePage;
import SmartBusSystem.service.query.StopQuery;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class NavigationSystem {
    private static final Graph graph = new Graph();
    private static final UserHomePage userHomePage = new UserHomePage();
    private static final StopQuery stopQuery = new StopQuery();

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

    private static List<String> findRoute(String startStopId, String endStopId) {
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

        List<String> path = new ArrayList<>();
        if (!prev.containsKey(endStopId)) {
            return Collections.singletonList("无法找到路径");
        }

        for (String at = endStopId; at != null; at = prev.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);

        List<String> detailedRoute = new ArrayList<>();
        for (int i = 0; i < path.size() - 1; i++) {
            String from = path.get(i);
            String to = path.get(i + 1);
            String fromName = graph.getStop(from).getName();
            String toName = graph.getStop(to).getName();
            List<String> routeId = stopQuery.listRoute2listRouteId4navi(stopQuery.searchPassByRoute(fromName));

            detailedRoute.add(routeId + "从 " + fromName + " 到 " + toName);
        }
        return detailedRoute;
    }

    public static List<String> getNavigationGuide(String startStopName, String endStopName) {
        List<Stop> stops = stopQuery.showAllStop();
        List<RouteGuideRow> routeGuideRows = userHomePage.getAllRouteGuideRow();
        initializeSampleData(stops, routeGuideRows);

        String startStopId = stopQuery.getStopByName(startStopName).getID();
        String endStopId = stopQuery.getStopByName(endStopName).getID();

        List<String> guide = findRoute(startStopId, endStopId);

        String title = "从 " + startStopName + " 到 " + endStopName + " 的导航路线";
        List<String> navigation = new ArrayList<>();
        navigation.add(title);
        navigation.addAll(guide);

        showNavigationInConsole(title, startStopName, guide);

        return navigation;
    }

    private static void showNavigationInConsole(String title, String startStopName, List<String> guide) {
        List<String> toNames = guide.stream().map(partGuide -> "->" + partGuide.split("到")[1]).toList();
        StringBuilder temp = new StringBuilder();
        for (String toName : toNames) {
            temp.append(toName);
        }
        String nextNames = new String(temp);

        log.info(title + ": " + startStopName + nextNames);
    }
}
