package moe.mochizuki.jsondeserialize;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Program {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public List<ChatMessageDataLog> chatMessageDataLog;

    public String result;

    @JsonCreator
    private Program(@JsonProperty("Result") String result, @JsonProperty("chatMessageDataLog") List<List<Object>> chatMessageDataLog) {
        this.result = result;
        this.chatMessageDataLog = new ArrayList<>();
        for (List<Object> obj : chatMessageDataLog)
            this.chatMessageDataLog.add(new ChatMessageDataLog((double) obj.get(0), (LinkedHashMap<String, Object>) obj.get(1)));
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Hello, World");

        String json = "{\"chatMessageDataLog\":[[1525770772.1816006,{\"color\":\"000000\",\"channel\":0,\"message\":\"155\",\"senderName\":\"test\\t\",\"uniqueId\":\"jfw2na25\\tjgxg3m0w\"}],[1525770856.9478872,{\"color\":\"000000\",\"channel\":0,\"message\":\"ccc\",\"senderName\":\"test\\t\",\"uniqueId\":\"jfw2na25\\tjgxg3m0w\"}]],\"result\":\"OK\"}";
        Program program = objectMapper.readValue(json, new TypeReference<Program>() {
        });

        System.out.println(program.result);
        System.out.println(program.chatMessageDataLog.get(1).getMessage());
    }
}
