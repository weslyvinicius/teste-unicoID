package br.com.test_unico.unicotest.aplication.port.in;


import br.com.test_unico.unicotest.aplication.domain.Feira;

import java.util.List;

public interface IUseCaseFeira {

    Feira cadastrarFeira(Feira feira);

    Feira atualizarCadastroFeira(Feira feira, Long id);

    List<Feira> buscarFeira(Feira feira);

    void importListaDeFeira(List<Feira> feiraList);

    void deletarFeira(Long codigoDoRegistro);
}
