package com.company;

import java.util.ArrayList;

public class Node {
    String nodeName;
    Node parentNode;
    ArrayList<Node> childList = new ArrayList<Node>();
    Boolean isChecked = false;
    Boolean isGoal;

    Node() {
        nodeName = "Start";
        parentNode = null;
        isGoal = false;
    }

    Node(String name, Node parent, Boolean isGoal){
        nodeName = name;
        parentNode = parent;
        this.isGoal = isGoal;
    }
}
