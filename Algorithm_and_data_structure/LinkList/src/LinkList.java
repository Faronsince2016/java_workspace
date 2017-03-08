/**
 * Created by Faron on 2017/3/8.
 */
class Node{
    int data;
    int np;
    String names;
    Node next;

    public Node(int data, int np, String names) {
        this.data = data;
        this.np = np;
        this.names = names;
        this.next = null;
    }
}

public class LinkList {
    private Node first;
    private Node last;

    //isEmpty() ;insert(); print();


    public boolean isEmty(){
        return first == null;
    }

    public void print(){
        Node current = first;
        while (current != null){
            System.out.println(current.data);
            System.out.println(current.names);
            System.out.println(current.np);
            System.out.println(current.next);
        }
    }

    public void insert(int data, int np, String names){
        Node node = new Node(data,np,names);

        //插入节点的时候 判断节点是否为空

        if (this.isEmty()){
            first = node;
            last =node;
        }else{
            last.next = node;
            last = node;
        }


    }

    public  static  void main(String[] args){
        LinkList list = new LinkList();
        list.insert(1000,10,"flw");
        list.insert(2000,20,"zn");
        list.insert(3000,30,"myfamily");

        list.print();
    }

}
