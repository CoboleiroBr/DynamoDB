package com.dynamodb.core.ports.in;

import com.dynamodb.core.domain.Banda;
import java.util.List;

public interface ListarBandasUseCase {

	List<Banda> listar();
}
