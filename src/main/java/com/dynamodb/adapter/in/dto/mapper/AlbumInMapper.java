package com.dynamodb.adapter.in.dto.mapper;

import com.dynamodb.adapter.in.dto.AlbumDTO;
import com.dynamodb.adapter.in.dto.BandaDTO;
import com.dynamodb.core.domain.Album;
import com.dynamodb.core.domain.Banda;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlbumInMapper {

  List<AlbumDTO> domainListToDTOList(List<Album> albuns);
}