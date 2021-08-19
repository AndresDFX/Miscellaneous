Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] is a palindrome.
Input: words = ["abcd","dcba","lls","s","sssll"]Output: [[0,1],[1,0],[3,2],[2,4]]Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Input: words = ["bat","tab","cat"]Output: [[0,1],[1,0]]Explanation: The palindromes are ["battab","tabbat"]
Input: words = ["a",""]Output: [[0,1],[1,0]]
Constraints:
1 <= words.length <= 50000 <= words[i].length <= 300words[i] consists of lower-case English letters.

Dada una lista de palabras únicas, devuelva todos los pares de índices distintos (i, j) en la lista dada, de modo que la concatenación de las dos palabras palabras [i] + palabras [j] sea un palíndromo.
Entrada: palabras = ["abcd", "dcba", "lls", "s", "sssll"] Salida: [[0,1], [1,0], [3,2], [2,4 ]] Explicación: Los palíndromos son ["dcbaabcd", "abcddcba", "slls", "llssssll"]
Entrada: palabras = ["murciélago", "tab", "gato"] Salida: [[0,1], [1,0]] Explicación: Los palíndromos son ["battab", "tabbat"]
Entrada: palabras = ["a", ""] Salida: [[0,1], [1,0]]
Restricciones:
1 <= palabras. Longitud <= 50000 <= palabras [i]. Longitud <= 300 palabras [i] consta de letras minúsculas en inglés.

daniel.cubides@wearemo.com


def validarPalindromo(cadena):
    i = 0
    j = len(cadena)-1
    
    while i<=j:
        if word[i]==cadena[j]:
            i += 1
            j -= 1
        else:
            return False
    return True

def listaPalindromos(palabras):
        n = len(palabras)
        indices = []
        
        for i in range(n):
            for j in range(n):
                if i==j: 
                    continue
                if validarPalindromo(palabras[i]+palabras[j]):
                    indices.append([i, j])
        return indices
    

    
print(listaPalindromos(["a",""]))

