/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.io.input.ReaderInputStream;
import org.apache.commons.io.output.WriterOutputStream;

import me.paddingdun.gen.code.user.TableConfig;
import me.paddingdun.gen.code.user.UserConfig;

/**
 * @author paddingdun
 *
 * 2016年2月3日
 */
public class GZipHelper {
	
	public static byte[] gzip(String text, String charset)throws Exception{
		GZIPOutputStream	gos = null;
		ReaderInputStream	ris = null;
		try{
			ris = new ReaderInputStream(new StringReader(text), charset);
			ByteArrayOutputStream 	bos = new ByteArrayOutputStream();
			gos = new GZIPOutputStream(bos);
			byte[] buffer = new byte[1024];
			
			int len = -1;
			while((len = ris.read(buffer)) > -1){
				gos.write(buffer, 0, len);
			}
			IOHelper.close(gos);
			return bos.toByteArray();
		}finally{
			IOHelper.close(ris);
			IOHelper.close(gos);
		}
	}
	
	public static String ungzip(byte[] bytes, String charset)throws Exception{
		GZIPInputStream		gis = null;
		WriterOutputStream	wos = null;
		try{
			gis = new GZIPInputStream(new ByteArrayInputStream(bytes));
			StringWriter sw = new StringWriter();
			wos = new WriterOutputStream(sw, charset);
			
			byte[] buffer = new byte[1024];
			int len = -1;
			while((len = gis.read(buffer)) > -1){
				wos.write(buffer, 0, len);
			}
			IOHelper.close(wos);
			return sw.toString();
		}finally{
			IOHelper.close(gis);
			IOHelper.close(wos);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		String s = "{\"cat\":\"pms\",\"tableName\":\"tb_di_task_log1\",\"tableType\":\"TABLE\",\"tableCommon\":\"\",\"columns\":[{\"columnName\":\"di_task_log_id\",\"type\":4,\"columnCommon\":\"\",\"autoIncrement\":false,\"primary\":true,\"javaType\":\"java.lang.Integer\",\"propertyName\":\"diTaskLogId\",\"getMethod\":\"getDiTaskLogId\",\"setMethod\":\"setDiTaskLogId\",\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":true,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"\"},{\"columnName\":\"create_time\",\"type\":93,\"columnCommon\":\"创建时间\",\"autoIncrement\":false,\"primary\":false,\"javaType\":\"java.sql.Timestamp\",\"propertyName\":\"createTime\",\"getMethod\":\"getCreateTime\",\"setMethod\":\"setCreateTime\",\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":true,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"创建时间\"},{\"columnName\":\"log_des\",\"type\":12,\"columnCommon\":\"日志内容\",\"autoIncrement\":false,\"primary\":false,\"javaType\":\"java.lang.String\",\"propertyName\":\"logDes\",\"getMethod\":\"getLogDes\",\"setMethod\":\"setLogDes\",\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":true,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"日志内容\"},{\"columnName\":\"status\",\"type\":4,\"columnCommon\":\"状态, 1:成功; 0:失败;\",\"autoIncrement\":false,\"primary\":false,\"javaType\":\"java.lang.Integer\",\"propertyName\":\"status\",\"getMethod\":\"getStatus\",\"setMethod\":\"setStatus\",\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":true,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"状态, 1:成功; 0:失败;\"},{\"columnName\":\"di_task_name\",\"type\":12,\"columnCommon\":\"数据接口任务名称,简短的英文标识\",\"autoIncrement\":false,\"primary\":false,\"javaType\":\"java.lang.String\",\"propertyName\":\"diTaskName\",\"getMethod\":\"getDiTaskName\",\"setMethod\":\"setDiTaskName\",\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":true,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"数据接口任务名称,简短的英文标识\"},{\"columnName\":\"log_iden\",\"type\":12,\"columnCommon\":\"日志标识\",\"autoIncrement\":false,\"primary\":false,\"javaType\":\"java.lang.String\",\"propertyName\":\"logIden\",\"getMethod\":\"getLogIden\",\"setMethod\":\"setLogIden\",\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":true,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"日志标识\"},{\"columnName\":\"op_user_id\",\"type\":12,\"columnCommon\":\"操作用户id\",\"autoIncrement\":false,\"primary\":false,\"javaType\":\"java.lang.String\",\"propertyName\":\"opUserId\",\"getMethod\":\"getOpUserId\",\"setMethod\":\"setOpUserId\",\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":true,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"操作用户id\"},{\"columnName\":\"op_user_name\",\"type\":12,\"columnCommon\":\"操作用户名称\",\"autoIncrement\":false,\"primary\":false,\"javaType\":\"java.lang.String\",\"propertyName\":\"opUserName\",\"getMethod\":\"getOpUserName\",\"setMethod\":\"setOpUserName\",\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":true,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"操作用户名称\"},{\"columnName\":\"task_log_type\",\"type\":4,\"columnCommon\":\"日志类型,0:数据接口日志, 1:任务扫描日志;\",\"autoIncrement\":false,\"primary\":false,\"javaType\":\"java.lang.Integer\",\"propertyName\":\"taskLogType\",\"getMethod\":\"getTaskLogType\",\"setMethod\":\"setTaskLogType\",\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":true,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"日志类型,0:数据接口日志, 1:任务扫描日志;\"}],\"entityBeanName\":\"DiTaskLog1\",\"jspColumns\":[{\"listRender\":{\"render\":\"\\n\\t\\n\\t\\t{\\\"data\\\":\\\"diTaskLogId\\\", \\\"defaultContent\\\":\\\"\\\",\\n\\t\\t \\\"render\\\":function( data, type, row, meta ){\\n\\t\\t \\treturn \\u0027\\u003cinput type\\u003d\\\"checkbox\\\" class\\u003d\\\"list_group_checkbox\\\" value\\u003d\\\"\\u0027 + data + \\u0027\\\"\\u003e\\u0027;\\n\\t\\t }\\n\\t\\t}\\n\\t \\n\\t\",\"show\":true,\"title\":\"\\n\\t\\n\\t\\t\\u003cinput type\\u003d\\\"checkbox\\\" class\\u003d\\\"list_head_group_checkbox\\\"\\u003e\\n\\t \\n\\t\"},\"editRender\":{\"render\":\"\\n\\t\\n\\t\\t\\u003cinput type\\u003d\\\"hidden\\\" id\\u003d\\\"diTaskLogId\\\" name\\u003d\\\"diTaskLogId\\\"\\u003e\\n\\t \\n\\t\",\"show\":true,\"title\":\"\"},\"columnName\":\"di_task_log_id\",\"type\":4,\"columnCommon\":\"\",\"autoIncrement\":false,\"primary\":true,\"javaType\":\"java.lang.Integer\",\"propertyName\":\"diTaskLogId\",\"getMethod\":\"getDiTaskLogId\",\"setMethod\":\"setDiTaskLogId\",\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":true,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"\"},{\"listRender\":{\"render\":\"\\n\\t\\n\\t\\t{\\\"data\\\":\\\"createTime\\\", \\\"defaultContent\\\":\\\"\\\"}\\n\\t \\n\\t\",\"show\":true,\"title\":\"创建时间\"},\"editRender\":{\"render\":\"\\n\\t\\n\\t\\t\\u003cdiv class\\u003d\\\"form-group\\\"\\u003e\\n\\t\\t\\t\\u003clabel for\\u003d\\\"createTime\\\" class\\u003d\\\"col-sm-2 control-label\\\"\\u003e\\n\\t\\t\\t创建时间\\n\\t\\t\\t\\u003c/label\\u003e\\n\\t\\t\\t\\u003cdiv class\\u003d\\\"col-sm-10\\\"\\u003e\\n\\t\\t\\t\\t\\u003cinput type\\u003d\\\"text\\\" class\\u003d\\\"form-control\\\" id\\u003d\\\"createTime\\\" name\\u003d\\\"createTime\\\"\\u003e\\n\\t\\t\\t\\u003c/div\\u003e\\n\\t\\t\\u003c/div\\u003e\\n\\t \\n\\t\",\"show\":true,\"title\":\"创建时间\"},\"columnName\":\"create_time\",\"type\":93,\"columnCommon\":\"创建时间\",\"autoIncrement\":false,\"primary\":false,\"javaType\":\"java.sql.Timestamp\",\"propertyName\":\"createTime\",\"getMethod\":\"getCreateTime\",\"setMethod\":\"setCreateTime\",\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":true,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"创建时间\"},{\"listRender\":{\"render\":\"\\n\\t\\n\\t\\t{\\\"data\\\":\\\"logDes\\\", \\\"defaultContent\\\":\\\"\\\"}\\n\\t \\n\\t\",\"show\":true,\"title\":\"日志内容\"},\"editRender\":{\"render\":\"\\n\\t\\n\\t\\t\\u003cdiv class\\u003d\\\"form-group\\\"\\u003e\\n\\t\\t\\t\\u003clabel for\\u003d\\\"logDes\\\" class\\u003d\\\"col-sm-2 control-label\\\"\\u003e\\n\\t\\t\\t日志内容\\n\\t\\t\\t\\u003c/label\\u003e\\n\\t\\t\\t\\u003cdiv class\\u003d\\\"col-sm-10\\\"\\u003e\\n\\t\\t\\t\\t\\u003cinput type\\u003d\\\"text\\\" class\\u003d\\\"form-control\\\" id\\u003d\\\"logDes\\\" name\\u003d\\\"logDes\\\"\\u003e\\n\\t\\t\\t\\u003c/div\\u003e\\n\\t\\t\\u003c/div\\u003e\\n\\t \\n\\t\",\"show\":true,\"title\":\"日志内容\"},\"columnName\":\"log_des\",\"type\":12,\"columnCommon\":\"日志内容\",\"autoIncrement\":false,\"primary\":false,\"javaType\":\"java.lang.String\",\"propertyName\":\"logDes\",\"getMethod\":\"getLogDes\",\"setMethod\":\"setLogDes\",\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":true,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"日志内容\"},{\"listRender\":{\"render\":\"\\n\\t\\n\\t\\t{\\\"data\\\":\\\"status\\\", \\\"defaultContent\\\":\\\"\\\"}\\n\\t \\n\\t\",\"show\":true,\"title\":\"状态, 1:成功; 0:失败;\"},\"editRender\":{\"render\":\"\\n\\t\\n\\t\\t\\u003cdiv class\\u003d\\\"form-group\\\"\\u003e\\n\\t\\t\\t\\u003clabel for\\u003d\\\"status\\\" class\\u003d\\\"col-sm-2 control-label\\\"\\u003e\\n\\t\\t\\t状态, 1:成功; 0:失败;\\n\\t\\t\\t\\u003c/label\\u003e\\n\\t\\t\\t\\u003cdiv class\\u003d\\\"col-sm-10\\\"\\u003e\\n\\t\\t\\t\\t\\u003cinput type\\u003d\\\"text\\\" class\\u003d\\\"form-control\\\" id\\u003d\\\"status\\\" name\\u003d\\\"status\\\"\\u003e\\n\\t\\t\\t\\u003c/div\\u003e\\n\\t\\t\\u003c/div\\u003e\\n\\t \\n\\t\",\"show\":true,\"title\":\"状态, 1:成功; 0:失败;\"},\"columnName\":\"status\",\"type\":4,\"columnCommon\":\"状态, 1:成功; 0:失败;\",\"autoIncrement\":false,\"primary\":false,\"javaType\":\"java.lang.Integer\",\"propertyName\":\"status\",\"getMethod\":\"getStatus\",\"setMethod\":\"setStatus\",\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":true,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"状态, 1:成功; 0:失败;\"},{\"listRender\":{\"render\":\"\\n\\t\\n\\t\\t{\\\"data\\\":\\\"diTaskName\\\", \\\"defaultContent\\\":\\\"\\\"}\\n\\t \\n\\t\",\"show\":true,\"title\":\"数据接口任务名称,简短的英文标识\"},\"editRender\":{\"render\":\"\\n\\t\\n\\t\\t\\u003cdiv class\\u003d\\\"form-group\\\"\\u003e\\n\\t\\t\\t\\u003clabel for\\u003d\\\"diTaskName\\\" class\\u003d\\\"col-sm-2 control-label\\\"\\u003e\\n\\t\\t\\t数据接口任务名称,简短的英文标识\\n\\t\\t\\t\\u003c/label\\u003e\\n\\t\\t\\t\\u003cdiv class\\u003d\\\"col-sm-10\\\"\\u003e\\n\\t\\t\\t\\t\\u003cinput type\\u003d\\\"text\\\" class\\u003d\\\"form-control\\\" id\\u003d\\\"diTaskName\\\" name\\u003d\\\"diTaskName\\\"\\u003e\\n\\t\\t\\t\\u003c/div\\u003e\\n\\t\\t\\u003c/div\\u003e\\n\\t \\n\\t\",\"show\":true,\"title\":\"数据接口任务名称,简短的英文标识\"},\"columnName\":\"di_task_name\",\"type\":12,\"columnCommon\":\"数据接口任务名称,简短的英文标识\",\"autoIncrement\":false,\"primary\":false,\"javaType\":\"java.lang.String\",\"propertyName\":\"diTaskName\",\"getMethod\":\"getDiTaskName\",\"setMethod\":\"setDiTaskName\",\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":true,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"数据接口任务名称,简短的英文标识\"},{\"listRender\":{\"render\":\"\\n\\t\\n\\t\\t{\\\"data\\\":\\\"logIden\\\", \\\"defaultContent\\\":\\\"\\\"}\\n\\t \\n\\t\",\"show\":true,\"title\":\"日志标识\"},\"editRender\":{\"render\":\"\\n\\t\\n\\t\\t\\u003cdiv class\\u003d\\\"form-group\\\"\\u003e\\n\\t\\t\\t\\u003clabel for\\u003d\\\"logIden\\\" class\\u003d\\\"col-sm-2 control-label\\\"\\u003e\\n\\t\\t\\t日志标识\\n\\t\\t\\t\\u003c/label\\u003e\\n\\t\\t\\t\\u003cdiv class\\u003d\\\"col-sm-10\\\"\\u003e\\n\\t\\t\\t\\t\\u003cinput type\\u003d\\\"text\\\" class\\u003d\\\"form-control\\\" id\\u003d\\\"logIden\\\" name\\u003d\\\"logIden\\\"\\u003e\\n\\t\\t\\t\\u003c/div\\u003e\\n\\t\\t\\u003c/div\\u003e\\n\\t \\n\\t\",\"show\":true,\"title\":\"日志标识\"},\"columnName\":\"log_iden\",\"type\":12,\"columnCommon\":\"日志标识\",\"autoIncrement\":false,\"primary\":false,\"javaType\":\"java.lang.String\",\"propertyName\":\"logIden\",\"getMethod\":\"getLogIden\",\"setMethod\":\"setLogIden\",\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":true,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"日志标识\"},{\"listRender\":{\"render\":\"\\n\\t\\n\\t\\t{\\\"data\\\":\\\"opUserId\\\", \\\"defaultContent\\\":\\\"\\\"}\\n\\t \\n\\t\",\"show\":true,\"title\":\"操作用户id\"},\"editRender\":{\"render\":\"\\n\\t\\n\\t\\t\\u003cdiv class\\u003d\\\"form-group\\\"\\u003e\\n\\t\\t\\t\\u003clabel for\\u003d\\\"opUserId\\\" class\\u003d\\\"col-sm-2 control-label\\\"\\u003e\\n\\t\\t\\t操作用户id\\n\\t\\t\\t\\u003c/label\\u003e\\n\\t\\t\\t\\u003cdiv class\\u003d\\\"col-sm-10\\\"\\u003e\\n\\t\\t\\t\\t\\u003cinput type\\u003d\\\"text\\\" class\\u003d\\\"form-control\\\" id\\u003d\\\"opUserId\\\" name\\u003d\\\"opUserId\\\"\\u003e\\n\\t\\t\\t\\u003c/div\\u003e\\n\\t\\t\\u003c/div\\u003e\\n\\t \\n\\t\",\"show\":true,\"title\":\"操作用户id\"},\"columnName\":\"op_user_id\",\"type\":12,\"columnCommon\":\"操作用户id\",\"autoIncrement\":false,\"primary\":false,\"javaType\":\"java.lang.String\",\"propertyName\":\"opUserId\",\"getMethod\":\"getOpUserId\",\"setMethod\":\"setOpUserId\",\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":true,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"操作用户id\"},{\"listRender\":{\"render\":\"\\n\\t\\n\\t\\t{\\\"data\\\":\\\"opUserName\\\", \\\"defaultContent\\\":\\\"\\\"}\\n\\t \\n\\t\",\"show\":true,\"title\":\"操作用户名称\"},\"editRender\":{\"render\":\"\\n\\t\\n\\t\\t\\u003cdiv class\\u003d\\\"form-group\\\"\\u003e\\n\\t\\t\\t\\u003clabel for\\u003d\\\"opUserName\\\" class\\u003d\\\"col-sm-2 control-label\\\"\\u003e\\n\\t\\t\\t操作用户名称\\n\\t\\t\\t\\u003c/label\\u003e\\n\\t\\t\\t\\u003cdiv class\\u003d\\\"col-sm-10\\\"\\u003e\\n\\t\\t\\t\\t\\u003cinput type\\u003d\\\"text\\\" class\\u003d\\\"form-control\\\" id\\u003d\\\"opUserName\\\" name\\u003d\\\"opUserName\\\"\\u003e\\n\\t\\t\\t\\u003c/div\\u003e\\n\\t\\t\\u003c/div\\u003e\\n\\t \\n\\t\",\"show\":true,\"title\":\"操作用户名称\"},\"columnName\":\"op_user_name\",\"type\":12,\"columnCommon\":\"操作用户名称\",\"autoIncrement\":false,\"primary\":false,\"javaType\":\"java.lang.String\",\"propertyName\":\"opUserName\",\"getMethod\":\"getOpUserName\",\"setMethod\":\"setOpUserName\",\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":true,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"操作用户名称\"},{\"listRender\":{\"render\":\"\\n\\t\\n\\t\\t{\\\"data\\\":\\\"taskLogType\\\", \\\"defaultContent\\\":\\\"\\\"}\\n\\t \\n\\t\",\"show\":true,\"title\":\"日志类型,0:数据接口日志, 1:任务扫描日志;\"},\"editRender\":{\"render\":\"\\n\\t\\n\\t\\t\\u003cdiv class\\u003d\\\"form-group\\\"\\u003e\\n\\t\\t\\t\\u003clabel for\\u003d\\\"taskLogType\\\" class\\u003d\\\"col-sm-2 control-label\\\"\\u003e\\n\\t\\t\\t日志类型,0:数据接口日志, 1:任务扫描日志;\\n\\t\\t\\t\\u003c/label\\u003e\\n\\t\\t\\t\\u003cdiv class\\u003d\\\"col-sm-10\\\"\\u003e\\n\\t\\t\\t\\t\\u003cinput type\\u003d\\\"text\\\" class\\u003d\\\"form-control\\\" id\\u003d\\\"taskLogType\\\" name\\u003d\\\"taskLogType\\\"\\u003e\\n\\t\\t\\t\\u003c/div\\u003e\\n\\t\\t\\u003c/div\\u003e\\n\\t \\n\\t\",\"show\":true,\"title\":\"日志类型,0:数据接口日志, 1:任务扫描日志;\"},\"columnName\":\"task_log_type\",\"type\":4,\"columnCommon\":\"日志类型,0:数据接口日志, 1:任务扫描日志;\",\"autoIncrement\":false,\"primary\":false,\"javaType\":\"java.lang.Integer\",\"propertyName\":\"taskLogType\",\"getMethod\":\"getTaskLogType\",\"setMethod\":\"setTaskLogType\",\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":true,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"日志类型,0:数据接口日志, 1:任务扫描日志;\"},{\"listRender\":{\"render\":\"\\n\\t\\n\\t\\t{\\\"data\\\":null, \\\"defaultContent\\\":\\\"\\\",\\n\\t\\t \\\"render\\\":function( data, type, row, meta ){\\n\\t\\t\\treturn \\u0027\\u003cbutton type\\u003d\\\"button\\\" class\\u003d\\\"btn btn-default\\\"\\u003e\\u0027+\\n\\t\\t\\t  \\u0027\\u003cspan class\\u003d\\\"glyphicon glyphicon-edit\\\" aria-hidden\\u003d\\\"true\\\"\\u003e\\u003c/span\\u003e\\u0027+\\n\\t\\t\\t\\u0027\\u003c/button\\u003e\\u0027+\\n\\t\\t\\t\\u0027\\u003cbutton type\\u003d\\\"button\\\" class\\u003d\\\"btn btn-default\\\"\\u003e\\u0027+\\n\\t\\t\\t  \\u0027\\u003cspan class\\u003d\\\"glyphicon glyphicon-remove-circle\\\" aria-hidden\\u003d\\\"true\\\"\\u003e\\u003c/span\\u003e\\u0027+\\n\\t\\t\\t\\u0027\\u003c/button\\u003e\\u0027;\\n\\t\\t }\\n\\t\\t}\\n\\t \\n\\t\",\"show\":true,\"title\":\"操作\"},\"editRender\":{\"show\":false},\"type\":-1,\"columnCommon\":\"操作\",\"autoIncrement\":false,\"primary\":false,\"gson\":true,\"queryRenderShow\":false,\"listRenderShow\":true,\"editRenderShow\":false,\"queryRenderWay\":1000,\"listRenderWay\":2000,\"editRenderWay\":3000,\"columnTitle\":\"操作\"}],\"queryFormRender\":{\"show\":false}}";
		
		
		
		byte[] ziped = gzip(s, "utf-8");
		System.out.println(ziped.length);
		
		UserConfig uc = new UserConfig();
		TableConfig tc = new TableConfig();
		tc.setId("pms:task");
		tc.setText(ziped);
		uc.setTableConfig(tc);
		
//		System.out.println(ConfigHelper.convertToXml(uc, "utf-8"));
		
		UserConfig uc1 = ConfigHelper.convertToObject(UserConfig.class, ConfigHelper.convertToXml(uc, "utf-8"), "utf-8");
		
		
		System.out.println(ungzip(uc1.getTableConfig().getText(), "utf-8"));

	}

}
