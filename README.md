#DynamoDB

## Ambiente local
Para executar a aplicação em ambiente local faz-se necessários alguns passos:

1 - Executar o docker-compose.yml

2 - Configurar o ambiente AWS através do AWS CLI, conforme abaixo:

    aws configure
    Key ID: root
    Access Key: root
    Region: sa-east-1
    Format: text

3 - Criar a tabela "Banda" (no diretório Scripts), conforme abaixo:

    aws dynamodb create-table --cli-input-json file://banda_table.json --endpoint-url=http://localhost:8000

4 - Executar a aplicação
