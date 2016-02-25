package com.company.common.resource;

import java.io.FileNotFoundException;
import java.io.InputStream;

import com.company.common.util.ClassUtils;

public class ClassPathResource {

	/**  */
	private String path = null;
	
	/**  */
	private ClassLoader classLoader = null;
	
	private Class<?> clazz = null;

	public ClassPathResource(String path) {
		this(path, null);
	}

	public ClassPathResource(String path, ClassLoader classLoader) {
		this.path = path;
		this.classLoader = (classLoader != null ? classLoader : ClassUtils
				.getDefaultClassLoader());
	}

	public InputStream getInputStream() throws FileNotFoundException {
		InputStream is = null;
		if (classLoader != null) {
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
