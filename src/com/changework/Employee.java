package com.changework;

import java.util.List;

public class Employee {

        public int id;
        public int importance;
        public List<Integer> subordinates;
        Employee(int id, int importance,List<Integer> subordinates) { this.id = id; this.importance = importance; this.subordinates = subordinates;}
}
