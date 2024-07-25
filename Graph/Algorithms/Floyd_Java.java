void floydAlgo(int[][] adjMatrix) {
        int len = adjMatrix.length;
        
        for(int k = 0; k < len; k++) {
            for(int i = 0; i < len; i++) {
                for(int j = 0; j < len; j++) {
                    if(adjMatrix[i][k] != Integer.MAX_VALUE && adjMatrix[k][j] != Integer.MAX_VALUE) {
                        adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                    }
                }
            }
        }
    }
