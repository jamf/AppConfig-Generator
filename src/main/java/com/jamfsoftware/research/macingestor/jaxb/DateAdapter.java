package com.jamfsoftware.research.macingestor.jaxb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * <code>DateAdapter</code> is an {@link XmlAdapter} implementation that
 * (un)marshals dates between <code>String</code> and <code>Date</code> representations.
 * All date strings meet <a href="http://en.wikipedia.org/wiki/ISO_8601">ISO
 * 8601</a> basic format. For example, June 16, 2011 16:46:01 GMT is
 * "20110616164601Z". Adapted from
 * http://blogs.oracle.com/CoreJavaTechTips/entry/exchanging_data_with_xml_and
 */

public class DateAdapter extends XmlAdapter<java.lang.String, java.util.Date> {

	private java.lang.String[] formats = {
			"yyyy-MM-dd'T'HH:mm:ss'Z'",
			"yyyy-MM-dd'T'HH:mm'Z'",
			"yyyyMMdd'T'HHmmss'Z'",
			"yyyy-MM-dd"};

	private SimpleDateFormat format;

	public DateAdapter() {
		format = new SimpleDateFormat(formats[0]);
	}

	@Override
	public java.lang.String marshal(Date d) {
		try {
			return format.format(d);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Date unmarshal(java.lang.String d) {
		for (java.lang.String f: formats) {
			try {
				return new SimpleDateFormat(f).parse(d);
			} catch(ParseException ignored) {}
		}
		return null;
	}

}