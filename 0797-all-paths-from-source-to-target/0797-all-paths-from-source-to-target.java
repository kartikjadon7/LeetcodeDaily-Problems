import java.util.*;

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<Integer> path = new ArrayList<>();

        dfs(graph, 0, graph.length - 1, path);

        return ans;
    }

    private void dfs(int[][] graph, int node, int target, List<Integer> path) {

        path.add(node);

        if (node == target) {
            ans.add(new ArrayList<>(path));   

            path.remove(path.size() - 1);     
            return;
        }

        for (int next : graph[node]) {
            dfs(graph, next, target, path);
        }

        path.remove(path.size() - 1);
    }
}