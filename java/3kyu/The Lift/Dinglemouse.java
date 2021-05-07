import java.util.*;

public class Dinglemouse {

    static Map<Integer, List<Integer>> queue;
    static BitSet floorsDone;
    static List<Integer> lifting;
    static int lifterPos;
    static int capacity;
    static List<Integer> stops;

    public static int[] theLift(final int[][] x, final int y) {
        capacity = y;
        queue = new HashMap<>();
        floorsDone = new BitSet();
        List<Integer> aux;
        for (int floor = 0; floor < x.length; floor++) {
            aux = new ArrayList<>();
            for (int i = 0; i < x[floor].length; i++) {
                aux.add(x[floor][i]);
            }
            queue.put(floor, aux);
            floorsDone.set(floor, queue.get(floor).size() < 1);

        }
        lifting = new ArrayList<>();
        lifterPos = 0;
        boolean finished = false;
        stops = new ArrayList<>();
        stops.add(0); // we start on the ground
        boolean canGoUp;
        boolean canGoDown;
        while (!finished) {
            finished = true;
            for (int i = 0; i < x.length; i++) { // if any floor has ppl you are not done
                if (!floorsDone.get(i)) {
                    finished = false;
                    break;
                }
            }
            if (!finished) {
                canGoUp = checkForPplOver();
                while (canGoUp && lifterPos < queue.size() - 1) {
                    moveLifter(1); // move the elevator to the next floor
                    if (lifting.size() < 1) {
                        canGoUp = checkForPplOver();
                    }
                }
                canGoDown = checkForPplUnder();
                while (canGoDown && lifterPos > 0) {
                    moveLifter(-1); // move the elevator to the next floor
                    if (lifting.size() < 1) {
                        canGoDown = checkForPplUnder();
                    }
                }
            }
        }
        if (stops.get(stops.size() - 1) != 0) { // add gorun level if it didnt stop there
            stops.add(0);
        }
        return stops.stream().mapToInt(Integer::intValue).toArray();
    }

    private static Boolean checkForPplUnder() {
        for (int i = lifterPos; i >= 0; i--) {
            if (queue.get(i).size() >= 1 || lifting.contains(i)) { // if there are ppl waiting on lower levels or
                                                                   // someone wants to go there
                return true;
            }
        }
        return false;
    }

    private static boolean checkForPplOver() {
        for (int i = lifterPos; i < queue.size(); i++) {
            if (queue.get(i).size() >= 1 || lifting.contains(i)) {// if there are ppl waiting on higher levels or
                                                                  // someone wants to go there
                return true;
            }
        }
        return false;
    }

    private static void moveLifter(int direction) {
        boolean stop = false;
        if ((lifterPos == 0 && direction < 0) || (lifterPos == queue.size() - 1 && direction > 0)) {
            direction = -direction; // if we reach one of the edges we have to reverse the direction (so we stop)
            stop = true;
        }
        for (int i = lifting.size() - 1; i >= 0; i--) { // get ppl off the elevator
            if (lifting.get(i) == lifterPos) {
                lifting.remove(i);
                stop = true;
            }
        }
        for (int i = 0; i < queue.get(lifterPos).size(); i++) {
            if ((direction > 0 && queue.get(lifterPos).get(i) > lifterPos)
                    || (direction < 0 && queue.get(lifterPos).get(i) < lifterPos)) {// get ppl in the elevator
                stop = true;
                if (lifting.size() < capacity) {
                    lifting.add(queue.get(lifterPos).get(i));
                    queue.get(lifterPos).remove(i);
                    i--;
                } else {
                    break;
                }
            }
        }
        if (queue.get(lifterPos).size() < 1) { // if the floor is empty the floor is finished
            floorsDone.set(lifterPos, queue.get(lifterPos).size() < 1);
        }
        if ((stop && stops.get(stops.size() - 1) != lifterPos)) { // add the stop if it happened
            stops.add(lifterPos);
        }
        lifterPos += direction;// move the elvetor to the next floor
    }
}