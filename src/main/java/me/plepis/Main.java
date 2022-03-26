package me.plepis;

import me.plepis.util.IO.FileToObject;
import me.plepis.util.IO.IOPath;
import me.plepis.util.IO.ObjectToFile;
import me.plepis.util.sample_model.Perpetuator;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Perpetuator ansis = new Perpetuator("Ansis", "plepis.me", 71);
        ObjectToFile.serialize(ansis).to(IOPath.SERIALS, "ansis.ser");
        List<Perpetuator> deserialized = FileToObject.deserialize(IOPath.SERIALS, "ansis.ser").as(Perpetuator.class);
        deserialized.stream().forEach(System.out::println);
    }


}
