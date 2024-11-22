package br.gov.rs.saude.api.saude.api.core.domain.entity.jpa.types;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import br.gov.rs.saude.api.saude.api.core.exception.impl.ModelTypeException;
import br.gov.rs.saude.api.saude.api.core.utils.messages.GlobalMappingMessagesEnum;
import lombok.NoArgsConstructor;

/**
 * Classe Abstrata para ser herdada por todas as classes de configuracao de
 * Types JPA
 * 
 * @param <T>
 */
@NoArgsConstructor
public abstract class AbstractImmutableType<T> implements UserType<T> {

	public abstract T get(ResultSet rs, int position, SharedSessionContractImplementor session, Object owner)
			throws HibernateException, SQLException;

	public abstract void set(PreparedStatement st, T value, int index, SharedSessionContractImplementor session)
			throws HibernateException, SQLException;

	@Override
	public Class<T> returnedClass() {
		return getClassTypeParameter();
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return Objects.equals(x, y);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}
	
	@Override
	public T nullSafeGet(ResultSet rs, int position, SharedSessionContractImplementor session, Object owner)
			throws SQLException {
		return get(rs, position, session, owner);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
			throws HibernateException, SQLException {
		set(st, (T) value, index, session);
	}

	@Override
	public T deepCopy(T value) throws HibernateException {
		return value;
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T assemble(Serializable cached, Object owner) throws HibernateException {
		return (T) cached;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T replace(Object original, Object target, Object owner) throws HibernateException {
		return (T) original;
	}

	@SuppressWarnings("unchecked")
	private Class<T> getClassTypeParameter() {
		// Get "T" and assign it to this.entityClass
		Type genericSuperClass = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = null;
		while (parameterizedType == null) {
			if ((genericSuperClass instanceof ParameterizedType)) {
				parameterizedType = (ParameterizedType) genericSuperClass;
			} else {
				genericSuperClass = ((Class<T>) genericSuperClass).getGenericSuperclass();
			}
		}
		try {
			Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
			if (actualTypeArguments.length > 0 && actualTypeArguments[0] instanceof Class) {
				return (Class<T>) actualTypeArguments[0];
			} else if (actualTypeArguments.length > 0 && actualTypeArguments[0] instanceof ParameterizedType) {
				return (Class<T>) ((ParameterizedType) actualTypeArguments[0]).getRawType();
			}
			return null;
		} catch (Exception err) {
			throw new ModelTypeException(GlobalMappingMessagesEnum.MSG_ERROR_CONVERTER_USER_TYPE_JPA);
		}
	}

}
