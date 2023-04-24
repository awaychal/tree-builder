package org.example;

import java.util.*;

class Pair{
    Node start;
    Node end;

    Pair(Node start, Node end){
        this.start = start;
        this.end = end;
    }
}
public class test {

    public static Node buildTree(List<Pair> edges) {
        Set<Node> rootNodes = new HashSet<>();
        Set<Node> childNodes = new HashSet<>();

        for(Pair pair: edges){
            pair.start.addChild(pair.end);

            rootNodes.remove(pair.end);
            childNodes.add(pair.end);
            if (!childNodes.contains(pair.start)) {
                rootNodes.add(pair.start);
            }
        }

        if (rootNodes.isEmpty()) {
            throw new IllegalArgumentException("Input pairs contain a cycle with the root");
        }

        return rootNodes.iterator().next();
    }

    public static void main(String[] args) {
        List<Pair> edges = new ArrayList<>();
        edges.add(new Pair(new Node(4), new Node(5)));
        edges.add(new Pair(new Node(5), new Node(3)));
        edges.add(new Pair(new Node(1), new Node(5)));
        edges.add(new Pair(new Node(2), new Node(1)));
        //System.out.println(Arrays.deepToString(inputArr));

        System.out.println(buildTree(edges));
    }
}
