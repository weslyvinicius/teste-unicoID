package br.com.test_unico.unicotest.adapter_in.representacao.response;

import br.com.test_unico.unicotest.adapter_in.util.ConstantsNames;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FeiraResponse {

    @JsonProperty(ConstantsNames.FEIRA_ID)
    private Long id;

    @JsonProperty(ConstantsNames.FEIRA_LONGITUDE)
    private Long longitude;

    @JsonProperty(ConstantsNames.FEIRA_LATITUDE)
    private Long latitude;

    @JsonProperty(ConstantsNames.FEIRA_SETCENS)
    private Long setcens;

    @JsonProperty(ConstantsNames.FEIRA_AREAP)
    private Long areap;

    @JsonProperty(ConstantsNames.FEIRA_CODIGO_DISTRITO)
    private Integer codigoDistrito;

    @JsonProperty(ConstantsNames.FEIRA_DISTRITO)
    private String distrito;

    @JsonProperty(ConstantsNames.FEIRA_CODIGO_SUB_PREFEITURA)
    private Long codigoSubPrefeitura;

    @JsonProperty(ConstantsNames.FEIRA_SUB_PREFEITURA)
    private String subPrefeitura;

    @JsonProperty(ConstantsNames.FEIRA_REGIAO_05)
    private String regiao05;

    @JsonProperty(ConstantsNames.FEIRA_REGIAO_08)
    private String regiao08;

    @JsonProperty(ConstantsNames.FEIRA_NOME_FEIRA)
    private String nomeDaFeira;

    @JsonProperty(ConstantsNames.FEIRA_REGISTRO)
    private String registro;

    @JsonProperty(ConstantsNames.FEIRA_LOGRADOURO)
    private String logradouro;

    @JsonProperty(ConstantsNames.FEIRA_NUMERO)
    private String numero;

    @JsonProperty(ConstantsNames.FEIRA_BAIRRO)
    private String bairro;

    @JsonProperty(ConstantsNames.FEIRA_REFERENCIA)
    private String referencia;


}
