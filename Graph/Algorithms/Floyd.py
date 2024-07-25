def floyd(adjMatrix, inf):
    size = len(adjMatrix)
    
    for k in range(size):
        for i in range(size):
            for j in range(size):
                if adjMatrix[i][k] != inf and adjMatrix[k][j] != inf:
                    adjMatrix[i][j] = min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j])
    
    for row in adjMatrix:
        print(row)
