package com.dynamodb.adapter.in.dto.mapper;

import com.dynamodb.adapter.in.dto.AlbumDTO;
import com.dynamodb.adapter.in.dto.MusicaDTO;
import com.dynamodb.core.domain.Album;
import com.dynamodb.core.domain.Musica;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-21T23:15:57-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class AlbumInMapperImpl implements AlbumInMapper {

    @Override
    public List<AlbumDTO> domainListToDTOList(List<Album> albuns) {
        if ( albuns == null ) {
            return null;
        }

        List<AlbumDTO> list = new ArrayList<AlbumDTO>( albuns.size() );
        for ( Album album : albuns ) {
            list.add( albumToAlbumDTO( album ) );
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

    protected List<MusicaDTO> musicaListToMusicaDTOList(List<Musica> list) {
        if ( list == null ) {
            return null;
        }

        List<MusicaDTO> list1 = new ArrayList<MusicaDTO>( list.size() );
        for ( Musica musica : list ) {
            list1.add( musicaToMusicaDTO( musica ) );
        }

        return list1;
    }

    protected AlbumDTO albumToAlbumDTO(Album album) {
        if ( album == null ) {
            return null;
        }

        AlbumDTO albumDTO = new AlbumDTO();

        albumDTO.setNomeAlbum( album.getNomeAlbum() );
        albumDTO.setMusicas( musicaListToMusicaDTOList( album.getMusicas() ) );

        return albumDTO;
    }
}
