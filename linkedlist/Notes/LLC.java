package linkedlist.Notes;
import java.util.*;

public class LLC {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.addFirst("a");    
        list.addFirst("is");
        
        list.add("list");

        list.addFirst("This");
        

        System.out.println(list);
        System.out.println(list.size());

        for(int i = 0; i < list.size(); i++){
            //In case you of searching an element.
            // if(value == get(i))
            System.out.print(list.get(i)+ " -> ");
        }
        System.out.println("null");
    }
}
