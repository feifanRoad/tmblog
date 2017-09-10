package com.tm.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

/**
 * 自动构建项目工具
 * 类名: TzAutoProject
 * 创建人:lifan 
 * 时间：2017年7月17日 上午10:34:27 
 * @version 1.0.0
 *
 *
 *
 * 写在前面：	1、config源文件夹需要自己手动创建一个
 * 			2、核心文件中加密数据库用户名和密码
 * 			3、db.properties文件需要填好数据库和用户名密码
 * 			4、导入所有需要用到的jar包
 *
 */
public class TmAutoProject {
	private static String pageName = "tm";//包名，可变更
	
	//主要变更对象
	private static String beanName = "Knowlege";//类名
	private static String description = "知识点管理模块";//描述
	private static String author = "lifan";//作者
	
	private static String smallBeanName = beanName.toLowerCase();
//	private static String qq = "1111111111";
//	private static String telephone = "111111111111";
//	private static String email = "111111111@qq.com";
	private static String date = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
	
	//主方法
	//按照步骤创建文件，	第一步执行后就就注释掉，此步骤在整个项目过程中只需要执行一次
	//				第二步可以多次执行，只需更改上面的模块信息即可
	public static void main(String[] args) throws IOException {
		//第一步：先生成只需要创建一次的文件
//		createComBean();
//		createApplicationContext();
//		createMabatiesXml();
//		createDbProperties();
//		createMvcXml();
//		createWebXml();
//		createCoreDESUtils();
//		createCoreEncryptProperty();
//		createCoreExamplePlugin();
//		createCoreUTF8String();
		
		//第二步：根据需求创建文件
//		createBean();
//		createDao();
//		createSQLXml();
		createService();
		createServiceImpl();
//		createWeb();
//		createPage();
//		createTemplate();
		
		//暂不可用
//		createTable();
	}
	
	
	
	//目录结构
	private static String srcPath = "src/";//src根目录
	private static String configPath = "config/";//config根目录
	private static String beanPath = "com/"+pageName+"/model/";//model目录
	private static String daoPath = "com/"+pageName+"/dao/";//dao目录
	private static String servicePath = "com/"+pageName+"/service/";//service目录
	private static String serviceImplPath = "com/"+pageName+"/service/"+smallBeanName+"/impl/";//service实现类目录
	private static String webPath = "com/"+pageName+"/web/"+smallBeanName+"/";//web控制层目录
	private static String corePath = "com/"+pageName+"/core/";//核心层目录
	private static String pagePath = "/WebRoot/WEB-INF/pages/"+smallBeanName+"/";//页面分层目录
	private static String xmlPath = "/WebRoot/WEB-INF/";//xml文件根目录
	
	//模板目录
	private static String beanTemplate = "template/bean.txt";//实体
	private static String comBeanTemplate = "template/comBean.txt";//通用参数实体
	private static String daoTemplate = "template/mapper.txt";//dao中mapper接口
	private static String xmlTemplate = "template/sql.txt";//sql文件
	private static String serviceTemplate = "template/service.txt";//service
	private static String serviceImplTemplate = "template/serviceImpl.txt";//service实现类
	private static String webTemplate = "template/web.txt";//web控制层
	private static String pageTemplate = "template/list.txt";//list页面
	private static String tableTemplate = "template/table.sql";//表结构模板
	private static String templateTemplate = "template/template.txt";//模板页面
	private static String applicationContextTemplate = "template/applicationContext.txt";//application配置文件
	private static String mabatiesXmlTemplate = "template/mybatisConfig.txt";//mybatis配置文件
	private static String dbTemplate = "template/dbProperties.txt";//数据库db配置文件
	private static String springMvcTemplate = "template/springMvc.txt";//springMVC配置文件
	private static String webXmlTemplate = "template/webXml.txt";//web.xml配置文件
	private static String ExamplePluginTemplate = "template/ExamplePlugin.txt";//核心aop织入文件
	private static String UTF8StringTemplate = "template/UTF8StringHttpMessageConverter.txt";//编码集设置文件
	private static String DESUtilsTemplate = "template/DESUtils.txt";//db加密文件
	private static String EncryptPropertyTemplate = "template/EncryptProperty.txt";//db解密文件
	
