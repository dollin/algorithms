package org.elvaston.leetcode.todo;


/**
 * https://leetcode.com/problems/exam-room/
 * Won't work w/ numbers up to 10^9 so need to re-write.
 * In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.
 * When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.  If there are multiple such seats, they sit in the seat with the lowest number.  (Also, if no one is in the room, then the student sits at seat number 0.)
 * Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat() returning an int representing what seat the student sat in, and ExamRoom.leave(int p) representing that the student in seat number p now leaves the room.  It is guaranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p.
 *
 * Example 1:
 * Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * Output: [null,0,9,4,2,null,5]
 * Explanation:
 * ExamRoom(10) -> null
 * seat() -> 0, no one is in the room, then the student sits at seat number 0.
 * seat() -> 9, the student sits at the last seat number 9.
 * seat() -> 4, the student sits at the last seat number 4.
 * seat() -> 2, the student sits at the last seat number 2.
 * leave(4) -> null
 * seat() -> 5, the student sits at the last seat number 5.
 * ​​​​​​​
 * Note:
 * 1 <= N <= 10^9
 * ExamRoom.seat() and ExamRoom.leave() will be called at most 10^4 times across all test cases.
 * Calls to ExamRoom.leave(p) are guaranteed to have a student currently sitting in seat number p.
 */
public class exam_room {
        private final int[] seats;
        private final int max;
        private int peopleInSeats = 0;

        public exam_room(int N) {
            this.seats = new int[N];
            this.max = N;
            for (int i = 0; i < seats.length; i++) {
                seats[i] = max;
            }
        }

        public int seat() {
            int indexOfSeat = 0;
            if (peopleInSeats == 0) {
                seats[0] = 0;
                updateDistances(0, seats);
            } else {
                int currentDistance = 0;
                for (int i = 0; i < seats.length; i++) {
                    if (currentDistance < seats[i]) {
                        currentDistance = seats[i];
                        indexOfSeat = i;
                    }
                }
                seats[indexOfSeat] = 0;
                updateDistances(indexOfSeat, seats);
            }
            peopleInSeats++;
            return indexOfSeat;
        }

        public void leave(int p) {
            System.out.println("before leave: " + p);
            for (int i = 0; i < seats.length; i++) {
                System.out.print(seats[i] + ", ");
            }
            System.out.println();
            seats[p] = max;
            int leftSeatIndex = p;
            boolean hasLeftIndex = false;
            if (p > 0) {
                for (int i = p -1; i >= 0; i--) {
                    if (seats[i] == 0) {
                        leftSeatIndex = i;
                        hasLeftIndex = true;
                        break;
                    }
                    seats[i] = max;
                }
            }

            boolean hasRightIndex = false;
            int rightSeatIndex = p;
            if (p < seats.length) {
                for (int i = p +1; i < seats.length; i++) {
                    if (seats[i] == 0) {
                        rightSeatIndex = i;
                        hasRightIndex = true;
                        break;
                    }
                    seats[i] = max;
                }
            } else {
                seats[rightSeatIndex] = max;
            }

            if (hasLeftIndex) {
                updateDistances(leftSeatIndex, seats);
            }
            if (hasRightIndex) {
                updateDistances(rightSeatIndex, seats);
            }
            System.out.println("after leave: " + p + " updated indexes: [" + leftSeatIndex + "," + rightSeatIndex + "]");
            for (int i = 0; i < seats.length; i++) {
                System.out.print(seats[i] + ", ");
            }
            System.out.println();

            peopleInSeats--;
        }

        private void updateDistances(int seatedAt, int[] seats) {
            for (int i = 0; i < seats.length; i++) {
                seats[i] = Math.min(Math.abs(i - seatedAt), seats[i]);
            }
        }
    }

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */

