package br.gov.rs.saude.api.saude.api.core.domain.entity.jpa.types.global;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import br.gov.rs.saude.api.saude.api.core.domain.entity.jpa.types.AbstractImmutableType;
import br.gov.rs.saude.api.saude.api.core.domain.enums.global.SexoEnum;

/**
 * Classe Converter JPA Types para {@link SexoEnum}
 */
public class SexoEnumJpaType extends AbstractImmutableType<SexoEnum> {

	@Override
	public int getSqlType() {
		return Types.VARCHAR;
	}

	@Override
	public SexoEnum get(ResultSet rs, int position, SharedSessionContractImplementor session, Object owner)
			throws HibernateException, SQLException {
		SexoEnum result = null;
		String value = rs.getString(position);
		if(!rs.wasNull()) {
			result = SexoEnum.getByCode(value);
		}
		return result;
	}

	@Override
	public void set(PreparedStatement st, SexoEnum value, int index, SharedSessionContractImplementor session)
			throws HibernateException, SQLException {
		if(value != null) {
			st.setString(index, value.getCode());
		} else {
			st.setNull(index, Types.VARCHAR);
		}
	}
	
}
