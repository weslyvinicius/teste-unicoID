package br.com.test_unico.unicotest.aplication.domain;

import br.com.test_unico.unicotest.aplication.exception.AlteracaoDeRegistroNaoPermitidoException;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Feira {

    private Long id;

    private Long longitude;

    private Long latitude;

    private Long setcens;

    private Long areap;

    private Integer codigoDistrito;

    private String distrito;

    private Integer codigoSubPrefeitura;

    private String subPrefeitura;

    private String regiao05;

    private String regiao08;

    private String nomeDaFeira;

    private String registro;

    private String logradouro;

    private String numero;

    private String bairro;

    private String referencia;

    public void atualizaDadosFeira(Feira feira){
        this.longitude= feira.longitude;
        this.latitude= feira.latitude;
        this.setcens= feira.setcens;
        this.areap= feira.areap;
        this.codigoDistrito= feira.codigoDistrito;
        this.distrito= feira.distrito;
        this.codigoSubPrefeitura= feira.codigoSubPrefeitura;
        this.subPrefeitura= feira.subPrefeitura;
        this.regiao05= feira.regiao05;
        this.regiao08= feira.regiao08;
        this.nomeDaFeira= feira.nomeDaFeira;
        this.logradouro= feira.logradouro;
        this.numero= feira.numero;
        this.bairro= feira.bairro;
        this.referencia= feira.referencia;

        if( !this.registro.equalsIgnoreCase(feira.registro)){
            throw new AlteracaoDeRegistroNaoPermitidoException();
        }else
            this.registro = feira.registro;
    }

}
