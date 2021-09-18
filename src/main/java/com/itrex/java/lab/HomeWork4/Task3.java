package com.itrex.java.lab.HomeWork4;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Scanner;

/**
 * There is a class called Request(data: String)
 * for representing some XML requests in a payment system.
 * It has a getter for the data field and a constructor with a single argument.
 * <p>
 * The following is what the value of data looks like in a human-readable
 * format (it is a single line string when processing).
 *
 * <request>
 * <transaction>
 * <type>payment</type>
 * <sum>100000</sum>
 * <order_id>e94dc619-6172-4ffe-aae8-63112c551570</order>
 * <desc>We'd like to buy an elephant</desc>
 * </transaction>
 * <digest>CZVMYTgc3iiOdJjFP+6dhQ==</digest>
 * </request>
 * <p>
 * You must implement the chain of responsibility pattern in the functional style for
 * stage-by-stage request creating.
 * <p>
 * 1) Write the RequestHandler interface with a single abstract method called handle
 * and one default method; the first method is needed to use lambda expressions.
 * It should accept a Request object and then return a new Request with changed data.
 * The second method is used to combine several handlers into a single one.
 * <p>
 * 2) Create commonRequestHandler that is combined from three existing handlers:
 * wrapInTransactionTag, createDigest and wrapInRequestTag.
 * <p>
 * It is important to use the provided template for your solution.
 * Please, do not change it and read comments within the code.
 * The template is long enough, scroll it to the bottom.
 * All comments where your code is expected start with !!!
 * <p>
 * Keep in mind, all handlers have been already implemented and
 * they are available for you. You need to write only a suitable
 * functional interface and compose all existing handlers as functions
 * into one commonRequestHandler to follow the described algorithm.
 */

public class Task3 {

    /**
     * Accepts a request and returns new request with data wrapped in the tag <transaction>...</transaction>
     */
    static RequestHandler wrapInTransactionTag = req ->
            new Request(String.format("<transaction>%s</transaction>", req.getData()));

    /**
     * Accepts a request and returns a new request with calculated digest inside the tag <digest>...</digest>
     */
    final static RequestHandler createDigest = (req) -> {
        String digest = "";
        try {
            final MessageDigest md5 = MessageDigest.getInstance("MD5");
            final byte[] digestBytes = md5.digest(req.getData().getBytes("UTF-8"));
            digest = new String(Base64.getEncoder().encode(digestBytes));
        } catch (Exception ignored) {
        }
        return new Request(req.getData() + String.format("<digest>%s</digest>", digest));
    };

    /**
     * Accepts a request and returns a new request with data wrapped in the tag <request>...</request>
     */
    static RequestHandler wrapInRequestTag = req ->
            new Request(String.format("<request>%s</request>", req.getData()));

    /**
     * It should represents a chain of responsibility combined from another handlers.
     * The format: commonRequestHandler = handler1.setSuccessor(handler2.setSuccessor(...))
     * The combining method setSuccessor may has another name
     */
    static RequestHandler commonRequestHandler = wrapInTransactionTag.andThen(createDigest).andThen(wrapInRequestTag);
    // !!! write a combination of existing handlers here

    /**
     * It represents a handler and has two methods: one for handling requests and other for combining handlers
     */
    @FunctionalInterface
    interface RequestHandler {

        // !!! write a method handle that accept request and returns new request here
        // it allows to use lambda expressions for creating handlers below
        Request handle(Request request);

        // !!! write a default method for combining this and other handler single one
        // the order of execution may be any but you need to consider it when composing handlers
        // the method may has any name
        default RequestHandler andThen(RequestHandler other) {
            return (var2) -> other.handle(this.handle(var2));
        }
    }

    /**
     * Immutable class for representing requests.
     * If you need to change the request data then create new request.
     */
    static class Request {
        private final String data;

        public Request(String requestData) {
            this.data = requestData;
        }

        public String getData() {
            return data;
        }
    }

    // Don't change the code below
    public static void main(String[] args) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final String requestData = scanner.nextLine();
        final Request notCompletedRequest = new Request(requestData);
        System.out.println(commonRequestHandler.handle(notCompletedRequest).getData());
    }
}

