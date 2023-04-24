package org.example;

import java.util.HashMap;
import java.util.Map;

public class TreeBuilder {

    public static Node constructTree(int[][] inputArr){

        if(inputArr == null || inputArr.length == 0){
            throw new IllegalArgumentException("Input is null or doesn't contain any elements");
        }

        //To store first array nodes in provided input array and parent nodes
        Map<Integer, Node> map = new HashMap<>();

        for (int[] arr : inputArr) {

            int firstElement = arr[0];
            int secondElement = arr[1];

            int parent, child;

            //Handle root node
            if (firstElement == Constants.ROOT_NODE && !map.containsKey(firstElement)) {

                parent = firstElement;
                child = secondElement;

                handleRootNode(map, parent, child);
            }else if (secondElement == Constants.ROOT_NODE && !map.containsKey(secondElement)) {

                parent = secondElement;
                child = firstElement;

                handleRootNode(map, parent, child);
            }
            //handle child nodes
            else {
                if (map.containsKey(firstElement) && map.containsKey(secondElement)) {
                    Node root = map.get(Constants.ROOT_NODE);
                    if(firstElement == Constants.ROOT_NODE || root.getChildren().contains(map.get(firstElement))){
                        parent = firstElement;
                        child = secondElement;
                    }else if(secondElement == Constants.ROOT_NODE || root.getChildren().contains(map.get(secondElement))){
                        parent = secondElement;
                        child = firstElement;
                    }else{
                        throw new IllegalArgumentException("Isolated node found.");
                    }

                    Node parentNode = map.get(parent);
                    parentNode.addChild(map.get(child));

                    map.put(parent, parentNode);
                }else if (map.containsKey(firstElement) || map.containsKey(secondElement)) {
                    if (map.containsKey(firstElement)) {
                        parent = firstElement;
                        child = secondElement;
                    } else {
                        parent = secondElement;
                        child = firstElement;
                    }

                    Node parentNode = map.get(parent);
                    Node childNode = new Node(child);
                    parentNode.addChild(childNode);

                    map.put(parent, parentNode);
                } else {

                    Node n1 = new Node(firstElement);
                    n1.addChild(new Node(secondElement));
                    Node n2 = new Node(secondElement);
                    n2.addChild(new Node(firstElement));

                    map.put(firstElement, n1);
                    map.put(secondElement, n2);
                }
            }
        }

        if(!map.containsKey(Constants.ROOT_NODE))
            throw new IllegalArgumentException("Root node 1 is not present");

        return map.get(Constants.ROOT_NODE) ;
    }

    private static void handleRootNode(Map<Integer, Node> map, int parent, int child) {
        Node parentNode = new Node(parent);
        if (map.containsKey(child)) {
            parentNode.addChild(map.get(child));
        } else {
            Node childNode = new Node(child);
            parentNode.addChild(childNode);

            map.put(child, childNode);
        }
        map.put(parent, parentNode);
    }

}
