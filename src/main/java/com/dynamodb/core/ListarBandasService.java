package com.dynamodb.core;

import com.dynamodb.core.domain.Banda;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dynamodb.core.ports.in.ListarBandasUseCase;
import com.dynamodb.core.ports.out.BandasPort;
import lombok.RequiredArgsConstructor; 

@Service
@RequiredArgsConstructor
public class ListarBandasService implements ListarBandasUseCase {

	private final BandasPort bandasPort;

	@Override
	public List<Banda> listar() {
		
		return bandasPort.listar();
	}	
}