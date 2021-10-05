package br.com.test_unico.unicotest.aplication.usecase;

import br.com.test_unico.unicotest.aplication.domain.Feira;
import br.com.test_unico.unicotest.aplication.exception.AlteracaoDeRegistroNaoPermitidoException;
import br.com.test_unico.unicotest.aplication.exception.ResultNotFoundException;
import br.com.test_unico.unicotest.aplication.port.out.IFeiraRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UseCaseFeiraTest {

    @InjectMocks
    private UseCaseFeira useCaseFeira;

    @Mock
    private IFeiraRepository feiraRepository;

    @Test
    void cadastrarFeira() {

        Mockito.when(feiraRepository.salvarFeira(Mockito.any())).thenReturn(buildClassFeiraRetorno());
        final Feira result = useCaseFeira.cadastrarFeira(buildClassFeira());

        Assertions.assertEquals(1L, result.getId());
        Assertions.assertEquals("4041-0", result.getRegistro());

    }

    @Test
    void atualizarCadastroFeira() {
        List<Feira> feiraList = Arrays.asList(buildClassFeiraRetorno());
        Mockito.when(feiraRepository.buscarFeira(Mockito.any())).thenReturn(feiraList);
        Mockito.when(feiraRepository.updateFeira(Mockito.any())).thenReturn(buildClassFeiraRetornoUpdate());

        final Feira result = useCaseFeira.atualizarCadastroFeira(buildClassFeiraUpdate(), 1L);

        Assertions.assertEquals(1L, result.getId());
        Assertions.assertEquals("4041-0", result.getRegistro());
        Assertions.assertEquals("VILA MADALENA", result.getDistrito());
    }

    @Test
    void atualizarCadastroFeiraResultNotFoundException() {
        Mockito.when(feiraRepository.buscarFeira(Mockito.any())).thenReturn(Collections.emptyList());

        Assertions.assertThrows(ResultNotFoundException.class, () -> useCaseFeira.atualizarCadastroFeira(buildClassFeiraUpdate(), 1L));

    }

    @Test
    void atualizarCadastroFeiraAlteracaoDeRegistroNaoPermitidoException() {
        List<Feira> feiraList = Arrays.asList(buildClassFeiraRetorno());
        Mockito.when(feiraRepository.buscarFeira(Mockito.any())).thenReturn(feiraList);

        Assertions.assertThrows(AlteracaoDeRegistroNaoPermitidoException.class, () ->
                useCaseFeira.atualizarCadastroFeira(buildClassFeiraUpdatNaoPermitido(), 1L));

    }

    @Test
    void buscarFeira() {

        List<Feira> feiraList = Arrays.asList(buildClassFeiraRetorno());
        Mockito.when(feiraRepository.buscarFeira(Mockito.any())).thenReturn(feiraList);

        var feiraListResult = useCaseFeira.buscarFeira(buildClassFeiraFilter());

        Assertions.assertEquals(1, feiraListResult.size());
        Assertions.assertEquals(1L, feiraListResult.get(0).getId());
        Assertions.assertEquals("4041-0", feiraListResult.get(0).getRegistro());
        Assertions.assertEquals("VILA FORMOSA", feiraListResult.get(0).getDistrito());
    }

    @Test
    void importListaDeFeira() {

        useCaseFeira.importListaDeFeira(List.of(buildClassFeira(), buildClassFeira()));
        Mockito.verify(feiraRepository, Mockito.times(1)).salvarListaDeFeiras(Mockito.anyList());

    }

    @Test
    void deletarFeira() {

        useCaseFeira.deletarFeira(1L);
        Mockito.verify(feiraRepository, Mockito.times(1)).deleteFeira(1L);


    }

    private Feira buildClassFeira(){
        return Feira.builder()
                .longitude(-46550164L)
                .latitude(-23558733L)
                .setcens(355030885000091L)
                .areap(3550308005040L)
                .codigoDistrito(87)
                .distrito("VILA FORMOSA")
                .codigoSubPrefeitura(26)
                .subPrefeitura("ARICANDUVA-FORMOSA-CARRAO")
                .regiao05("Leste")
                .regiao08("Leste 1")
                .nomeDaFeira("VILA FORMOSA")
                .registro("4041-0")
                .logradouro("RUA MARAGOJIPE")
                .numero("S/N")
                .bairro("VL FORMOSA")
                .referencia("TV RUA PRETORIA")
                .build();

    }

    private Feira buildClassFeiraRetorno(){
        var feira = buildClassFeira();
        feira.setId(1L);
        return feira;
    }

    private Feira buildClassFeiraRetornoUpdate(){
        var feira = buildClassFeiraUpdate();
        feira.setId(1L);
        return feira;
    }

    private Feira buildClassFeiraUpdate(){
        var feira = buildClassFeira();
        feira.setDistrito("VILA MADALENA");
        return feira;

    }

    private Feira buildClassFeiraUpdatNaoPermitido(){
        var feira = buildClassFeira();
        feira.setRegistro("4041-5");
        return feira;

    }

    private Feira buildClassFeiraFilter(){
        return Feira.builder().id(1L).build();
    }
}