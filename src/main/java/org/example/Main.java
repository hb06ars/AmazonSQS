package org.example;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

import java.util.List;

public class Main {

    private static final Region REGION = Region.US_EAST_1; // Região onde o SQS está configurado

    public static void main(String[] args) {

        // Criando cliente SQS
        try (SqsClient sqsClient = SqsClient.builder()
                .region(REGION)
                .credentialsProvider(ProfileCredentialsProvider.create()) // Utilizando o perfil configurado
                .build()) {

            // Passo 1: Criar a fila SQS
            String queueUrl = CreateQueue.execute(sqsClient);
            System.out.println("Fila criada com sucesso. URL da fila: " + queueUrl);

            // Passo 2: Enviar uma mensagem para a fila
            SendMessage.execute(sqsClient, queueUrl, "Mensagem de teste 1");

            // Passo 3: Receber a mensagem da fila
            ReceiveMessages.execute(sqsClient, queueUrl);

            // Passo 4: Excluir a fila (opcional)
            DeleteQueue.execute(sqsClient, queueUrl);

        }
    }
}
