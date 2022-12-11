//time O(m*n)
//space O (m*n)
public class Main {
    public static void main(String[] args) {
        String[][] matrix = {
                {"1","1","0","0","0"},
                {"1","1","0","0","0"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}
        };

        System.out.println("Number of Islands = " + findNumIslands(matrix));
    }
    public static int findNumIslands(String[][] matrix){
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0 ; i < m; i ++){
            for(int j = 0 ; j < n; j ++){
                if( matrix[i][j].equals("1") && visited[i][j] == false ){
                    count++;
                    visitNeighbours(matrix, visited, i, j);
                }
            }
        }

        return count;
    }

    private static void visitNeighbours(String[][] matrix, boolean[][] visited, int m, int n){
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;

        if(m < 0 || n < 0 || m >= maxRow || n >= maxCol || matrix[m][n].equals("0") || visited[m][n] == true){
            return;
        }
        visited[m][n] = true;
        visitNeighbours(matrix, visited, m -1, n);
        visitNeighbours(matrix, visited, m, n -1);
        visitNeighbours(matrix, visited, m, n + 1);
        visitNeighbours(matrix, visited, m + 1, n );
    }
}