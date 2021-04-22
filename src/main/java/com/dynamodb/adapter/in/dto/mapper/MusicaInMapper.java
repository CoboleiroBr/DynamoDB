package com.dynamodb.adapter.in.dto.mapper;

import com.dynamodb.adapter.in.dto.MusicaDTO;
import com.dynamodb.core.domain.Musica;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MusicaInMapper {

  List<MusicaDTO> domainListToDTOList(List<Musica> musicas);
}