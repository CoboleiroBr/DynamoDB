package com.dynamodb.adapter.out.database.mapper;

import com.dynamodb.adapter.out.database.entity.MusicaEntity;
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
public class MusicaOutMapperImpl implements MusicaOutMapper {

    @Override
    public List<Musica> entityListToDomainList(List<MusicaEntity> musicas) {
        if ( musicas == null ) {
            return null;
        }

        List<Musica> list = new ArrayList<Musica>( musicas.size() );
        for ( MusicaEntity musicaEntity : musicas ) {
            list.add( musicaEntityToMusica( musicaEntity ) );
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
}
