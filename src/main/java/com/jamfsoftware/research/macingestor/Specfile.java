package com.jamfsoftware.research.macingestor;

public class Specfile {

	private String resourceLocation;
	private String version;
	private String bundleId;

	public Specfile(String bundleId, String version, String resourceLocation) {
		this.bundleId = bundleId;
		this.version = version;
		this.resourceLocation = resourceLocation;
	}

	public String getResourceLocation() {
		return resourceLocation;
	}

	public String getVersion() {
		return version;
	}

	public String getBundleId() {
		return bundleId;
	}
}
