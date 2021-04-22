package epam_list;

public class EpamList implements EList {

    private final int DEFAULT_CAPACITY = 10;
    private final double COEFFICIENT_EXTENSION = 0.3;
    private Object[] listEpam;
    private int countIndex = 0;

    public EpamList() {
        this.listEpam = new Object[DEFAULT_CAPACITY];
    }

    public EpamList(int capacity) {
        this.listEpam = new Object[capacity];
    }

    @Override
    public void add(Object o) {
        if (this.countIndex < (int) DEFAULT_CAPACITY * (1 - COEFFICIENT_EXTENSION)) {
            resizeListEpam();
        }
        this.listEpam[countIndex] = o;
        countIndex++;

    }

    private void resizeListEpam() {
        int sizeOfBufferListEpam = (int) (this.listEpam.length * (COEFFICIENT_EXTENSION + 1));
        Object[] bufferListEpam = new Object[sizeOfBufferListEpam];
        for (int i = 0; i < countIndex; i++) {
            bufferListEpam[i] = this.listEpam[i];
        }
        this.listEpam = bufferListEpam;
    }

    @Override
    public int size() {
        return this.countIndex;
    }

    @Override
    public boolean remove(int i) {
        if (i > 0 || i < countIndex) {
            for (int j = i; j < countIndex - i - 1; j++) {
                this.listEpam[i] = this.listEpam[i + 1];
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < countIndex - 1; i++) {
            if (get(i).equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > listEpam.length - 1) {
            throw new RuntimeException("Invalid index");
        } else {
            return this.listEpam[index];
        }
    }

    @Override
    public void printAllContext() {
        String msg = "[ ";
        if (countIndex > 0) {
            for (int i = 0; i < countIndex; i++) {
                if (i == countIndex - 1) {
                    msg = msg + i + "]";
                } else {
                    msg = msg + i + ",";
                }
            }
            System.out.println(msg);
        } else {
            System.out.println("[]");
        }
    }
}
