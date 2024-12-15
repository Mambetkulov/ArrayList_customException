import exceptions.AgeException;
import exceptions.EmptyValueException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        int count = 0;
        System.out.println( "fill the sheet with 5 employees \n");
       do {
           try {
               System.out.println("Enter your name");
               String name = new Scanner(System.in).nextLine();
               checkName(name);
               System.out.println("Enter your job");
               String job = new Scanner(System.in).nextLine();
               checkJob(job);
               System.out.println("Enter your age");
               int age = new Scanner(System.in).nextInt();
               checkAge(age);

               employees.add(new Employee(name, age, job));

           } catch (EmptyValueException | AgeException e) {
               count = 1;
               System.out.println(e);
           } catch (InputMismatchException s) {
               count = 1;
               System.out.println("only numbers");
           } finally {
               if(count == 0){
                   System.out.println("employee was successfully saved \n");
               }
               else{
                   System.out.println("""
                           the employee was not saved
                           try again !!!
                      
                           """);
               }
               count = 0;
           }
       }while(employees.size()!=5);

        System.out.println(employees);
    }


    static void checkAge (int age)throws AgeException{
        if(age<15){
            throw new AgeException("\n" + "your age must be at least 15 +");
        }
    }

    static void checkName(String name)throws EmptyValueException{
        if(name.isEmpty()){
            throw new EmptyValueException("\n" + "name field cannot be empty so please enter your name");
        }
    }

    static void checkJob (String job)throws EmptyValueException{
        if(job.isEmpty()){
            throw new EmptyValueException("\n" + "job field cannot be empty so please enter your job");

        }
    }
}