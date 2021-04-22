package com.dynamodb.core;

import com.dynamodb.commons.exception.RepositoryException;
import com.dynamodb.core.domain.Banda;
import com.dynamodb.core.ports.in.ConsultarBandaUseCase;
import com.dynamodb.core.ports.out.BandasPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultarBandaService implements ConsultarBandaUseCase {

	private final BandasPort bandasPort;

	@Override
	public Banda consultarPorNomeEGeneroMusical(String nome, String generoMusical) {

		Optional<Banda> banda = bandasPort.consultarPorNomeEGeneroMusical(nome, generoMusical);

		if (banda.isEmpty()) {
			throw new RepositoryException(HttpStatus.NOT_FOUND,
					String.format("Banda '%s' de genero musical '%s' não encontrada", nome, generoMusical));
		}
		return banda.get();
	}

	@Override
	public List<Banda> consultarPorNome(String nome) {

		List<Banda> bandas = bandasPort.consultarPorNome(nome);

		if (bandas.isEmpty()) {
			throw new RepositoryException(HttpStatus.NOT_FOUND,
					String.format("Bandas com nome '%s' não encontradas", nome));
		}
		return bandas;
	}

	@Override
	public List<Banda> consultarPorNomePartiQL(String nome) {

		List<Banda> bandas = bandasPort.consultarPorNomePartiQL(nome);

		if (bandas.isEmpty()) {
			throw new RepositoryException(HttpStatus.NOT_FOUND,
					String.format("Bandas com nome '%s' não encontradas", nome));
		}
		return bandas;
	}

	@Override
	public List<Banda> consultarPorAnoLancamento(Long anoLancamento) {

		List<Banda> bandas = bandasPort.consultarPorAnoLancamento(anoLancamento);

		if (bandas.isEmpty()) {
			throw new RepositoryException(HttpStatus.NOT_FOUND,
					String.format("Bandas com ano de lancamento %d não encontradas", anoLancamento));
		}
		return bandas;
	}

	@Override
	public List<Banda> consultarPorRangeAnoLancamento(Long anoLancamentoInicial, Long anoLancamentoFinal) {

		List<Banda> bandas = bandasPort
				.consultarPorRangeAnoLancamento(anoLancamentoInicial, anoLancamentoFinal);

		if (bandas.isEmpty()) {
			throw new RepositoryException(HttpStatus.NOT_FOUND,
					String.format("Bandas com ano de lancamento entre %d e %d não encontradas",
							anoLancamentoInicial, anoLancamentoFinal));
		}
		return bandas;
	}
}