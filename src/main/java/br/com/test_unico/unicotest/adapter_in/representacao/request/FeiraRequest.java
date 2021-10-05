package br.com.test_unico.unicotest.adapter_in.representacao.request;

import br.com.test_unico.unicotest.adapter_in.util.ConstantsNames;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeiraRequest {

    @NotNull
    @JsonProperty(ConstantsNames.FEIRA_LONGITUDE)
    private Long longitude;

    @NotNull
    @JsonProperty(ConstantsNames.FEIRA_LATITUDE)
    private Long latitude;

    @NotNull
    @JsonProperty(ConstantsNames.FEIRA_SETCENS)
    private Long setcens;

    @NotNull
    @JsonProperty(ConstantsNames.FEIRA_AREAP)
    private Long areap;

    @NotNull
    @JsonProperty(ConstantsNames.FEIRA_CODIGO_DISTRITO)
    private Integer codigoDistrito;

    @NotEmpty
    @JsonProperty(ConstantsNames.FEIRA_DISTRITO)
    private String distrito;

    @NotNull
    @JsonProperty(ConstantsNames.FEIRA_CODIGO_SUB_PREFEITURA)
    private Integer codigoSubPrefeitura;

    @NotEmpty
    @JsonProperty(ConstantsNames.FEIRA_SUB_PREFEITURA)
    private String subPrefeitura;

    @NotEmpty
    @JsonProperty(ConstantsNames.FEIRA_REGIAO_05)
    private String regiao05;

    @NotEmpty
    @JsonProperty(ConstantsNames.FEIRA_REGIAO_08)
    private String regiao08;

    @NotEmpty
    @JsonProperty(ConstantsNames.FEIRA_NOME_FEIRA)
    private String nomeDaFeira;

    @NotEmpty
    @JsonProperty(ConstantsNames.FEIRA_REGISTRO)
    private String registro;

    @NotEmpty
    @JsonProperty(ConstantsNames.FEIRA_LOGRADOURO)
    private String logradouro;

    @NotEmpty
    @JsonProperty(ConstantsNames.FEIRA_NUMERO)
    private String numero;

    @NotEmpty
    @JsonProperty(ConstantsNames.FEIRA_BAIRRO)
    private String bairro;

    @JsonProperty(ConstantsNames.FEIRA_REFERENCIA)
    private String referencia;


}
