/**
 * @author Grace Gong and Zeshan Ahmed
 */

import java.util.ArrayList;
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class TestGraph
{
    public static void main(String[] args)
    {
        {
            Collection<Vertex> v = new ArrayList<Vertex>();
            v.add(new Vertex("1"));
            v.add(new Vertex("2"));
            v.add(new Vertex("3"));
            Collection<Edge> e = new ArrayList<Edge>();
            e.add(new Edge(new Vertex("1"),new Vertex("2"),10));
            e.add(new Edge(new Vertex("2"),new Vertex("3"),20));
            Graph graph=new MyGraph(v,e);
            boolean pass=true;
            if(graph.edgeCost(new Vertex("1"),new Vertex("2"))!=10)
                pass=false;
            if(graph.edgeCost(new Vertex("2"),new Vertex("3"))!=20)
                pass=false;
            if(pass)
                System.out.println("Test1 passed!");
            else
                System.out.println("Test1 failed!");

        }
        {
            Collection<Vertex> v = new ArrayList<Vertex>();
            v.add(new Vertex("1"));
            v.add(new Vertex("2"));
            v.add(new Vertex("3"));
            Collection<Edge> e = new ArrayList<Edge>();
            e.add(new Edge(new Vertex("1"),new Vertex("2"),10));
            e.add(new Edge(new Vertex("2"),new Vertex("3"),20));
            Graph graph=new MyGraph(v,e);
            boolean pass=true;
            if(graph.vertices().size()!=3)
                pass=false;
            if(graph.edges().size()!=2)
                pass=false;
            if(pass)
                System.out.println("Test2 passed!");
            else
                System.out.println("Test2 failed!");
        }
        {
            Collection<Vertex> v = new ArrayList<Vertex>();
            v.add(new Vertex("1"));
            v.add(new Vertex("2"));
            v.add(new Vertex("3"));
            Collection<Edge> e = new ArrayList<Edge>();
            e.add(new Edge(new Vertex("1"),new Vertex("2"),10));
            e.add(new Edge(new Vertex("2"),new Vertex("3"),20));
            MyGraph graph=new MyGraph(v,e);
            boolean pass=true;
            Path path=graph.shortestPath(new Vertex("1"),new Vertex("3"));

            if(path.cost!=30)
                pass=false;
            if(path.vertices.size()!=3)
                pass=false;
            if(!path.vertices.get(2).getLabel().equals("3"))
                pass=false;
            if(pass)
                System.out.println("Test3 passed!");
            else
                System.out.println("Test3 failed!");
        }
    }

}
