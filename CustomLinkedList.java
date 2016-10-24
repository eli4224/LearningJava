public class CustomLinkedList{
  //Instance Variables
  Node root;
  int size;
  
  
  //Constructors
  public CustomLinkedList() {
    root = null;
    size = 0;
    
  }
  
  
  
  //Methods
  
  public void add(Object obj) {
    Node oldroot = root;
    root = new Node(obj);  
    root.next = oldroot;
    size++;
  }
  public Object get(int index){
    if(index >= size || index < 0) throw new IndexOutOfBoundsException(index.toString());
    Node tempnode = root;
    for(int i = 0; i < index; i++){
      tempnode = tempnode.next;  
    }
    return tempnode.value;
  }
  
  public void set(Object value, int index) {
    if(index >= size || index < 0) throw new IndexOutOfBoundsException(index.toString());
    Node tempnode = root;
    for(int i = 0; i < index; i++;) {
      tempnode = tempnode.next;
    }
    tempnode.value = value;
    return;
  }
  
  public void insert(Object value, int index) {
    if(index >= size || index < 0) throw new IndexOutOfBoundsException(index.toString());
    if(index = 0) {
      add(value);
      return;
    }
    Node tempnode = root;
    Node node = new Node(value);
    if(int i = 1; i < index; i++) {
      tempnode = tempnode.next;
    }
    node.next = tempnode.next;
    tempnode.next = node;
    size++;
    return;
  }
   //Anything else
  class Node{
    //Instance Variables
    Node next;
    Object value;
    
    //Constructor
    Node(Object value) {
      this.value = value;
      next = null;
    }
    
    
    //Methods
  }