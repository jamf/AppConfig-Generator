package com.jamfsoftware.research.macingestor;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.jamfsoftware.research.macingestor.jaxb.ManagedAppConfiguration;

public class JAXBReader<T> {

	private Class<T> type;
	
	public JAXBReader(Class<T> type){
		this.type = type;
	}
	
	public static void main(String[] args) {
		try {
			JAXBContext jc = JAXBContext.newInstance(ManagedAppConfiguration.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
	        ManagedAppConfiguration mac = (ManagedAppConfiguration) unmarshaller.unmarshal(new File("mac.xml"));
	        List<Object> dict =  mac.getDict().getStringOrStringArrayOrInteger();
	        for(Object o : dict){
	        	MACDataType data = (MACDataType)o;
	        	System.out.println(data.getValidation());
	        	System.out.println(data.isUserOrDeviceVariable());
	        }
	        System.out.println(mac);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public T read(InputStream is){
		try {
			JAXBContext jc = JAXBContext.newInstance(type);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
	        return (T) unmarshaller.unmarshal(is);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
