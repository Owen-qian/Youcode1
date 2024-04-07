package test;

import main.model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SkillTest {
    private Skill atk;
    private Skill def;
    private Skill hea;
    
    @BeforeEach
    public void runBefore() {
        atk = new Attack(0, 10, 2);
        def = new Defence(0, 0, 2);
        hea = new Healing(2);
    }

    @Test 
    public void constructorTest() {
        assertEquals(10, atk.getAmount(false));
        assertEquals(0, def.getAmount(false));
        assertEquals(20, hea.getAmount(false));
    }
}
