package br.gov.rs.saude.api.saude.api.core.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;

import br.gov.rs.saude.api.saude.api.core.exception.impl.MapperConverterException;
import br.gov.rs.saude.api.saude.api.core.exception.impl.ValidationException;
import br.gov.rs.saude.api.saude.api.core.utils.ValidationUtils;
import br.gov.rs.saude.api.saude.api.core.utils.messages.GlobalMappingMessagesEnum;
import lombok.Getter;

/**
 * Classe Base para realizar ModelMappers e Parses de JSONs
 */
public abstract class ModelMapperBase implements Serializable {
	
	private static final long serialVersionUID = 6243062174461823271L;

	public static final Logger LOGGER = LoggerFactory.getLogger(ModelMapperBase.class);
	
	@Getter(value = lombok.AccessLevel.PROTECTED)
	private static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	@Getter(value = lombok.AccessLevel.PROTECTED)
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	private static boolean isInitializable = false;
	
	static {
		init();
	}
	
	private static void init() {
		if(!isInitializable) {
			MODEL_MAPPER.getConfiguration()
				.setAmbiguityIgnored(true)
				.setFieldMatchingEnabled(true)
				.setFieldAccessLevel(AccessLevel.PRIVATE);
			OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			OBJECT_MAPPER.setSerializationInclusion(Include.NON_NULL);
			OBJECT_MAPPER.findAndRegisterModules();
			isInitializable = true;
		}
	}
	
	public static <T> T mapper(Object source, Class<T> typeTarget) {
		try {			
			return MODEL_MAPPER.map(source, typeTarget);
		} catch(Exception err) {
			final String msg = "Erro ao tentar mapear o Object Source = " + source.getClass().getName() + " para o Object Type = " + typeTarget.getName();
			LOGGER.error(msg, err);
			throw new MapperConverterException(GlobalMappingMessagesEnum.MSG_ERROR_CONVERTER_SOURCE_TO_TARGET, source.getClass().getName(), typeTarget.getName());
		}
	}
	
	public static <S, T> List<T> mapper(List<S> source, Class<T> typeTarget) {
		if(ValidationUtils.isEmpty(source)) {
			throw new ValidationException(GlobalMappingMessagesEnum.MSG_ERROR_VALIDATION_LIST_SOURCE_IS_NULL);
		}
		return source.stream()
				.map(s -> mapper(s, typeTarget))
				.collect(Collectors.toList());
	}
	
	public static <S, T> Set<T> mapper(Set<S> source, Class<T> typeTarget) {
		if(ValidationUtils.isEmpty(source)) {
			throw new ValidationException(GlobalMappingMessagesEnum.MSG_ERROR_VALIDATION_LIST_SOURCE_IS_NULL);
		}
		return source.stream()
				.map(s -> mapper(s, typeTarget))
				.collect(Collectors.toSet());
	}
	
	protected <S, T> T mapperSafeNull(S source, Class<T> typeTarget) {
		return ValidationUtils.isNotNull(source) ? mapper(source, typeTarget) : null;
	}
	
	protected <S, T> Page<T> mapperSafeNull(Page<S> sources, Class<T> typeTarget) {
		return ValidationUtils.isNotEmpty(sources) ? sources.map((source) ->  mapper(source, typeTarget)) : null;
	}
	
	protected <S, T> List<T> mapperSafeNull(List<S> sources, Class<T> typeTarget) {
		return ValidationUtils.isNotEmpty(sources) ? mapper(sources, typeTarget) : null;
	}
	
	protected <S, T> Set<T> mapperSafeNull(Set<S> sources, Class<T> typeTarget) {
		return ValidationUtils.isNotEmpty(sources) ? mapper(sources, typeTarget) : null;
	}
	
	public static <T> T readValue(String source, Class<T> typeTarget) {
		try {			
			return OBJECT_MAPPER.readValue(source, typeTarget);
		} catch(Exception err) {
			final String msg = "Erro ao tentar converter o source = [" + source.getClass().getName() + "] para o tipo Object Target = " + typeTarget.getName();
			LOGGER.error(msg, err);
			throw new MapperConverterException(GlobalMappingMessagesEnum.MSG_ERROR_CONVERTER_SOURCE_TO_TARGET, source.getClass().getName(), typeTarget.getName());
		}
	}
	
	public static <T> List<T> readListValue(String source, Class<T> typeTarget) {
		try {
			CollectionType listType = OBJECT_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, typeTarget);
			return OBJECT_MAPPER.readValue(source, listType);
		} catch(Exception err) {
			final String msg = "Erro ao tentar converter o source = [" + source.getClass().getName() + "] para o tipo de List Target = " + typeTarget.getName();
			LOGGER.error(msg, err);
			throw new MapperConverterException(GlobalMappingMessagesEnum.MSG_ERROR_CONVERTER_SOURCE_TO_TARGET, source.getClass().getName(), typeTarget.getName());
		}
	}
	
	public static String writeValue(Object source) {
		try {			
			return OBJECT_MAPPER.writeValueAsString(source);
		} catch(Exception err) {
			final String msg = "Erro ao tentar converter o Object Source = " + source.getClass().getName() + " para o tipo String";
			LOGGER.error(msg, err);
			throw new MapperConverterException(GlobalMappingMessagesEnum.MSG_ERROR_CONVERTER_SOURCE_TO_STRING, source);
		}
	}
	
	public static ModelMapper newInstanceModelMapper() {
		return new ModelMapper();
	}
	
}
