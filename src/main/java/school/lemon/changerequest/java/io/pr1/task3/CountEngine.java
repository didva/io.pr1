package school.lemon.changerequest.java.io.pr1.task3;

import java.io.FileNotFoundException;

/**
 * Count engine
 */
public interface CountEngine {
    /**
     * Count amount of characters that are equal to given character 'c'
     * <p>
     * Only characters that are equal to character 'c' should be counted
     * <p>
     * Here is example of valid file content with 5 '@' characters:
     * <pre>
     *     1 Some line with only one 'at' character: @
     *     2
     *     3 No 'at' characters
     *     4 Ch@ngeRequest
     *     5 @@@
     * </pre>
     *
     * @param filename name of file to count characters in
     * @param c        character to be counted in file
     * @return amount of characters in the given file that are equal to 'c' or 0 if there are no such characters
     * @throws FileNotFoundException if file with given name wasn't found
     */
    long countSpecificCharacter(String filename, char c) throws FileNotFoundException;

    /**
     * Count amount of characters in file with given filename
     * <p>
     * Any characters should be applied
     *
     * @param filename name of file to count characters in
     * @return amount of characters in the given file or 0 if file is empty
     * @throws FileNotFoundException if file with given name wasn't found
     */
    long countCharacters(String filename) throws FileNotFoundException;

    /**
     * Count amount of words in file with given filename
     * <p>
     * We are assuming that word is sequence of characters that have more than one character of given character class: [a-zA-Z0-9]
     * and may have any amount of other characters except whitespaces.
     * <p>
     * Here is example of valid file content with 7 words:
     * <pre>
     *     1 F1rst l!ne h@ve f)ve words!!!! ! ! ! ! ! !
     *     2                        .. !
     *     3 6!
     *     4 this_is_the_last_word :-)
     * </pre>
     * So, from the example above, following are valid words:
     * <pre>
     *     F1rst
     *     l!ne
     *     h@ve
     *     f)ve
     *     words
     *     6!
     *     this_is_the_last_word
     * </pre>
     *
     * @param filename name of file to count words in
     * @return amount of words in the given file or 0 if there are no words in file
     * @throws FileNotFoundException if file with given name wasn't found
     */
    long countWords(String filename) throws FileNotFoundException;

    /**
     * Count amount of paragraphs in file with given filename
     * <p>
     * We are assuming that paragraphs are separated by 2(or more) empty lines.
     * We are also assuming that paragraph is a text, that have more than one word.
     * <p>
     * Here is example of valid file content with 3 paragraphs:
     * <pre>
     *     1 First paragraph line one.
     *     2 First paragraph line two.
     *     3
     *     4
     *     5 Second paragraph line one.
     *     6
     *     7 Second paragraph line three.
     *     8
     *     9
     *     10                  !!!!!!!!
     *     11
     *     12
     *     13 Third paragraph line one.
     *     14
     *     15
     *     16
     *     17
     *     18
     * </pre>
     * For the example above function should return 3.
     * <p>
     * Here is example of valid file content with 0 paragraphs:
     * <pre>
     *     1 @!#$%^&*!
     *     2 ((@
     *     3 ;;:'
     *     4
     *     5 '!
     * </pre>
     *
     * @param filename name of file to count paragraphs in
     * @return amount of paragraphs in the given file or 0 if there are no paragraphs in file
     * @throws FileNotFoundException if file with given name wasn't found
     */
    long countParagraphs(String filename) throws FileNotFoundException;
}
