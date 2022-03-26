package me.plepis.util.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectToFile {

    private ObjectOutputStream oos;
    private FileOutputStream fos;
    private Serializable[] objs;

    public static ObjectToFile serialize(Serializable... objs) {
        return new ObjectToFile(objs);
    }

    private ObjectToFile(Serializable... objs) {
        this.objs = objs;
    }

    public void to(String file) {
        try {
            this.fos = new FileOutputStream(file);
            this.oos = new ObjectOutputStream(fos);
            for (Serializable obj : objs) {
                oos.writeObject(obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void to(String path, String file){
        to(path + file);
    }


}
