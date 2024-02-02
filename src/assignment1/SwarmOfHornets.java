package assignment1;

public class SwarmOfHornets {
    private Hornet[] hornetArray;
    private int size;

    public SwarmOfHornets() {
        this.hornetArray = new Hornet[0];
        size = 0;
    }

    public int sizeOfSwarm() {
        return size;
    }

    public Hornet[] getHornets() {
        Hornet[] temp = new Hornet[size];
        for (int i = 0; i < size; i++) {
            temp[i] = hornetArray[i];
        }
        return temp;
        //since you double every time, you change size, the last elements could be null
    }

    public Hornet getFirstHornet() {
        if (size > 0) {
            return hornetArray[0];
        }
        else {
            return null;
        }
    }

    public void addHornet(Hornet hornet) {
        if (hornetArray.length == size) {
            resize();
        }
        hornetArray[size] = hornet;
        size++;
    }

    public boolean removeHornet(Hornet hornet) {
        for (int i = 0; i < size; i++) {
            if (hornetArray[i] == hornet) {
                for (int j = i; j < size - 1; j++) {
                    hornetArray[j] = hornetArray[j+1];
                }
                hornetArray[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    private void resize() {
        if (size == 0) {
            Hornet [] bigger = new Hornet[1];
            hornetArray = bigger;
        }
        else {
            Hornet[] bigger = new Hornet[size * 2];
            for (int i = 0; i < size; i++) {
                bigger[i] = hornetArray[i];
            }
            hornetArray = bigger;
        }
    }
}

