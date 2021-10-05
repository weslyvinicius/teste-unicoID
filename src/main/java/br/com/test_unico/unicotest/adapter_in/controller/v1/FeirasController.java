package br.com.test_unico.unicotest.adapter_in.controller.v1;

import br.com.test_unico.unicotest.adapter_in.controller.v1.contratos.IFeirasController;
import br.com.test_unico.unicotest.adapter_in.representacao.mapper.IFeiraMapper;
import br.com.test_unico.unicotest.adapter_in.representacao.request.FeiraCriteriaRequest;
import br.com.test_unico.unicotest.adapter_in.representacao.request.FeiraRequest;
import br.com.test_unico.unicotest.adapter_in.representacao.response.FeiraResponse;
import br.com.test_unico.unicotest.aplication.port.in.IUseCaseFeira;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class FeirasController implements IFeirasController {

    private final IUseCaseFeira useCaseFeira;
    private final IFeiraMapper feiraMapper;

    public FeirasController(IUseCaseFeira useCaseFeira, IFeiraMapper feiraMapper) {
        this.useCaseFeira = useCaseFeira;
        this.feiraMapper = feiraMapper;
    }

    @Override
    public FeiraResponse cadastrarFeira(@Valid FeiraRequest feiraRequest) {
        log.info("Controller - Cadastrando registro {}", feiraRequest);
        return feiraMapper.toResponse(useCaseFeira.cadastrarFeira(feiraMapper.toDomain(feiraRequest)));
    }

    @Override
    public FeiraResponse atualizarCadastroDaFeira(@Valid FeiraRequest feiraRequest, Long id) {
        log.info("Controller - Atualizando registro {}", feiraRequest);
        return feiraMapper.toResponse(useCaseFeira.atualizarCadastroFeira(feiraMapper.toDomain(feiraRequest), id));
    }

    @Override
    public List<FeiraResponse> buscaCadastroDaFeira(FeiraCriteriaRequest feiraCriteriaRequest) {
        log.info("Controller - Buscando registros com o filtro {}", feiraCriteriaRequest);
        return feiraMapper.toResponseList(useCaseFeira.buscarFeira(feiraMapper.toDomain(feiraCriteriaRequest)));
    }

    @Override
    public void deletarCadastroDaFeira(Long codigoDoRegistro) {
        log.info("Controller - Deletando registro id {}", codigoDoRegistro);
        useCaseFeira.deletarFeira(codigoDoRegistro);
    }
}
