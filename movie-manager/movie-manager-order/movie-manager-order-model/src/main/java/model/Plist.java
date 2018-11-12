package model;

import java.util.List;

public class Plist<T> {
    private List<T> list;
    private int total;
    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Plist{" +
                "list=" + list +
                ", total=" + total +
                '}';
    }
}
