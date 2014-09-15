/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.dkiselev.osm.o5mreader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import ru.dkiselev.osm.o5mreader.datasets.Header;
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
		
		O5MHandler handler = new O5MHandler() {
			List<Node> nodes = new ArrayList<>();
			List<Way> ways = new ArrayList<>();
			List<Relation> relations = new ArrayList<>();

			@Override
			public void handleNode(Node ds) {
				nodes.add(ds);
			}

			@Override
			public void handleWay(Way ds) {
				ways.add(ds);
			}

			@Override
			public void handleRelation(Relation ds) {
				relations.add(ds);
			}

			@Override
			public String toString() {
				return "O5MHandler { nodes=" + nodes.size() + ", ways=" + ways.size() + ", relations=" + relations.size() + " }";
			}
			
		};
		
		O5MReader reader = new O5MReader(is);
		reader.read(handler);
		//TODO Count datasets and check
		System.out.println(handler.toString());
	}
	
	
}
