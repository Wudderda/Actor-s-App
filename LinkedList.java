package com.hasan.actorsapp;

public  class LinkedList { // ordered Linked list structure

    Node head; // head of list

    LinkedList(Node start) {
        head = start;
    }

    class Node {
        //data;
        int person_id;
        String person_name;
        double popularity;
        Node next;

        // Constructor
        Node(int id, double pop, String name) {
            person_id = id;
            person_name = name;
            popularity = pop;
            next = null;
        }
    }
    // Method to insert a new node
    public LinkedList insert(LinkedList list, int id, double pop, String name) {   // Create a new node with given data
        LinkedList.Node new_node = new LinkedList.Node(id, pop, name);
        new_node.next = null;
        LinkedList.Node previous = null;
        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        } else {
            //If the person to add has biggest popularity make him the new head of the list
            if (pop >= list.head.popularity) {
                new_node.next = list.head;
                LinkedList list1 = new LinkedList(new_node);
                list = list1;
            }
            // Else traverse till correct position of the list
            else {
                LinkedList.Node last = list.head;
                previous = last;
                while (last.next != null && last.popularity > pop) {
                    previous = last;
                    last = last.next;
                }
                //If the person to add has smallest popularity make him the tail of the list
                if (last.next == null && last.popularity >= pop) {
                    last.next = new_node;
                }
                //Else insert it to the correct position which is somewhere in middle of the list.
                else {
                    new_node.next = last;
                    previous.next = new_node;
                }
            }
        }

        // Return the list by head
        return list;
    }
    // Method to search the number of occurrences of a specific name in the linked list.
    public int search(LinkedList list, String name) {
        int count = 0;
        //If list is null , no further operation needed. count is 0.
        if (list != null) {
            LinkedList.Node currNode = list.head;
            String currName = "";
            while (currNode != null) {
                currName = currNode.person_name;
                for (int i = 0; i < name.length(); i++) {
                    //If name to be searched has bigger size , no possible match exists.
                    if (i > currName.length()) {
                        break;
                    }
                    //If name of the actor ends before the name to be searched , break the loop.
                    else if (currName.charAt(i) == ' ') {
                        break;
                    }
                    //If there is a mismatching char in the actor name , break the loop.
                    if (currName.charAt(i) != name.charAt(i)) {
                        break;
                    }
                    //Matched name , increment count.
                    if (i == name.length() - 1 && currName.charAt(i + 1) == ' ') {
                        count++;
                    }
                }
                currNode = currNode.next;
            }
        }
        return count;
    }
    //method to give personal information in a string with specific format for just one node:
    public  String getDisplay(Node a){
        int length=a.person_name.length();
        String indentation_name=" ";
        String indentation_id=" ";
        int length2=(a.person_id+" ").length();
        for(int i=0;i<8-length2;i++){
            indentation_id+=' ';
        }
        for(int i=0;i<20-length;i++){
            indentation_name+=' ';
        }
        String info=a.person_id+indentation_id +a.person_name+indentation_name+ a.popularity;
        return info;
    }
    //method to give personal information in an array of string with specific format for all the linked list:
    public  String[] getDisplayString(LinkedList list){
        Node currNode=list.head;
        int size=0;
        int index=1;
        //get size of the list
        while(currNode!=null){
            currNode=currNode.next;
            size++;
        }
        currNode=list.head;
        //Create array of strings to display
        String[] Infos = new String[size+1];
        Infos[0]="id:     name:              popularity:";
        while(currNode!=null){
            Infos[index]=getDisplay(currNode);
            currNode=currNode.next;
            index++;
        }
        return Infos;
    }
    // Method to print the LinkedList.
    public void printList(LinkedList list) {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.println("currNode.popularity =" + currNode.popularity + " ");

            // Go to next node
            currNode = currNode.next;
        }
    }

    // Method to search the number of occurrences of a specific name in the linked list.

}
