/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.dkiselev.osm.o5mreader.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;
import ru.dkiselev.osm.o5mreader.O5MReader;
import ru.dkiselev.osm.o5mreader.SimpleO5MHandler;
import ru.dkiselev.osm.o5mreader.datasets.Node;
import ru.dkiselev.osm.o5mreader.datasets.Relation;
import ru.dkiselev.osm.o5mreader.datasets.Way;

/**
 *
 * @author Mateusz Paluch <matepal@gmail.com>
 */
public class O5MReaderTest {
	
	public O5MReaderTest() {
	}

	/**
	 * Test of parseHeader method, of class O5MReader.
	 * @throws java.lang.Exception
	 */
	@Test
	public void readSmallFile() throws Exception {
		String[] filename = new String[] {
			"monaco-latest.o5m"
		};
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream(filename[0]);
		
		Assert.assertNotNull(is);
		
		SimpleO5MHandler handler = new SimpleO5MHandler();
		O5MReader reader = new O5MReader(is);
		
		//TODO Count datasets and check
		System.out.println(handler.toString());
		
		assertEquals(true, handler.getNodes().size() > 0);
		assertEquals(true, handler.getWays().size() > 0);
		assertEquals(true, handler.getRelations().size() > 0);
		
	}
}
