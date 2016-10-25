package com.company.project.common.resource;

import java.io.FileNotFoundException;
import java.io.InputStream;

import com.company.project.common.util.ClassUtils;

public class ClassPathResource {

	/**  */
	private final String path;
	
	/**  */
	private ClassLoader classLoader = null;
	
	/**  */
	private Class<?> clazz = null;

	public ClassPathResource(String path) {
		this(path, (ClassLoader) null);
	}
	
	public ClassPathResource(String path, ClassLoader classLoader) {
		this.path = path;
		this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
	}
	
	public ClassPathResource(String path, Class<?> clazz) {
		this.path = path;
		this.clazz = clazz;
	}

	public InputStream getInputStream() throws FileNotFoundException {
		InputStream is = null;
		if(this.clazz != null) {
			is = this.clazz.getResourceAsStream(this.path);
		} else if (classLoader != null) {
			is = this.classLoader.getResourceAsStream(this.path);
		} else {
			is = ClassLoader.getSystemResourceAsStream(this.path);
		}
		if (is == null) {
			throw new FileNotFoundException("");
		}
		return is;
	}
}
