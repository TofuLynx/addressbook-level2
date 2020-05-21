package seedu.addressbook.data.person;

import org.junit.jupiter.api.Test;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.util.TestUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ReadOnlyPersonTest {
    @Test
    void getAsTextHidePrivate() {
        getPersonWithPublicPhoneWithoutTags();
        getPersonWithPublicEmailWithoutTags();
        getPersonWithPublicAddressWithoutTags();
        getPersonPrivateAttributesWithoutTags();
        getPersonPrivateAttributesWith1Tag();
        getPersonPrivateAttributesWith4Tags();
    }

    /***
     * Helper to append a person's tags to a given string builder
     * @author António Eloi
     * @date 13/05/2020
     * @param p Person to retrieve information from
     * @param str StringBuilder to append information
     */
    public void appendPersonTagsToStringBuilder(Person p, StringBuilder str) {
        for (Tag tag : p.getTags()) {
            str.append(tag);
        }
    }

    /***
     * Helper to append a person's name to a given string builder
     * @author António Eloi
     * @date 13/05/2020
     * @param p Person to retrieve information from
     * @param str StringBuilder to append information
     */
    public void appendPersonNameToStringBuilder(Person p, StringBuilder str) {
        str.append(p.getName());
    }

    /***
     * Helper to append a person's phone to a given string builder
     * @author António Eloi
     * @date 13/05/2020
     * @param p Person to retrieve information from
     * @param str StringBuilder to append information
     */
    public void appendPersonPhoneToStringBuilder(Person p, StringBuilder str) {
        str.append(" Phone: ").append(p.getPhone());
    }

    /***
     * Helper to append a person's email to a given string builder
     * @author António Eloi
     * @date 13/05/2020
     * @param p Person to retrieve information from
     * @param str StringBuilder to append information
     */
    public void appendPersonEmailToStringBuilder(Person p, StringBuilder str) {
        str.append(" Email: ").append(p.getEmail());
    }

    /***
     * Helper to append a person's address to a given string builder
     * @author António Eloi
     * @date 13/05/2020
     * @param p Person to retrieve information from
     * @param str StringBuilder to append information
     */
    public void appendPersonAddressToStringBuilder(Person p, StringBuilder str) {
        str.append(" Address: ").append(p.getAddress());
    }

    private void getPersonWithPublicPhoneWithoutTags() {
        boolean phonePrivate = false;
        boolean emailPrivate = true;
        boolean addressPrivate = true;
        Set<Tag> tags = null;
        Person p = TestUtil.generateTestPersonByAttributesPrivacy(phonePrivate, emailPrivate, addressPrivate, tags);

        StringBuilder builder = new StringBuilder();
        appendPersonNameToStringBuilder(p, builder);
        appendPersonPhoneToStringBuilder(p, builder);
        builder.append(" Tags: ");

        String expectedString = builder.toString();
        String actualString = p.getAsTextHidePrivate();

        assertEquals(expectedString,actualString, "String containing Name and Phone number wasn't the result");
    }

    private void getPersonWithPublicEmailWithoutTags() {
        boolean phonePrivate = true;
        boolean emailPrivate = false;
        boolean addressPrivate = true;
        Set<Tag> tags = null;
        Person p = TestUtil.generateTestPersonByAttributesPrivacy(phonePrivate, emailPrivate, addressPrivate, tags);

        StringBuilder builder = new StringBuilder();
        appendPersonNameToStringBuilder(p, builder);
        appendPersonEmailToStringBuilder(p, builder);
        builder.append(" Tags: ");

        String expectedString = builder.toString();
        String actualString = p.getAsTextHidePrivate();

        assertEquals(expectedString,actualString, "String containing Name and Email wasn't the result");
    }

    private void getPersonWithPublicAddressWithoutTags() {
        boolean phonePrivate = true;
        boolean emailPrivate = true;
        boolean addressPrivate = false;
        Set<Tag> tags = null;
        Person p = TestUtil.generateTestPersonByAttributesPrivacy(phonePrivate, emailPrivate, addressPrivate, tags);

        StringBuilder builder = new StringBuilder();
        appendPersonNameToStringBuilder(p, builder);
        appendPersonAddressToStringBuilder(p, builder);
        builder.append(" Tags: ");

        String expectedString = builder.toString();
        String actualString = p.getAsTextHidePrivate();

        assertEquals(expectedString,actualString, "String containing Name and Address wasn't the result");
    }

    private void getPersonPrivateAttributesWithoutTags() {
        boolean phonePrivate = true;
        boolean emailPrivate = true;
        boolean addressPrivate = true;
        Set<Tag> tags = null;
        Person p = TestUtil.generateTestPersonByAttributesPrivacy(phonePrivate, emailPrivate, addressPrivate, tags);

        StringBuilder builder = new StringBuilder();
        appendPersonNameToStringBuilder(p, builder);
        builder.append(" Tags: ");

        String expectedString = builder.toString();
        String actualString = p.getAsTextHidePrivate();

        assertEquals(expectedString,actualString, "String containing Name and Without Tags wasn't the result");
    }
    private void getPersonPrivateAttributesWith1Tag() {
        boolean phonePrivate = true;
        boolean emailPrivate = true;
        boolean addressPrivate = true;
        Set<Tag> tags = null;
        try {
            tags = new HashSet<>(Arrays.asList(new Tag("friend")));
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
        Person p = TestUtil.generateTestPersonByAttributesPrivacy(phonePrivate, emailPrivate, addressPrivate, tags);

        StringBuilder builder = new StringBuilder();
        appendPersonNameToStringBuilder(p, builder);
        builder.append(" Tags: ");
        appendPersonTagsToStringBuilder(p, builder);


        String expectedString = builder.toString();
        String actualString = p.getAsTextHidePrivate();

        assertEquals(expectedString,actualString, "String containing Name and Tags wasn't the result");
    }

    private void getPersonPrivateAttributesWith4Tags() {
        boolean phonePrivate = true;
        boolean emailPrivate = true;
        boolean addressPrivate = true;
        Set<Tag> tags = null;
        try {
            tags = new HashSet<>(Arrays.asList(new Tag("friend"), new Tag("12macacos"), new Tag("dei"), new Tag("uc")));
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
        Person p = TestUtil.generateTestPersonByAttributesPrivacy(phonePrivate, emailPrivate, addressPrivate, tags);

        StringBuilder builder = new StringBuilder();
        appendPersonNameToStringBuilder(p, builder);
        builder.append(" Tags: ");
        appendPersonTagsToStringBuilder(p, builder);


        String expectedString = builder.toString();
        String actualString = p.getAsTextHidePrivate();

        assertEquals(expectedString,actualString, "String containing Name and Tags wasn't the result");
    }
}
