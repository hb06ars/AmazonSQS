package org.example;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;
import software.amazon.awssdk.services.sqs.model.CreateQueueResponse;

public class CreateQueue {

    // Criar uma fila SQS
    public static String execute(SqsClient sqsClient) {
        String QUEUE_NAME = "MyTestQueue"; // Nome da fila

        CreateQueueRequest createQueueRequest = CreateQueueRequest.builder()
                .queueName(QUEUE_NAME)
                .build();
        CreateQueueResponse createQueueResponse = sqsClient.createQueue(createQueueRequest);
        return createQueueResponse.queueUrl();
    }

}
