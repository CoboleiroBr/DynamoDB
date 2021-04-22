package com.dynamodb.adapter.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BandaDTO {

	@JsonProperty("nome")
	@NotBlank
	private String nome;

	@JsonProperty("genero_musical")
	@NotBlank
	private String generoMusical;

	@JsonProperty("sub_generos_musicais")
	private Set<String> subGenerosMusicais;

	@JsonProperty("ano_lancamento")
	private Long anoLancamento;

	@JsonProperty("albuns")
	private List<AlbumDTO> albuns;
}