package interview.asked;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Java Streams in-practice
public class StreamAPI {

    static class Employee {

        private int id;
        private String name;
        private int age;
        private int salary;
        private String city;

        public Employee(int id, String name, int age, int salary, String city) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.city = city;
        }
        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getSalary() {
            return salary;
        }

        public String getCity() {
            return city;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    ", city='" + city + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Employee)) return false;
            Employee employee = (Employee) o;
            return getCity().equals(employee.getCity());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getCity());
        }
    }

    public static void main(String[] args) {
        int k = 3;
        Employee e1 = new Employee(1, "mani", 23, 12000, "HYD");
        Employee e2 = new Employee(2, "nish", 26, 14400, "HYD");
        Employee e3 = new Employee(3, "fgtr", 24, 12070, "MBI");
        Employee e4 = new Employee(4, "jhyu", 33, 12900, "DBG");
        List<Employee> listEmp = new ArrayList(){{
            add(e1);
            add(e2);
            add(e3);
            add(e4);
        }};
        findMaxSalary(listEmp);
        sortByName(listEmp);
        sortByAge(listEmp);
        sortBySalary(listEmp);
        kthHighestSalary(k, listEmp);
        //
        List<Integer> listInt = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4);
        totalSum(listInt);
        totalSumOfEvenNumbers(listInt);
        countEvenNumber(listInt);
        squareOfEachElement(listInt);
        findOccurrenceOfListInteger(listInt);
        findMaxOccurrenceOfListInteger(listInt);

        List<String> listStr = Arrays.asList("manish", "nishant", "amit", "anish", "deepak", "raman");
        countStringGreaterThanKLength(listStr);

        groupByCity(listEmp);
        concateListOfString(listStr);

        distinctObjByCity(listEmp);

        convertListToMap(listStr);

        List<Integer> list2 = Arrays.asList(6,7,8,5);
        findIntersectionOfTwoList(listInt, list2);

        // check string is ascending/lexi order or not
        String[] S = {"abc", "abcd", "ab", "afg", "adb", null, ""};
        for (String str : S)
            isAscendingOrder(str);

        // Adjacent Pairs
        int[] arr = {1,2,3,4,5};
        adjacentPairs(arr);

        //
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "manish");
        map.put(2, "mani");
        map.put(3, "amit");
        map.put(4, "nishant");
        map.put(5, "kunal");
        sortMapByValue(map);

    }

    private static void distinctObjByCity(List<Employee> listEmp) {
        Set<String> set = new HashSet<>(listEmp.size());
        System.out.println("Filter duplicate Object : I : " +
                listEmp.stream()
                .filter(e -> set.add(e.getCity()))
                .collect(Collectors.toList()));
        System.out.println("Filter duplicate Object : II : " +
                listEmp.stream()
                .collect(Collectors.groupingBy(Employee::getCity))
                .values()
                .stream()
                .map(e -> e.get(0))
                .collect(Collectors.toList()));
        System.out.println("Filter duplicate Object : III : " +
                listEmp.stream()
                .distinct()
                .collect(Collectors.toList()));
    }

    private static void concateListOfString(List<String> listStr) {
        System.out.println("Concatenate all the strings in a list : I : " +
                listStr.stream()
                .collect(Collectors.joining(",")));
        System.out.println("Concatenate all the strings in a list : II : " +
                listStr.stream()
                .reduce("", (a, b) -> a.concat(b)));
    }

    private static void groupByCity(List<Employee> listEmp) {
        System.out.println("Group By City : " +
                listEmp.stream()
                .collect(Collectors.groupingBy(Employee::getCity, Collectors.counting())));
    }

    private static void countStringGreaterThanKLength(List<String> listStr) {
        System.out.println("Total Strings which length has greater than 5 : " +
                listStr.stream()
                .filter(e -> e.length() > 5)
                .count());
    }

    private static void findOccurrenceOfListInteger(List<Integer> listInt) {
        System.out.println("Occurrence of element : " + listInt.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

    private static void findMaxOccurrenceOfListInteger(List<Integer> listInt) {
        System.out.println("Max Occurrence of element : " + listInt
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null));
    }

    private static void squareOfEachElement(List<Integer> listInt) {
        System.out.println("Square of each element : " + listInt.stream()
                .map(n -> n * n)
                .collect(Collectors.toList()));
    }

    private static void countEvenNumber(List<Integer> listInt) {
        System.out.println("Total Even Numbers : " + listInt.stream()
                .filter(e -> e % 2 == 0)
                .count());
    }

    private static void totalSumOfEvenNumbers(List<Integer> listInt) {
        System.out.println("Total Sum of Even Number Way I : " + listInt.stream()
                .filter(e -> e % 2 == 0)
                .reduce(0, (a, b) -> a + b)
                .intValue());
        System.out.println("Total Sum of Even Number Way II : " + listInt.stream()
                .filter(e -> e % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum());
    }

    private static void totalSum(List<Integer> listInt) {
        System.out.println("Total Sum Way I : " + listInt.stream()
                .reduce(0, (a, b) -> a + b)
                .intValue());
        System.out.println("Total Sum Way II : " + listInt.stream()
                .mapToInt(Integer::intValue)
                .sum());
    }

    private static void kthHighestSalary(int k, List<Employee> list) {
        System.out.println("Kth highest salary : " + list.stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary() - o2.getSalary();
            }
        }).collect(Collectors.toList()).get(list.size() - k));
    }

    private static void sortBySalary(List<Employee> list) {
        System.out.println("Sort by salary : " + list.stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary() - o2.getSalary();
            }
        }).collect(Collectors.toList()));
    }

    private static void sortByAge(List<Employee> list) {
        System.out.println("Sort by age : " + list.stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getAge() - o2.getAge();
            }
        }).collect(Collectors.toList()));
    }

    private static void sortByName(List<Employee> list) {
        System.out.println("Sort by name : " + list.stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }).collect(Collectors.toList()));
    }

    private static void findMaxSalary(List<Employee> list) {
        System.out.println("Max salary : " + list.stream().max(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary() - o2.getSalary();
            }
        }).get());
    }

    private static void convertListToMap(List<String> list) {
        System.out.println(list
                .stream()
                .collect(Collectors.toMap(e -> e, e -> e)));
    }

    private static void findIntersectionOfTwoList(List<Integer> list1, List<Integer> list2) {
        System.out.println(list1
                .stream()
                .filter(list2::contains)
                .collect(Collectors.toList()));
    }

    private static void isAscendingOrder(String str) {
        if (str == null || str.length() <= 1) {
            System.out.println(str + " isAscendingOrder -> " + true );
            return;
        }
        boolean result = IntStream.range(0, str.length() - 1)
                .allMatch(i -> str.charAt(i) < str.charAt(i + 1));
        System.out.println(str + " isAscendingOrder -> " + result );
    }

    private static void adjacentPairs(int[] arr) {
        List<List<Integer>> pairs =
                IntStream.range(0, arr.length - 1)
                        .mapToObj(i -> Arrays.asList(arr[i], arr[i + 1]))
                        .collect(Collectors.toList());
        System.out.println("adjacentPairs : " + pairs);
    }

    private static void sortMapByValue(Map<Integer, String> map) {
        map.forEach((key, value) -> System.out.println(key + " -> " + value));
        List<Map.Entry<Integer, String>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        System.out.println(list);

        // using stream api
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach((e) -> System.out.println(e.getKey() + " -> " + e.getValue()));


    }

    private static void firstRepeatedChar(String str) {
        str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresentOrElse(
                        ch -> System.out.println("First repeated char is " + ch),
                        () -> System.out.println("No repeated char found")
                );
        // IInd way
        IntStream.range(0, str.length())
                .mapToObj(i -> str.charAt(i))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst().ifPresentOrElse(
                        ch -> System.out.println("First repeated char is " + ch),
                        () -> System.out.println("No repeated char found")
                );
    }

    private static String reverse(String str) {
        String result = IntStream.range(0, str.length())
                .mapToObj(i -> str.charAt(str.length() - i - 1))
                .map(Objects::toString)
                .collect(Collectors.joining());

        // IInd way
        result = Stream.iterate(str.length() - 1, i -> i >= 0, i -> i = i-  1)
                .map(str::charAt)
                .map(Objects::toString)
                .collect(Collectors.joining());

        return result;
    }
}
