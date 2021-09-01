package utils.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.pojos.Route;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class JSONReader<T> {
    private  Class<T> typeParameterClass;


    public JSONReader(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public T readJson(String path){
        ObjectMapper mapper = new ObjectMapper();
        T object = null;
        try {
            object = mapper.readValue(new File(path), typeParameterClass);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return object;
    }
}
