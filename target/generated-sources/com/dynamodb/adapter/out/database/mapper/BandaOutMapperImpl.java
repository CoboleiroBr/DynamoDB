package com.dynamodb.adapter.out.database.mapper;

import com.dynamodb.adapter.out.database.entity.AlbumEntity;
import com.dynamodb.adapter.out.database.entity.BandaEntity;
import com.dynamodb.adapter.out.database.entity.MusicaEntity;
import com.dynamodb.core.domain.Album;
import com.dynamodb.core.domain.Banda;
import com.dynamodb.core.domain.Musica;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-21T23:15:57-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class BandaOutMapperImpl implements BandaOutMapper {

    @Override
    public BandaEntity domainToEntity(Banda banda) {
        if ( banda == null ) {
            return null;
        }

        BandaEntity bandaEntity = new BandaEntity();

        bandaEntity.setNome( banda.getNome() );
        bandaEntity.setGeneroMusical( banda.getGeneroMusical() );
        Set<String> set = banda.getSubGenerosMusicais();
        if ( set != null ) {
            bandaEntity.setSubGenerosMusicais( new HashSet<String>( set ) );
        }
        bandaEntity.setAnoLancamento( banda.getAnoLancamento() );
        bandaEntity.setAlbuns( albumListToAlbumEntityList( banda.getAlbuns() ) );

        return bandaEntity;
    }

    @Override
    public Banda entityToDomain(BandaEntity bandaEntity) {
        if ( bandaEntity == null ) {
            return null;
        }

        Banda banda = new Banda();

        banda.setNome( bandaEntity.getNome() );
        banda.setGeneroMusical( bandaEntity.getGeneroMusical() );
        Set<String> set = bandaEntity.getSubGenerosMusicais();
        if ( set != null ) {
            banda.setSubGenerosMusicais( new HashSet<String>( set ) );
        }
        banda.setAnoLancamento( bandaEntity.getAnoLancamento() );
        banda.setAlbuns( albumEntityListToAlbumList( bandaEntity.getAlbuns() ) );

        return banda;
    }

    @Override
    public List<Banda> entityListToDomainList(List<BandaEntity> bandas) {
        if ( bandas == null ) {
            return null;
        }

        List<Banda> list = new ArrayList<Banda>( bandas.size() );
        for ( BandaEntity bandaEntity : bandas ) {
            list.add( entityToDomain( bandaEntity ) );
        }

        return list;
    }

    protected MusicaEntity musicaToMusicaEntity(Musica musica) {
        if ( musica == null ) {
            return null;
        }

        MusicaEntity musicaEntity = new MusicaEntity();

        musicaEntity.setNomeMusica( musica.getNomeMusica() );

        return musicaEntity;
    }

    protected List<MusicaEntity> musicaListToMusicaEntityList(List<Musica> list) {
        if ( list == null ) {
            return null;
        }

        List<MusicaEntity> list1 = new ArrayList<MusicaEntity>( list.size() );
        for ( Musica musica : list ) {
            list1.add( musicaToMusicaEntity( musica ) );
        }

        return list1;
    }

    protected AlbumEntity albumToAlbumEntity(Album album) {
        if ( album == null ) {
            return null;
        }

        AlbumEntity albumEntity = new AlbumEntity();

        albumEntity.setNomeAlbum( album.getNomeAlbum() );
        albumEntity.setMusicas( musicaListToMusicaEntityList( album.getMusicas() ) );

        return albumEntity;
    }

    protected List<AlbumEntity> albumListToAlbumEntityList(List<Album> list) {
        if ( list == null ) {
            return null;
        }

        List<AlbumEntity> list1 = new ArrayList<AlbumEntity>( list.size() );
        for ( Album album : list ) {
            list1.add( albumToAlbumEntity( album ) );
        }

        return list1;
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

    protected List<Album> albumEntityListToAlbumList(List<AlbumEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Album> list1 = new ArrayList<Album>( list.size() );
        for ( AlbumEntity albumEntity : list ) {
            list1.add( albumEntityToAlbum( albumEntity ) );
        }

        return list1;
    }
}
