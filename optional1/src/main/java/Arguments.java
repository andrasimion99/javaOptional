import java.util.Arrays;

public class Arguments {
    public static void main(String args[]) {
        long startTime = System.nanoTime();
        validareNumarArg(args);
        int n, k;
        //parsam primele doua argumente in int
        try {
            n = Integer.parseInt(args[0]);
            k = Integer.parseInt(args[1]);
        }
        catch(NumberFormatException e){
            System.out.println("n si k trebuie sa fie intregi");
            return;
        }


        int m = args.length - 2;
        Graph graph = new Graph(n);

        char characters[] = new char[m];
        validateLetters(args, characters); //validare litere si adaugarea acestora in sirul de caractere

        String words[] = new String[n];
        creareArrayCuvinte(words, characters, n, k); //crearea array-ul de cuvinte random
        printArray(words);

        boolean neighborsWords[][] = new boolean[n][n];
        creareMatrice(words, neighborsWords); //crearea matricei booleana intre cuvinte vecine
        printMatrix(neighborsWords);

        verficariNrVecini(words, neighborsWords, n); //verficarile necesare din enunt, cuvintele cu numar maxim/minim de vecini si daca toate cuv au acelasi nr de vecini

        addMuchiigraph(graph, neighborsWords, n); //adaugam muchiile in liste de adiacenta din matricea de adiacenta
        //graph.printListeAdicenta();
        if (graph.CompConexe() == 1) {
            System.out.println("Graful este conex");
        } else {
            System.out.println("Graful nu este conex");
        }
        long endTime = System.nanoTime();
        System.out.println("Timpul de executie: " + (endTime - startTime) + " nanosecunde");
    }

    public static void validareNumarArg(String[] args) {
        if (args.length < 3) {
            System.out.println("Not enough arguments");
            System.exit(-1);
        }
    }

    public static void validateLetters(String args[], char[] characters) {
        for (int index = 2; index < args.length; index++) {
            //verificam daca lungimea stringului fiecarui argument este 1
            if (args[index].length() != 1) {
                System.out.println("Argument " + args[index] + " is too long");
                System.exit(-1);
            }
            //parsam urmatoarele argumente din string in char, fiind litere
            char letter = args[index].charAt(0);
            //verificam daca caracterul apartine alfabetului si o introducem in sirul de caractere in caz afirmativ
            if (isLetter(letter)) {
                characters[index - 2] = letter;
            } else {
                System.out.println("Argument " + args[index] + " is not a letter");
                System.exit(-1);
            }
        }
    }

    public static String randomWord(char characters[], int k) {
        StringBuilder word = new StringBuilder();
        for (int times = 0; times < k; times++) {
            word.append(characters[((int) (Math.random() * 100)) % (characters.length)]);
        }
        return word.toString();
    }

    public static void creareArrayCuvinte(String[] words, char[] characters, int n, int k) {
        for (int index = 0; index < n; index++) {
            words[index] = randomWord(characters, k); //adaugam cuvinte formate random in array
        }
    }

    public static void printArray(String[] words) {
        System.out.println("Array-ul de cuvinte: " + Arrays.toString(words));
    }

    public static boolean isLetter(char letter) {
        return (letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z');
    }

    public static void creareMatrice(String[] words, boolean[][] neighborsWords) {
        for (int index1 = 0; index1 < words.length; index1++) {
            String word1 = words[index1];
            char[] chars;
            chars = new char[word1.length()];
            word1.getChars(0, word1.length(), chars, 0);
            for (int index2 = index1; index2 < words.length; index2++) {
                String word2 = words[index2];
                for (int index3 = 0; index3 < chars.length; index3++) {
                    //verficiam daca cuvintele au cel putin un caracter asemanator
                    if (word2.indexOf(chars[index3]) != -1) {
                        neighborsWords[index1][index2] = true;
                        neighborsWords[index2][index1] = true;
                        break;
                    }
                }
            }
        }
    }

    public static void printMatrix(boolean[][] matrix) {
        for (boolean[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int countNeightbors(boolean[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                counter++;
            }
        }
        return counter;
    }

    public static int[] rowWordMaxNeighbors(boolean[][] neighborsWords) {
        int rowNo = 0, maxNeighbors = 0, pos = 0, count = 0;
        for (boolean[] row : neighborsWords) {
            if (countNeightbors(row) > maxNeighbors) {
                maxNeighbors = countNeightbors(row);
                count = 1;
            } else if (countNeightbors(row) == maxNeighbors) {
                count++;
            }
        }
        int rowArr[] = new int[count];
        for (boolean[] row : neighborsWords) {
            if (countNeightbors(row) == maxNeighbors) {
                rowArr[pos++] = rowNo;
            }
            rowNo++;
        }
        return rowArr;
    }

    public static int[] rowWordMinNeighbors(boolean[][] neighborsWords, int n) {
        int rowNo = 0, minNeighbors = n, pos = 0, count = 0;
        for (boolean[] row : neighborsWords) {
            if (countNeightbors(row) < minNeighbors) {
                minNeighbors = countNeightbors(row);
                count = 1;
            } else if (countNeightbors(row) == minNeighbors) {
                count++;
            }
        }
        int rowArr[] = new int[count];
        for (boolean[] row : neighborsWords) {
            if (countNeightbors(row) == minNeighbors) {
                rowArr[pos++] = rowNo;
            }
            rowNo++;
        }
        return rowArr;
    }

    public static void printWordsWithNeighbors(String[] words, int[] pos) {
        for (int i = 0; i < pos.length; i++) {
            System.out.print(words[pos[i]] + " ");
        }
    }

    public static void verficariNrVecini(String[] words, boolean[][] neighborsWords, int n) {
        if (rowWordMaxNeighbors(neighborsWords).length == n) {
            System.out.println("Toate cuvintele au acelasi numar de vecini");
        } else {
            System.out.println("Cuvintele nu au acelasi numar de vecini");
            //afisam cuvintele cu numar maxim de vecini si cu numar minim
            System.out.println("Cuvintele cu cei mai putini vecini: ");
            printWordsWithNeighbors(words, rowWordMinNeighbors(neighborsWords, n));
            System.out.println();
            System.out.println("Cuvintele cu cei mai multi vecini: ");
            printWordsWithNeighbors(words, rowWordMaxNeighbors(neighborsWords));
            System.out.println();
        }
    }

    public static void addMuchiigraph(Graph graph, boolean[][] neighborsWords, int n) {
        for (int nod1 = 0; nod1 < n; nod1++) {
            for (int nod2 = nod1 + 1; nod2 < n; nod2++) {
                if (neighborsWords[nod1][nod2]) {
                    graph.addMuchie(nod1, nod2);
                }
            }
        }
    }
}