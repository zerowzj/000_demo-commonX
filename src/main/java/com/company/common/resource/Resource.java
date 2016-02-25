package com.company.common.resource;

import java.io.File;
import java.net.URI;
import java.net.URL;

public interface Resource extends InputStreamResource {

	/**
	 * 
	 */
	public boolean exist();
	
	/**
	 * 
	 */
	public File getFile();
	
	/**
	 * 
	 */
	public URL getURL();
	
	/**
	 * 
	 */
	public URI getURI();
}
