# AMAZON SQS

Documento com o propósito simples de apenas fazer um Producer e Consumer de mensagens utilizando o AMAZON SQS.

- Será preciso criar um grupo para acessar o Amazon SQS com devidas permissões.
- Será necessário criar um USER no Amazon SQS.
- A Role é utilizada para acesso sem credenciais.
- Pode ser feito o acesso pelo: aws configure

- Para ler a fila (ACCOUNT_ID e QUEUE_NAME):
- Use o comando: aws sqs receive-message --queue-url https://sqs.us-east-1.amazonaws.com/999888777666/MyTestQueue

