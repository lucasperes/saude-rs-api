package br.gov.rs.saude.api.dadospessoais.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.DadosPessoalEntity;

/**
 * Repository para {@link DadosPessoalEntity}
 */
@Repository
public interface DadosPessoaisRepository extends JpaRepository<DadosPessoalEntity, Long> {

}
