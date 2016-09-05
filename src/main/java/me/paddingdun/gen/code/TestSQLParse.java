/**
 * 
 */
package me.paddingdun.gen.code;

import java.util.List;

import net.sf.jsqlparser.parser.CCJSqlParser;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.WithItem;

/**
 * @author paddingdun
 *
 * 2016年9月1日
 * @since 1.0
 * @version 1.0
 */
public class TestSQLParse {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		Statement stmt = CCJSqlParserUtil.parse("select t1.a, t2.b from test t1, test2 t2 where t1.a = t2.a");
		Select select = (Select)stmt;
		List<WithItem> list = select.getWithItemsList();
		for (WithItem wi : list) {
			System.out.println(wi.getName());
		}
	}

}
