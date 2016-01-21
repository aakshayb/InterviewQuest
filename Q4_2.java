import java.util.*;

class Q4_2{
	public static boolean isConnected(int v1,int v2,boolean[][] edges,boolean[] visited){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v1);
		visited[v1]=true;
		while(!queue.isEmpty()){
			int t = queue.poll();
			if(t==v2) return true;
			for(int i=0;i<edges.length;i++){
				if(edges[v1][i]&&!visited[i]){
					queue.add(i);
					visited[i]=true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		boolean[][] edges = {{false,false,true,false,false},
							 {true,false,false,false,false},
							 {false,false,false,false,true},
							 {false,true,false,false,false},
							 {false,false,false,true,false}};
		boolean[] visited = {false,false,false,false,false,false};
		
		System.out.println(isConnected(0,3,edges,visited));
		
	}
}
