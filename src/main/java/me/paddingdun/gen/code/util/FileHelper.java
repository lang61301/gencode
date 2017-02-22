/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public class FileHelper {
	
	private static void genJavaFile(String baseDir, String pkgName, String fileName, String fileContent){
		String dir_str = pkgName.replaceAll(Pattern.quote("."), Matcher.quoteReplacement(File.separator));
		File dir = new File(baseDir, dir_str);
		if(!dir.exists())
			dir.mkdirs();
		
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(dir, fileName)), Charset.forName("UTF-8")));
			bw.write(fileContent);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			IOHelper.close(bw);
		}
	}
	
	public static void genPojoJavaFile(String baseDir, String pkgName, String entityName, String fileContent){
		String fileName = GenFilenameHelper.javaEntityFileName(entityName);
		genJavaFile(baseDir, pkgName, fileName, fileContent);
	}
	
	public static void genBasePojoJavaFile(String baseDir, String pkgName, String entityName, String fileContent){
		String fileName = GenFilenameHelper.javaBaseEntityFileName(entityName);
		genJavaFile(baseDir, pkgName + ".base", fileName, fileContent);
	}
	
	public static void genSqlMapXmlFile(String baseDir, String entityName, String fileContent){

		String fn = GenFilenameHelper.sqlMapXmlFileName(entityName);
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
	
	public static void genSqlMapIDaoJavaFile(String baseDir, String pkgName, String entityName, String fileContent){
		String fileName = GenFilenameHelper.sqlMapIDaoJavaFileName(entityName);
		genJavaFile(baseDir, pkgName, fileName, fileContent);
	}
	
	public static void genSqlMapBaseDaoJavaFile(String baseDir, String pkgName, String entityName, String fileContent){
		String fileName = GenFilenameHelper.sqlMapBaseDaoJavaFileName(entityName);
		genJavaFile(baseDir, pkgName + ".base", fileName, fileContent);
	}
	
	public static void genSqlMapDaoImplJavaFile(String baseDir, String pkgName, String entityName, String fileContent){
		String fileName = GenFilenameHelper.sqlMapDaoImplJavaFileName(entityName);
		genJavaFile(baseDir, pkgName, fileName, fileContent);
	}
	
	public static void genSqlMapIServiceJavaFile(String baseDir, String pkgName, String entityName, String fileContent){
		String fileName = GenFilenameHelper.sqlMapIServiceJavaFileName(entityName);
		genJavaFile(baseDir, pkgName, fileName, fileContent);
	}
	
	public static void genSqlMapBaseServiceJavaFile(String baseDir, String pkgName, String entityName, String fileContent){
		String fileName = GenFilenameHelper.sqlMapBaseServiceJavaFileName(entityName);
		genJavaFile(baseDir, pkgName +".base", fileName, fileContent);
	}
	
	public static void genSqlMapServiceImplJavaFile(String baseDir, String pkgName, String entityName, String fileContent){
		String fileName = GenFilenameHelper.sqlMapServiceImplJavaFileName(entityName);
		genJavaFile(baseDir, pkgName, fileName, fileContent);
	}
	
	public static void genSqlMapBaseServiceImplJavaFile(String baseDir, String pkgName, String entityName, String fileContent){
		String fileName = GenFilenameHelper.sqlMapBaseServiceImplJavaFileName(entityName);
		genJavaFile(baseDir, pkgName + ".base", fileName, fileContent);
	}
	
	public static void genSpringWebActionJavaFile(String baseDir, String pkgName, String entityName, String fileContent){
		String fileName = GenFilenameHelper.springWebActionJavaFileName(entityName);
		genJavaFile(baseDir, pkgName, fileName, fileContent);
	}
	
	public static void genBootstrapDataTableJspFile(String baseDir, String categoryDir, String entityName, String fileContent){

		String fn = GenFilenameHelper.bootstrapDataTableJspFileName(entityName);
		BufferedWriter bw = null;
		try {
			File dir = null;
			if(StringUtils.isNotBlank(categoryDir)){
				dir = new File(baseDir, categoryDir);
			}else{
				dir = new File(baseDir);
			}
			if(!dir.exists())
				dir.mkdirs();
			
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(dir, fn)), Charset.forName("UTF-8")));
			bw.write(fileContent);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			IOHelper.close(bw);
		}
	}
	
	public static void genConfigXmlFile(String baseDir, String categoryDir, String name, String fileContent){
		String fn = GenFilenameHelper.configXmlFileName(name);
		BufferedWriter bw = null;
		try {
			File dir = null;
			if(StringUtils.isNotBlank(categoryDir)){
				dir = new File(baseDir, categoryDir);
			}else{
				dir = new File(baseDir);
			}
			if(!dir.exists())
				dir.mkdirs();
			
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(dir, fn)), Charset.forName("UTF-8")));
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
