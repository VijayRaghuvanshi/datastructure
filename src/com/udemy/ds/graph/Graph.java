package com.udemy.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<String, ArrayList<String>> adjList = new HashMap<>();

    public void printGraph(){
        System.out.println(adjList);
    }
    public boolean addVertex(String vertex){
        boolean flag = false;
        if (!adjList.containsKey(vertex)){
            adjList.put(vertex,new ArrayList<>());
            flag = true;
        }
        return flag;
    }
    public boolean addEdge(String vertexA, String vertexB){
        boolean flag = false;
        if ( adjList.containsKey(vertexA) && adjList.containsKey(vertexB)){
            adjList.get(vertexA).add(vertexB);
            adjList.get(vertexB).add(vertexA);
            flag = true;
        }
        return flag;
    }

    public boolean removeEdge(String vertexA, String vertexB){
        boolean flag = false;

        if (adjList.containsKey(vertexA) && adjList.containsKey(vertexB)){
            adjList.get(vertexA).remove(vertexB);
            adjList.get(vertexB).remove(vertexA);
            flag = true;
        }
        return flag;
    }

    public boolean removeVertex(String vertex){
        boolean flag = false;
        if (adjList.containsKey(vertex)){
            for (String v:  adjList.get(vertex) ) {
                adjList.get(v).remove(vertex);
            }
            adjList.remove(vertex);
            flag = true;
        }
        return flag;
    }
}
