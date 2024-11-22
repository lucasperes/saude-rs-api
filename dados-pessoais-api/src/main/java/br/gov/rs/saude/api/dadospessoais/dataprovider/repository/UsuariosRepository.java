package br.gov.rs.saude.api.dadospessoais.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.UsuarioEntity;

/**
 * Repository para {@link UsuarioEntity}
 */
@Repository
public interface UsuariosRepository extends JpaRepository<UsuarioEntity, Long> {

}
