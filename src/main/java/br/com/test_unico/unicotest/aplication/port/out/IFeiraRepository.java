package br.com.test_unico.unicotest.aplication.port.out;


import br.com.test_unico.unicotest.aplication.domain.Feira;

import java.util.List;

public interface IFeiraRepository {

    Feira salvarFeira(Feira feira);

    void salvarListaDeFeiras(List<Feira> feiraList);

    Feira updateFeira(Feira feira);

    List<Feira> buscarFeira(Feira feira);

    void deleteFeira(Long codigoDoRegistro);
}
