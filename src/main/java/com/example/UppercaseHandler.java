package com.example;

import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import com.microsoft.azure.functions.*;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Optional;
import java.util.function.Function;

public class UppercaseHandler extends FunctionInvoker<Message<String>, String> {
    @FunctionName("uppercase")
    public String execute(@HttpTrigger(name = "req", methods = {HttpMethod.GET,
            HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
                          ExecutionContext context) {

        Message<String> message = MessageBuilder.withPayload(request.getBody().get()).copyHeaders(request.getHeaders()).build();
        return handleRequest(message, context);
    }
}
