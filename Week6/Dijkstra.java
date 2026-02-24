package Week6;
import java.util.*;
class Dijkstra {
    static void dijkstra(int V, ArrayList<ArrayList<int[]>> adj, int src){

        int[] dist = new int[V];
        int[] parent = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);

        dist[src] = 0;
        pq.add(new int[]{src,0});

        while(!pq.isEmpty()){

            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];

            if(d>dist[u]) continue;

            for(int[] edge : adj.get(u)){
                int v = edge[0];
                int w = edge[1];

                if(dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                    parent[v] = u;
                    pq.add(new int[]{v,dist[v]});
                }
            }
        }

        // Print distances
        System.out.println("Distances:");
        for(int i=1;i<V;i++){
            System.out.println("Node " + i + " -> " + dist[i]);
        }

        // Print paths
        System.out.println("\nPaths:");
        for(int i=1;i<V;i++){
            if(i == src) continue;
            System.out.print("Path to " + i + ": ");
            printPath(i, parent);
            System.out.println();
        }
    }

    static void printPath(int t, int[] parent){
        if(t == -1) return;
        printPath(parent[t], parent);
        System.out.print(t + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt()+1;
        int e = sc.nextInt(); 
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new int[]{v,w});
        }
        int src = sc.nextInt();
        dijkstra(n, adj, src);
        sc.close();
    }
}