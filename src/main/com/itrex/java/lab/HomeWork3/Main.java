package main.com.itrex.java.lab.HomeWork3;

import java.util.List;
import java.util.stream.Collectors;

/*
Sample Input 1:
 * 2
 * Sample Output 1:
 * True
 * <p>
 * Sample Input 2:
 * 3
 * Sample Output 2:
 * True
 * <p>
 * Sample Input 3:
 * 4
 * Sample Output 3:
 * False
 */
public class Main {
    public static void main(String[] args) {

//        for (long i = 0; i < 10; i++) {                         //Task1
//            System.out.println("i=" + i + " -" + Task1.isPrime(i));
//        }
//
//        IntStream list = Task3.createFilteringStream(IntStream.of(1,3), IntStream.of(2,4));  //Task3
//        list.forEach(System.out::println);
//        ArrayList<Integer> collect = Task3.createFilteringStream(IntStream.of(30, 60, 90), IntStream.of(75)).collect(ArrayList<Integer>::new, List::add, List::addAll);
//        System.out.println(collect);
//        List<Integer> collect2 = Task3.createFilteringStream(IntStream.of(30, 60, 90), IntStream.of(75)).boxed().collect(Collectors.toList());
//        System.out.println(collect2);
//
//        for (long i = 0; i < 20; i++) {
//            System.out.printf("%d factorial = %d \n",i,Task4.factorial(i) );
//        }
//        System.out.println(Task5.sumOfOddNumbersInRange(0,0));
//        System.out.println(Task5.sumOfOddNumbersInRange(7,9));
//        System.out.println(Task5.sumOfOddNumbersInRange(21,30));
    String text = "* Important. You need 111 return 23 a prepared stream from the template method,\n" +
            " * not a list of bad words Pay attention to the method template. Do not change it!";
    List<String> word = List.of("bad","words", "method","of","111");
        System.out.println(Task2.createBadWordsDetectingStream(text,word).collect(Collectors.toList()));

// * [
// * {
// * "number": "1001",
// * "balance": 0,
// * "transactions": [
// * {
// * "uuid": "774cedda-9cde-4f53-8bc2-5b4d4859772a",
// * "state": "CANCELED",
// * "sum": 1000,
// * "created": "2016.12.12 18:30:05"
//                        * }
// * ]
// * },
// * {
// * "number": "1002",
// * "balance": 8000,
// * "transactions": [
// * {
// * "uuid": "337868a7-f469-43c0-9042-3422ce37ee26a",
// * "state": "FINISHED",
// * "sum": 8000,
// * "created": "2016.12.12 17:30:55"
//                        * },
// * {
// * "uuid": "f8047f86-89e7-4226-8b75-74c55a4d7e31",
// * "state": "CANCELED",
// * "sum": 10000,
// * "created": "2016.12.12 18:10:18"
//                        * }
// * ]
// * }
// * ]
        Transaction can = new Transaction( State.CANCELED,1000L);
        Transaction transaction1 = new Transaction( State.FINISHED,8000L);
        Transaction transaction2 = new Transaction( State.CANCELED,10000L);
        Account account1 = new Account(0L,List.of(can));
        Account account2 = new Account(8000L,List.of(transaction1,transaction2));
        Account account3 = new Account(8000L,List.of(transaction1,transaction2));
        System.out.println(Task7.calcSumOfCanceledTransOnNonEmptyAccounts(List.of(account1,account2,account3, new Account(600L,List.of(transaction2,transaction2)))));
// * [
// * {
// * "name": "dep-1",
// * "code": "111-1",
// * "employees": [
// * {
// * "name": "William",
// * "salary": 20000
//                        * },
// * {
// * "name": "Sophia",
// * "salary": 10000
//                        * }
// * ]
// * },
// * {
// * "name": "dep-2",
// * "code": "222-1",
// * "employees": [
// * {
// * "name": "John",
// * "salary": 50000
//                        * }
// * ]
// * }
// * ]
        Employees employees1 = new Employees();
        employees1.setName("William");
        employees1.setSalary(20000);
        Employees employees2 = new Employees();
        employees1.setName("Sophia");
        employees1.setSalary(10000);
        Employees employees3 = new Employees();
        employees1.setName("John");
        employees1.setSalary(50000);

        Department department1 =new Department();
        department1.setCode("111-1");
        department1.setEmployees(List.of(employees1,employees2));
        Department department2 =new Department();
        department2.setCode("222-1");
        department2.setEmployees(List.of(employees3));
        Department department3 =new Department();
        department3.setCode("111-2");
        department3.setEmployees(List.of(employees1,employees2,employees1));

        System.out.println(Task6.calcNumberOfEmployees(List.of(department1,department2,department3),200000L));




    }
}
