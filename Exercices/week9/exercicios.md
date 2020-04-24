## Exercicio 1 - Notação assintótica
 
1. f(n) = O(g(n))
2. f(n) = BigOMEGA (g(n))
3. f(n) = Theta(g(n))

a) f(n) = 5n^2 - 100n + 34; g(n) = 2n^3 - 97

- Alinea a) 1 verdadeiro. Existem constantes positivas "x" e "c", (n >= x) tal que f(n) <= c * g(n). Ou seja independentemente das constantes que escolhermos, g(n) no limite para o infinito (para n's muito grandes) vai crescer sempre mais rápido que f(n)

- Alinea a) 2 falso. Não existem constantes positivas "x" e "c", (n >= x)  tal que f(n) >= a c * g(n). Isto é, independentemente das constantes que fossem escolhidas, f(n) nunca seria maior que g(n) no limite para infinito.

- Alinea a) 3 falso. Para f(n) ser Theta(g(n)), então tinha acontecer simultaneamente: f(n) = O(g(n)) e f(n) = BigOMEGA (g(n)). Isto é função "f" tinha de ter um crescimento assintotico "igual" a "g". Para f(n) = Theta(g(n)), então têm de existir constantes "x", "c1", "c2", (n >= x) tal que c1 * g(n) <= f(n) <= c2 * g(n).


b) f(n) = 54n + 100; g(n) = 6n - 24

- Alinea b) 1 verdadeiro. Podemos encontrar constantes positivas "x" e "c", (n >= x) tal que f(n) <= c * g(n). Por exemplo se c = 2000, x = 1, g(n) será sempre maior que f(n).

- Alinea b) 2 verdadeiro. Podemos encontrar constantes positivas "x" e "c", (n >= x) tal que f(n) >= c * g(n). Por exemplo c=1, x = 1, a função "f" vai "dominar" em crescimento assintotico a função "g".

- Alinea b) 3 verdadeiro. Uma vez que 1 e 2 são verdadeiros, então 3 é obrigatoriamente verdadeiro. De facto existem constantes "x", "c1" e "c2", (n >= x) tal que c1 * g(n) <= f(n) <= c2 * g(n), por exemplos c1 = 1, c2 = 2000, x = 1; Isto significa que à parte de constantes a função "g" e "f" crescem assintoticamente à mesma velocidade.


c) f(n) = 2^n; g(n) = 6n^2

- Alinea c) 1 falso. Apesar "f" começar por ser mais pequena que "g", (podendo até ser usada em casos em que sabes que o input é suficientemente pequeno), esta para os casos de análise à medida que n tende para infinito, "f" cresce assintoticamente muito mais rápido que 6n^2, não existe tas constantes que "digam" o contrario. Uma vez que f(n) "domina" g(n) o que acontece é até que g(n) = O(f(n)) e não f(n) = O(g(n)).

- Alinea c) 2 verdadeiro. Se g(n) = O(f(n)), então acontece que f(n) = BigOMEGA (g(n)). Podemos ver que a "jogando" com algumas constantes, conseguimos que f(n) >= c * g(n).

- Alinea c) 3 falso. Uma vez que f(n) = BigOMEGA (g(n)) e f(n) = O(g(n)) não se verificam ao mesmo tempo, 3 não se verifica.


d) f(n) = 30; g(n) = log 30

- Alinea d) 1 verdadeiro. Conseguimos encontrar constantes "x", "c" (n >= x), tal que f(n) <= c * g(n). Tomemos por exemplo, x = 1, c = 30, 30 <= 30 * log 30.

- Alinea d) 2 verdadeiro. A função "g", "jogando com constantes" pode ser "dominada" pela função "f".

- Alinea d) 3 verdadeiro. Visto que 1 e 2 verificam-se, 3 irá verificar-se obrigatoriamente. Ambas tem crescimento assintotico igual.


e) f(n) = n * log n; g(n) = n^2

