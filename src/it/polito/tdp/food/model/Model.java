package it.polito.tdp.food.model;

import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {
	
	private List<Condiment> ingredienti;
	
	private Graph<Condiment, Adiacenza> grafo;

	public void creaGrafo(Double calorie) {
		
		FoodDao dao = new FoodDao();
		
		ingredienti = dao.listAllCondimentByCal(calorie);
		
		grafo = new SimpleWeightedGraph<>(Adiacenza.class);
		
		// vertici
		
		Graphs.addAllVertices(grafo, ingredienti);
		
		// archi
		
		for(Condiment c1 : grafo.vertexSet()) {
			for(Condiment c2 : grafo.vertexSet()) {
				if(!c1.equals(c2)) {
//					if(dao.getFoodByCondiments(c1, c2).size > 0) {
//						Graphs.addEdge(grafo, c1, c2, dao.getFoodByCondiments(c1, c2).size());
//					}
				}
					
			}
		}
		
	}

}
