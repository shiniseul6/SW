package hw.ch11;

import java.util.List;

public abstract class Entry {
    protected Entry parent;

    public abstract String getName();
    public abstract int getSize();

    public Entry add(Entry entry) {
        throw new RuntimeException("예외 발생: 추가할 수 없습니다.");
    }

    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }

    public String getFullName() {
        StringBuilder fullname = new StringBuilder();
        Entry entry = this;
        do {
            fullname.insert(0, "/" + entry.getName());
            entry = entry.parent;
        } while (entry != null);
        return fullname.toString();
    }

    public abstract List<Entry> search(String keyword);
}