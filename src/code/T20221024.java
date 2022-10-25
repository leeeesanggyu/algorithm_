package code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class T20221024 {
    public static void main(String[] args) throws Exception {
        String input1 = "Hello, world!";
        String input2 = "lod";
        // input1 을 input2 를 다 제거해라
        // “He, wr!”

        String[] splitInput1 = input1.split("");
        String[] splitInput2 = input2.split("");

        List<String> temp = Arrays.asList(splitInput1);
        for (String el : splitInput2) {
            temp = temp.stream()
                    .filter(e -> !e.equals(el))
                    .collect(Collectors.toList());
        }

        for (String el : temp) {
            System.out.print(el);
        }
    }
}

//emp
//| id | name |
//| 1  | AA   |
//| 2  | BB   |
//| 3  | CC   |
//| 4  | DD   |
//
//salary
//| id | emp_id    | payed_date    | amount |
//| 1  | 1         | 2021-01-25    | 100    |
//| 2  | 1         | 2021-02-25    | 100    |
//| 3  | 2         | 2021-01-25    | 50     |
//| 4  | 2         | 2021-02-25    | 100    |
//| 5  | 3         | 2021-01-25    | 200    |
//| 6  | 3         | 2021-02-25    | 300    |
//
//Q3. 위의 테이블을 사용하여 emp.name 별 salary.amount 합계 산출하는 쿼리 작성

// SELECT   emp.name, sum(salary.amount)
// FROM     emp
//      JOIN salary ON emp.id = salary.emp_id;

// SELECT   emp.name, sum(salary.amount)
// FROM     emp
//      LEFT JOIN salary ON emp.id = salary.emp_id

// SELECT   emp.name, sum(salary.amount) AS sum_amount
// FROM     emp
//              LEFT JOIN salary ON emp.id = salary.emp_id
// WHERE    sum_amount > 500;