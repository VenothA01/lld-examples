package com.dailycoder.behavioural;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

interface Router{

   public void route(Message msg);
}

class SMSRouter implements Router{

     public void route(Message msg){
         System.out.println("Routing SMS");
    }
}

class JMSRouter implements Router{

    public void route(Message msg){
        System.out.println("Routing SMS");
    }
}

class NullRouter implements Router{

    public void route(Message msg){
        System.out.println("Route Nothing");
        return;
    }
}

class Message {

    private String body;

    private String priority;

    public Message(String body, String priority) {
        this.body = body;
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "{body='" + body + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}

class RouterFactory{


    public static Router getRouterForMessage(Message msg) {

        if (msg.getPriority() == null) {
            return new NullRouter();
        }

        switch (msg.getPriority()) {
            case "high":
                return new SMSRouter();

            case "medium":
                return new JMSRouter();

            default:
                return new NullRouter();
        }

    }
}


public class RoutingHandler {


    public void handle(Iterable<Message> messages) {
        for (Message msg : messages) {
            Router router = RouterFactory.getRouterForMessage(msg);
            router.route(msg);
        }
    }


    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};

        Map<Integer,Long> map = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);


        Message highPriorityMsg = new Message("Alert!", "high");
        Message mediumPriorityMsg = new Message("Warning!", "medium");
        Message lowPriorityMsg = new Message("Take a look!", "low");
        Message nullPriorityMsg = new Message("Take a look!", null);

        List<Message> messages = Arrays.asList(highPriorityMsg,
                mediumPriorityMsg,
                lowPriorityMsg,
                nullPriorityMsg);

        RoutingHandler routingHandler = new RoutingHandler();
        routingHandler.handle(messages);

    }
}
