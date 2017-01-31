package school.lemon.changerequest.java.io.pr1.task2;

import java.io.FileNotFoundException;

/**
 * Number swap engine
 */
public interface NumberSwapEngine {

    /**
     * Swap minimum and maximum element in file with comma-separated sequence of unsigned integers.
     * <p>
     * Expect that given file(if present in filesystem) will contain comma-separated sequence of unsigned integers in only one line.
     * <p>
     * Here is valid example of possible file content:
     * <pre>
     *     1 1,2,3,4,    7 ,    4 , 10,    0,    9999 ,  1,    0,       2
     *     2
     * </pre>
     * In the given example above there is only one maximum element that is equal to 9999
     * and possible two minimum elements that are equal to 0.
     *
     * In case you have got one maximum and more than one minimum element - swap maximum with the very <b>first</b> minimum element.
     * For the example above, the result should be:
     * <pre>
     *     1 1,2,3,4,    7 ,    4 , 10,    9999,     0,  1,    0,       2
     *     2
     * </pre>
     *
     * In case you have got one minimum and more than one maximum element - swap minimum with the <b>first</b> maximum element.
     * From:
     * <pre>
     *     1 1,2,2,3,4,9,5,6,9
     *     2
     * </pre>
     * To:
     * <pre>
     *     1 9,2,2,3,4,1,5,6,9
     *     2
     * </pre>
     *
     * In case you have got many minimum and many maximum elements - swap earlier minimum with earlier maximum element.
     * From:
     * <pre>
     *     1 1,1,2,3,4,9,5,6,9,9
     *     2
     * </pre>
     * To:
     * <pre>
     *     1 9,9,2,3,4,1,5,6,1,9
     *     2
     * </pre>
     * @param filename filename of file to check
     * @return true if anything was changed in the given file
     * @throws FileNotFoundException if file with given filename doesn't exist
     */
    boolean swapMinAndMax(String filename) throws FileNotFoundException;
}
