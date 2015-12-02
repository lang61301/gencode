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

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 * @author paddingdun
 *
 * 2015年12月2日
 */
public class ReplaceProjectPackageName {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		String dir_src	  = "D:\\home\\workspace\\Test";
//		String dir_src	  = "D:\\home\\doc\\frame\\ssh2";
		
		String dir_target = "D:\\home\\tmp\\Test";
		String charset 	  = "UTF-8";
		
		//需要替换的包名;
		String mark_base_package	  = "me.paa.test";
		//替换后的包名;
		String rpl_base_package 	  = "com.shengqun";
		
		//可以被替换的包名;
		String rpl_mark_base_package  = mark_base_package.replaceAll("\\.", Matcher.quoteReplacement("\\") + Matcher.quoteReplacement("."));
		//可以被替换的路径名;
		String rpl_mark_dir_base  = mark_base_package.replaceAll("\\.", Matcher.quoteReplacement("\\") + Matcher.quoteReplacement(File.separator));
		
		//被替换的路径名称;
		String rpl_dir_base  = rpl_base_package.replaceAll("\\.", Matcher.quoteReplacement(File.separator));
		
		String dir_java   = String.format("src%smain%sjava", File.separator, File.separator, File.separator);
		
		
		File base_src =  new File(dir_src);
		File base_target =  new File(dir_target, dir_java);
		if(base_target.exists()){
			FileUtils.deleteDirectory(base_target);
		}
		base_target.mkdirs();
		
		if(base_src.exists()
				&& base_src.isDirectory()){
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
					File dir_target_new =  new File(base_target, rel_new);
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
								bw.write(tmp_line.replaceFirst(rpl_mark_base_package, Matcher.quoteReplacement(rpl_base_package)));
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
//					break;
					
//					BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
//					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
					
					
					
					
//					br.close();
//					bw.close();
				}
			}else{
				print_dir_not_exists(base_src_java.getAbsolutePath());
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
