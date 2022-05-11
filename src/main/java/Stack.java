import java.util.LinkedList;
import java.util.List;

public class Stack {

    private List<String> basket;
    private int limit;

    public Stack(int limit) {
        if (limit < 0){
            throw new StackIllegalCapacityException("Illegal Capacity! stack cannot take negative size");
        }
        this.limit = limit;
        this.basket = new LinkedList<>();
    }

    public int getSize() {
        return basket.size();
    }

    public void push(String element) {
        if (basket.size() >= limit){
            throw new StackOverflowException("You passed the limit of stack which is "+ limit);
        }
        if (basket.contains(element)){
            throw new StackUniqueException("Duplicated Set element is in stack");
        }
        basket.add(element);
    }

    public void pop() {
        if (basket.size() <= 0){
            throw new StackUnderflowException("You passed the limit of stack which is "+ lastIndex());
        }
        basket.remove(lastIndex());
    }

    private int lastIndex() {
        return basket.size()!=0 ? basket.size()-1 : 0;
    }

    public String top() {
        if (basket.size() == 0){
            throw new StackEmptyException("You passed the limit of stack which is " + lastIndex());
        }
        return basket.get(lastIndex());
    }

    public List getElements() {
        return basket;
    }

    public boolean isEmpty() {
        return basket.isEmpty();
    }

    public Integer find(String element) {
        Integer index = basket.indexOf(element);
        if (index == -1){
           index = null;
        }
        return index;
    }
}
