package com.dynamodb.adapter.out.database.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.SaveBehavior;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExecuteStatementRequest;
import com.amazonaws.services.dynamodbv2.model.ExecuteStatementResult;
import com.dynamodb.adapter.out.database.entity.BandaEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DynamoDBRepository {

  private final AmazonDynamoDB amazonDynamoDB;
  private final DynamoDBMapper dynamoDBMapper;

  public void save(BandaEntity bandaEntity) {

    dynamoDBMapper.save(bandaEntity);
  }

  public void update(BandaEntity bandaEntity) {

    dynamoDBMapper.save(bandaEntity, SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES.config());
  }

  public void delete(BandaEntity bandaEntity) {

    dynamoDBMapper.delete(bandaEntity);
  }

  public Optional<BandaEntity> findByNomeEGeneroMusical(String nome, String generoMusical) {

    return Optional.ofNullable(dynamoDBMapper.load(BandaEntity.class, nome, generoMusical));
  }

  public List<BandaEntity> findByNome(String nome) {

    DynamoDBQueryExpression<BandaEntity> expression = new DynamoDBQueryExpression<BandaEntity>()
        .withHashKeyValues(BandaEntity.builder().nome(nome).build());

    return dynamoDBMapper.query(BandaEntity.class, expression);
  }

  public List<BandaEntity> findByNomePartiQL(String nome) {

    List<AttributeValue> parameters = new ArrayList<>();
    parameters.add(new AttributeValue(nome));

    ExecuteStatementRequest executeStatementRequest = new ExecuteStatementRequest()
        .withStatement("SELECT * FROM Banda where nome=?")
        .withParameters(parameters);

    ExecuteStatementResult result = amazonDynamoDB.executeStatement(executeStatementRequest);

    System.out.println("ExecuteStatement successful: "+ result.toString());

    List<BandaEntity> bandasEntity = new ArrayList<>();
    result.getItems().forEach(item -> formatar(bandasEntity, item));

    return bandasEntity;
  }

  public List<BandaEntity> findByAnoLancamento(Long anoLancamento) {

    DynamoDBQueryExpression<BandaEntity> expression = new DynamoDBQueryExpression<BandaEntity>()
        .withIndexName("anoLancamento_idx")
        .withHashKeyValues(BandaEntity.builder().anoLancamento(anoLancamento).build())
        .withConsistentRead(false);

    return dynamoDBMapper.query(BandaEntity.class, expression);
  }

  public List<BandaEntity> findByRangeAnoLancamento(Long anoLancamentoInicial, Long anoLancamentoFinal) {

    return dynamoDBMapper.scan(BandaEntity.class, new DynamoDBScanExpression()
        .withFilterExpression("anoLancamento between :anoLancamentoInicial and :anoLancamentoFinal")
        .withExpressionAttributeValues(Map.of(
            ":anoLancamentoInicial", new AttributeValue().withN(String.valueOf(anoLancamentoInicial)),
            ":anoLancamentoFinal", new AttributeValue().withN(String.valueOf(anoLancamentoFinal)))));
  }

  public List<BandaEntity> findAll() {

    return dynamoDBMapper.scan(BandaEntity.class, new DynamoDBScanExpression());
  }

  //Utilizando a interface de documento para acessar o Dynamo
    /*DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
    Table table = dynamoDB.getTable("Banda");
    QuerySpec spec = new QuerySpec().withHashKey(new KeyAttribute("nome", nome));

    ItemCollection<QueryOutcome> items = table.query(spec);

    List<BandaEntity> bandasEntity = new ArrayList<>();
    items.forEach(item -> formatar(bandasEntity, item));

    return bandasEntity;*/

  private boolean formatar(List<BandaEntity> bandasEntity, Map<String, AttributeValue> item) {
    return bandasEntity
        .add(BandaEntity.builder()
            .nome(item.get("nome").getS())
            .generoMusical(item.get("generoMusical").getS())
            .anoLancamento(Long.valueOf(item.get("anoLancamento").getN()))
            .subGenerosMusicais(item.get("subGenerosMusicais").getSS().stream().collect(Collectors.toSet()))
            .build());
  }
}