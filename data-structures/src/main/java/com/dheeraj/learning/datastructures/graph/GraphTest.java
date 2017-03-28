package com.dheeraj.learning.datastructures.graph;

import java.util.HashMap;
import java.util.Queue;
import java.util.Random;

/**
 * Created by dgopali on 10/5/2015.
 */
public class GraphTest {
    public static void main(String[] args) throws Exception {
        //DFS
        //The below graph creation is basically required to store all the nodes and transfer it anywhere whenever required.
        //Can start searching with any node if we have this graph.
        HashMap<Integer, Node> graph = constructGraph(6);
        for(Node n : graph.values()){
            n.visited = false;
        }
        System.out.println("DFS : ");
        dfs(graph.get(0)); //
        for(Node n : graph.values()){
            n.visited = false;
        }
        System.out.println("\nBFS");
        bfs(graph.get(0)); //0 1 2 3 5 6 4*/

        System.out.println();
        for (Node node : graph.values()) {
            System.out.println(node);
        }
    }

    public static HashMap<Integer, Node> constructGraph(int size){
        HashMap<Integer, Node> graph = new HashMap<Integer, Node>();
        //Create nodes or vertices
        for(int i=0;i<size;i++){
            graph.put(i,new Node(i));
        }

        //Create edges
        Random random = new Random();
        for(int j=0; j<size ; j++){
            for (int i=0; i<3; i++) {
                int rand = random.nextInt(size);
                if(rand != j)
                    graph.get(j).add(graph.get(rand));
            }
        }

        return graph;
    }

    static void dfs(Node root){
        if(root == null)
            return;
        System.out.print(root.val+" ");
        root.visited=true;
        for(Node n : root.children){
            if(n.visited == false){
                dfs(n);
            }
        }
    }

    static void bfs(Node root) throws Exception{
        if(root==null)
            return;
        sun.misc.Queue queue = new sun.misc.Queue();
        queue.enqueue(root);
        while(!queue.isEmpty()){
            Node n = (Node)queue.dequeue();
            if(n.visited == false){
                System.out.print(n.val+" ");
                n.visited = true;
                for(Node child : n.children){
                    queue.enqueue(child);
                }
            }
        }

    }
}
