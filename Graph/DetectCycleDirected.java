import java.util.*;

class Graph
{
    private List<List<Integer>> adj;
    private int V;

    public void addEdge(int src, int dest)
    {
        this.adj.get(src).add(dest);
    }

    private boolean cycleHelper(boolean[] visited, boolean[] recStack, int vertex)
    {
        int i = 0;
        List<Integer> edgeList = this.adj.get(vertex);

        visited[vertex] = true;
        recStack[vertex] = true;

        for(i = 0; i < edgeList.size(); i++)
        {
            if(!visited[edgeList.get(i)])
            {
                if(cycleHelper(visited, recStack, edgeList.get(i)))
                {
                    return true;
                }
            }
            else if(recStack[edgeList.get(i)])
            {
                return true;
            }
        }

        recStack[vertex] = false;
        return false;
    }

    public boolean detectCycle()
    {
        boolean visited[] = new boolean[this.V];
        boolean recStack[] = new boolean[this.V];
        int i = 0;

        for(i = 0; i < this.V; i++)
        {
            visited[i] = false;
        }

        for(i = 0; i < this.V; i++)
        {
            if(!visited[i])
            {
                if(cycleHelper(visited, recStack, i))
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

class DetectCycleDirected
{
    public static void main(String args[])
    {
        Graph graph = new Graph(4);

        graph.addEdge(0,1);
        graph.addEdge(0, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        //graph.addEdge(3, 2);

        System.out.println(graph.detectCycle());
    }
}