package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {

    @Test
    void update() {
        ConcreteMember amit=new ConcreteMember();
        UndoableStringBuilder str=new UndoableStringBuilder();
        str.append("i love java");
        amit.update(str);
        assertEquals(amit.getStr().toString(),"i love java");
    }
}