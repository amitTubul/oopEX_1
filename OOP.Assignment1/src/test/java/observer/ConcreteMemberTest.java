package observer;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {
    public static final Logger logger = LoggerFactory.getLogger(ConcreteMemberTest.class);
    @Test
    void update() {
        ConcreteMember amit=new ConcreteMember();
        UndoableStringBuilder str=new UndoableStringBuilder();
        str.append("i love java");
        amit.update(str);
        assertEquals(amit.getStr().toString(),"i love java");
        logger.info(()-> JvmUtilities.objectFootprint(amit,str));

    }
}