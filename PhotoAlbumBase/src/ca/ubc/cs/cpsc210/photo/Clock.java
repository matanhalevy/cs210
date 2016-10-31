package ca.ubc.cs.cpsc210.photo;

import java.util.Iterator;

/**
 * Created by Yoram on 2014-12-02.
 */
public class Clock implements Iterable{
    private Integer startTime;
    private Integer numHours;

    public Clock(Integer start, Integer hrs) {
        this.startTime = start;
        this.numHours = hrs;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new ClockIterator();
    }

    private class ClockIterator implements Iterator<Integer>{
        private int currTime;

        private ClockIterator() {
            this.currTime = startTime;
        }

        @Override
        public boolean hasNext() {
            return currTime < (startTime + numHours);
        }

        @Override
        public Integer next() {
            Integer nextTime = currTime;
            currTime++;
            return nextTime;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }


    }
}
