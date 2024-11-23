package br.gov.rs.saude.api.dadospessoais.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.PerfilEntity;

/**
 * Repository para {@link PerfilEntity}
 */
@Repository
public interface PerfisRepository extends JpaRepository<PerfilEntity, Integer> {

}
