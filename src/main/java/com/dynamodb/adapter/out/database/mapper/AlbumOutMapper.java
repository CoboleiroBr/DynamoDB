package com.dynamodb.adapter.out.database.mapper;

import com.dynamodb.adapter.out.database.entity.AlbumEntity;
import com.dynamodb.core.domain.Album;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlbumOutMapper {
	
	List<Album> entityListToDomainList(List<AlbumEntity> albuns);
}