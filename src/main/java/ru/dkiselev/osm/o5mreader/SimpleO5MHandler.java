/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.dkiselev.osm.o5mreader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ru.dkiselev.osm.o5mreader.datasets.Node;
import ru.dkiselev.osm.o5mreader.datasets.Relation;
import ru.dkiselev.osm.o5mreader.datasets.Way;

/**
 *
 * @author Mateusz Paluch <matepal@gmail.com>
 */
public class SimpleO5MHandler extends O5MHandler {
	private final Map<Long, Node> nodes = new HashMap<>();
	private final Map<Long, Way> ways = new HashMap<>();
	private final Map<Long, Relation> relations = new HashMap<>();

	public Map<Long, Node> getNodes() {
		return nodes;
	}

	public Map<Long, Way> getWays() {
		return ways;
	}

	public Map<Long, Relation> getRelations() {
		return relations;
	}

	@Override
	public void handleNode(Node ds) {
		nodes.put(ds.getId(), ds);
	}

	@Override
	public void handleWay(Way ds) {
		ways.put(ds.getId(), ds);
	}

	@Override
	public void handleRelation(Relation ds) {
		relations.put(ds.getId(), ds);
	}

	public Node getNode(long id) {
		return nodes.get(id);
	}
	
	public Way getWay(long id) {
		return ways.get(id);
	}
	
	public Relation getRelation(long id) {
		return relations.get(id);
	}
	
	@Override
	public String toString() {
		return "O5MHandler { nodes=" + nodes.size() + ", ways=" + ways.size() + ", relations=" + relations.size() + " }";
	}
}
