package com.allykh.assignment2;

public class DoublyLinkedList extends Object {
    public WebLink head;
    public WebLink tail;
    public WebLink current;

    private class WebLink{
        public String url;
        public WebLink back;
        public WebLink next;
        public WebLink(String url){
            this.url = url;
        }
    }

    public String goBack(){
        if(current == null){
            return "";
        } else if(current.back == null){
            return "";
        }
        current = current.back;
        return current.url;
    }

    public String goForward(){
        if(current == null){
            return "";
        } else if(current.next == null){
            return "";
        }
        current = current.next;
        return current.url;
    }

    public void addNew(String link){
        WebLink newLink = new WebLink(link);

        if(head == null){
            head = newLink;
            tail = newLink;
            current = newLink;
            //System.out.println(newLink.url);
        } else {
            current.next = newLink;  //wipes all other history from that point on
            newLink.back = current;
            newLink.next = null;  // is this necessary?
            current = newLink;
            tail = newLink;
            //System.out.println(newLink.url);
        }

    }
}
