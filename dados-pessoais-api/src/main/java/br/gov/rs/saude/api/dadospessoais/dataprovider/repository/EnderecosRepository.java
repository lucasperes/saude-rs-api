package br.gov.rs.saude.api.dadospessoais.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.EnderecoEntity;

/**
 * Repository para {@link EnderecoEntity}
 */
@Repository
public interface EnderecosRepository extends JpaRepository<EnderecoEntity, Long> {

}
