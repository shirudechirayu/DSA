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

    private boolean cycleHelper(boolean[] visited, int parent, int vertex)
    {
        int i = 0;
        List<Integer> edgeList = this.adj.get(vertex);

        visited[vertex] = true;

        for(i = 0; i < edgeList.size(); i++)
        {
            if(!visited[edgeList.get(i)])
            {
                if(cycleHelper(visited, vertex, edgeList.get(i)))
                {
                    return true;
                }
            }
            else if(edgeList.get(i) != parent)
            {
                return true;
            }
        }

        return false;
    }

    public boolean detectCycle()
    {
        boolean visited[] = new boolean[this.V];
        int i = 0;

        for(i = 0; i < this.V; i++)
        {
            visited[i] = false;
        }

        for(i = 0; i < this.V; i++)
        {
            if(!visited[i])
            {
                if(cycleHelper(visited, -1, i))
                {
                    return true;
                }
            }
        }

        return false;
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

class DetectCycleUndirected
{
    public static void main(String args[])
    {
        Graph graph = new Graph(5);

        graph.addEdge(0,3);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(4, 3);
        graph.addEdge(2,4);

        System.out.println(graph.detectCycle());
    }
}