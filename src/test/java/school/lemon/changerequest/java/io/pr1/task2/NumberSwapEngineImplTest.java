package school.lemon.changerequest.java.io.pr1.task2;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumberSwapEngineImplTest {

    private static final String MIN_COUNT_MORE_THAN_MAX_FILE_PATH = "src/test/resources/task2/case1.dat";
    private static final String MIN_COUNT_EQUALS_TO_MAX_FILE_PATH = "src/test/resources/task2/case2.dat";
    private static final String MAX_COUNT_MORE_THAN_MIN_FILE_PATH = "src/test/resources/task2/case3.dat";
    private static final String WITH_ONE_NUMBER_FILE_PATH = "src/test/resources/task2/case4.dat";
    private static final String NON_EXISTING_FILE_PATH = "src/test/resources/task2/case-1.123";

    @Test
    public void testSwapWhenMinCountMoreThanMax() throws IOException {
        prepareFile(MIN_COUNT_MORE_THAN_MAX_FILE_PATH, "1,2,3,4,    7 ,    4 , 10,    0,    9999 ,  1,    0,       2");
        NumberSwapEngine numberSwapEngine = new NumberSwapEngineImpl();
        assertTrue(numberSwapEngine.swapMinAndMax(MIN_COUNT_MORE_THAN_MAX_FILE_PATH));
        verifyFile(MIN_COUNT_MORE_THAN_MAX_FILE_PATH,
                "1,2,3,4,    7 ,    4 , 10,    9999,    0 ,  1,    0,       2");
    }

    @Test
    public void testSwapWhenMaxCountMoreThanMin() throws IOException {
        prepareFile(MAX_COUNT_MORE_THAN_MIN_FILE_PATH,
                "   9999   ,2,3,9999,    7 ,    4 , 10,    0,    9999 ,  1,    0,       2");
        NumberSwapEngine numberSwapEngine = new NumberSwapEngineImpl();
        assertTrue(numberSwapEngine.swapMinAndMax(MAX_COUNT_MORE_THAN_MIN_FILE_PATH));
        verifyFile(MAX_COUNT_MORE_THAN_MIN_FILE_PATH,
                "   0   ,2,3,0,    7 ,    4 , 10,    9999,    9999 ,  1,    9999,       2");
    }

    @Test
    public void testSwapWhenMaxCountEqualsToMin() throws IOException {
        prepareFile(MIN_COUNT_EQUALS_TO_MAX_FILE_PATH,
                "   9999   ,2,3,4,    7 ,    4 , 10,    0,    9999 ,  1,    0,       2");
        NumberSwapEngine numberSwapEngine = new NumberSwapEngineImpl();
        assertTrue(numberSwapEngine.swapMinAndMax(MIN_COUNT_EQUALS_TO_MAX_FILE_PATH));
        verifyFile(MIN_COUNT_EQUALS_TO_MAX_FILE_PATH,
                "   0   ,2,3,4,    7 ,    4 , 10,    9999,    0 ,  1,    9999,       2");
    }

    @Test
    public void testSwapWhenNothingChanged() throws IOException {
        prepareFile(WITH_ONE_NUMBER_FILE_PATH, "   9999   ");
        NumberSwapEngine numberSwapEngine = new NumberSwapEngineImpl();
        assertFalse(numberSwapEngine.swapMinAndMax(WITH_ONE_NUMBER_FILE_PATH));
        verifyFile(WITH_ONE_NUMBER_FILE_PATH, "   9999   ");
    }

    @Test(expected = FileNotFoundException.class)
    public void testFileNotFound() throws IOException {
        NumberSwapEngine numberSwapEngine = new NumberSwapEngineImpl();
        numberSwapEngine.swapMinAndMax(NON_EXISTING_FILE_PATH);
    }

    private void verifyFile(String fileName, String line) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            assertEquals(line, reader.readLine());
        }
    }

    private void prepareFile(String fileName, String line) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(fileName)))) {
            writer.write(line);
            writer.newLine();
        }
    }


}
