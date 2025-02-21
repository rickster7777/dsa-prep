package Collections;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Reflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> int1 = new ArrayList<>(11);
        System.out.println("Size of int1 array list: " + int1.size());

        // Using reflection to access the "capacity"
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(int1);
        System.out.println("Capacity of int1 array list: " + elementData.length);
    }
}

// Exception in thread "main" java.lang.reflect.InaccessibleObjectException:
// Unable to make field transient \
// java.lang.Object[] java.util.ArrayList.elementData accessible: module
// java.base does not "opens java.util"
// to unnamed module @72ea2f77

/*
 * The InaccessibleObjectException you're encountering happens because, starting
 * from Java 9, the reflection system has been tightened under the module
 * system, and certain fields and methods are not accessible by default unless
 * the code is explicitly allowed to access them.
 * 
 * To avoid this issue, you have two potential solutions:
 * 
 * Solution 1: Using --add-opens JVM Argument
 * You can open the java.util package to the unnamed module by adding the
 * following argument when running your program:
 * 
 * --add-opens java.base/java.util=ALL-UNNAMED
 * For example, if you are running your program from the command line, you would
 * do:
 * 
 * java --add-opens java.base/java.util=ALL-UNNAMED YourMainClass
 * This will allow your code to access private fields using reflection, but keep
 * in mind that this is more of a workaround and can have security implications.
 * 
 */