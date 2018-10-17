package json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class Jackson2Util {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T fromJson(String json, Class<T> beanClass) throws IOException {
        return objectMapper.readValue(json, beanClass);
    }

    public static <T> T fromJson(String json, TypeReference<T> reference) throws IOException {
        return objectMapper.readValue(json, reference);
    }

    public static String toJson(Object bean) throws JsonProcessingException {
        return objectMapper.writeValueAsString(bean);
    }

    public static List fromJsonToList(String json, Class<?>... T) throws JsonParseException, JsonMappingException, IOException {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, T);
        return objectMapper.readValue(json, javaType);
    }

    public static Map<String, Object> toMap(String json) throws IOException {
        return objectMapper.readValue(json, new TypeReference<Map<String, Object>>(){});
    }
}
