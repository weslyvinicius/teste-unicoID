package br.com.test_unico.unicotest.adapter_out.repository;

import br.com.test_unico.unicotest.adapter_out.mapper.IFeiraRepositoryMapper;
import br.com.test_unico.unicotest.adapter_out.persistence.FeiraPersistence;
import br.com.test_unico.unicotest.aplication.domain.Feira;
import br.com.test_unico.unicotest.aplication.port.out.IFeiraRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Slf4j
public class FeiraRepository implements IFeiraRepository {

    private final FeiraPersistence feiraPersistence;
    private final IFeiraRepositoryMapper feiraRepositoryMapper;

    public FeiraRepository(FeiraPersistence feiraPersistence, IFeiraRepositoryMapper feiraRepositoryMapper) {
        this.feiraPersistence = feiraPersistence;
        this.feiraRepositoryMapper = feiraRepositoryMapper;
    }

    @Override
    public Feira salvarFeira(Feira feira) {
        log.info("FeiraRepository - salvarFeira {}", feira);
        return feiraRepositoryMapper.toDomain(feiraPersistence.save(feiraRepositoryMapper.toEntity(feira)));
    }

    @Override
    @Transactional
    public void salvarListaDeFeiras(List<Feira> feiraList) {
        log.info("FeiraRepository - salvarListaDeFeiras {\n {}", feiraList);
        feiraPersistence.saveAll(feiraRepositoryMapper.toEntityList(feiraList));
    }

    @Override
    public Feira updateFeira(Feira feira) {
        log.info("FeiraRepository - updateFeira {}", feira);
        return feiraRepositoryMapper.toDomain(feiraPersistence.save(feiraRepositoryMapper.toEntity(feira)));
    }

    @Override
    public List<Feira> buscarFeira(Feira feira) {
        log.info("FeiraRepository - buscarFeira {}", feira);
        return feiraRepositoryMapper.toDomainList(feiraPersistence.findAll(Example.of(feiraRepositoryMapper.toEntity(feira))));
    }

    @Override
    public void deleteFeira(Long codigoDoRegistro) {
        log.info("FeiraRepository - deleteFeira id {}", codigoDoRegistro);
        feiraPersistence.deleteById(codigoDoRegistro);
    }
}
