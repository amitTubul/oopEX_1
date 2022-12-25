package observer;

import java.util.ArrayList;


public class GroupAdmin implements Sender{

    private UndoableStringBuilder str;
    private ArrayList<ConcreteMember> members;

    //constructor
    public GroupAdmin(){
        this.str=new UndoableStringBuilder();
        this.members=new ArrayList<>();
    }
    @Override
    public void register(Member obj) {
        ConcreteMember member=(ConcreteMember) obj;
        members.add(member);
        member.setGroupAdmin(this);
        member.update(this.str);
    }

    @Override
    public void unregister(Member obj) {
        ConcreteMember member=(ConcreteMember)obj;
        members.remove(member);
        member.setGroupAdmin(null);
        member.update(null);
    }

    @Override
    public void insert(int offset, String obj) {
        str.insert(offset,obj);
    }

    @Override
    public void append(String obj) {
        str.append(obj);
    }

    @Override
    public void delete(int start, int end) {
        str.delete(start,end);
    }

    @Override
    public void undo() {
        str.undo();
    }

    public ArrayList<ConcreteMember> getMembers() {
        return members;
    }

    public UndoableStringBuilder getStr() {
        return str;
    }
}
