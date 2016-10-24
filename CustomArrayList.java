import java.util.Collection;
import java.util.List;
public class CustomArrayList implements List<Object>{
  
  //Instance Variables
  private Object[] arr;
  private int length;
  
  //Constructor
  public CustomArrayList() {
    this.clear();
  }
  
  //Methods
  @Override
  public boolean add(Object o) {
    if (length == arr.length) {//make sure there's enough space
      increaseSize(2);
    }//add the thing
    arr[length] = o;
    length++;
    return true;
  }
  
  @Override
  public void add(int index, Object o) {
    if(index < 0){
      return;
    }
    if(length <= index){
      this.set(index, o);
      return;
    }
    add(get(size()-1));
    for(int i = size()-1; i > index+1; i++){
      arr[i] = arr[i-1];
    }
    arr[index] = o;
  }
  
  @Override
  public Object set(int index, Object o) {
    if(index < 0){
      return null;
    }
    while(index >= arr.length) {
      increaseSize(2);
    }
    Object toReturn = arr[index];
    arr[index] = o;
    if(index >= length)
      length = index+1;
    return toReturn;
  }
  
  @Override
  public Object get(int index) {
    return arr[index];
  }
  
  public List<Object> subList(int a, int b) {
    CustomArrayList tempCustom = new CustomArrayList();
    for(int i = a; i < b; i++) {
      tempCustom.add(this.get(i));
    }
    return tempCustom;
  }
  
  @Override
  public java.util.ListIterator<Object> listIterator(){
    throw new UnsupportedOperationException();
  }
  
  @Override
  public java.util.ListIterator<Object> listIterator(int startAt){
    throw new UnsupportedOperationException();
  }
  
  @Override
  public java.util.Iterator<Object> iterator(){
    return new CustomArrayList.Iterator(this);
  }
  
  @Override
  public int lastIndexOf(Object o){
    for(int i = this.size()-1; i >= 0; i--){
      if(o == this.get(i))
        return i;
    }
    return -1;
  }
  
  @Override
  public int indexOf(Object o){
    for(int i = 0; i < this.size(); i++){
      if(o == this.get(i))
        return i;
    }
    return -1;
  }
  
  @Override
  public Object remove(int index){
    if(index >= length || index < 0)
      return null;
    length--;
    Object toReturn = arr[index];
    for(int i = index; i < this.size(); i++) arr[i] = arr[i+1];
    return toReturn;
  }
  
  @Override
  public boolean remove(Object o){
    int index = indexOf(o);
    if(index == -1)
      return false;
    remove(index);
    return true;
  }
  
  @Override
  public void clear(){
    arr = new Object[10];
    length = 0;
  }
  
  @Override
  public boolean retainAll(Collection<?> coll){
    throw new UnsupportedOperationException();
  }
  
  @Override
  public boolean removeAll(Collection<?> coll){
    throw new UnsupportedOperationException();
  }
  
  @Override
  public boolean addAll(Collection<?> coll){
    for(Object o : coll){
      add(o);
    }
    return true;
  }
  
  @Override
  public boolean addAll(int index, Collection<?> coll){
    throw new UnsupportedOperationException();
  }
  
  @Override
  public boolean containsAll(Collection<?> coll){
    throw new UnsupportedOperationException();
  }
  
  @Override
  public Object[] toArray(){
    Object[] arrtemp = new Object[length];
    for(int i = 0; i < arr.length; i++) {
      arrtemp[i] = arr[i];
    }
    return arrtemp;
  }
  
  @Override
  public <T> T[] toArray(T[] a){
    throw new UnsupportedOperationException();
  }
  
  @Override
  public boolean contains(Object o){
    for(int i = 0; i < size(); i++){
      if(arr[i] == o) return true;
    }
    return false;
  }
  
  public String toString() {
    if(length==0)
      return "[]";
    String toReturn = "["+arr[0];
    for(int i=1; i < length; i++){
      toReturn+=", " + arr[i];
    }
    toReturn+= "]";
    return toReturn;
  }
  
  @Override
  public boolean isEmpty(){
    return this.size() == 0;
  }
  
  @Override
  public int size(){
    return this.length;
  }
  
  private void increaseSize(int factor) {
    Object[] arrtemp = new Object[length*factor];
    for(int i = 0; i < arr.length; i++) {
      arrtemp[i] = arr[i];
    }
    arr = arrtemp;
  }
  
  private class Iterator implements java.util.Iterator<Object>{
    CustomArrayList list;
    int i;
    
    private Iterator(CustomArrayList list){
      this.list = list;
      i = 0;
    }
    
    @Override
    public Object next(){
      if(!hasNext())
        return null;
      return list.get(i++);
    }
    
    @Override
    public boolean hasNext(){
      return i < list.size();
    }
    
    public void remove(){
      if(i >= 1 && i <= list.size()){
        list.remove(++i);
      }
    }
  }
  
}