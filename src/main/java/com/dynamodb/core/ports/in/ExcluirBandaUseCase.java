package com.dynamodb.core.ports.in;

import com.dynamodb.core.domain.Banda;

public interface ExcluirBandaUseCase {

	void excluir(Banda banda);
}