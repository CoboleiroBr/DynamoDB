package com.dynamodb.adapter.in.dto.mapper;

import com.dynamodb.adapter.in.dto.AlbumDTO;
import com.dynamodb.adapter.in.dto.BandaDTO;
import com.dynamodb.adapter.in.dto.MusicaDTO;
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
public class BandaInMapperImpl implements BandaInMapper {

    @Override
    public BandaDTO domainToDTO(Banda banda) {
        if ( banda == null ) {
            return null;
        }

        BandaDTO bandaDTO = new BandaDTO();

        bandaDTO.setNome( banda.getNome() );
        bandaDTO.setGeneroMusical( banda.getGeneroMusical() );
        Set<String> set = banda.getSubGenerosMusicais();
        if ( set != null ) {
            bandaDTO.setSubGenerosMusicais( new HashSet<String>( set ) );
        }
        bandaDTO.setAnoLancamento( banda.getAnoLancamento() );
        bandaDTO.setAlbuns( albumListToAlbumDTOList( banda.getAlbuns() ) );

        return bandaDTO;
    }

    @Override
    public List<BandaDTO> domainListToDTOList(List<Banda> bandas) {
        if ( bandas == null ) {
            return null;
        }

        List<BandaDTO> list = new ArrayList<BandaDTO>( bandas.size() );
        for ( Banda banda : bandas ) {
            list.add( domainToDTO( banda ) );
        }

        return list;
    }

    @Override
    public Banda requestToDomain(BandaDTO bandaDTO) {
        if ( bandaDTO == null ) {
            return null;
        }

        Banda banda = new Banda();

        banda.setNome( bandaDTO.getNome() );
        banda.setGeneroMusical( bandaDTO.getGeneroMusical() );
        Set<String> set = bandaDTO.getSubGenerosMusicais();
        if ( set != null ) {
            banda.setSubGenerosMusicais( new HashSet<String>( set ) );
        }
        banda.setAnoLancamento( bandaDTO.getAnoLancamento() );
        banda.setAlbuns( albumDTOListToAlbumList( bandaDTO.getAlbuns() ) );

        return banda;
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

    protected List<AlbumDTO> albumListToAlbumDTOList(List<Album> list) {
        if ( list == null ) {
            return null;
        }

        List<AlbumDTO> list1 = new ArrayList<AlbumDTO>( list.size() );
        for ( Album album : list ) {
            list1.add( albumToAlbumDTO( album ) );
        }

        return list1;
    }

    protected Musica musicaDTOToMusica(MusicaDTO musicaDTO) {
        if ( musicaDTO == null ) {
            return null;
        }

        Musica musica = new Musica();

        musica.setNomeMusica( musicaDTO.getNomeMusica() );

        return musica;
    }

    protected List<Musica> musicaDTOListToMusicaList(List<MusicaDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Musica> list1 = new ArrayList<Musica>( list.size() );
        for ( MusicaDTO musicaDTO : list ) {
            list1.add( musicaDTOToMusica( musicaDTO ) );
        }

        return list1;
    }

    protected Album albumDTOToAlbum(AlbumDTO albumDTO) {
        if ( albumDTO == null ) {
            return null;
        }

        Album album = new Album();

        album.setNomeAlbum( albumDTO.getNomeAlbum() );
        album.setMusicas( musicaDTOListToMusicaList( albumDTO.getMusicas() ) );

        return album;
    }

    protected List<Album> albumDTOListToAlbumList(List<AlbumDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Album> list1 = new ArrayList<Album>( list.size() );
        for ( AlbumDTO albumDTO : list ) {
            list1.add( albumDTOToAlbum( albumDTO ) );
        }

        return list1;
    }
}
