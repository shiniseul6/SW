package hw.ch11;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private String name;
    private List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry : directory) {
            size += entry.getSize(); 
        }
        return size;
    }

    @Override
    public Entry add(Entry entry) {
        directory.add(entry);
        entry.parent = this; 
        return this;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry : directory) {
            entry.printList(prefix + "/" + name);
        }
    }

    @Override
    public List<Entry> search(String keyword) {
        List<Entry> result = new ArrayList<>();
        
        if (this.name.contains(keyword)) {
            result.add(this);
        }
        
        for (Entry entry : directory) {
            result.addAll(entry.search(keyword));
        }
        return result;
    }
}