package com.nowicka.dominika.dziennik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Class {
    public String groupName;
    List<Student> students = new ArrayList<>();
    public double maxStudents;

    public Class(double maxStudents){
        this.maxStudents = maxStudents;
    }
    public Class(){maxStudents = 10;}

    public void addStudent(Student student){
        if (students.size() >= maxStudents){
            System.err.println("W klasie jest maksymalna liczba uczniow");
        }
        else if (studentAlreadyAdded(student)){
            System.out.println("Uczen jest juz w klasie");
        }
        else{students.add(student);}
    }

    private boolean studentAlreadyAdded(Student student){
        return students.stream()
                .anyMatch(s -> s.surname.equals(student.surname) && s.name.equals(student.name));

    }
    public void addPoints(Student student, double points){
        student.points = student.points + points;
    }

    public void getStudent(Student student){
        if (student.points == 0){
            students.remove(student);
        }
    }

    public void changeCondition(Student student, StudentCondition condition){
        student.condition = condition;
    }

    public void removePoints(Student student, double points){
        student.points -= points;
    }

    public Student search(String surname){
        return students.stream()
                .filter(student -> student.surname.compareTo(surname) == 0)
                .findFirst()
                .orElse(null);
    }

    public List<Student> searchPartial(String partName){
        return students.stream()
                .filter(s -> s.surname.contains(partName) || s.name.contains(partName))
                .collect(Collectors.toList());
    }

    public int countByCondition(StudentCondition condition){
        return (int) students.stream()
                .filter(s -> s.condition.equals(condition))
                .count();
    }

    public List<Student> summary(){
        List<Student> classSummary = students.stream().toList();{
            return classSummary;
        }
    }

    public List<Student> sortByName(){
        List<Student> sortedList = students.stream()
                .sorted(Student::compareTo)
                .collect(Collectors.toList());
        sortedList.forEach(element -> System.out.println(element.name + " " + element.surname));
        return sortedList;

    }
    public List<Student> sortByPoints(){
        List<Student> sortedList = students.stream()
                .sorted(new Comparator<Student>() {
                            @Override
                            public int compare(Student o1, Student o2) {
                                // sortowanie malejąco, zamienione parametry
                                return Double.compare(o2.points,o1.points);
                            }
                        }
                ).collect(Collectors.toList());
        sortedList.forEach(element -> System.out.println(element.name + " " + element.surname + " ,punkty: " + element.points));
        return sortedList;
    }

    public Student max(){
        Student s1 = Collections.max(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.points,o2.points);
            }
        });
        System.out.println("Student z najwieksza liczba pkt: " + s1.name + " " + s1.surname);
        return s1;
    }
}
