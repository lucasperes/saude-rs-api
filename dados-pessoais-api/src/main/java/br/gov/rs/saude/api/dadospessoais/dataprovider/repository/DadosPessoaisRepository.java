package br.gov.rs.saude.api.dadospessoais.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.DadosPessoaisEntity;

/**
 * Repository para {@link DadosPessoaisEntity}
 */
@Repository
public interface DadosPessoaisRepository extends JpaRepository<DadosPessoaisEntity, Long> {

}
