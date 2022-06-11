/**
 * @author Grace Gong and Zeshan Ahmed
 */

import java.util.*;

/**
 * A representation of a graph. Assumes that we do not have negative cost edges
 * in the graph.
 */

//The code creates a MyGraph object with the given collection of vertices and the given collection of edges.
public class MyGraph implements Graph
{
    // you will need some private fields to represent the graph
    // you are also likely to want some private helper methods

    // YOUR CODE HERE
    //The code creates an array called table that is 97 elements long, which will be used to store the VertexNode objects for each vertex in this graph.
    VertexNode[] table;
    final int SIZE = 97;

    /**
     * Creates a MyGraph object with the given collection of vertices and the
     * given collection of edges.
     *
     * @param v a collection of the vertices in this graph
     * @param e a collection of the edges in this graph
     */
    public MyGraph(Collection<Vertex> v, Collection<Edge> e) throws IllegalArgumentException
    {

        // YOUR CODE HERE
        // The first line starts by creating a HashMap called table that will store all of the nodes in this graph.
        table = new VertexNode[SIZE];
        //The next few lines create a VertexNode object for every vertex in table .
        //Then, if findVertex(vertex) returns null , it creates a new VertexNode with an empty label (the string "null").
        for (Vertex vertex : v) {
            VertexNode current = findVertex(vertex);
            if (current==null) {
                table[vertex.hashCode() % SIZE] = new VertexNode(table[vertex.hashCode() % SIZE], new Vertex(vertex.getLabel()));
            }
        }

        //The next few lines iterate through all of the edges in e .
        //For each edge, they find both ends: source and destination .
        for (Edge edge : e) {
            VertexNode source = findVertex(edge.getSource());
            VertexNode destination = findVertex(edge.getDestination());
            if(source==null||destination==null)
                throw new IllegalArgumentException("Invalid edge!");
            //check for dupplicates.
            for(Edge vertexEdge:source.getAdjacency())
            {
                if(vertexEdge.getDestination().equals(edge.getDestination()))
                {
                    if(vertexEdge.getWeight()!=edge.getWeight())
                    {
                        throw new IllegalArgumentException("Dupplicate edge!");
                    }
                    edge=null;
                    break;
                }
            }
            if(edge!=null)
                source.getAdjacency().add(new Edge(source.getVertex(),destination.getVertex(),edge.getWeight()));
        }
    }

    //The code is a method that returns the collection of vertices of this graph.
    private VertexNode findVertex(Vertex vertex)
    {
        int index = vertex.hashCode() % SIZE;
        VertexNode current = table[index];
        while (current != null) {
            if (current.getVertex().equals(vertex)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * Return the collection of vertices of this graph
     *
     * @return the vertices as a collection (which is anything iterable)
     */
    @Override
    public Collection<Vertex> vertices()
    {
        // YOUR CODE HERE
        ArrayList<Vertex>result=new ArrayList<Vertex>();
        for(int index=0;index<SIZE;index++)
        {
            VertexNode current = table[index];
            while(current!=null)
            {
                result.add(current.getVertex());
                current=current.getNext();
            }
        }
        return result;
    }

    /**
     * Return the collection of edges of this graph
     *
     * @return the edges as a collection (which is anything iterable)
     */
    @Override
    public Collection<Edge> edges()
    {
        // YOUR CODE HERE
        ArrayList<Edge>result=new ArrayList<Edge>();

        for(int index=0;index<SIZE;index++)
        {
            VertexNode current = table[index];
            while(current!=null)
            {
                result.addAll(current.getAdjacency());
                current=current.getNext();
            }
        }
        return result;
    }

    /**
     * Return a collection of vertices adjacent to a given vertex v. i.e., the
     * set of all vertices w where edges v -> w exist in the graph. Return an
     * empty collection if there are no adjacent vertices.
     *
     * @param v one of the vertices in the graph
     * @return an iterable collection of vertices adjacent to v in the graph
     * @throws IllegalArgumentException if v does not exist.
     */
    @Override
    public Collection<Vertex> adjacentVertices(Vertex v)throws IllegalArgumentException
    {
        // YOUR CODE HERE
        ArrayList<Vertex>result=new ArrayList<Vertex>();
        VertexNode node=findVertex(v);
        if (node==null)
            throw new IllegalArgumentException("Invalid node"+v);
        for(Edge edge:node.getAdjacency())
        {
            result.add(edge.getDestination());
        }
        return result;
    }

    /**
     * Test whether vertex b is adjacent to vertex a (i.e. a -> b) in a directed
     * graph. Assumes that we do not have negative cost edges in the graph.
     *
     * @param a one vertex
     * @param b another vertex
     * @return cost of edge if there is a directed edge from a to b in the
     * graph, return -1 otherwise.
     * @throws IllegalArgumentException if a or b do not exist.
     */
    @Override
    public int edgeCost(Vertex a, Vertex b)throws IllegalArgumentException
    {
        // YOUR CODE HERE
        ArrayList<Vertex>result=new ArrayList<Vertex>();
        VertexNode node=findVertex(a);
        if (node==null)
            throw new IllegalArgumentException("Invalid node"+a);
        for(Edge edge:node.getAdjacency())
        {
            if(edge.getDestination().equals(b))
                return edge.getWeight();
        }
        return -1;

    }


    /**
     * Returns the shortest path from a to b in the graph, or null if there is
     * no such path. Assumes all edge weights are nonnegative. Uses Dijkstra's
     * algorithm.
     *
     * @param a the starting vertex
     * @param b the destination vertex
     * @return a Path where the vertices indicate the path from a to b in order
     * and contains a (first) and b (last) and the cost is the cost of the path.
     * Returns null if b is not reachable from a.
     * @throws IllegalArgumentException if a or b does not exist.
     */
    public Path shortestPath(Vertex a, Vertex b)
    {

        // YOUR CODE HERE (you might comment this out this method while doing
        // Part 1)
        List<Vertex> vertices=new ArrayList<Vertex> ();
        int cost=0;
        clearPath();
        List<VertexNode> Q=new ArrayList<VertexNode> ();
        VertexNode source = findVertex(a);
        VertexNode destination = findVertex(b);
        if(source==null||destination==null)
            throw new IllegalArgumentException("Invalid edge!");

        Q.add(source);
        source.setDistance(0);
        source.setParent(source);
        VertexNode current=null;
        while(!Q.isEmpty())
        {
            current=Q.get(0);
            for(VertexNode node:Q)
            {
                if(current.getDistance()>node.getDistance())
                    current=node;
            }
            Q.remove(current);
            if(current==destination)
                break;
            for(Edge edge:current.getAdjacency())
            {
                VertexNode adjacent = findVertex(edge.getDestination());
                if(adjacent.getParent()==null)
                {
                    adjacent.setDistance(current.getDistance()+edge.getWeight());
                    adjacent.setParent(current);
                    Q.add(adjacent);
                }
                else if(adjacent.getDistance()>current.getDistance()+edge.getWeight())
                {
                    adjacent.setDistance(current.getDistance()+edge.getWeight());
                    adjacent.setParent(current);
                }
            }
        }
        if(current!=destination)
            return null;
        cost=current.getDistance();
        while(current!=current.getParent())
        {
            vertices.add(0,current.getVertex());
            current=current.getParent();
        }
        vertices.add(0,current.getVertex());
        return new Path(vertices,cost);
    }

    private void clearPath()
    {
        for(int index=0;index<SIZE;index++)
        {
            VertexNode current = table[index];
            while(current!=null)
            {
                current.setDistance(0);
                current.setParent(null);
                current=current.getNext();
            }
        }
    }

}
