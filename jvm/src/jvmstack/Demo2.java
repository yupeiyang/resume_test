package jvmstack;

import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) throws Exception {
        Dept dept = new Dept();
        dept.setName("tom");

        Emp emp = new Emp();
        emp.setName("paul");
        emp.setDept(dept);

        Emp emp1 = new Emp();
        emp1.setName("puma");
        emp1.setDept(dept);

        dept.setList(Arrays.asList(emp, emp1));

        //ObjectMapper mapper = new ObjectMapper();
        //System.out.println(mapper.writeValueAsString(dept));
        System.out.println(dept);
    }
}