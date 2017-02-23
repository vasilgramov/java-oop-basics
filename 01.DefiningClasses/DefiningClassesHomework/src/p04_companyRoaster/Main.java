package p04_companyRoaster;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, List<Employee>> employeesByDepartmen = new LinkedHashMap<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] employeeArgs = in.nextLine().split("\\s+");

            String name = employeeArgs[0];
            double salary = Double.parseDouble(employeeArgs[1]);
            String position = employeeArgs[2];
            String department = employeeArgs[3];

            Employee employee = new Employee(name, salary, position, department);

            if (employeeArgs.length == 5) {
                Pattern pattern = Pattern.compile("^\\d+$");

                String token = employeeArgs[4];
                Matcher matcher = pattern.matcher(token);

                if (matcher.find()) {
                    employee.setAge(Integer.parseInt(token));
                } else {
                    employee.setEmail(token);
                }
            }

            if (employeeArgs.length == 6) {
                employee.setEmail(employeeArgs[4]);
                employee.setAge(Integer.parseInt(employeeArgs[5]));
            }

            if (!employeesByDepartmen.containsKey(department)) {
                List<Employee> employees = new ArrayList<>();
                employees.add(employee);
                employeesByDepartmen.put(department, employees);
            } else {
                List<Employee> employees = employeesByDepartmen.get(department);
                employees.add(employee);
                employeesByDepartmen.put(department, employees);
            }
        }

        employeesByDepartmen.entrySet().stream()
                .sorted((d1, d2) -> Double.compare(
                        (d2.getValue().stream().mapToDouble(e -> e.getSalary()).sum() / d2.getValue().size()),
                        (d1.getValue().stream().mapToDouble(e -> e.getSalary()).sum() / d1.getValue().size())))
                .limit(1)
                .forEach(d -> {
                    System.out.println("Highest Average Salary: " + d.getKey());

                    d.getValue().stream()
                            .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                            .forEach(e -> {
                                System.out.println(e);
                            });
                });
    }
}
