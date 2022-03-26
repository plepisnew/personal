package me.plepis.util.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class FileToObject {

    private ObjectInputStream ois;
    private FileInputStream fis;
    private List<Object> objs;

    public static FileToObject deserialize(String file) {
        FileToObject instance = new FileToObject(file);
        instance.objs = new ArrayList<>();
        while (true) {
            try {
                instance.objs.add(instance.ois.readObject());
            } catch (ClassNotFoundException | IOException e) {
                break;
            }
        }
        return instance;
    }

    public static FileToObject deserialize(String path, String file){
        return deserialize(path + file);
    }

    public <T> List<T> as(Class<T> type) {
        List<T> stuff = new ArrayList<>();
        for (Object obj : objs) {
            if (type.isInstance(obj)) {
                stuff.add(type.cast(obj));
            }
        }
        return stuff;
    }

    private FileToObject(String file) {
        try {
            this.fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
