package observer;

import java.util.ArrayList;


public class GroupAdmin implements Sender{

    private UndoableStringBuilder str;
    private ArrayList<ConcreteMember> members;


    /**
     * GroupAdmin constructor.
     */
    public GroupAdmin(){
        this.str=new UndoableStringBuilder();
        this.members=new ArrayList<>();
    }


    /**
     * this function registers a member to the GroupAdmin by adding it to the members ArrayList
     * @param obj the member object that register.
     */
    @Override
    public void register(Member obj) {
        ConcreteMember member=(ConcreteMember) obj;
        if(members.contains(member))return;
        members.add(member);
        member.setGroupAdmin(this);
        member.update(this.str);
    }

    /**
     * this function unregisters a registered member of GroupAdmin by removing it from the members ArrayList
     * @param obj the member object that unregister.
     */
    @Override
    public void unregister(Member obj) {
        ConcreteMember member=(ConcreteMember)obj;
        if(!members.contains(member))return;
        members.remove(member);
        member.setGroupAdmin(null);
        member.update(null);
    }

    /**
     * Inserts a string into the GroupAdmin UndoableStringBuilder object
     * @param offset the offset.
     * @param obj a string .
     */
    @Override
    public void insert(int offset, String obj) {
        str.insert(offset,obj);
        notifyMembers();
    }

    /**
     * Appends the specified string to the GroupAdmin UndoableStringBuilder object
     * @param obj a string.
     */
    @Override
    public void append(String obj) {
        str.append(obj);
        notifyMembers();
    }

    /**
     * Removes the characters in a substring of this sequence. The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     * @param start The beginning index, inclusive.
     * @param end The ending index, exclusive.
     */
    @Override
    public void delete(int start, int end) {
        str.delete(start,end);
        notifyMembers();
    }

    /**
     * pop out the last string before the last operation and put it in the
     * GroupAdmin UndoableStringBuilder object .
     */
    @Override
    public void undo() {
        str.undo();
        notifyMembers();
    }

    /**
     * @return the members ArrayList.
     */
    public ArrayList<ConcreteMember> getMembers() {
        return members;
    }

    /**
     * @return the UndoableStringBuilder object.
     */
    public UndoableStringBuilder getStr() {
        return str;
    }

    /**
     * notify all members when an update occurs in the GroupAdmin UndoableStringBuilder object.
     */
    public void notifyMembers(){
        for (ConcreteMember member:members) {
            member.update(this.str);
        }
    }
}
