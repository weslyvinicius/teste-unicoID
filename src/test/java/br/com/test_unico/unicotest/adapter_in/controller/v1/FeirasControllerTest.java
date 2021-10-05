package br.com.test_unico.unicotest.adapter_in.controller.v1;

import br.com.test_unico.unicotest.adapter_in.config.JacksonUtils;
import br.com.test_unico.unicotest.adapter_in.representacao.request.FeiraRequest;
import br.com.test_unico.unicotest.adapter_in.util.ConstantsNames;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FeirasControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @Order(1)
    void cadastrarFeira() throws Exception {

        mvc.perform(post(ConstantsNames.URI_VERSION_NAME)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(serializeToString(buildClassFeira())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.ID", is(1L), Long.class))
                .andExpect(jsonPath("$.LONG", is(-46550164L), Long.class))
                .andExpect(jsonPath("$.LAT", is(-23558733L), Long.class))
                .andExpect(jsonPath("$.SETCENS", is(355030885000091L), Long.class))
                .andExpect(jsonPath("$.AREAP", is(3550308005040L), Long.class))
                .andExpect(jsonPath("$.CODDIST", is(87)))
                .andExpect(jsonPath("$.DISTRITO", is("VILA FORMOSA")))
                .andExpect(jsonPath("$.CODSUBPREF", is(26)))
                .andExpect(jsonPath("$.SUBPREFE", is("ARICANDUVA-FORMOSA-CARRAO")))
                .andExpect(jsonPath("$.REGIAO5", is("Leste")))
                .andExpect(jsonPath("$.REGIAO8", is("Leste 1")))
                .andExpect(jsonPath("$.NOME_FEIRA", is("VILA FORMOSA")))
                .andExpect(jsonPath("$.REGISTRO", is("4041-0")))
                .andExpect(jsonPath("$.LOGRADOURO", is("RUA MARAGOJIPE")))
                .andExpect(jsonPath("$.NUMERO", is("S/N")))
                .andExpect(jsonPath("$.BAIRRO", is("VL FORMOSA")))
                .andExpect(jsonPath("$.REFERENCIA", is("TV RUA PRETORIA")));
    }

    @Test
    @Order(2)
    void atualizarCadastroDaFeira() throws Exception {

        mvc.perform(put(ConstantsNames.URI_VERSION_NAME+ConstantsNames.URI_ID, 1L )
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(serializeToString(buildClassFeiraUpdate())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.ID", is(1L), Long.class))
                .andExpect(jsonPath("$.LONG", is(-46550164L), Long.class))
                .andExpect(jsonPath("$.LAT", is(-23558733L), Long.class))
                .andExpect(jsonPath("$.SETCENS", is(355030885000091L), Long.class))
                .andExpect(jsonPath("$.AREAP", is(3550308005040L), Long.class))
                .andExpect(jsonPath("$.CODDIST", is(87)))
                .andExpect(jsonPath("$.DISTRITO", is("VILA MADALENA")))
                .andExpect(jsonPath("$.CODSUBPREF", is(26)))
                .andExpect(jsonPath("$.SUBPREFE", is("ARICANDUVA-FORMOSA-CARRAO")))
                .andExpect(jsonPath("$.REGIAO5", is("Leste")))
                .andExpect(jsonPath("$.REGIAO8", is("Leste 1")))
                .andExpect(jsonPath("$.NOME_FEIRA", is("VILA FORMOSA")))
                .andExpect(jsonPath("$.REGISTRO", is("4041-0")))
                .andExpect(jsonPath("$.LOGRADOURO", is("RUA MARAGOJIPE")))
                .andExpect(jsonPath("$.NUMERO", is("S/N")))
                .andExpect(jsonPath("$.BAIRRO", is("VL FORMOSA")))
                .andExpect(jsonPath("$.REFERENCIA", is("TV RUA PRETORIA")));
    }

    @Test
    @Order(3)
    void atualizarCadastroDaFeiraCampoRegistroNaoPermitido() throws Exception {

        mvc.perform(put(ConstantsNames.URI_VERSION_NAME+ConstantsNames.URI_ID, 1L )
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(serializeToString(buildClassFeiraUpdatNaoPermitido())))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.errosMensagem[0]", is("Alter column \"REGISTO\" not permission")));

    }


    @Test
    @Order(4)
    void buscaCadastroDaFeira() throws Exception {

        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("DISTRITO", "VILA MADALENA");

        mvc.perform(get(ConstantsNames.URI_VERSION_NAME)
                .params(requestParams)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.ID", is(1L), Long.class))
                .andExpect(jsonPath("$.LONG", is(-46550164L), Long.class))
                .andExpect(jsonPath("$.LAT", is(-23558733L), Long.class))
                .andExpect(jsonPath("$.SETCENS", is(355030885000091L), Long.class))
                .andExpect(jsonPath("$.AREAP", is(3550308005040L), Long.class))
                .andExpect(jsonPath("$.CODDIST", is(87)))
                .andExpect(jsonPath("$.DISTRITO", is("VILA MADALENA")))
                .andExpect(jsonPath("$.CODSUBPREF", is(26)))
                .andExpect(jsonPath("$.SUBPREFE", is("ARICANDUVA-FORMOSA-CARRAO")))
                .andExpect(jsonPath("$.REGIAO5", is("Leste")))
                .andExpect(jsonPath("$.REGIAO8", is("Leste 1")))
                .andExpect(jsonPath("$.NOME_FEIRA", is("VILA FORMOSA")))
                .andExpect(jsonPath("$.REGISTRO", is("4041-0")))
                .andExpect(jsonPath("$.LOGRADOURO", is("RUA MARAGOJIPE")))
                .andExpect(jsonPath("$.NUMERO", is("S/N")))
                .andExpect(jsonPath("$.BAIRRO", is("VL FORMOSA")))
                .andExpect(jsonPath("$.REFERENCIA", is("TV RUA PRETORIA")));
    }

    @Test
    void deletarCadastroDaFeira() {
    }

    private FeiraRequest buildClassFeira(){
        return FeiraRequest.builder()
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

    private FeiraRequest buildClassFeiraUpdate(){
        var feira = buildClassFeira();
        feira.setDistrito("VILA MADALENA");
        return feira;

    }

    private FeiraRequest buildClassFeiraUpdatNaoPermitido(){
        var feira = buildClassFeira();
        feira.setRegistro("4041-5");
        return feira;

    }

    public static String serializeToString(Object objectToSerialize) throws JsonProcessingException {
        return JacksonUtils.getObjectMapper().writeValueAsString(objectToSerialize);
    }
}