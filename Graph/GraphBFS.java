import java.util.*;

class Graph
    {
        private List<List<Integer>> adj;
        private int V;

        public void addEdge(int src, int dest)
        {
            this.adj.get(src).add(dest);
            this.adj.get(dest).add(src);
        }

        private void bfsHelper(boolean[] visited, int src)
        {
            Queue<Integer> q = new LinkedList<Integer>();

            q.add(src);
            visited[src] = true;

            while(!q.isEmpty())
            {
                int first = q.remove();
                System.out.println(first);

                for(int i = 0; i < this.adj.get(first).size(); i++)
                {
                    if(!visited[this.adj.get(first).get(i)])
                    {
                        System.out.println("Not visited vertex " + this.adj.get(first).get(i));
                        q.add(this.adj.get(first).get(i));
                        visited[this.adj.get(first).get(i)] = true;
                    }
                }

            }
        }

        public void bfs()
        {
            boolean[] visited = new boolean[this.V];

            for(int i = 0; i < this.V; i++)
            {
                visited[i] = false;
            }

            for(int i = 0; i < this.V; i++)
            {
                if(!visited[i])
                {
                    bfsHelper(visited,i);
                }
            }
        }

        public Graph(int vertex)
        {
            this.V = vertex;

            this.adj = new ArrayList<>(V);

            for(int i = 0; i < V; i++)
            {
                this.adj.add(new ArrayList<>());
            }
        }
    }

class GraphBFS
{
    public static void main(String[] args)
    {
        Graph graph = new Graph(4);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2,3);
        graph.addEdge(1,2);

        graph.bfs();
    }
}