	//包名
	private static String beanPackage ="com."+pageName+".model";
	private static String daoPackage ="com."+pageName+".dao";
	private static String servicePackage ="com."+pageName+".service";
	private static String serviceImplPackage ="com."+pageName+".service"+smallBeanName+".impl";
	private static String webPackage ="com."+pageName+".web";
	private static String corePackage ="com."+pageName+".core";
	
	/**
	 * 创建template模板
	 * 方法名: createTemplate 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 上午10:53:15
	 * @param @throws IOException
	 * @return void
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static void createTemplate() throws IOException{
		//根目录
		String rootPath = getRoot(pagePath);
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile,"template.jsp");
		//获取模板页面路径
		String template = getRoot(templateTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Template: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Template: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+pagePath+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	/**
	 * 创建page页面
	 * 方法名: createPage 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 上午10:52:57
	 * @param @throws IOException
	 * @return void
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static void createPage() throws IOException{
		//根目录
		String rootPath = getRoot(pagePath);
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile,"list.jsp");
		//获取模板页面路径
		String template = getRoot(pageTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Pages: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Pages: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+pagePath+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	/**
	 * 创建web控制层
	 * 方法名: createWeb 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 上午10:52:43
	 * @param @throws IOException
	 * @return void
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static void createWeb() throws IOException{
		//根目录
		String rootPath = getRoot(srcPath+webPath);
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, beanName+"Controller.java");
		//获取模板页面路径
		String template = getRoot(webTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Web: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Web: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+webPackage+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	/**
	 * 创建serviceImpl
	 * 方法名: createServiceImpl 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 上午10:52:33
	 * @param @throws IOException
	 * @return void
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static void createServiceImpl() throws IOException{
		//根目录
		String rootPath = getRoot(srcPath+serviceImplPath);
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, beanName+"ServiceImpl.java");
		//获取模板页面路径
		String template = getRoot(serviceImplTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示ServiceImpl: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示ServiceImpl: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+serviceImplPackage+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	/**
	 * 创建service
	 * 方法名: createService 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 上午10:52:23
	 * @param @throws IOException
	 * @return void
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static void createService() throws IOException{
		//根目录
		String rootPath = getRoot(srcPath+servicePath+smallBeanName);
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, "I"+beanName+"Service.java");
		//获取模板页面路径
		String template = getRoot(serviceTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Service: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Service: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+servicePackage+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	/**
	 * 创建sqlxml
	 * 方法名: createSQLXml 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 上午10:52:02
	 * @param @throws IOException
	 * @return void
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static void createSQLXml() throws IOException{
		//根目录
		String rootPath = getRoot(srcPath+daoPath+smallBeanName);
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, beanName+".xml");
		//获取模板页面路径
		String template = getRoot(xmlTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示sqlxml: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示sqlxml: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+daoPackage+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	
	/**
	 * 创建dao
	 * 方法名: createDao 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 上午10:51:45
	 * @param @throws IOException
	 * @return void
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static void createDao() throws IOException{
		//根目录
		String rootPath = getRoot(srcPath+daoPath+smallBeanName);
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, "I"+beanName+"Mapper.java");
		//获取模板页面路径
		String template = getRoot(daoTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Mapper: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Mapper: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+daoPackage+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	/**
	 * 创建实体
	 * 方法名: createBean 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 上午10:51:35
	 * @param @throws IOException
	 * @return void
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static void createBean() throws IOException{
		//根目录
		String rootPath = getRoot(srcPath+beanPath);
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, beanName+".java");
		//获取模板页面路径
		String template = getRoot(beanTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Bean: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Bean: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+beanPackage+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	/**
	 * 创建通用的参数实体
	 * 方法名: createComBean 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 上午10:38:04
	 * @param @throws IOException
	 * @return void
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static void createComBean() throws IOException{
		//根目录
		String rootPath = getRoot(srcPath+beanPath);
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, "TmParams.java");
		//获取模板页面路径
		String template = getRoot(comBeanTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Bean: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Bean: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+beanPackage+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	/**
	 * 创建applicationContext文件
	 * 方法名: createApplicationContext 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 上午11:32:59
	 * @param @throws IOException
	 * @return void
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static void createApplicationContext() throws IOException{
		//根目录
		String rootPath = getRoot(configPath+"spring");
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, "applicationContext.xml");
		//获取模板页面路径
		String template = getRoot(applicationContextTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Bean: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Bean: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+beanPackage+"】成功!!!");
			System.out.println("+++++++++++++++++并导入mybatis相关jar包【druid-1.0.9.jar】");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	/**
	 * 创建mabatiesxml文件
	 * 方法名: createMabatiesXml 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 上午11:41:49
	 * @param @throws IOException
	 * @return void
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static void createMabatiesXml() throws IOException{
		//根目录
		String rootPath = getRoot(configPath);
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, "mybatis-config.xml");
		//获取模板页面路径
		String template = getRoot(mabatiesXmlTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Bean: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Bean: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+beanPackage+"】成功!!!");
			System.out.println("+++++++++++++++++需要在core层添加【ExamplePlugin.java】");
			System.out.println("+++++++++++++++++并导入mybatis相关jar包【mybatis-3.3.0-SNAPSHOT.jar】【mybatis-ehcache-1.0.0.jar】【mybatis-spring-1.2.1.jar】");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	/**
	 * 创建DbPropertise文件
	 * 方法名: createDbProperties 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 上午11:59:09
	 * @param @throws IOException
	 * @return void
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static void createDbProperties() throws IOException{
		//根目录
		String rootPath = getRoot(configPath+"db");
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, "db.properties");
		//获取模板页面路径
		String template = getRoot(dbTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Bean: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Bean: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+beanPackage+"】成功!!!");
			System.out.println("+++++++++++++++++需要在core/des层添加【DESUtils.java】【EncryptPropertyPlaceholderConfigurer.java】");
			System.out.println("+++++++++++++++++并导入相关jar包【mysql-connector-java-5.1.6-bin.jar】");
			System.out.println("+++++++++++++++++填写数据库和用户名密码");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	/**
	 * 创建springMVC文件
	 * 方法名: createMvcXml 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 下午12:04:44
	 * @param @throws IOException
	 * @return void
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static void createMvcXml() throws IOException{
		//根目录
		String rootPath = getRoot(xmlPath);
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile,pageName+"mvc.xml");
		//获取模板页面路径
		String template = getRoot(springMvcTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Pages: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Pages: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+pagePath+"】成功!!!");
			System.out.println("+++++++++++++++++需要在core层添加【UTF8StringHttpMessageConverter.java】");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	/**
	 * 创建web.xml文件
	 * 方法名: createWebXml 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 下午1:15:45
	 * @param @throws IOException
	 * @return void
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static void createWebXml() throws IOException{
		//根目录
		String rootPath = getRoot(xmlPath);
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile,"web.xml");
		//获取模板页面路径
		String template = getRoot(webXmlTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Pages: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Pages: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+pagePath+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	/**
	 * 创建核心文件ExamplePlugin
	 * 方法名: createCoreExamplePlugin 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 下午2:09:12
	 * @param @throws IOException
	 * @return void
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static void createCoreExamplePlugin() throws IOException{
		//根目录
		String rootPath = getRoot(srcPath+corePath);
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile,"ExamplePlugin.java");
		//获取模板页面路径
		String template = getRoot(ExamplePluginTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Pages: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Pages: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+pagePath+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	/**
	 * 创建核心文件UTF8StringHttpMessageConverter
	 * 方法名: createCoreUTF8String 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 下午2:09:41
	 * @param @throws IOException
	 * @return void
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static void createCoreUTF8String() throws IOException{
		//根目录
		String rootPath = getRoot(srcPath+corePath);
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile,"UTF8StringHttpMessageConverter.java");
		//获取模板页面路径
		String template = getRoot(UTF8StringTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Pages: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Pages: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+pagePath+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	/**
	 * 创建核心文件DESUtils
	 * 方法名: createCoreDESUtils 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 下午2:10:42
	 * @param @throws IOException
	 * @return void
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static void createCoreDESUtils() throws IOException{
		//根目录
		String rootPath = getRoot(srcPath+corePath+"des");
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile,"DESUtils.java");
		//获取模板页面路径
		String template = getRoot(DESUtilsTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Pages: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Pages: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+pagePath+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	/**
	 * 创建核心文件EncryptPropertyPlaceholderConfigurer
	 * 方法名: createCoreEncryptProperty 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 下午2:11:35
	 * @param @throws IOException
	 * @return void
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static void createCoreEncryptProperty() throws IOException{
		//根目录
		String rootPath = getRoot(srcPath+corePath+"des");
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile,"EncryptPropertyPlaceholderConfigurer.java");
		//获取模板页面路径
		String template = getRoot(EncryptPropertyTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Pages: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Pages: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+pagePath+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
//	public static void createTable(){
//		try {
//			//获取模板页面路径
//			String template = getRoot(tableTemplate);
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kekeblog2?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true", "root", "1qazxsw2");
//			new SqlFileExecutor().execute(connection, template,"\\[smallBeanName\\]",smallBeanName);
//	        System.out.println("【自动构建提示Table: 】生成表keke_"+smallBeanName+"表成功!");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("【自动构建提示Table: 】生成表keke_"+smallBeanName+"表失败!");
//		} 
//	}
	
	
	
	/**
	 * 替换模板信息
	 * 方法名: replaceTemplate 
	 * 创建人: lifan 
	 * 时间：2017年7月17日 上午10:54:49
	 * @param @param content
	 * @param @return
	 * @return String
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static String replaceTemplate(String content){
		if(TmStringUtils.isNotEmpty(content)){
			content = content.replaceAll("\\[beanPackage\\]",beanPackage)
					.replaceAll("\\[daoPackage\\]",daoPackage)
					.replaceAll("\\[servicePackage\\]",servicePackage)
					.replaceAll("\\[webPackage\\]",webPackage)
					.replaceAll("\\[corePackage\\]",corePackage)
					.replaceAll("\\[description\\]",description)
					.replaceAll("\\[author\\]",author)
					.replaceAll("\\[date\\]",date)
//					.replaceAll("\\[qq\\]",qq)
//					.replaceAll("\\[email\\]",email)
					.replaceAll("\\[smallBeanName\\]",smallBeanName)
//					.replaceAll("\\[telephone\\]",telephone)
					.replaceAll("\\[pageName\\]",pageName)
					.replaceAll("\\[beanName\\]",beanName);
			return content;
		}else{
			return "";
		}
	}
	
	
//		Properties properties = System.getProperties();
//		Enumeration<Object> keys =  properties.keys();
//		while (keys.hasMoreElements()) {
//			Object object = (Object) keys.nextElement();
//			System.out.println(object+"============="+properties.get(object));
//		}
	/**
	 * 获取项目根目录方法
	 * 方法名: getRoot 
	 * 创建人: lifan 
	 * 时间：2017年9月8日 上午10:50:58
	 * @param @param path
	 * @param @return
	 * @return String
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static String getRoot(String path){
		return new File(System.getProperty("user.dir"),path).getAbsolutePath();
	}
	
	
	
	
}
