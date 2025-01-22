class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;

        // Initialize result matrix with same dimensions as input
        int[][] matrix=new int[m][n];

        // Initialize the matrix 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(isWater[i][j]!=1){                                
                    // Mark land cells as MAX_VALUE
                    matrix[i][j]=10000000;
                }
            }
        }


        int neighborValue=10000000; 

        // Forward Pass from (0,0) based on previous UPPER & LEFT cell
        int[][] directions={ {-1,0}, {0,-1} };

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                neighborValue=10000000;

                // Check only previous LEFT & UPPER adjacent cells
                for(int[] dir:directions){
                    int nr=i+dir[0];
                    int nc=j+dir[1];

                    // If adjacent cell is within boundary
                    if(nr>=0 && nr<m && nc>=0 && nc<n){                        
                        neighborValue=Math.min(neighborValue, matrix[nr][nc]);
                    } 
                }

                matrix[i][j]=Math.min(matrix[i][j], neighborValue+1);
            }
        }


        // Backward Pass from (m-1,n-1) based on previous DOWN & RIGHT cell
        directions=new int[][]{ {1,0}, {0,1} };
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                neighborValue=10000000;

                // Check only previous RIGTH & DOWN adjacent cells
                for(int[] dir:directions){
                    int nr=i+dir[0];
                    int nc=j+dir[1];

                    // If adjacent cell is within boundary
                    if(nr>=0 && nr<m && nc>=0 && nc<n){                        
                        neighborValue=Math.min(neighborValue, matrix[nr][nc]);
                    } 
                }

                matrix[i][j]=Math.min(matrix[i][j], neighborValue+1);
            }
        }


        return matrix;
    }

}
