/**
 * @author Grace Gong and Zeshan Ahmed
 */

import java.util.ArrayList;

public class VertexNode
{
    private VertexNode next;
    private Vertex vertex;
    private ArrayList<Edge> adjacency;
    private int distance;
    private VertexNode parent;

    public VertexNode(VertexNode next, Vertex vertex)
    {
        this.next = next;
        this.vertex = vertex;
        adjacency=new ArrayList<Edge>();
    }

    public VertexNode getNext()
    {
        return next;
    }

    public void setNext(VertexNode next)
    {
        this.next = next;
    }

    public Vertex getVertex()
    {
        return vertex;
    }

    public void setVertex(Vertex vertex)
    {
        this.vertex = vertex;
    }

    public ArrayList<Edge> getAdjacency()
    {
        return adjacency;
    }

    public void setAdjacency(ArrayList<Edge> adjacency)
    {
        this.adjacency = adjacency;
    }

    public int getDistance()
    {
        return distance;
    }

    public void setDistance(int distance)
    {
        this.distance = distance;
    }

    public VertexNode getParent()
    {
        return parent;
    }

    public void setParent(VertexNode parent)
    {
        this.parent = parent;
    }
}
