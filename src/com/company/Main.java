package com.company;

public class Main {

    public static void main(String[] args) {
	    //Node Creation
        Node startNode = new Node();
        Node intersectionOne = new Node("Intersection One", startNode, false);
        Node intersectionTwo = new Node("Intersection Two", intersectionOne, false);
        Node intersectionThree = new Node("Intersection Three", intersectionTwo, false);
        Node intersectionFour = new Node("Intersection Four", intersectionThree, false);
        Node intersectionFive = new Node("Intersection Five", intersectionFour, false);
        Node intersectionSix = new Node("Intersection Five", intersectionFive, false);
        Node goalNode = new Node("Goal", intersectionSix, true);

        //dead ends creation
        Node deadEndOne = new Node("Dead End One", intersectionOne, false);
        Node deadEndTwo = new Node("Dead End Two", intersectionTwo, false);
        Node deadEndThree = new Node("Dead End Three", intersectionThree, false);
        Node deadEndFour = new Node("Dead End Four", intersectionFour, false);
        Node deadEndFive = new Node("Dead End Five", intersectionFive, false);
        Node deadEndSix = new Node("Dead End Five", intersectionSix, false);

        //add children to nodes
        startNode.childList.add(intersectionOne);

        intersectionOne.childList.add(intersectionTwo);
        intersectionOne.childList.add(deadEndOne);

        intersectionTwo.childList.add(deadEndTwo);
        intersectionTwo.childList.add(intersectionThree);

        intersectionThree.childList.add(intersectionFour);
        intersectionThree.childList.add(deadEndThree);

        intersectionFour.childList.add(deadEndFour);
        intersectionFour.childList.add(intersectionFive);

        intersectionFive.childList.add(deadEndFive);
        intersectionFive.childList.add(intersectionSix);

        intersectionSix.childList.add(deadEndSix);
        intersectionSix.childList.add(goalNode);

        //DFS
        System.out.println("DFS Implementation");
        Node currentNode = startNode;
        while(!currentNode.isGoal) {
            //output current node
            System.out.print(currentNode.nodeName + " -> ");

            //validates if dead end and returns to parent node if that is the case
            if (currentNode.childList.isEmpty()) {
                currentNode.isChecked = true;
                currentNode = currentNode.parentNode;
                continue;
            }

            //checks if all children have been checked for node
            int counter = 0;
            for (int i = 0; i <= currentNode.childList.size() - 1; i++) {
                if (currentNode.childList.get(i).isChecked) {
                    counter++;
                }
                else if (!currentNode.childList.get(i).isChecked) {
                    break;
                }
            }
            if (counter == currentNode.childList.size()) {
                currentNode.isChecked = true;
                currentNode = currentNode.parentNode;
            }
            else{
                int i = 0;
                while(currentNode.childList.get(i).isChecked){
                    i++;
                }
                currentNode = currentNode.childList.get(i);
            }
        }
        System.out.print("GOAL!\n");

        //reset the checked state of the nodes
        startNode.isChecked = false;
        intersectionOne.isChecked = false;
        intersectionTwo.isChecked = false;
        intersectionThree.isChecked = false;
        intersectionFour.isChecked = false;
        intersectionFive.isChecked = false;
        intersectionSix.isChecked = false;
        deadEndOne.isChecked = false;
        deadEndTwo.isChecked = false;
        deadEndThree.isChecked = false;
        deadEndFour.isChecked = false;
        deadEndFive.isChecked = false;
        deadEndSix.isChecked = false;
        goalNode.isChecked = false;

        //BSF
        System.out.println("BFS Implementation");
        currentNode = startNode;
        while(!currentNode.isGoal){

        }

    }
}
