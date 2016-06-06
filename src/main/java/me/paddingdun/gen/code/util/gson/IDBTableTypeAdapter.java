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

import me.paddingdun.gen.code.data.tabletree.DBTable;
import me.paddingdun.gen.code.data.tabletree.IDBTable;
import me.paddingdun.gen.code.util.GsonHelper;

/**
 * @author paddingdun
 *
 * 2016年5月31日
 * @since 1.0
 * @version 1.0
 */
public class IDBTableTypeAdapter implements JsonDeserializer<IDBTable>, JsonSerializer<IDBTable> {

	/* (non-Javadoc)
	 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public IDBTable deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return GsonHelper.create().fromJson(json, DBTable.class);
	}

	/* (non-Javadoc)
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(IDBTable src, Type typeOfSrc, JsonSerializationContext context) {
		if(src != null)
			return context.serialize(src);
		return null;
	}


}
