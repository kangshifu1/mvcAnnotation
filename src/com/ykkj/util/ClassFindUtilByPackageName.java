package com.ykkj.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import sun.net.www.protocol.jar.JarURLConnection;

import com.ykkj.form.YKKJBean;
/**
 *   �õ�һ�� package ����������  
 *   ���� getClasses(PackagPath); �õ�Set<Class<?>>
 * @author ykkj
 *
 */
public class ClassFindUtilByPackageName{
/*	public static void main(String[] args) {
		Set<Class<?>> set = Demo.getClasses("com.ykkj.form");
		for (Class class1 : set) {
			System.out.println(class1.getName());
		}
	}*/
	public static Map<String ,YKKJBean> getMap(String packagepath){
		Map<String,YKKJBean> map=new HashMap<String, YKKJBean>();
		Set<Class<?>>  classes=getClasses(packagepath);
		YKKJBean  bean=null;		 
		for(Class<?> clazz:classes){
			System.out.println(clazz.getName());
			bean =new YKKJBean();
			if(clazz.isAnnotationPresent(com.ykkj.annotation.YKKJBean.class)){
				com.ykkj.annotation.YKKJBean beanannotation =clazz.getAnnotation(com.ykkj.annotation.YKKJBean.class);
				String name=beanannotation.name();
				String clas=beanannotation.clas().getName();
				String type=beanannotation.type();
				String path =beanannotation.path();
				String [] forwardName=beanannotation.forwardName();
				String [] forwardValue =beanannotation.forwardValue();
				System.out.println("name :"+name);
				System.out.println("clas  :"+clas);
				
				bean.setName(name);
				bean.setClas(clas);
				bean.setUrlclass(type);
				bean.setUrlpath(path);
				Map<String, String> urlmap=new HashMap<String,String>();
				for(int i=0;i<forwardName.length;i++){
					urlmap.put(forwardName[i],forwardValue[i]);
				}
				
				bean.setMap(urlmap);
				System.out.println(bean);
				map.put(path, bean);
			}
		}
		return map;
		
	}
	/**
	 * �Ӱ�package�л�ȡ���е�Class
	 * 
	 * @param pack
	 * @return
	 */
	public static Set<Class<?>> getClasses(String pack) {

		// ��һ��class��ļ���
		Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
		// �Ƿ�ѭ������
		boolean recursive = true;
		// ��ȡ�������� �������滻
		String packageName = pack;
		String packageDirName = packageName.replace('.', '/');
		// ����һ��ö�ٵļ��� ������ѭ�����������Ŀ¼�µ�things
		Enumeration<URL> dirs = null;
		try {

			dirs = Thread.currentThread().getContextClassLoader()
					.getResources(packageDirName);
			System.out.println(dirs.toString());
			// ѭ��������ȥ
			while (dirs.hasMoreElements()) {
				// ��ȡ��һ��Ԫ��
				URL url = dirs.nextElement();
				// �õ�Э�������
				String protocol = url.getProtocol();
				// ��������ļ�����ʽ�����ڷ�������
				if ("file".equals(protocol)) {
					System.err.println("file���͵�ɨ��");
					// ��ȡ��������·��
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
					// ���ļ��ķ�ʽɨ���������µ��ļ� ����ӵ�������
					findAndAddClassesInPackageByFile(packageName, filePath,
							recursive, classes);
				} else if ("jar".equals(protocol)) {
					// �����jar���ļ�
					// ����һ��JarFile
					System.err.println("jar���͵�ɨ��");
					JarFile jar;
					try {
						// ��ȡjar
						jar = ((JarURLConnection) url.openConnection())
								.getJarFile();
						// �Ӵ�jar�� �õ�һ��ö����
						Enumeration<JarEntry> entries = jar.entries();
						// ͬ���Ľ���ѭ������
						while (entries.hasMoreElements()) {
							// ��ȡjar���һ��ʵ�� ������Ŀ¼ ��һЩjar����������ļ� ��META-INF���ļ�
							JarEntry entry = entries.nextElement();
							String name = entry.getName();
							// �������/��ͷ��
							if (name.charAt(0) == '/') {
								// ��ȡ������ַ���
								name = name.substring(1);
							}
							// ���ǰ�벿�ֺͶ���İ�����ͬ
							if (name.startsWith(packageDirName)) {
								int idx = name.lastIndexOf('/');
								// �����"/"��β ��һ����
								if (idx != -1) {
									// ��ȡ���� ��"/"�滻��"."
									packageName = name.substring(0, idx)
											.replace('/', '.');
								}
								// ������Ե�����ȥ ������һ����
								if ((idx != -1) || recursive) {
									// �����һ��.class�ļ� ���Ҳ���Ŀ¼
									if (name.endsWith(".class")
											&& !entry.isDirectory()) {
										// ȥ�������".class" ��ȡ����������
										String className = name.substring(
												packageName.length() + 1,
												name.length() - 6);
										try {
											// ��ӵ�classes
											/*
											 * classes.add(Class
											 * .forName(packageName + '.' +
											 * className));
											 * 
											 * 
											 * Java���� �ղش���
											 * 
											 * classes.add(Class.forName(packageName
											 * + '.' + className));
											 * 
											 * ����Ӧ����
											 * 
											 * Java���� �ղش���
											 * 
											 * classes.add(Thread.currentThread()
											 * .
											 * getContextClassLoader().loadClass
											 * (packageName + '.' + className));
											 * 
											 * 
											 * Class.forName�ᴥ�������е�static����ġ�
											 * 
											 * 
											 * 
											 * �����class.forname ��
											 * ��classload��loadClass�������ˡ�
											 */
											classes.add(Thread
													.currentThread()
													.getContextClassLoader()
													.loadClass(
															packageName + '.'
																	+ className));
										} catch (ClassNotFoundException e) {
											// log
											// .error("����û��Զ�����ͼ����� �Ҳ��������.class�ļ�");
											e.printStackTrace();
										}
									}
								}
							}
						}
					} catch (IOException e) {
						// log.error("��ɨ���û�������ͼʱ��jar����ȡ�ļ�����");
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return classes;
	}

	/**
	 * ���ļ�����ʽ����ȡ���µ�����Class
	 * 
	 * @param packageName
	 * @param packagePath
	 * @param recursive
	 * @param classes
	 */
	public static void findAndAddClassesInPackageByFile(String packageName,
			String packagePath, final boolean recursive, Set<Class<?>> classes) {
		System.out.println("findAndAddClassesInPackageByFile");
		// ��ȡ�˰���Ŀ¼ ����һ��File
		File dir = new File(packagePath);
		// ��������ڻ��� Ҳ����Ŀ¼��ֱ�ӷ���
		if (!dir.exists() || !dir.isDirectory()) {
			// log.warn("�û�������� " + packageName + " ��û���κ��ļ�");
			return;
		}
		// ������� �ͻ�ȡ���µ������ļ� ����Ŀ¼
		File[] dirfiles = dir.listFiles(new FileFilter() {
			// �Զ�����˹��� �������ѭ��(������Ŀ¼) ��������.class��β���ļ�(����õ�java���ļ�)
			public boolean accept(File file) {
				return (recursive && file.isDirectory())
						|| (file.getName().endsWith(".class"));
			}
		});
		// ѭ�������ļ�
		for (File file : dirfiles) {
			// �����Ŀ¼ �����ɨ��
			if (file.isDirectory()) {
				findAndAddClassesInPackageByFile(
						packageName + "." + file.getName(),
						file.getAbsolutePath(), recursive, classes);
			} else {
				// �����java���ļ� ȥ�������.class ֻ��������
				String className = file.getName().substring(0,
						file.getName().length() - 6);
				try {
					// ��ӵ�������ȥ
					// classes.add(Class.forName(packageName + '.' +
					// className));
					// �����ظ�ͬѧ�����ѣ�������forName��һЩ���ã��ᴥ��static������û��ʹ��classLoader��load�ɾ�
					classes.add(Thread.currentThread().getContextClassLoader()
							.loadClass(packageName + '.' + className));
				} catch (ClassNotFoundException e) {
					// log.error("����û��Զ�����ͼ����� �Ҳ��������.class�ļ�");
					e.printStackTrace();
				}
			}
		}
	}
}