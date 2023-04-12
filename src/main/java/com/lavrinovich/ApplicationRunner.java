package com.lavrinovich;

import java.util.List;
import java.util.stream.Collectors;

public class ApplicationRunner {

    public static int getSum(Employee employee) {
        return employee.getTasks()
                .stream()
                .filter(task -> task.getStatus().equals(Status.COMPLETED))
                .mapToInt(Task::getPoint)
                .sum();
    }

    public static void main(String[] args) {
        // result: Map<String, Int> name of employees who has points > 1k / points
        List<Employee> employees = initEmployees();
        employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        ApplicationRunner::getSum
                ))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1000)
                //.sorted(Comparator.comparingInt(Map.Entry::getValue))
                //.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                //.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                //.limit(2)
                .forEach(System.out::println);
    }

    private static List<Employee> initEmployees() {
        return List.of(
                new Employee("Alex", List.of(
                        new Task("a", 400, Status.COMPLETED),
                        new Task("b", 400, Status.FAILED),
                        new Task("c", 4100, Status.COMPLETED)
                )),
                new Employee("Dima", List.of(
                        new Task("a", 100, Status.OPEN),
                        new Task("b", 100, Status.COMPLETED),
                        new Task("c", 4400, Status.COMPLETED)
                )),
                new Employee("Mandarina", List.of(
                        new Task("a", 200, Status.COMPLETED),
                        new Task("b", 400, Status.COMPLETED),
                        new Task("c", 600, Status.COMPLETED)
                )),
                new Employee("Apelsina", List.of(
                        new Task("a", 400, Status.COMPLETED),
                        new Task("b", 400, Status.COMPLETED),
                        new Task("c", 400, Status.COMPLETED)
                )),
                new Employee("Masha", List.of(
                        new Task("a", 400, Status.COMPLETED),
                        new Task("b", 300, Status.COMPLETED),
                        new Task("c", 200, Status.COMPLETED)
                )),
                new Employee("Kseniya", List.of(
                        new Task("a", 400, Status.COMPLETED),
                        new Task("b", 400, Status.OPEN),
                        new Task("c", 400, Status.FAILED)
                )));
    }
}
