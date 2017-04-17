package bg.softuni.repository;

import bg.softuni.staticData.ExceptionMessages;
import bg.softuni.io.OutputWriter;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class RepositoryFilter {
    public void printFilteredStudents(
            Map<String, Double> studentsWithMarks,
            String filterType,
            Integer numberOfStudents) {

        Predicate<Double> filter = createFilter(filterType);

        if (filter == null) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FILTER);
        }

        int studentsCount = 0;
        for (Map.Entry<String, Double> stringDoubleEntry : studentsWithMarks.entrySet()) {
            if (studentsCount >= numberOfStudents) {
                break;
            }

            if (filter.test(stringDoubleEntry.getValue())) {
                OutputWriter.printStudent(stringDoubleEntry.getKey(), stringDoubleEntry.getValue());
                studentsCount++;
            }
        }
    }

    private Predicate<Double> createFilter(String filterType) {
        switch (filterType) {
            case "excellent":
                return mark -> mark >= 5.0;
            case "average":
                return mark -> 3.5 <= mark && mark < 5.0;
            case "poor":
                return mark -> mark < 3.5;
            default:
                return null;
        }
    }
}

