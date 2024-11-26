package br.gov.rs.saude.api.dadospessoais.dataprovider.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.UsuarioEntity;
import br.gov.rs.saude.api.saude.api.core.domain.entity.AbstractEntityBase;
import br.gov.rs.saude.api.saude.api.core.domain.enums.global.EntityStatusEnum;

/**
 * Repository para {@link UsuarioEntity}
 */
@Repository
public interface UsuariosRepository extends JpaRepository<UsuarioEntity, Long> {

	@Query(value = "from UsuarioEntity e where e.status = :status", countProjection = AbstractEntityBase.ATTR_ALIAS_ENTITY_ID)
	Page<UsuarioEntity> list(
			@Param("status") EntityStatusEnum status,
			Pageable pageable);
	
}
