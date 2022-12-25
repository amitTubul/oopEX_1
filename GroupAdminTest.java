package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {

    @Test
    void register() {
        GroupAdmin admin=new GroupAdmin();
        ConcreteMember amit=new ConcreteMember();
        ConcreteMember israel=new ConcreteMember();
        admin.register(amit);
        admin.register(israel);
        assertEquals(2,admin.getMembers().size());
    }

    @Test
    void unregister() {
        GroupAdmin admin=new GroupAdmin();
        ConcreteMember amit=new ConcreteMember();
        ConcreteMember israel=new ConcreteMember();
        admin.register(amit);
        admin.register(israel);
        admin.unregister(amit);
        admin.unregister(israel);
        assertEquals(0,admin.getMembers().size());
    }

    @Test
    void insert() {
        GroupAdmin admin=new GroupAdmin();
        admin.insert(0,"we are the champions");
        assertEquals(admin.getStr().toString(),"we are the champions");
    }

    @Test
    void append() {
        GroupAdmin admin=new GroupAdmin();
        admin.append("we are the champions");
        assertEquals(admin.getStr().toString(),"we are the champions");
    }

    @Test
    void delete() {
        GroupAdmin admin=new GroupAdmin();
        admin.append("we are the champions");
        admin.delete(0,7);
        assertEquals(admin.getStr().toString(),"the champions");
    }

    @Test
    void undo() {
        GroupAdmin admin=new GroupAdmin();
        admin.append("we are the champions");
        admin.undo();
        assertEquals(admin.getStr().toString(),"");
        admin.append("we are the champions");
        admin.delete(0,7);
        admin.undo();
        assertEquals(admin.getStr().toString(),"we are the champions");
        admin.undo();
        assertEquals(admin.getStr().toString(),"");

    }
}