- Alinea e) 1 verdadeiro. A função "g" cresce assintoticamente mais rapido que a funçao "f". Podemos encontrar constantes "x", "c", (x >= n) tal que
f(n) <= c * g(n).

- Alinea e) 2 falso. Pelo contrário, g(n) = BigOMEGA (f(n)). Pois a função "f" cresce assintoticamente mais devagar que a função "g". Por exemplo, podemos encontrar constantes "x" e "c", (n >= x) em que g(n) >= c * f(n), mas não o contrario, isto é f(n) >= c * g(n).

- Alinea e) 3 falso. A função "f" e "g" não crescem de forma assintoticamente "igual", elas não são, f(n) = BigOMEGA (g(n)) e  f(n) = O (g(n)) simultaneamente.


f) f(n) = sqrt(n); g(n) = log n

- Alinea f) 1 falso. Há medida que o input, "n", fica maior, à medida que o input cresce para infinito, a função "f" fica infinitamete maior, "domina" a função "g". Não podemos encontrar constantes "x" , "c", (n >= x), f(x) >= c * g(x).

- Alinea f) 2 verdadeiro. Podemos encontrar constantes "x", "c" (n >= x) tal que f(x) >= c * g(x). Isto é a função g(x) cresce assintoticamente muito mais devagar que a funcao f.

- Alinea f) 3 falso. Não conseguimos encontrar constantes "c1", "c2" e "x", tal que c1 * g(n) <= f(n) <= c2 * g(n). O crescimento da função "f" não pode ser "controlado" pelo crescimento assintotico da função "g". 


## Exercicio 2 - Complexidade de TAD Conjunto

1. a) Theta(n); b) Theta(n); c) Theta(n); d) Theta(1); e) Theta(1)
2. a) Theta(1); b) Theta(1); c) Theta(1); d) Theta(1); e) Theta(n) - n tamanho do array

2. O tradeoff que nos sujeitamos é o de melhor tempo de execução por bastante mais memoria usada. Agora temos um array tão grande quanto o maior numero que temos guardado.



## Exercicio 3 - Previsão do tempo de execuçao

1. Programa P:
- n = 300; 1.5s
- n = 600; 12.0s
- n = 1200; 1m36s (96s)

a) Complexidade temporal mais provavel de P? Justifique
b) Estimativa temporal para n = 5000. Justifique

a) Visto que quando o input duplicou o tempo ficou 8x maior. 12/1.5 = 8, isto indicia a forte possibilidade de uma complexidade polinomial. Olhando para exemplos como n^2, a taxa de crescimento quando o input duplica seria (2n^2)/n^2 = 4, ou seja dado um input "n", em que o tempo de execução é "x", se duplicarmos o input "2n", entao irá demorar "4x". 
Quase mais tem de ser uma potencia maior, n^3, dado um input arbitrario "n" e depois duplicando-o, (2n^3)/n^3 = 8, o tempo fica 8x maior quando o input é duplicado em complexidade cubica. Para verificar, tomando n1 = 600, n2 = 1200, t1 = 12.0, t2 = 96.0. Fazendo t2 = f(n2)/f(n1) * t1, isto tem de dar 96, pois estamos a estimar o tempo de excuçao de um input n2 = 1200. De facto, fazendo aritmetica: t2 = (1200)^3/(300)^3 * 12 <=> t2 = 96.
Complexidade Cubica n^3.

b) t3 = f(n3) / f(n2) * t2 <=> t3 = (5000)^3 / (1200)^3 * 96 <=> t3 = 6944s ou 1h55m12s





#### Notas pessoais
- Analise de algoritmo, considerar ou pior caso ou caso medio (normalmente pior caso), e ver o crescimento da função.
- O(f(n)) apenas garante que nuca será maior que f(n) o crescimento.
- Theta(f(n)) garante que nunca será nem mais nem menos que f(n).
- Muitas vezes o O(f(n)) e Theta(f(n)) são usados um em vez do outro, o que não está errado, dizer que função que é Theta(n) é O(n) não é errado, Theta(n) apenas é mais correto, dá mais informação.