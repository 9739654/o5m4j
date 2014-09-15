/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.dkiselev.osm.o5mreader;

/**
 *
 * @author Mateusz Paluch <matepal@gmail.com>
 */
public class Boundaries {
	
	private final double[] b = new double[4];
	
	Boundaries(double minLon, double minLat, double maxLon, double maxLat) {
		b[0] = minLon;
		b[1] = minLat;
		b[2] = maxLon;
		b[3] = maxLat;
	}
	
	public double getMinLon() {
		return b[0];
	}
	
	public double getMinLat() {
		return b[1];
	}
	
	public double getMaxLon() {
		return b[2];
	}
	
	public double getMaxLat() {
		return b[3];
	}
	
}
