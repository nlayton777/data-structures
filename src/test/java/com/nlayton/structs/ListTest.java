package com.nlayton.structs;

import static com.nlayton.NickMatchers.isFalse;
import static com.nlayton.NickMatchers.isTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

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
        list.remove(1);
        assertThat(list.contains(1), isFalse());
    }

    @Test
    public void iterator() {
        fail();
    }

    @Test
    public void toArray() {
        list.addAll(Arrays.asList(1, 2, 3, 4, 5));
        final Object[] a = list.toArray();
        assertThat(a, arrayContaining(1, 2, 3, 4, 5));
    }

    @Test
    public void testToArray() {
        list.addAll(Arrays.asList(5,6,7,8,9));
        final int[] a = list.toArray(new int[]);
        assertThat(a, arrayContaining(5,6,7,8,9));
    }

    @Test
    public void add() {
        assertThat(list.add(1), isTrue());
        assertThat(list.size(), is(1));
        assertThat(list.add(1), isTrue());
        assertThat(list.size(), is(2));
    }

    @Test(expected = NullPointerException.class)
    public void addNull() {
        list.add(null);
    }

    @Test
    public void remove() {
        fail();
    }

    @Test
    public void containsAll() {
        fail();
    }

    @Test
    public void addAll() {
        fail();
    }

    @Test
    public void testAddAll() {
        fail();
    }

    @Test
    public void removeAll() {
        fail();
    }

    @Test
    public void retainAll() {
        fail();
    }

    @Test
    public void clear() {
        fail();
    }

    @Test
    public void get() {
        fail();
    }

    @Test
    public void set() {
        fail();
    }

    @Test
    public void testAdd() {
        fail();
    }

    @Test
    public void testRemove() {
        fail();
    }

    @Test
    public void indexOf() {
        fail();
    }

    @Test
    public void lastIndexOf() {
        fail();
    }

    @Test
    public void listIterator() {
        fail();
    }

    @Test
    public void testListIterator() {
        fail();
    }

    @Test
    public void subList() {
        fail();
    }
}