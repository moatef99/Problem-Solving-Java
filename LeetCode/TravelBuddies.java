package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class TravelBuddies {

    public String[] getUsers() {
        return new String[]{"1", "7", "3", "4", "5", "6", "4", "8"};
    }

    public String[] getVisitedDestinations(String user) {
        HashMap<String, String[]> visitedLocations = new HashMap<String, String[]>();
        visitedLocations.put("1", new String[]{"A"});
        visitedLocations.put("2", new String[]{"A", "B", "C"});
        visitedLocations.put("3", new String[]{"B"});
        visitedLocations.put("4", new String[]{"B"});
        visitedLocations.put("5", new String[]{"C"});
        visitedLocations.put("6", new String[]{"C"});
        visitedLocations.put("7", new String[]{"D"});
        visitedLocations.put("8", new String[]{"D"});

        return visitedLocations.get(user);
    }

    public HashMap<String, String[]> getCityHash() {
        HashMap<String, String[]> cityHash = new HashMap<String, String[]>();
        cityHash.put("A", new String[]{"1", "2"});
        cityHash.put("B", new String[]{"2", "3", "4"});
        cityHash.put("C", new String[]{"2", "5", "6"});
        cityHash.put("D", new String[]{"7", "8"});
        return cityHash;
    }

    public int getLargestTravelGroupSize() {
        int max = 0;
        HashSet<String> cities = new HashSet<>();
        HashSet<String> group = new HashSet<>();

        for (String user : getUsers()) {
            if (!group.contains(user)) {
                max = max > group.size() ? max : group.size();
                group = new HashSet<>();
                getTravelGroup(user, group, cities);
            }
        }
        return max > group.size() ? max : group.size();
    }

    public void getTravelGroup(String user, HashSet<String> group, HashSet<String> cities) {
        if (group.contains(user)) {
            return;
        }
        group.add(user);

        String[] visitedCities = getVisitedDestinations(user);
        for (String city : visitedCities) {
            if (!cities.contains(city)) {
                cities.add(city);
                String[] travelBuddies = getCityHash().get(city);
                for (String travelBuddy : travelBuddies) {
                    getTravelGroup(travelBuddy, group, cities);
                }
            }
        }
    }

    public static void main(String[] args) {
        TravelBuddies tb = new TravelBuddies();
        System.out.println(tb.getLargestTravelGroupSize());
    }
}
