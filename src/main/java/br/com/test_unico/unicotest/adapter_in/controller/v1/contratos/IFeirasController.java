package br.com.test_unico.unicotest.adapter_in.controller.v1.contratos;

import br.com.test_unico.unicotest.adapter_in.representacao.request.FeiraCriteriaRequest;
import br.com.test_unico.unicotest.adapter_in.representacao.request.FeiraRequest;
import br.com.test_unico.unicotest.adapter_in.representacao.response.FeiraResponse;
import br.com.test_unico.unicotest.adapter_in.util.ConstantsNames;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "API REST Projeto Cadastramento/Consulta de Feira Livre")
@RequestMapping(ConstantsNames.URI_VERSION_NAME)
public interface IFeirasController {


    @ApiOperation(value = "Serviço para cadastramento de uma Feira Livre")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    FeiraResponse cadastrarFeira(@Valid @RequestBody FeiraRequest feiraRequest);

    @ApiOperation(value = "Serviço para atualização de uma Feira Livre")
    @PutMapping(ConstantsNames.URI_ID)
    @ResponseStatus(HttpStatus.OK)
    FeiraResponse atualizarCadastroDaFeira(@Valid @RequestBody FeiraRequest feiraRequest, @PathVariable Long id);

    @ApiOperation(value = "Serviço para busca uma lista de uma Feira Livre a partir do filtro de criteria")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<FeiraResponse> buscaCadastroDaFeira(@RequestParam FeiraCriteriaRequest feiraCriteriaRequest);

    @ApiOperation(value = "Serviço para deletar um cadastro de Feira Livre")
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    void deletarCadastroDaFeira(@PathVariable Long codigoDoRegistro);
}
