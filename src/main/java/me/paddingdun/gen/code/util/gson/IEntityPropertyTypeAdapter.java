/**
 * 
 */
package me.paddingdun.gen.code.util.gson;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import me.paddingdun.gen.code.data.table2.EntityProperty;
import me.paddingdun.gen.code.data.table2.IEntityProperty;
import me.paddingdun.gen.code.util.GsonHelper;

/**
 * @author paddingdun
 *
 * 2016年5月31日
 * @since 1.0
 * @version 1.0
 */
public class IEntityPropertyTypeAdapter implements JsonDeserializer<IEntityProperty>, JsonSerializer<IEntityProperty> {

	/* (non-Javadoc)
	 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public IEntityProperty deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return GsonHelper.create().fromJson(json, EntityProperty.class);
	}

	/* (non-Javadoc)
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(IEntityProperty src, Type typeOfSrc, JsonSerializationContext context) {
		if(src != null)
			return context.serialize(src);
		return null;
	}



}
