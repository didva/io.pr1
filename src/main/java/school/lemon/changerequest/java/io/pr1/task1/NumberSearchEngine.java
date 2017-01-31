package school.lemon.changerequest.java.io.pr1.task1;

import java.io.FileNotFoundException;

/**
 * Number search engine
 */
public interface NumberSearchEngine {
    /**
     * Determine whether given file has number with given index.
     * <p>
     * Expect that given file(if present in filesystem) will have only one unsigned integer per line.
     * <p>
     * Here is valid example of possible file content:
     * <pre>
     *     1    5775
     *     2    0
     *     3
     *     4    555
     *     5    111
     *     6
     *     7    9
     *     8
     *     9    1
     *     10   111111
     * </pre>
     * In the given example above there are numbers with indexes: [1,2,4,5,7,9,10] and there are no numbers with index [3,6,8]
     *
     * @param filename filename of file to check
     * @param index    index of number to check (index starts from 1)
     * @return true, if number with given index exists in the file
     * @throws IndexOutOfBoundsException if given index in negative or 0
     * @throws FileNotFoundException     if no file with given filename exists
     */
    boolean hasNumberWithIndex(String filename, int index) throws FileNotFoundException, IndexOutOfBoundsException;
}
