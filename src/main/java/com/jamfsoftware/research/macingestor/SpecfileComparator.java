package com.jamfsoftware.research.macingestor;

import java.util.Comparator;

public class SpecfileComparator implements Comparator<Specfile> {
	@Override
	public int compare(final Specfile s1, final Specfile s2) {
		if (s1.getBundleId().equals(s2.getBundleId())) { // same bundle id
			try { // check version
				int s1Version = Integer.parseInt(s1.getVersion());
				int s2Version = Integer.parseInt(s2.getVersion());

				// sort in descending version order
				return -(Integer.compare(s1Version, s2Version));
			} catch(NumberFormatException e) { // check for 'current'
				if (s1.getVersion().equals("current")) {
					return -1; // s1 is the most recent one
				} else {
					return 1; // fallback in case somehow version is neither a number or 'current' (throw it at the end)
				}
			}
		} else { // different bundle ids, order alphabetically
			return s1.getBundleId().compareTo(s2.getBundleId());
		}
	}
}
