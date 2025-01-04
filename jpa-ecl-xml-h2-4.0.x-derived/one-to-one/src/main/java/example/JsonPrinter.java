package example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonPrinter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> void print(T t) {
        try {
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(t));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
