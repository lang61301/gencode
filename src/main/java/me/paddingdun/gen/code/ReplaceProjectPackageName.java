/**
 * 
 */
package me.paddingdun.gen.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 * @author paddingdun
 *
 * 2015年12月2日
 */
public class ReplaceProjectPackageName {
	
	public static void main(String[] args)throws Exception {
		rpl(args);
	}

	/**
	 * @param args
	 */
	public static void rpl(String[] args) throws Exception{
		String dir_src	  = "D:\\home\\doc\\frame\\ssh2";
//		String dir_src	  = "D:\\home\\doc\\frame\\ssh2";
		
		String dir_target = "D:\\home\\doc\\frame\\DwyaneTest";
		String charset 	  = "UTF-8";
		
		//需要替换的包名;
		String mark_base_package	  = "me.paddingdun";
		//替换后的包名;
		String rpl_base_package 	  = "me.dwyane";
		
		//可以被替换的包名;
		String rpl_mark_base_package  = mark_base_package.replaceAll(Pattern.quote("."), Matcher.quoteReplacement("\\") + Matcher.quoteReplacement("."));
		//可以被替换的路径名;
		String rpl_mark_dir_base  = mark_base_package.replaceAll(Pattern.quote("."), Matcher.quoteReplacement("\\") + Matcher.quoteReplacement(File.separator));
		
		//被替换的路径名称;
		String rpl_dir_base  = rpl_base_package.replaceAll(Pattern.quote("."), Matcher.quoteReplacement(File.separator));
		
		String dir_java   = String.format("src%smain%sjava", File.separator, File.separator);
		
		String dir_resource = String.format("src%smain%sresources", File.separator, File.separator);
		
		String dir_webapp = String.format("src%smain%swebapp", File.separator, File.separator);
		
		File base_src =  new File(dir_src);
		File base_target_java =  new File(dir_target, dir_java);
		if(base_target_java.exists()){
			FileUtils.deleteDirectory(base_target_java);
		}
		base_target_java.mkdirs();
		
		File base_target_resource =  new File(dir_target, dir_resource);
		if(base_target_resource.exists()){
			FileUtils.deleteDirectory(base_target_resource);
		}
		base_target_resource.mkdirs();
		
		File base_target_webapp =  new File(dir_target, dir_webapp);
		if(base_target_webapp.exists()){
			FileUtils.deleteDirectory(base_target_webapp);
		}
		base_target_webapp.mkdirs();
		
		
		if(base_src.exists()
				&& base_src.isDirectory()){
			//替换java文件;
			File base_src_java = new File(base_src, dir_java);
			if(base_src_java.exists()
					&& base_src_java.isDirectory()){
				
				String bsj = base_src_java.getCanonicalPath();
				Collection<File> files = FileUtils.listFiles(base_src_java, new String[]{"java", "xml", "properties"}, true);
				for(File file : files){
					String fileName = file.getName();
					String ext = FilenameUtils.getExtension(fileName);
					String par = file.getParentFile().getCanonicalPath();
					String rel = par.substring(bsj.length());
					
					String rel_new = rel.replaceFirst(rpl_mark_dir_base, Matcher.quoteReplacement(rpl_dir_base));
//						System.out.println(rel);
//						System.out.println(rel_new);
					
					//创建目标文件父目录;
					File dir_target_new =  new File(base_target_java, rel_new);
					if(!dir_target_new.exists()){
						dir_target_new.mkdirs();
					}
					//创建目标文件;
					File file_target_new = new File(dir_target_new, fileName);
					if("java".equalsIgnoreCase(ext)){
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_target_new), charset));
						
						BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
						String line = null;
						while((line = br.readLine()) != null){
							String tmp_line = line.trim();
							//替换包名称或者导入的包名称;
							if(tmp_line.startsWith("package")
									|| tmp_line.startsWith("import")){
								bw.write(tmp_line.replaceAll(rpl_mark_base_package, Matcher.quoteReplacement(rpl_base_package)));
							}else{
								bw.write(line);
							}
							bw.write('\r');
							bw.write('\n');
						}
						
						br.close();
						bw.close();
						
					//xml和properties文件;
					}else{
						FileUtils.copyFile(file, file_target_new);
					}
				}
			}else{
				print_dir_not_exists(base_src_java.getAbsolutePath());
			}
			
			//替换资源文件;
			File base_src_resource = new File(base_src, dir_resource);
			if(base_src_resource.exists()
					&& base_src_resource.isDirectory()){
				
				String bsj = base_src_resource.getCanonicalPath();
				Collection<File> files = FileUtils.listFiles(base_src_resource, null, true);
				for(File file : files){
					String fileName = file.getName();
					String ext = FilenameUtils.getExtension(fileName);
					String par = file.getParentFile().getCanonicalPath();
					String rel = par.substring(bsj.length());
					
					//创建目标文件父目录;
					File dir_target_new =  new File(base_target_resource, rel);
					if(!dir_target_new.exists()){
						dir_target_new.mkdirs();
					}
					//创建目标文件;
					File file_target_new = new File(dir_target_new, fileName);
					if("xml".equalsIgnoreCase(ext)){
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_target_new), charset));
						
						BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
						String line = null;
						while((line = br.readLine()) != null){
							String tmp_line = line.trim();
							//替换包名称或者导入的包名称;
							bw.write(tmp_line.replaceAll(Pattern.quote(mark_base_package), Matcher.quoteReplacement(rpl_base_package)));
							bw.write('\r');
							bw.write('\n');
						}
						
						br.close();
						bw.close();
						
					//properties文件;
					}else{
						FileUtils.copyFile(file, file_target_new);
					}
				}
			}else{
				print_dir_not_exists(base_src_resource.getAbsolutePath());
			}
			
			//替换webapp;
			File base_src_webapp = new File(base_src, dir_webapp);
			if(base_src_webapp.exists()
					&& base_src_webapp.isDirectory()){
				
				String bsj = base_src_webapp.getCanonicalPath();
				Collection<File> files = FileUtils.listFiles(base_src_webapp, null, true);
				for(File file : files){
					String fileName = file.getName();
					String ext = FilenameUtils.getExtension(fileName);
					String par = file.getParentFile().getCanonicalPath();
					String rel = par.substring(bsj.length());
					
					//创建目标文件父目录;
					File dir_target_new =  new File(base_target_webapp, rel);
					if(!dir_target_new.exists()){
						dir_target_new.mkdirs();
					}
					//创建目标文件;
					File file_target_new = new File(dir_target_new, fileName);
					if("jsp".equalsIgnoreCase(ext)
							|| "tag".equalsIgnoreCase(ext)){
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_target_new), charset));
						
						BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
						String line = null;
						while((line = br.readLine()) != null){
							String tmp_line = line.trim();
							//替换包名称或者导入的包名称;
							bw.write(tmp_line.replaceFirst(Pattern.quote(mark_base_package), Matcher.quoteReplacement(rpl_base_package)));
							bw.write('\r');
							bw.write('\n');
						}
						
						br.close();
						bw.close();
						
					//其它所有文件;
					}else{
						FileUtils.copyFile(file, file_target_new);
					}
				}
			}else{
				print_dir_not_exists(base_src_webapp.getAbsolutePath());
			}
		}else{
			print_dir_not_exists(dir_src);
		}
//		System.out.println(File.separator);
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(base_src), charset));
	}
	
	public static void print_dir_not_exists(String dir){
		System.out.println(String.format("dir[%s] is not exists or is not a directory!", dir));
	}


}
