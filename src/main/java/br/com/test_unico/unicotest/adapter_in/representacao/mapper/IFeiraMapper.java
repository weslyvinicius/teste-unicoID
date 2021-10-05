package br.com.test_unico.unicotest.adapter_in.representacao.mapper;


import br.com.test_unico.unicotest.adapter_in.representacao.request.FeiraCriteriaRequest;
import br.com.test_unico.unicotest.adapter_in.representacao.request.FeiraRequest;
import br.com.test_unico.unicotest.adapter_in.representacao.request.ImportFeiraRequest;
import br.com.test_unico.unicotest.adapter_in.representacao.response.FeiraResponse;
import br.com.test_unico.unicotest.aplication.domain.Feira;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IFeiraMapper {

    Feira toDomain(FeiraRequest feiraRequest);

    FeiraResponse toResponse(Feira feira);

    List<FeiraResponse> toResponseList(List<Feira> feiraList);

    Feira toDomain(FeiraCriteriaRequest feiraCriteriaRequest);

    List<Feira> toDomainList(List<ImportFeiraRequest> importFeiraRequests);

    Feira toDomainList(ImportFeiraRequest importFeiraRequests);

}
