package com.dynamodb.adapter.out.database.mapper;

import com.dynamodb.adapter.out.database.entity.BandaEntity;
import com.dynamodb.core.domain.Banda;
import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BandaOutMapper {
	
	BandaEntity domainToEntity(Banda banda);
	
	Banda entityToDomain(BandaEntity bandaEntity);

	List<Banda> entityListToDomainList(List<BandaEntity> bandas);
}