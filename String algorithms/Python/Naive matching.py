def naive(text, pattern, n, m):
    for idx in range(n - m):
        j = 0
        while j < m and pattern[j] == text[idx + j]:
            j += 1
        
        if j == m:
            return idx
    
    return -1
