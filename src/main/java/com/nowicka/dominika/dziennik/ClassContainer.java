package com.nowicka.dominika.dziennik;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClassContainer {
    public Map<String,Class> groups = new HashMap<>();
    public void addClass(String className, double capacity){
        groups.put(className, new Class(capacity));
    }

    public void removeClass(String className){
        groups.remove(className);
    }

    public List<String> findEmpty(){
        return groups.entrySet().stream()
                .filter(group -> group.getValue().students.isEmpty())
                .map(group -> group.getKey())
                .collect(Collectors.toList());

    }

    public void summary(){
        groups.entrySet().stream()
                .forEach(
                        group -> {
                            System.out.println("Nazwa grupy: " + group.getKey());
                            System.out.println("Procent zapelnienia: " + group.getValue().students.size()/group.getValue().maxStudents * 100 + "%");
                        }
                );
        System.out.println();
    }

}
