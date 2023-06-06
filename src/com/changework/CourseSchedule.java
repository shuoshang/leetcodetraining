package com.changework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {


    public boolean canFinish(int numCourses, int[][] prerequisites) {

                int[] indegrees = new int[numCourses];
                List<List<Integer>> adjacency = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();
                for(int i = 0; i < numCourses; i++)
                    adjacency.add(new ArrayList<>());
                // Get the indegree and adjacency of every course.
                for(int[] cp : prerequisites) {
                    indegrees[cp[0]]++;
                    adjacency.get(cp[1]).add(cp[0]);
                }
                // Get all the courses with the indegree of 0.
                for(int i = 0; i < numCourses; i++)
                    if(indegrees[i] == 0) queue.add(i);
                // BFS TopSort.
                while(!queue.isEmpty()) {
                    int pre = queue.poll();
                    numCourses--;
                    for(int cur : adjacency.get(pre))
                        if(--indegrees[cur] == 0) queue.add(cur);
                }
                return numCourses == 0;
    }

    public static void main(String[] args) {

        // write your code here
        CourseSchedule courseSchedule =  new CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites =  new int[][]{{1,0},{0,1}};
        boolean  number = courseSchedule.canFinish(numCourses,prerequisites);
        System.out.println(number);
    }
}
