package com.dynamodb.adapter.in.dto.mapper;

import com.dynamodb.adapter.in.dto.BandaDTO;
import com.dynamodb.core.domain.Banda;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BandaInMapper {

  BandaDTO domainToDTO(Banda banda);

  List<BandaDTO> domainListToDTOList(List<Banda> bandas);

  Banda requestToDomain(BandaDTO bandaDTO);
}
