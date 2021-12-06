package com.nowicka.dominika.dziennik;

public class Student implements Comparable<Student>{
    public String name;
    public String surname;
    StudentCondition condition;
    Integer birthYear;
    public Double points;
    String comment;

    public Student(String name, String surname, StudentCondition condition, Integer birthYear, Double points, String comment) {
        this.name = name;
        this.surname = surname;
        this.condition = condition;
        this.birthYear = birthYear;
        this.points = points;
        this.comment = comment;
    }
    public Student(){
        this.name = "Imie Studenta";
        this.surname = "Nazwisko Studenta";
        this.points = 0.0;
    }

    public void print(){
        System.out.println("Student: " + name + " " + surname);
        System.out.println("Stan studenta: " + condition.toString());
        System.out.println("Rok urodzenia: " + birthYear);
        System.out.println("Punkty: " + points);
        System.out.println("Komentarze: " + comment);
    }

    //porównanie ze wględu na nazwisko
    @Override
    public int compareTo(Student o){
        return surname.compareTo(o.surname);
    }
}
