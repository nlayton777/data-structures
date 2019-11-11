package com.nlayton;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * @author nick.layton
 * @since Nov-2019
 */
public class NickMatchers {

    private NickMatchers() {
        // no init
    }

    public static Matcher<Boolean> isTrue() {
        return new TypeSafeMatcher<Boolean>() {
            @Override
            protected boolean matchesSafely(final Boolean item) {
                return Boolean.TRUE.equals(item);
            }

            @Override
            public void describeTo(final Description description) {
                description.appendValue("Expected true");
            }
        };
    }

    public static Matcher<Boolean> isFalse() {
        return new TypeSafeMatcher<Boolean>() {
            @Override
            protected boolean matchesSafely(final Boolean item) {
                return Boolean.FALSE.equals(item);
            }

            @Override
            public void describeTo(final Description description) {
                description.appendValue("Expected true");
            }
        };
    }
}
