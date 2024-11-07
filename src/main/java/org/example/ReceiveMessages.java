package org.example;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;

import java.util.List;

public class ReceiveMessages {

    // Receber mensagens da fila
    public static void execute(SqsClient sqsClient, String queueUrl) {
        ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(1)
                .build();
        ReceiveMessageResponse receiveMessageResponse = sqsClient.receiveMessage(receiveMessageRequest);
        List<Message> messages = receiveMessageResponse.messages();
        for (Message message : messages) {
            System.out.println("Mensagem recebida: " + message.body());
            // Excluir mensagem após o processamento
            DeleteMessage.execute(sqsClient, queueUrl, message.receiptHandle());
        }
    }

}
