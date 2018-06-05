package com.wjk.boot.springboot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import com.wjk.boot.springboot.generate.util.ColumnClass;
import com.wjk.boot.springboot.generate.util.FreeMarkerTemplateUtils;

import freemarker.template.Template;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeGenerateUtils {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;


	private final String AUTHOR = "Wjk";
	private final String CURRENT_DATE = "2018/06/01";
	private final String tableName = "person";
	private final String packageName = "com.wjk.boot.springboot.generate";
	private final String tableAnnotation = "人员信息";

	private final String changeTableName = replaceUnderLineAndUpperCase(tableName);

	private final String diskPath = "E://workspace2/SpringBootDemo/src/main/java/com/wjk/boot/springboot/generate/";

	@Test
	public void testGenerate() throws Exception{

		Connection conn = sqlSessionFactory.openSession().getConnection();
		DatabaseMetaData data = conn.getMetaData();
		ResultSet resultSet = data.getColumns(null,"%",tableName,"%");


		//生成Model文件
		generateModelFile(resultSet);
	}
	
	public String replaceUnderLineAndUpperCase(String str){
		StringBuffer sb = new StringBuffer();
		sb.append(str);
		int count = sb.indexOf("_");
		while(count!=0){
			int num = sb.indexOf("_",count);
			count = num + 1;
			if(num != -1){
				char ss = sb.charAt(count);
				char ia = (char) (ss - 32);
				sb.replace(count , count + 1,ia + "");
			}
		}
		String result = sb.toString().replaceAll("_","");
		return StringUtils.capitalize(result);
	}

	private void generateModelFile(ResultSet resultSet) throws Exception {
		final String suffix = ".java";
		final String path = diskPath +"vo/" + changeTableName + suffix;
		final String templateName = "Model.ftl";
		File mapperFile = new File(path);
		List<ColumnClass> columnClassList = new ArrayList<>();
		ColumnClass columnClass = null;
		while(resultSet.next()){
			//id字段略过
			//if(resultSet.getString("COLUMN_NAME").equals("id")) continue;
			columnClass = new ColumnClass();
			//获取字段名称
			columnClass.setColumnName(resultSet.getString("COLUMN_NAME"));
			//获取字段类型
			columnClass.setColumnType(resultSet.getString("TYPE_NAME"));
			//转换字段名称，如 sys_name 变成 SysName
			columnClass.setChangeColumnName(replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME")));
			//字段在数据库的注释
			columnClass.setColumnComment(resultSet.getString("REMARKS"));
			columnClassList.add(columnClass);
			
			System.out.println(columnClass);
		}
		Map<String,Object> dataMap = new HashMap<>();
		dataMap.put("model_column",columnClassList);
		generateFileByTemplate(templateName,mapperFile,dataMap);
	}
	
	private void generateFileByTemplate(final String templateName,File file,Map<String,Object> dataMap) throws Exception{
        Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("table_name_small",tableName);
        dataMap.put("table_name",changeTableName);
        dataMap.put("author",AUTHOR);
        dataMap.put("date",CURRENT_DATE);
        dataMap.put("package_name",packageName);
        dataMap.put("table_annotation",tableAnnotation);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"),10240);
        template.process(dataMap,out);
    }
}
