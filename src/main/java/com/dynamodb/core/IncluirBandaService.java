package com.dynamodb.core;

import com.dynamodb.core.domain.Banda;
import com.dynamodb.core.ports.in.IncluirBandaUseCase;
import com.dynamodb.core.ports.out.BandasPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IncluirBandaService implements IncluirBandaUseCase {

	private final BandasPort bandasPort;

	@Override
	public void incluir(Banda banda) {
		
		bandasPort.incluir(banda);
	}

	@Override
	public void alterar(Banda banda) {

		bandasPort.alterar(banda);
	}
}