
public class Doubly_Linkedlist {

    public static void main(String[] args) {
       doublyLinkedlist dl=new doublyLinkedlist();
       dl.insertAtFirst(6);
       dl.insertAtLast(8);
       dl.insertAtLast(0);
       dl.removeAtFirst();
       dl.removeAtLast();
       dl.display();
       dl.reversDisplay();
    }
    
}
class doublyLinkedlist{
    class node{
       private int item;
       private node next,prev;
    }
   private node tail,head;
   private int length;
    public void insertAtFirst(int item){
        node newNode=new node();
        newNode.item=item;
        if (length==0){
            newNode.next=null;
            newNode.prev=null;
            head=tail=newNode;
        }else {
            newNode.prev=null;
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
            
        }
        length++;
    }
    public void insertAtLast(int item){
       node newNode=new node();
        newNode.item=item;
        if (length==0){
            newNode.next=null;
            newNode.prev=null;
            tail=head=newNode;
        }else {
            newNode.next=null;
            newNode.prev=tail;
            tail.next=newNode;
            tail=newNode;
            
        }
        length++;
    }
    public void insertAtpos(int item,int pos){
        if (pos<0||pos>length){
            System.out.println("Out Of Range");
        }else {
            node newNode=new node();
            newNode.item=item;
            if (pos==0){
                insertAtFirst(item);
            }else if (pos==length){
                insertAtLast(item);
            }else {
                node curr=head;
                for (int i=1;i<pos;i++){
                    curr=curr.next;
                }
                newNode.next=curr.next;
                newNode.prev=curr;
                curr.next=newNode;
                curr.next.prev=newNode;
                length++;
            }
        }
    }
    public void  removeAtFirst(){
        if (length==0){
            System.out.println("Linked list is Empty");
        }else if (length==1){
            head=tail=null;
        }else {
            head=head.next;
            head.prev=null;            
        }
        length--;
}
    public void removeAtLast(){
        if (length==0){
            System.out.println("Linked list is Empty");
        }else if (length==1){
            head=tail=null;
        }
        else {
            tail=tail.prev;
            tail.next=null;
        }
        length--;
    }
    public void removeAtpos(int item){
    if (length==0){
        System.out.println("Linked list is Empty");
    }else if (head.item==item){
        removeAtFirst();
    }else if (tail.item==item){
        removeAtLast();
    }
    else {
        node curr=head.next;
        while(curr !=null){
            if (curr.item==item){
                break;
             
            }
            curr=curr.next;
        }
        if (curr==null){
            System.out.println("elemnt not found");
        }else if (curr.next==null){
            removeAtLast();
        }else {
            curr.prev.next=curr.next;
            curr.next.prev=curr.prev;
            length--;
        }
    }
    }
    public void display(){
        node curr=head;
        while(curr !=null){
            System.out.print(curr.item+" ");
            
            curr=curr.next;
        }
        System.out.println();
    }
        public void reversDisplay(){
        node curr=tail;
        while(curr !=null){
            System.out.print(curr.item+" ");
            
            curr=curr.prev;
        }
        System.out.println();
    }
}
