package util;

/**
 * @author Petteri Salonurmi
 *
 * StringUtility
 * Utilities for the String class
 *
 */
public class StringUtility {

    /**
     * isStringNotNullAndEmpty
     * A String utility for checking of the given String is empty or null.
     *
     * @param stringToBeChecked - The String to be checked.
     * @return true/false, depending on if the String was empty, null or valid.
     */
    public boolean isStringNotNullAndEmpty(String stringToBeChecked) {
        return (stringToBeChecked != null && !stringToBeChecked.isEmpty());
    }

}
