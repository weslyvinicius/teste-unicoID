package br.com.test_unico.unicotest.adapter_out.persistence;

import br.com.test_unico.unicotest.adapter_out.entity.FeiraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeiraPersistence extends JpaRepository<FeiraEntity, Long> {
}
