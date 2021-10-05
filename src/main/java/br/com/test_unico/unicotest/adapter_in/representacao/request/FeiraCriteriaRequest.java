package br.com.test_unico.unicotest.adapter_in.representacao.request;

import br.com.test_unico.unicotest.adapter_in.util.ConstantsNames;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeiraCriteriaRequest {

    @JsonProperty(ConstantsNames.FEIRA_DISTRITO)
    private String distrito;

    @JsonProperty(ConstantsNames.FEIRA_REGIAO_05)
    private String regiao05;

    @JsonProperty(ConstantsNames.FEIRA_NOME_FEIRA)
    private String nomeDaFeira;

    @JsonProperty(ConstantsNames.FEIRA_BAIRRO)
    private String bairro;
}
