package seedu.addressbook.common;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        /* TEST STARTS HERE */

        //testEmptyCollection();
        ArrayList<String> emptyCollection = new ArrayList<>();
        assertEquals(true, Utils.elementsAreUnique(emptyCollection), "Expected for an empty collection to assert all ellements are unique");

        //testCollectionWith2ItemsNotUnique();
        ArrayList<String> items1 = new ArrayList<>();
        items1.add("item1");
        items1.add("item1");
        assertEquals(false, Utils.elementsAreUnique(items1), "Expected for an collection of two items with two duplicate elements to assert elements are not unique");

        //testCollectionWith4Items2NotUnique();
        ArrayList<String> items2 = new ArrayList<>();
        items2.add("item1");
        items2.add("item3");
        items2.add("item4");
        items2.add("item1");
        assertEquals(false, Utils.elementsAreUnique(items2), "Expected for an collection of four items with two duplicate elements to assert elements are not unique");

        //testCollectionWith1Item();
        ArrayList<String> items3 = new ArrayList<>();
        items3.add("item1");
        assertEquals(true, Utils.elementsAreUnique(items3), "Expected for an collection with one elements to assert elements are unique");

        //testCollectionWith2ItemUnique();
        ArrayList<String> items4 = new ArrayList<>();
        items4.add("item1");
        items4.add("item2");
        assertEquals(true, Utils.elementsAreUnique(items4), "Expected for an collection with two unique elements to assert elements are unique");

        //testCollectionWith4ItemUnique();
        ArrayList<String> items5 = new ArrayList<>();
        items5.add("item1");
        items5.add("item2");
        items5.add("item3");
        items5.add("item4");
        assertEquals(true, Utils.elementsAreUnique(items5), "Expected for an collection with four unique elements to assert elements are unique");
        /* TEST ENDS HERE */

        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, Integer.valueOf(1));
        assertNotUnique(null, 1, Integer.valueOf(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    @Test
    public void isAnyNull() {
        // no items
        assertFalse(Utils.isAnyNull());

        // varargs array that is null (i.e. no array)
        assertFalse(Utils.isAnyNull((Object[]) null));

        // one item which is null (i.e. an array with one null item)
        assertTrue(Utils.isAnyNull((Object) null));

        // at least one item, none of which are null
        assertFalse(Utils.isAnyNull("A"));
        assertFalse(Utils.isAnyNull("A", ""));
        assertFalse(Utils.isAnyNull(1, 2, "C"));

        // at least one item, some of which are null
        assertTrue(Utils.isAnyNull(null, 1));
        assertTrue(Utils.isAnyNull("A", null, "C"));
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
