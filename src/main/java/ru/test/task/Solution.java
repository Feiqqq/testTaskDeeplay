package ru.test.task;

import java.util.HashMap;

public class Solution {

    private static final HashMap<String, HashMap<String, Integer>> costOfMovingForRasaTable = new HashMap<>();
    private static final HashMap<String, Integer> costForHuman = new HashMap<>();
    private static final HashMap<String, Integer> costForSwamper = new HashMap<>();
    private static final HashMap<String, Integer> costForWoodman = new HashMap<>();
    private static int[][] map = null;

    private static int best_sum = -1;
    private static int n;
    private static int m;
    public static int getResult(String gameMapCode, String rasa) {
        fillTable();
        map = fillMap(rasa, gameMapCode);
        n = map.length - 1;
        m = map.length - 1;
        solve(1, 1, map[0][0]);
        return best_sum;
    }

    private static void solve(int x, int y, int sum) {
        if (x == n && y == m) {
            if (best_sum == -1 || sum < best_sum) best_sum = sum;
        } else if (sum < best_sum || best_sum == -1) {
            if (x < n) {
                solve(x + 1, y, sum + map[(x + 1)][y]);
            }
            if (y < m) {
                solve(x, y + 1, sum + map[x][(y + 1)]);
            }
            if (x != 0) {
                solve(x - 1 , y, sum + map[(x - 1)][y]);
            }
            if (y != 0) {
                solve(x, y - 1, sum + map[x][(y - 1)]);
            }
        }
    }

    private static void fillTable() {
        String Swamp = "S";
        String Water = "W";
        String Bushes = "T";
        String Plain = "P";

        costForHuman.put(Swamp, 5);
        costForHuman.put(Water, 2);
        costForHuman.put(Bushes, 3);
        costForHuman.put(Plain, 1);

        costForSwamper.put(Swamp, 2);
        costForSwamper.put(Water, 2);
        costForSwamper.put(Bushes, 5);
        costForSwamper.put(Plain, 2);

        costForWoodman.put(Swamp, 3);
        costForWoodman.put(Water, 3);
        costForWoodman.put(Bushes, 2);
        costForWoodman.put(Plain, 2);

        costOfMovingForRasaTable.put("Human", costForHuman);
        costOfMovingForRasaTable.put("Swamper", costForSwamper);
        costOfMovingForRasaTable.put("Woodman", costForWoodman);
    }

    private static int[][] fillMap(String rasa, String gameMapCode) {
        int size = (int) Math.sqrt(gameMapCode.length());
        int[][] gameMap = new int[size][size];
        char[] gameMapCharCodeArray = gameMapCode.toCharArray();
        int temp = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gameMap[i][j] = costOfMovingForRasaTable.get(rasa).get(String.valueOf(gameMapCharCodeArray[temp]));
                temp++;
            }
        }
        return gameMap;
    }

}
