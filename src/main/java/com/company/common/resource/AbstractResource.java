package com.company.common.resource;


public abstract class AbstractResource implements Resource {

	@Override
	public boolean exist() {
		return getFile().exists();
	}

//	@Override
//	public File getFile() {
//		//TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public URL getURL() {
//		//TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public URI getURI() {
//		//TODO Auto-generated method stub
//		return null;
//	}
}
