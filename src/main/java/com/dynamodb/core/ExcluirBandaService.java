package com.dynamodb.core;

import com.dynamodb.core.domain.Banda;
import com.dynamodb.core.ports.in.ExcluirBandaUseCase;
import com.dynamodb.core.ports.out.BandasPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExcluirBandaService implements ExcluirBandaUseCase {

	private final BandasPort bandasPort;

	@Override
	public void excluir(Banda banda) {
		
		bandasPort.excluir(banda);
	}	
}