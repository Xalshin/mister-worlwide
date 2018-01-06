import coding.challenge.graph.BiDirectionalGraph;
import coding.challenge.graph.Node;
import coding.challenge.graph.utils.GrapheUtils;

public class Main {

	public static void main(String[] args) {
		BiDirectionalGraph test = new BiDirectionalGraph("Santa");
		Node alphaCentauri = new Node("Alpha Centauri");
		Node arbre = new Node("Arbre");
		Node tambi = new Node("Tambi");
		Node snowdin = new Node("Snowdin");
		Node faerun = new Node("Faerun");
		Node norrath = new Node("Norrath");
		Node straylight = new Node("Straylight");
		Node tristram = new Node("Tristram");
		test.addRelationshipAtoB(alphaCentauri, snowdin, 66);
		test.addRelationshipAtoB(alphaCentauri, tambi, 28);
		test.addRelationshipAtoB(alphaCentauri, faerun, 60);
		test.addRelationshipAtoB(alphaCentauri, norrath, 34);
		test.addRelationshipAtoB(alphaCentauri, straylight, 34);
		test.addRelationshipAtoB(alphaCentauri, tristram, 3);
		test.addRelationshipAtoB(alphaCentauri, arbre, 108);
		
		test.addRelationshipAtoB(snowdin, tambi, 22);
		test.addRelationshipAtoB(snowdin, faerun, 12);
		test.addRelationshipAtoB(snowdin, norrath, 91);
		test.addRelationshipAtoB(snowdin, straylight, 121);
		test.addRelationshipAtoB(snowdin, tristram, 111);
		test.addRelationshipAtoB(snowdin, arbre, 71);
		
		test.addRelationshipAtoB(tambi, faerun, 39);
		test.addRelationshipAtoB(tambi, norrath, 113);
		test.addRelationshipAtoB(tambi, straylight, 130);
		test.addRelationshipAtoB(tambi, tristram, 35);
		test.addRelationshipAtoB(tambi, arbre, 40);
		
		test.addRelationshipAtoB(faerun, norrath, 63);
		test.addRelationshipAtoB(faerun, straylight, 21);
		test.addRelationshipAtoB(faerun, tristram, 57);
		test.addRelationshipAtoB(faerun, arbre, 83);
		
		test.addRelationshipAtoB(norrath, straylight, 9);
		test.addRelationshipAtoB(norrath, tristram, 50);
		test.addRelationshipAtoB(norrath, arbre, 60);
		
		test.addRelationshipAtoB(straylight, tristram, 27);
		test.addRelationshipAtoB(straylight, arbre, 81);
		
		test.addRelationshipAtoB(tristram, arbre, 90);
		
		System.out.println(GrapheUtils.getFastestRoute(test).isPresent() ? GrapheUtils.getFastestRoute(test).get() : "woops");
		
	}

}
