class Solution {
    int[] prnt;
    int[] rank;
    public int countComponents(int n, int[][] edges) {
        prnt = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            prnt[i] = i;
        }
        int comp = n;
        for (int[] edge : edges) {

            if (union(edge[0], edge[1])) {
                comp--;
            }
        }
        return comp;
    }
    private int find(int x) {
        if (prnt[x] != x) {
            prnt[x] = find(prnt[x]);
        }
        return prnt[x];
    }
    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false;
        }
        if (rank[rootX] > rank[rootY]) {
            prnt[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            prnt[rootX] = rootY;
        } else {
            prnt[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
}