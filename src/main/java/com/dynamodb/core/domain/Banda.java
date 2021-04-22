package com.dynamodb.core.domain;

import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Banda {
	
	private String nome;
		
	private String generoMusical;

	private Set<String> subGenerosMusicais;

	private Long anoLancamento;

	private List<Album> albuns;
}