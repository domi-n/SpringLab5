package com.nowicka.dominika;

import com.nowicka.dominika.dziennik.ClassContainer;
import com.nowicka.dominika.dziennik.Student;
import com.nowicka.dominika.dziennik.Class;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class MainFrame extends JFrame implements ActionListener {
    public JTable classTable;
    public JTable studentsTable;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton addClass;
    final Class[] selectedClass = {new Class()};
    final Student[] selectedStudent = {new Student()};
    ClassContainer classes = new ClassContainer();
    //final JTable classesTable;
    JTextField studentNameField;
    JTextField classNameField;
    List<Student> tempStudentList;

//    TableModel dataModelClass = new AbstractTableModel() {
//        @Override
//        public int getRowCount() {
//            return classes.groups.size();
//        }
//
//        @Override
//        public String getColumnName(int columnIndex){
//            String[] names = {"Name", "Count", "Max Count"};
//            return names[columnIndex];
//        }
//        @Override
//        public int getColumnCount() {
//            return 3;
//        }

    TableModel dataModelStudent = new AbstractTableModel() {
        @Override
        public int getRowCount() {
            return selectedClass[0].summary().size();
        }

        @Override
        public String getColumnName(int columnIndex) {
            String[] names = {"First Name", "Last Name", "Points", "Birth Year", "Condition"};
            return names[columnIndex];
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            List<Student> data = selectedClass[0].summary();
            //Student temp =data.get(rowIndex);

            return data;
        }
    };

    MainFrame(ClassContainer def_class) {
        classes = def_class;
        addClass = new JButton("Add class");
        addClass.addActionListener(this);
        studentsTable = new JTable(dataModelStudent);
        studentsTable.setCellSelectionEnabled(true);


        ListSelectionModel select2 = studentsTable.getSelectionModel();
        select2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        select2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent f) {
                int row = studentsTable.getSelectedRow();
                selectedStudent[0] = selectedClass[0].summary().get(row);
            }
        });

        tempStudentList = selectedClass[0].summary();
        studentNameField = new JTextField();
        studentNameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentsTable.updateUI();
            }
        });

        JScrollPane studentTablePane = new JScrollPane(studentsTable);

        classTable.setFillsViewportHeight(true);
        this.setTitle("Title");
        this.setLayout(new GridLayout(7, 2));
        this.setSize(1000, 1000);
        //this.add(classesTable.getTableHeader());
        //his.add(classTablePane);
        //this.add(studentsTable.getTableHeader());
        this.add(studentTablePane);


        this.add(addClass);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addClass) {
            Class newClass = new Class();
            if (Objects.equals(classNameField.getText(), "")) {
                return;
            }
            newClass.groupName = classNameField.getText();
            newClass.maxStudents = 10.0;
            classes.addClass(newClass.groupName, newClass.maxStudents);
            classTable.updateUI();
            classNameField.setText("");
        }
    }
}

