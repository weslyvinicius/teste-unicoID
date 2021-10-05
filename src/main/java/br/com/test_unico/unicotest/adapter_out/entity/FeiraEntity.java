package br.com.test_unico.unicotest.adapter_out.entity;

import br.com.test_unico.unicotest.adapter_in.util.ConstantsNames;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "feiras")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeiraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ConstantsNames.FEIRA_TABLE_ID)
    private Long id;

    @Column(name = ConstantsNames.FEIRA_TABLE_LONGITUDE)
    private Long longitude;

    @Column(name = ConstantsNames.FEIRA_TABLE_LATITUDE)
    private Long latitude;

    @Column(name = ConstantsNames.FEIRA_TABLE_SETCENS)
    private Long setcens;

    @Column(name = ConstantsNames.FEIRA_TABLE_AREAP)
    private Long areap;

    @Column(name = ConstantsNames.FEIRA_TABLE_CODIGO_DISTRITO)
    private Integer codigoDistrito;

    @Column(name = ConstantsNames.FEIRA_TABLE_DISTRITO)
    private String distrito;

    @Column(name = ConstantsNames.FEIRA_TABLE_CODIGO_SUB_PREFEITURA)
    private Long codigoSubPrefeitura;

    @Column(name = ConstantsNames.FEIRA_TABLE_SUB_PREFEITURA)
    private String subPrefeitura;

    @Column(name = ConstantsNames.FEIRA_TABLE_REGIAO_05)
    private String regiao05;

    @Column(name = ConstantsNames.FEIRA_TABLE_REGIAO_08)
    private String regiao08;

    @Column(name = ConstantsNames.FEIRA_TABLE_NOME_FEIRA)
    private String nomeDaFeira;

    @Column(name = ConstantsNames.FEIRA_TABLE_REGISTRO, unique = true)
    private String registro;

    @Column(name = ConstantsNames.FEIRA_TABLE_LOGRADOURO)
    private String logradouro;

    @Column(name = ConstantsNames.FEIRA_TABLE_NUMERO)
    private String numero;

    @Column(name = ConstantsNames.FEIRA_TABLE_BAIRRO)
    private String bairro;

    @Column(name = ConstantsNames.FEIRA_TABLE_REFERENCIA)
    private String referencia;


}
