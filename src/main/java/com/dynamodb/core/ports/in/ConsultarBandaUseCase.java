package com.dynamodb.core.ports.in;

import com.dynamodb.core.domain.Banda;
import java.util.List;

public interface ConsultarBandaUseCase {

	List<Banda> consultarPorNome(String nome);

	List<Banda> consultarPorNomePartiQL(String nome);

	Banda consultarPorNomeEGeneroMusical(String nome, String generoMusical);

	List<Banda> consultarPorAnoLancamento(Long anoLancamento);

	List<Banda> consultarPorRangeAnoLancamento(Long anoLancamentoInicial, Long anoLancamentoFinal);
}