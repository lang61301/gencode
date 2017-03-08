/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import me.paddingdun.gen.code.data.table2.EntityProperty;
import me.paddingdun.gen.code.data.table2.IEntityProperty;
import me.paddingdun.gen.code.data.table2.QueryColumn;
import me.paddingdun.gen.code.data.table2.TableColumn;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public class EntityHelper {
	static String[] TABLE_PREFIX = new String[]{"tb_", "t_"};
	
	/**
	 * 数字开头的字符串的正则;
	 */
	static Pattern P_NON_NUMBER = Pattern.compile("^(\\d*)(.*?)$");

	public static String col(String col){
		return op(col, false);
	}
	
	public static String table(String table){
		return op(table, true);
	}
	
	public static String set(String col){
		String prefix = "set";
		String tmp = prefix + col.substring(0,1).toUpperCase() + col.substring(1);
		return tmp;
	}
	
	public static String get(String col, int type){
		String prefix = "get";
		if(TypesHelper.isBooleanType(type)){
			prefix ="is";
		}
		String tmp = prefix + col.substring(0,1).toUpperCase() + col.substring(1);
		return tmp;
	}
	
	public static String get(String col, String javaType){
		String prefix = "get";
		if(TypesHelper.isBooleanType(javaType)){
			prefix ="is";
		}
		String tmp = prefix + col.substring(0,1).toUpperCase() + col.substring(1);
		return tmp;
	}
	
	/**
	 * 处理表格名称和表格字段;
	 * 将其转换成符合java规范的实体类名称和字段名称;
	 * @param s
	 * @param tableName
	 * @return
	 */
	private static String op(String s, boolean tableName){
		if(StringUtils.isBlank(s)){
			throw new RuntimeException("the table name or column is null");
		}
		//取空格,变成小写字符串;
		String s_low = s.toLowerCase().trim();
		
		//剔除前缀;
		String s_r_prefix = s_low;
		if(tableName){
			for (String pre : TABLE_PREFIX) {
				s_r_prefix = StringUtils.removeStart(s_r_prefix, pre);
			}
		}
		StreamTokenizer st = new StreamTokenizer(new StringReader(s_r_prefix));
		//分割字符;
		st.whitespaceChars('-', '-');
		st.whitespaceChars('_', '_');
		st.whitespaceChars('.', '.');
		
		//普通字符
		st.ordinaryChars('0', '9');
		
		//将数字变成字符串;
		st.wordChars('0', '9');
		StringBuilder sb = new StringBuilder();
		boolean start = true;
		int count = 1;
		while(true){
			int ttype = StreamTokenizer.TT_EOF;
			try {
				ttype = st.nextToken();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			if(StreamTokenizer.TT_EOF == ttype
					|| StreamTokenizer.TT_EOL == ttype)
				break;
			if(StreamTokenizer.TT_WORD == ttype){
				String tmp = st.sval;
				if(start){
					if(count == 1){
						tmp = tmp.replaceFirst(P_NON_NUMBER.pattern(), "$2");
					}
					
					int length = tmp.length();
					if(length == 0){
						continue;
					}else if(length == 1){
						if(tableName){
							tmp = tmp.toUpperCase();
						}else{
							count++;
							if(count > 2)
								start = false;
						}
					}else{
						if(tableName){
							tmp = tmp.substring(0,1).toUpperCase() + tmp.substring(1);
						}
						start = false;
					}
					sb.append(tmp);
				}else{
					sb.append(tmp.substring(0,1).toUpperCase() + tmp.substring(1));
				}
			}
		}
		String result = sb.toString();
		if(StringUtils.isBlank(result)){
			throw new RuntimeException(String.format("the table name or column [%s] can not convert to valid java class name or property!", s));
		}
		return result;
	}
	
	public static IEntityProperty from(TableColumn tc){
		IEntityProperty ep = new EntityProperty();
		ep.setGetMethod(tc.getGetMethod());
		ep.setJavaType(tc.getJavaType());
		ep.setPropertyName(tc.getPropertyName());
		ep.setPropertyTitle(tc.getPropertyTitle());
		ep.setSetMethod(tc.getSetMethod());
		return ep;
	}
	
	public static IEntityProperty from(QueryColumn qc){
		IEntityProperty ep = new EntityProperty();
		ep.setGetMethod(qc.getGetMethod());
		ep.setJavaType(qc.getJavaType());
		ep.setPropertyName(qc.getPropertyName());
		ep.setPropertyTitle(qc.getPropertyTitle());
		ep.setSetMethod(qc.getSetMethod());
		return ep;
	}
	
	public static void main(String[] args)throws Exception {
		System.out.println(table("tb_ss__uio"));
	}
}
