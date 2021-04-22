package com.dynamodb.adapter.out.database.mapper;

import com.dynamodb.adapter.out.database.entity.MusicaEntity;
import com.dynamodb.core.domain.Musica;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MusicaOutMapper {
	
	List<Musica> entityListToDomainList(List<MusicaEntity> musicas);
}