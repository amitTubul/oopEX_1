package observer;


public class ConcreteMember implements Member{
    private GroupAdmin groupAdmin;
    private UndoableStringBuilder str;

    /**
     * ConcreteMember constructor
     */
    public ConcreteMember(){}

    /**
     * function used by the GroupAdmin to update a member
     * @param usb the UndoableStringBuilder object.
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.str=usb;
    }

    /**
     * sets a GroupAdmin to the ConcreteMember object
     * @param groupAdmin the member's GroupAdmin.
     */
    public void setGroupAdmin(GroupAdmin groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    /**
     * @return the ConcreteMember UndoableStringBuilder object.
     */
    public UndoableStringBuilder getStr() {
        return str;
    }
}
