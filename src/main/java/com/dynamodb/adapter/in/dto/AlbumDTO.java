package com.dynamodb.adapter.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDTO {

  @JsonProperty("nome_album")
  private String nomeAlbum;

  @JsonProperty("musicas")
  private List<MusicaDTO> musicas;
}