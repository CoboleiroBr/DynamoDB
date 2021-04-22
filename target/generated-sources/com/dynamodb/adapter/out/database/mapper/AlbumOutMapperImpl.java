package com.dynamodb.adapter.out.database.mapper;

import com.dynamodb.adapter.out.database.entity.AlbumEntity;
import com.dynamodb.adapter.out.database.entity.MusicaEntity;
import com.dynamodb.core.domain.Album;
import com.dynamodb.core.domain.Musica;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-21T23:15:56-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class AlbumOutMapperImpl implements AlbumOutMapper {

    @Override
    public List<Album> entityListToDomainList(List<AlbumEntity> albuns) {
        if ( albuns == null ) {
            return null;
        }

        List<Album> list = new ArrayList<Album>( albuns.size() );
        for ( AlbumEntity albumEntity : albuns ) {
            list.add( albumEntityToAlbum( albumEntity ) );
        }

        return list;
    }

    protected Musica musicaEntityToMusica(MusicaEntity musicaEntity) {
        if ( musicaEntity == null ) {
            return null;
        }

        Musica musica = new Musica();

        musica.setNomeMusica( musicaEntity.getNomeMusica() );

        return musica;
    }

    protected List<Musica> musicaEntityListToMusicaList(List<MusicaEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Musica> list1 = new ArrayList<Musica>( list.size() );
        for ( MusicaEntity musicaEntity : list ) {
            list1.add( musicaEntityToMusica( musicaEntity ) );
        }

        return list1;
    }

    protected Album albumEntityToAlbum(AlbumEntity albumEntity) {
        if ( albumEntity == null ) {
            return null;
        }

        Album album = new Album();

        album.setNomeAlbum( albumEntity.getNomeAlbum() );
        album.setMusicas( musicaEntityListToMusicaList( albumEntity.getMusicas() ) );

        return album;
    }
}
