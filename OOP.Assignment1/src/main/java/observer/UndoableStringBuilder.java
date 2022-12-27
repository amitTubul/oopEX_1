package observer;

/*
Use the class you've implemented in previous assignment
 */
import java.util.Stack;
/**
 * StringBuilder with undo support
 * java.lang.StringBuilder - class with modifier <b>final</b>,
 * so no inheritance, use delegation.
 */
import java.util.Stack;

/**
 * Matala0, extending Java StringBuilder class with undo() operation.
 * @author Israel Gitler & Amit Tubul.
 */


public class UndoableStringBuilder {
    /**
     * attributes-
     * myStack - a stack which holds all the strings who have been changed.
     * myString - a StringBuilder object.
     */
    private Stack<String> myStack;
    private StringBuilder myString;

    /**
     * UndoableStringBuilder constructor.
     */
    public UndoableStringBuilder(){
        this.myStack = new Stack<String>();
        this.myString = new StringBuilder();
    }

    /**
     * Appends the specified string to this character sequence.
     * @param str a string.
     * @return the class object after operation.
     */
    public UndoableStringBuilder append(String str){
        myStack.push(myString.toString());
        myString.append(str);

        return this;
    }

    /**
     * Removes the characters in a substring of this sequence. The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     * @param start The beginning index, inclusive.
     * @param end The ending index, exclusive.
     * @return the class object after operation.
     */
    public UndoableStringBuilder delete(int start, int end){
        try {
            myStack.push(myString.toString());
            myString.delete(start, end);
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println("Invalid operation --> " + e.getMessage());
        }

        return  this;
    }

    /**
     * Inserts the string into this character sequence.
     * @param offset the offset.
     * @param str a string.
     * @return the class object after operation.
     */
    public UndoableStringBuilder insert(int offset, String str){
        try {
            myStack.push(myString.toString());
            myString.insert(offset, str);
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println("Invalid operation --> " + e.getMessage());
        }
        return  this;
    }

    /**
     * Replaces the characters in a substring of this sequence with characters in
     * the specified String. The substring begins at the specified start and
     * extends to the character at index end - 1 or to the end of the sequence if
     * no such character exists. First the characters in the substring are removed
     * and then the specified String is inserted at start. (This sequence will be
     * lengthened to accommodate the specified String if necessary).
     * @param start The beginning index, inclusive.
     * @param end The ending index, exclusive.
     * @param str String that will replace previous contents.
     * @return the class object after operation.
     */

    public UndoableStringBuilder replace(int start,int end, String str){
        try{
            myStack.push(myString.toString());
            myString.replace(start, end, str);
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println("Invalid operation --> " + e.getMessage());
        }
        catch (NullPointerException e){
            System.out.println("Invalid operation --> " + e.getMessage());
        }
        return  this;
    }

    /**
     * Causes this character sequence to be replaced by the reverse of the
     * sequence.
     * @return the class object after operation.
     */
    public UndoableStringBuilder reverse(){
        myStack.push(myString.toString());
        myString.reverse();

        return this;
    }

    /**
     * toString method.
     * @return the class object string after operation.
     */
    public String toString (){
        return myString.toString();
    }

    /**
     * pop out the last string before the last operation and put it as a new
     * StringBuilder object into "myString".
     * @return the class object after operation.
     */

    public void undo() {
        if (!myStack.isEmpty()) {
            myString = new StringBuilder(myStack.pop());
        }
    }

}

