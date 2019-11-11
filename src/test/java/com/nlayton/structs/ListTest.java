package com.nlayton.structs;

import static com.nlayton.NickMatchers.isFalse;
import static com.nlayton.NickMatchers.isTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author nick.layton
 * @since Nov-2019
 */
@RunWith(Parameterized.class)
public class ListTest {

    @Rule
    public final TestName testName = new TestName();

    private List<Integer> list;

    public ListTest(final List<Integer> list) {
        this.list = list;
    }

    @Parameters(name = "{0}")
    public static Object[] getParameters() {
        return new Object[]{
                NickLists.linkedList()
        };
    }

    @Test
    public void size() {
        assertThat(list.size(), is(0));
        list.add(1);
        list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        assertThat(list.size(), is(9));
        list.remove(2);
        assertThat(list.size(), is(8));
    }

    @Test
    public void isEmpty() {
        assertThat(list.isEmpty(), isTrue());
        list.add(1);
        assertThat(list.isEmpty(), isFalse());
        list.remove(1);
        assertThat(list.isEmpty(), isTrue());
    }

    @Test
    public void contains() {
        assertThat(list.contains(1), isFalse());
        list.add(1);
        assertThat(list.contains(1), isTrue());
    }

    @Test
    public void iterator() {
    }

    @Test
    public void toArray() {
    }

    @Test
    public void testToArray() {
    }

    @Test
    public void add() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void containsAll() {
    }

    @Test
    public void addAll() {
    }

    @Test
    public void testAddAll() {
    }

    @Test
    public void removeAll() {
    }

    @Test
    public void retainAll() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void get() {
    }

    @Test
    public void set() {
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void testRemove() {
    }

    @Test
    public void indexOf() {
    }

    @Test
    public void lastIndexOf() {
    }

    @Test
    public void listIterator() {
    }

    @Test
    public void testListIterator() {
    }

    @Test
    public void subList() {
    }
}