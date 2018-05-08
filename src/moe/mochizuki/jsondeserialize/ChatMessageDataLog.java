package moe.mochizuki.jsondeserialize;

import java.util.LinkedHashMap;

public class ChatMessageDataLog {
    public double timestamp;
    private LinkedHashMap<String, Object> hashMap;

    public ChatMessageDataLog(double timestamp, LinkedHashMap<String, Object> hashMap) {
        this.timestamp = timestamp;
        this.hashMap = hashMap;
    }

    public String getColor() {
        return (String) this.hashMap.get("color");
    }

    public int getChannel() {
        return (int) this.hashMap.get("channel");
    }

    public String getMessage() {
        return (String) this.hashMap.get("message");
    }

    public String getSenderName() {
        return (String) this.hashMap.get("senderName");
    }

    public String getUniqueId() {
        return (String) this.hashMap.get("uniqueId");
    }
}
