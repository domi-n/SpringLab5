package com.nowicka.dominika;

import com.nowicka.dominika.dziennik.Class;
import com.nowicka.dominika.dziennik.ClassContainer;
import com.nowicka.dominika.dziennik.Student;
import com.nowicka.dominika.dziennik.StudentCondition;

public class Main {
    public static void main(String[] args) {

        ClassContainer classContainer = new ClassContainer();
        classContainer.addClass("1a",5);
        Class first_a = classContainer.groups.get("1a");

        Student student1 = new Student("Jan", "Kowalski", StudentCondition.CHORY, 2001, 0.0, "");
        Student student2 = new Student("Anna", "Wisnicz", StudentCondition.NIEOBECNY, 2002, 5.0, "");
        Student student3 = new Student("Dominika", "Nowicka", StudentCondition.ODRABIAJACY, 2001, 2.0, "");
        Student student4 = new Student("Andrzej", "Wojas", StudentCondition.CHORY, 2001, 3.0, "");

        first_a.addStudent(student1);

        MainFrame mainFrame= new MainFrame(classContainer);
    }

}
