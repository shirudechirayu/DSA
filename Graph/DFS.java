import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Graph
{
    private List<List<Integer>> adjList;
    private int v;

    public Graph(int v)
    {
        int i = 0;

        this.v = v;

        this.adjList = new ArrayList<>(v);

        for(i = 0; i < v; i++)
        {
            this.adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest)
    {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    public void dfsHelper(int v, boolean[] visited)
    {
        Stack<Integer> st = new Stack<>();

        visited[v] = true;
        System.out.println(v + " ");

        int i = 0;

        for(i = adjList.get(v).size() - 1; i >= 0; i--)
        {
            if(!visited[adjList.get(v).get(i)])
                st.push(adjList.get(v).get(i));
        }

        if(!st.isEmpty())
            dfsHelper(st.pop(), visited);
    }

    public void dfs()
    {
        int i = 0;
        boolean[] visited = new boolean[v];

        for(i = 0; i < v; i++)
        {
            visited[i] = false;
        }

        for(i = 0; i < v; i++)
        {
            if(!visited[i])
                dfsHelper(i, visited);
        }
    }
    
}

class DFS
{
    public static void main(String[] args) 
    {
        Graph gf = new Graph(5);

        gf.addEdge(0, 1);
        gf.addEdge(0, 2);
        gf.addEdge(0, 3);
        gf.addEdge(2, 3);
        gf.addEdge(2, 4);

        gf.dfs();
    }
}