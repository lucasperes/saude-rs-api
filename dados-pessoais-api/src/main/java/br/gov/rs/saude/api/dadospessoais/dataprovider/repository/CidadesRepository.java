package br.gov.rs.saude.api.dadospessoais.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.CidadeEntity;

/**
 * Repository para {@link CidadeEntity}
 */
@Repository
public interface CidadesRepository extends JpaRepository<CidadeEntity, Integer> {

}
