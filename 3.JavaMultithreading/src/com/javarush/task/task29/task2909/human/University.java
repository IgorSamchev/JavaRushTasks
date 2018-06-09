package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University{
    private List<Student> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;

    public List getStudents() {
        return students;
    }

    public void setStudents(List students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        students = new ArrayList<>();
    }

    public Student getStudentWithAverageGrade(double avarageGrade) {
        int index = 0;

        for (int i = 0; i < students.size(); i++) {
            if (avarageGrade == students.get(i).getAverageGrade()){
                index = i;
                break;
            }
        }
        return students.get(index);
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxGrade = 0;
        int index = 0;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() > maxGrade){
                maxGrade = students.get(i).getAverageGrade();
                index = i;
            }
        }
        return students.get(index);
    }

    public Student getStudentWithMinAverageGrade() {
       double minGrade = Double.MAX_VALUE;
       int index = 0;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() < minGrade){
                minGrade = students.get(i).getAverageGrade();
                index = i;
            }
        }
        return students.get(index);
    }

   public void expel(Student student){
        students.remove(student);
    }
}