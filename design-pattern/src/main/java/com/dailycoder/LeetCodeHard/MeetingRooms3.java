package com.dailycoder.LeetCodeHard;

import java.util.Arrays;
import java.util.PriorityQueue;

class Room{

    int roomNumber;

    public Room(int roomNumber){
        this.roomNumber = roomNumber;
    }

    public String toString(){
        return String.format("Room number %s",roomNumber);
    }
}

public class MeetingRooms3 {

    public static int mostBooked(int n, int[][] meetings) {

        int result = 0;
        PriorityQueue<Room> freeRooms = new PriorityQueue<>((a,b)->a.roomNumber -b.roomNumber);
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        int roomNo = 0;

        while(roomNo<n){
            freeRooms.add(new Room(roomNo++));
        }
        Arrays.sort(meetings,(a, b) -> a[0] -b[0]);


        for(int[] meeting:meetings){

            int start = meeting[0];
            int end = meeting[0];

            if(freeRooms.size()>=0){
                Room occupied = freeRooms.poll();
                System.out.println("occupied:: "+occupied);
                endTimes.add(end);
            }

        }


        return result = 0;
    }

    public static void main(String[] args) {

        mostBooked(2,new int[][]{{0,10},{1,5},{2,7},{3,4}});
    }
}
