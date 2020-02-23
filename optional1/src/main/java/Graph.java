import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    int nrNoduri;
    LinkedList<Integer>[] listeAdiacentaArr;

    public Graph(int nrNoduri) {
        this.nrNoduri = nrNoduri;
        listeAdiacentaArr = new LinkedList[nrNoduri];
        for (int nod = 0; nod < nrNoduri; nod++) {
            listeAdiacentaArr[nod] = new LinkedList<Integer>();
        }
    }

    public int getNrNoduri() {
        return nrNoduri;
    }

    public LinkedList<Integer>[] getListeAdiacentaArr() {
        return listeAdiacentaArr;
    }

    public void printListeAdicenta() {
        for (int nod = 0; nod < nrNoduri; nod++) {
            System.out.println(listeAdiacentaArr[nod]);
        }
    }

    public void addMuchie(int nod1, int nod2) {
        listeAdiacentaArr[nod1].add(nod2);
        listeAdiacentaArr[nod2].add(nod1);
    }

    public int CompConexe() {
        boolean[] visited = new boolean[nrNoduri];
        int nrCompConexe = 0;
        for (int nod = 0; nod < nrNoduri; nod++) {
            if (!visited[nod]) {
                System.out.print("Componenta conexa " + (nrCompConexe + 1) + ": ");
                DFS(nod, visited);
                System.out.println();
                nrCompConexe++;
            }
        }
        return nrCompConexe;
    }

    public void DFS(int nod, boolean[] visited) {
        visited[nod] = true;
        System.out.print(nod + " ");
        for (int nodAdiacent : listeAdiacentaArr[nod]) {
            if (!visited[nodAdiacent]) {
                DFS(nodAdiacent, visited);
            }
        }
    }
}
