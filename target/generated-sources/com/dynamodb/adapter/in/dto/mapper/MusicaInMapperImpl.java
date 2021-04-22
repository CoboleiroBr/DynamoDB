package com.dynamodb.adapter.in.dto.mapper;

import com.dynamodb.adapter.in.dto.MusicaDTO;
import com.dynamodb.core.domain.Musica;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-21T23:15:58-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class MusicaInMapperImpl implements MusicaInMapper {

    @Override
    public List<MusicaDTO> domainListToDTOList(List<Musica> musicas) {
        if ( musicas == null ) {
            return null;
        }

        List<MusicaDTO> list = new ArrayList<MusicaDTO>( musicas.size() );
        for ( Musica musica : musicas ) {
            list.add( musicaToMusicaDTO( musica ) );
        }

        return list;
    }

    protected MusicaDTO musicaToMusicaDTO(Musica musica) {
        if ( musica == null ) {
            return null;
        }

        MusicaDTO musicaDTO = new MusicaDTO();

        musicaDTO.setNomeMusica( musica.getNomeMusica() );

        return musicaDTO;
    }
}
