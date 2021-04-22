package com.dynamodb.core.ports.out;

import com.dynamodb.core.domain.Banda;
import java.util.List;
import java.util.Optional;

public interface BandasPort {

	void incluir(Banda banda);

	void alterar(Banda banda);

	void excluir(Banda banda);

	Optional<Banda> consultarPorNomeEGeneroMusical(String nome, String generoMusical);

	List<Banda> consultarPorNome(String nome);

	List<Banda> consultarPorNomePartiQL(String nome);

	List<Banda> consultarPorAnoLancamento(Long anoLancamento);

	List<Banda> consultarPorRangeAnoLancamento(Long anoLancamentoInicial, Long anoLancamentoFinal);

	List<Banda> listar();
}