package com.dynamodb.adapter.out.database.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBDocument
public class AlbumEntity {

  private String nomeAlbum;

  private List<MusicaEntity> musicas;
}