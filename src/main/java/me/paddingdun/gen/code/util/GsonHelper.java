/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import me.paddingdun.gen.code.data.table.IDBColumn;
import me.paddingdun.gen.code.data.table2.IEntityProperty;
import me.paddingdun.gen.code.data.tabletree.IDBTable;
import me.paddingdun.gen.code.util.gson.IDBColumnTypeAdapter;
import me.paddingdun.gen.code.util.gson.IDBTableTypeAdapter;
import me.paddingdun.gen.code.util.gson.IEntityPropertyTypeAdapter;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public class GsonHelper {
	
	public static Gson create(){
		return create(false, false, false);
	}
	
	public static Gson create(boolean excludeFieldsWithoutExposeAnnotation, boolean prettyShow){
		return create(excludeFieldsWithoutExposeAnnotation, prettyShow, false);
	}

	public static Gson create(boolean excludeFieldsWithoutExposeAnnotation, boolean prettyShow, boolean disableHtmlEscaping){
		GsonBuilder gb = new GsonBuilder();
		gb.registerTypeAdapter(java.util.Date.class, new Date1TypeAdapter())
		.registerTypeAdapter(java.sql.Date.class, new Date2TypeAdapter())
		.registerTypeAdapter(java.sql.Timestamp.class, new Date3TypeAdapter())
		.registerTypeAdapter(BigDecimal.class, new BigDecimalDeserializer())
		.registerTypeAdapter(IEntityProperty.class, new IEntityPropertyTypeAdapter())
		.registerTypeAdapter(IDBColumn.class, new IDBColumnTypeAdapter())
//		.registerTypeAdapter(IDBTable.class, new IDBTableInstanceCreator())
		.registerTypeAdapter(IDBTable.class, new IDBTableTypeAdapter());
		if(excludeFieldsWithoutExposeAnnotation){
			gb.excludeFieldsWithoutExposeAnnotation();
		}
		if(disableHtmlEscaping){
			gb.disableHtmlEscaping();
		}
		if(prettyShow){
			gb.setPrettyPrinting();
		}
		return gb.create();
	}
	
	static class Date1TypeAdapter implements JsonSerializer<java.util.Date>, JsonDeserializer<java.util.Date>{

		/* (non-Javadoc)
		 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
		 */
		public java.util.Date deserialize(JsonElement json, Type type, JsonDeserializationContext ctx)
				throws JsonParseException {
			String s = json.getAsString();
			java.util.Date result = DateHelper.parseDate(s);
			return result;
		}

		/* (non-Javadoc)
		 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
		 */
		@Override
		public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
			if(src != null){
				return new JsonPrimitive(DateHelper.format(src, DateHelper.DATE_FMT_1));
			}
			return null;
		}
		
	}
	
	static class Date2TypeAdapter implements JsonSerializer<java.sql.Date>, JsonDeserializer<java.sql.Date>{

		/* (non-Javadoc)
		 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
		 */
		public java.sql.Date deserialize(JsonElement json, Type type, JsonDeserializationContext ctx)
				throws JsonParseException {
			String s = json.getAsString();
			java.util.Date tmp = DateHelper.parseDate(s);
			java.sql.Date result = null;
			if(tmp != null)
				result = new java.sql.Date(tmp.getTime());
			return result;
		}

		/* (non-Javadoc)
		 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
		 */
		@Override
		public JsonElement serialize(java.sql.Date src, Type typeOfSrc, JsonSerializationContext context) {
			if(src != null){
				return new JsonPrimitive(DateHelper.format(src, DateHelper.DATE_FMT_1));
			}
			return null;
		}
	}
	
	static class Date3TypeAdapter implements JsonSerializer<java.sql.Timestamp>, JsonDeserializer<java.sql.Timestamp>{

		/* (non-Javadoc)
		 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
		 */
		public java.sql.Timestamp deserialize(JsonElement json, Type type, JsonDeserializationContext ctx)
				throws JsonParseException {
			String s = json.getAsString();
			java.util.Date tmp = DateHelper.parseDate(s);
			java.sql.Timestamp result = null;
			if(tmp != null)
				result = new java.sql.Timestamp(tmp.getTime());
			return result;
		}

		/* (non-Javadoc)
		 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
		 */
		@Override
		public JsonElement serialize(Timestamp src, Type typeOfSrc, JsonSerializationContext context) {
			if(src != null){
				return new JsonPrimitive(DateHelper.format(src, DateHelper.DATE_FMT_DEFAULT));
			}
			return null;
		}
		
	}
	
	static class BigDecimalDeserializer implements JsonDeserializer<BigDecimal>{

		public BigDecimal deserialize(JsonElement json, Type type, JsonDeserializationContext ctx)
				throws JsonParseException {
			String s = json.getAsString();
			if("".equals(s)
					||"null".equals(s))
				return null;
			return new BigDecimal(s);
		}
		
	}
}
