package com.dynamodb.adapter.out.database;

import com.dynamodb.adapter.out.database.entity.BandaEntity;
import com.dynamodb.adapter.out.database.mapper.BandaOutMapper;
import com.dynamodb.adapter.out.database.repository.DynamoDBRepository;
import com.dynamodb.core.domain.Banda;
import com.dynamodb.core.ports.out.BandasPort;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BandaPersistenceAdapter implements BandasPort {

	private final DynamoDBRepository bandaRepository;

	private final BandaOutMapper bandaOutMapper;

	@Override
	public void incluir(Banda banda) {

		BandaEntity bandaEntity = bandaOutMapper.domainToEntity(banda);
		bandaEntity.setDataCriacao(new Date());

		bandaRepository.save(bandaEntity);
	}

	@Override
	public void alterar(Banda banda) {

		BandaEntity bandaEntity = bandaOutMapper.domainToEntity(banda);

		bandaRepository.update(bandaEntity);
	}

	@Override
	public void excluir(Banda banda) {

		BandaEntity bandaEntity = bandaOutMapper.domainToEntity(banda);

		bandaRepository.delete(bandaEntity);
	}

	@Override
	public Optional<Banda> consultarPorNomeEGeneroMusical(String nome, String generoMusical) {

		Optional<BandaEntity> bandaEntity = bandaRepository.findByNomeEGeneroMusical(nome, generoMusical);

		return bandaEntity.map(bandaOutMapper::entityToDomain);
	}

	@Override
	public List<Banda> consultarPorNome(String nome) {

		List<BandaEntity> BandasEntity = bandaRepository.findByNome(nome);

		return bandaOutMapper.entityListToDomainList(BandasEntity);
	}

	@Override
	public List<Banda> consultarPorNomePartiQL(String nome) {

		List<BandaEntity> BandasEntity = bandaRepository.findByNomePartiQL(nome);

		return bandaOutMapper.entityListToDomainList(BandasEntity);
	}

	@Override
	public List<Banda> consultarPorAnoLancamento(Long anoLancamento) {

		List<BandaEntity> BandasEntity = bandaRepository.findByAnoLancamento(anoLancamento);

		return bandaOutMapper.entityListToDomainList(BandasEntity);
	}

	@Override
	public List<Banda> consultarPorRangeAnoLancamento(Long anoLancamentoInicial,
			Long anoLancamentoFinal) {

		List<BandaEntity> BandasEntity = bandaRepository
				.findByRangeAnoLancamento(anoLancamentoInicial, anoLancamentoFinal);

		return bandaOutMapper.entityListToDomainList(BandasEntity);
	}

	@Override
	public List<Banda> listar() {
		
		List<BandaEntity> BandasEntity = bandaRepository.findAll();
		
		return bandaOutMapper.entityListToDomainList(BandasEntity);
	}
}