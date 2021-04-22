package com.dynamodb.core.ports.in;

import com.dynamodb.core.domain.Banda;

public interface IncluirBandaUseCase {

	void incluir(Banda banda);

	void alterar(Banda banda);
}