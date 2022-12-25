package observer;


public class ConcreteMember implements Member{
    private GroupAdmin groupAdmin;
    private UndoableStringBuilder str;

    //empty constructor
    public ConcreteMember(){}

    @Override
    public void update(UndoableStringBuilder usb) {
        this.str=usb;
    }

    public void setGroupAdmin(GroupAdmin groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    public UndoableStringBuilder getStr() {
        return str;
    }
}
