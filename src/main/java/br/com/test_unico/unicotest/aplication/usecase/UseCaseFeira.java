package br.com.test_unico.unicotest.aplication.usecase;


import br.com.test_unico.unicotest.aplication.domain.Feira;
import br.com.test_unico.unicotest.aplication.exception.ResultNotFoundException;
import br.com.test_unico.unicotest.aplication.port.in.IUseCaseFeira;
import br.com.test_unico.unicotest.aplication.port.out.IFeiraRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UseCaseFeira implements IUseCaseFeira {

    private final IFeiraRepository feiraRepository;

    public UseCaseFeira(IFeiraRepository feiraRepository) {
        this.feiraRepository = feiraRepository;
    }

    @Override
    public Feira cadastrarFeira(Feira feira) {
        log.info("UseCaseFeira - cadastrarFeira {}", feira);
        return feiraRepository.salvarFeira(feira);
    }

    @Override
    public Feira atualizarCadastroFeira(Feira feira, Long id) {
        log.info("UseCaseFeira - atualizarCadastroFeira {}", feira);

        var feiraFilter = Feira.builder().id(id).build();
        var feiraSalvaNoBanco = feiraRepository.buscarFeira(feiraFilter);

        if(feiraSalvaNoBanco.isEmpty()){
            throw new ResultNotFoundException();
        }

        var registroFeira = feiraSalvaNoBanco.get(0);
        registroFeira.atualizaDadosFeira(feira);
        return feiraRepository.updateFeira(registroFeira);
    }

    @Override
    public List<Feira> buscarFeira(Feira feira) {
        log.info("UseCaseFeira - buscarFeira {}", feira);
        return feiraRepository.buscarFeira(feira);
    }

    @Override
    public void importListaDeFeira(List<Feira> feiraList) {
        log.info("UseCaseFeira - importListaDeFeira {}", feiraList);
        feiraRepository.salvarListaDeFeiras(feiraList);
    }

    @Override
    public void deletarFeira(Long codigoDoRegistro) {
        log.info("UseCaseFeira - deletarFeira id {}", codigoDoRegistro);
        feiraRepository.deleteFeira(codigoDoRegistro);
    }
}
