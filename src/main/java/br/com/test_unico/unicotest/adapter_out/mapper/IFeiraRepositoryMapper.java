package br.com.test_unico.unicotest.adapter_out.mapper;


import br.com.test_unico.unicotest.adapter_out.entity.FeiraEntity;
import br.com.test_unico.unicotest.aplication.domain.Feira;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IFeiraRepositoryMapper {

    FeiraEntity toEntity(Feira feira);

    List<FeiraEntity> toEntityList(List<Feira> feiraList);

    Feira toDomain(FeiraEntity feiraEntity);

    List<Feira> toDomainList(List<FeiraEntity> feiraEntityList);





}
