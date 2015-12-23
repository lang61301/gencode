/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.regex.Matcher;

/**
 * @author paddingdun
 *
 * 2015年12月22日
 */
public class FileHelper {
	
	public static void genJavaFile(String baseDir, String pkgName, String fileName, String fileContent){
		String dir_str = pkgName.replaceAll("\\.", Matcher.quoteReplacement(File.separator));
		File dir = new File(baseDir, dir_str);
		if(!dir.exists())
			dir.mkdirs();
		
		String fn = fileName + ".java";
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(dir, fn)), Charset.forName("UTF-8")));
			bw.write(fileContent);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			IOHelper.close(bw);
		}
	}
	
	public static void genSqlMapXmlFile(String baseDir, String fileName, String fileContent){

		String fn = fileName + "_sql.xml";
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(baseDir, fn)), Charset.forName("UTF-8")));
			bw.write(fileContent);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			IOHelper.close(bw);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
