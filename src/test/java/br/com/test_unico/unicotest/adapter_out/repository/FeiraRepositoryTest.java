package br.com.test_unico.unicotest.adapter_out.repository;

import br.com.test_unico.unicotest.adapter_out.mapper.IFeiraRepositoryMapper;
import br.com.test_unico.unicotest.adapter_out.persistence.FeiraPersistence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FeiraRepositoryTest {

    @InjectMocks
    private FeiraRepository feiraRepository;

    @Mock
    private FeiraPersistence feiraPersistence;

    @Mock
    private IFeiraRepositoryMapper feiraRepositoryMapper;

    @Test
    void salvarFeira() {
    }

    @Test
    void salvarListaDeFeiras() {
    }

    @Test
    void updateFeira() {
    }

    @Test
    void buscarFeira() {
    }

    @Test
    void deleteFeira() {
    }
}