package datastruct;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyUnsortedListTest{

    private UnsortedList<Integer> list;

    @BeforeEach
    public void setUp() throws Exception {
        list = MyUnsortedList.of();
    }

    @AfterEach
    public void CleanUp() throws Exception {
        list = null;
    }

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void size() {
        assertEquals(0, list.size());
        for(int i = 1; i < 100; i++) {
          list.append(i);
          assertEquals(i, list.size());
      }
    }

    @Test
    public void prepend() {
        for(int i = 0; i < 100; i++) {
            list.prepend(i);
        }

        for(int i = 99; i > 0; i--) {
            assertEquals(list.pop(), i);
        }
    }

    @Test
    public void append() {
        for(int i = 0; i < 100; i++) {
            list.append(i);
        }

        for(int i = 0; i < 100; i++) {
            assertEquals(list.pop(), i);
        }
    }

    @Test
    public void insertException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.insert(0, 1);
        });
    }

    @Test
    public void insert() {
        for(int i = 0; i < 5; i++)
            list.append(i);

        // test l'insertion en début et fin de liste
        list.insert(-1, 0);
        list.insert(-1, 6);
        assertEquals(list.pop(), -1);
        assertEquals(list.popLast(), -1);

        // teste l'insertion en milieu de liste
        list.insert(-1, 2);
        list.pop();
        list.pop();
        assertEquals(list.pop(), -1);
    }

    @Test
    public void popException() {
        assertThrows(EmptyListException.class, () -> {
            list.pop();
        });
    }

    @Test
    public void pop() {
        list.append(1);
        list.append(2);
        assertEquals(list.pop(), 1);
    }


    @Test
    public void popLastException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.popLast();
        });
    }

    @Test
    public void popLast() {
        list.append(1);
        list.append(2);
        assertEquals(list.popLast(), 2);
    }

    @Test
    public void removeException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(0);
        });
    }

    @Test
    public void remove() {
        list.append(1);
        assertEquals(list.remove(0), 1);
        assertTrue(list.isEmpty());

        for(int i = 0; i < 5; i++)
            list.append(i);

        assertEquals(list.remove(4), 4);
        assertEquals(list.remove(1), 1);
        assertEquals(list.remove(0), 0);
    }
}