package skypro.algorithmshwp2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringListImplTest {
    StringListImpl out;
    String act;
    String exp;

    @BeforeEach
    void setUp() {
        out = new StringListImpl(5);
        out.add("One");
        out.add("Two");
        out.add("Three");
        out.add("Four");
    }

    @Test
    void shouldReturnCorrectResultOfAdditionTest() {
        act = out.add("Five");
        exp = "Five";
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfAdditionByIndexTest() {
        act = out.add(2, "Five");
        exp = "Five";
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfSettingTest() {
        act = out.set(1, "Three");
        exp = "Three";
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfRemovingTest() {
        act = out.remove("One");
        exp = "One";
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfRemovingByIndexTest() {
        act = out.remove(0);
        exp = "One";
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfContainingTest() {
        Boolean act = out.contains("One");
        Boolean exp = true;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfIndexOfTest() {
        int act = out.indexOf("One");
        int exp = 0;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfLastIndexOfTest() {
        int act = out.lastIndexOf("Ten");
        int exp = -1;
        assertEquals(exp, act);
        act = out.lastIndexOf("One");
        exp = 0;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfGettingTest() {
        act = out.get(2);
        exp = "Three";
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfEqualityTest() {
        Boolean act = out.equals(out);
        Boolean exp = true;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfSizeTest() {
        int act = out.size();
        int exp = 4;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfIsEmptyTest() {
        Boolean act = out.isEmpty();
        Boolean exp = false;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfClearingTest() {
        out.clear();
        int act = out.size();
        int exp = 0;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfToArrayTest() {
        act = Arrays.toString(out.toArray());
        exp = "[One, Two, Three, Four]";
        assertEquals(exp, act);
    }

    @Test
    void shouldThrowItemNotFoundExceptionTest() {
        assertThrows(ItemNotFoundException.class, () -> out.remove("Six"));
    }

    @Test
    void shouldThrowIndexOutOfBoundExceptionTest() {
        assertThrows(IndexOutOfBoundException.class, () -> out.remove(-1));
    }

    @Test
    void shouldThrowNullArgumentExceptionTest() {
        out.clear();
        assertThrows(NullArgumentException.class, () -> out.add(""));
    }

    @Test
    void shouldThrowSizeOutOfBoundExceptionTest() {
        out.add("Five");
        assertThrows(SizeOutOfBoundException.class, () -> out.add("Six"));
    }
}