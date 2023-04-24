package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {

    private int data;
    private List<Node> children = new ArrayList<>();

    public Node(int data){
        this.data = data;
    }

    public void addChild(Node node){
        children.add(node);
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public int getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", children=" + children +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return data == node.data && Objects.equals(children, node.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, children);
    }
}
