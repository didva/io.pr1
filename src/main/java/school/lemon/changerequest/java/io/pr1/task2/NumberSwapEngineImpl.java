package school.lemon.changerequest.java.io.pr1.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class NumberSwapEngineImpl implements NumberSwapEngine {

    private static final String SEPARATOR = ",";

    @Override
    public boolean swapMinAndMax(String filename) throws FileNotFoundException {
        String line = readLine(filename);
        if (line == null || line.trim().isEmpty()) {
            return false;
        }

        String[] stringValues = line.split(SEPARATOR);
        int[] intValues = getIntValues(stringValues);
        int[] minIndexes = getMinIndexes(intValues);
        int[] maxIndexes = getMaxIndexes(intValues);
        swapByIndexes(stringValues, intValues, minIndexes, maxIndexes);
        String result = String.join(SEPARATOR, stringValues);

        return !Objects.equals(line, result) && writeLine(filename, result);
    }

    private boolean writeLine(String fileName, String line) throws FileNotFoundException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {
            writer.write(line);
            writer.newLine();
            return true;
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            return false;
        }
    }

    private void swapByIndexes(String[] stringValues, int[] intValues, int[] minIndexes, int[] maxIndexes) {
        int indexesCount = Math.min(minIndexes.length, maxIndexes.length);
        for (int i = 0; i < indexesCount; i++) {
            int minIndex = minIndexes[i];
            int maxIndex = maxIndexes[i];
            stringValues[minIndex] = stringValues[minIndex].replaceAll("\\d+", String.valueOf(intValues[maxIndex]));
            stringValues[maxIndex] = stringValues[maxIndex].replaceAll("\\d+", String.valueOf(intValues[minIndex]));
        }
    }

    private int[] getMinIndexes(int[] intValues) {
        int minValue = intValues[0];
        int minValuesCount = 1;
        for (int i = 1; i < intValues.length; ++i) {
            if (intValues[i] < minValue) {
                minValue = intValues[i];
                minValuesCount = 1;
            } else if (intValues[i] == minValue) {
                ++minValuesCount;
            }
        }

        return getValueIndexes(minValue, intValues, minValuesCount);
    }

    private int[] getMaxIndexes(int[] intValues) {
        int maxValue = intValues[0];
        int maxValuesCount = 1;
        for (int i = 1; i < intValues.length; ++i) {
            if (intValues[i] > maxValue) {
                maxValue = intValues[i];
                maxValuesCount = 1;
            } else if (intValues[i] == maxValue) {
                ++maxValuesCount;
            }
        }
        return getValueIndexes(maxValue, intValues, maxValuesCount);
    }

    private int[] getValueIndexes(int value, int[] intValues, int valuesCount) {
        int[] indexes = new int[valuesCount];
        for (int i = 0, j = 0; i < intValues.length; ++i) {
            if (intValues[i] == value) {
                indexes[j++] = i;
            }
        }
        return indexes;
    }

    private int[] getIntValues(String[] stringValues) {
        int[] intValues = new int[stringValues.length];
        for (int i = 0; i < stringValues.length; i++) {
            intValues[i] = Integer.parseInt(stringValues[i].trim());
        }
        return intValues;
    }

    private String readLine(String fileName) throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            return reader.readLine();
        } catch (FileNotFoundException ex) {
            throw ex;
        } catch (IOException e) {
            System.out.println("IOException occurs while reading file: " + fileName);
            e.printStackTrace();
            return null;
        }
    }

}
