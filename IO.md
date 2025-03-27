# Problema de Programación Lineal 3x3 en Forma Matricial

## Problema Planteado

**Función objetivo:** Maximizar $Z = 10x_1 + 15x_2 + 20x_3$  
**Restricciones:**  
1. $2x_1 + x_2 + 2x_3 \leq 30$ (Madera)  
2. $x_1 + 2x_2 + x_3 = 20$ (Mano de obra)  
3. $x_1 + x_2 + 2x_3 \geq 15$ (Pintura)  
**No negatividad:** $x_1, x_2, x_3 \geq 0$

---

## Paso 1: Forma Estándar

Introducimos variables de holgura $s_1$, exceso $s_3$ y artificiales $a_1, a_2$:  

1. $2x_1 + x_2 + 2x_3 + s_1 = 30$  
2. $x_1 + 2x_2 + x_3 + a_1 = 20$  
3. $x_1 + x_2 + 2x_3 - s_3 + a_2 = 15$  

**Función objetivo:**  
$Z - 10x_1 - 15x_2 - 20x_3 + M a_1 + M a_2 = 0$

---

## Paso 2: Tabla Simplex Inicial No Básica Tradicional

Base inicial: $s_1, a_1, a_2$

| Base    | $x_1$ | $x_2$ | $x_3$ | $s_1$ | $s_3$ | $a_1$ | $a_2$ | RHS |
|----------|--------|--------|--------|--------|--------|--------|--------|-----|
| $s_1$   | 2      | 1      | 2      | 1      | 0      | 0      | 0      | 30  |
| $a_1$   | 1      | 2      | 1      | 0      | 0      | 1      | 0      | 20  |
| $a_2$   | 1      | 1      | 2      | 0      | -1     | 0      | 1      | 15  |
| $Z$     | -10    | -15    | -20    | 0      | 0      | M      | M      | 0   |

**Justificación:**  
- Variables básicas: $s_1 = 30, a_1 = 20, a_2 = 15$  
- Fila $Z$: Coeficientes de la función objetivo con penalización $M$ para artificiales.

---

## Paso 3: Tabla Simplex Inicial No Básica Matricial

**Matriz $A$:**  

$\begin{equation}
  \begin{bmatrix}
    1 & 2 \\
    3 & 4 
  \end{bmatrix}
  \label{eq:aeqn}
\end{equation}$
$A = 
\begin{equation}
\begin{pmatrix} 
2 & 1 & 2 & 1 & 0 & 0 & 0 \\ 
1 & 2 & 1 & 0 & 0 & 1 & 0 \\ 
1 & 1 & 2 & 0 & -1 & 0 & 1 
\end{pmatrix}
\end{equation}
$

**Vector $b$:**  
$$
b = \begin{bmatrix} 30 \\ 20 \\ 15 \end{bmatrix}
$$

**Vector $c$:**  
$$
c = \begin{bmatrix} 10 & 15 & 20 & 0 & 0 & -M & -M \end{bmatrix}^T
$$

**Base $B$:** Columnas de $s_1, a_1, a_2$:  
$$
B = \begin{bmatrix} 
1 & 0 & 0 \\ 
0 & 1 & 0 \\ 
0 & 0 & 1 
\end{bmatrix}
$$

**No básicas $N$:** Columnas de $x_1, x_2, x_3, s_3$:  
$$
N = \begin{bmatrix} 
2 & 1 & 2 & 0 \\ 
1 & 2 & 1 & 0 \\ 
1 & 1 & 2 & -1 
\end{bmatrix}
$$

**Vector básico $x_B$:**  
$$
x_B = B^{-1} b = \begin{bmatrix} 30 \\ 20 \\ 15 \end{bmatrix}
$$

**Costo básico $c_B$:**  
$$
c_B = \begin{bmatrix} 0 & -M & -M \end{bmatrix}
$$

**Fila $Z$:**  
$$
z_j - c_j = c_B B^{-1} A_j - c_j
$$
- $x_1$: $ 0 \cdot 2 + (-M) \cdot 1 + (-M) \cdot 1 - 10 = -2M - 10$  
- $x_2$: $ 0 \cdot 1 + (-M) \cdot 2 + (-M) \cdot 1 - 15 = -3M - 15$  
- $x_3$: $ 0 \cdot 2 + (-M) \cdot 1 + (-M) \cdot 2 - 20 = -3M - 20$  
- $s_3$: $ 0 \cdot 0 + (-M) \cdot 0 + (-M) \cdot (-1) - 0 = M$  

---

## Paso 4: Tabla Simplex Inicial Básica Tradicional con Identificación Matricial

| Base    | $x_1$ | $x_2$ | $x_3$ | $s_1$ | $s_3$ | $a_1$ | $a_2$ | RHS |
|----------|--------|--------|--------|--------|--------|--------|--------|-----|
| $s_1$   | 2      | 1      | 2      | 1      | 0      | 0      | 0      | 30  |
| $a_1$   | 1      | 2      | 1      | 0      | 0      | 1      | 0      | 20  |
| $a_2$   | 1      | 1      | 2      | 0      | -1     | 0      | 1      | 15  |
| $Z$     | -10    | -15    | -20    | 0      | 0      | M      | M      | 0   |

**Identificación Matricial:**  
- **$B$:** Columnas $s_1, a_1, a_2$:  
$$
B = \begin{bmatrix} 1 & 0 & 0 \\ 0 & 1 & 0 \\ 0 & 0 & 1 \end{bmatrix}
$$
- **$N$:** Columnas $x_1, x_2, x_3, s_3$:  
$$
N = \begin{bmatrix} 2 & 1 & 2 & 0 \\ 1 & 2 & 1 & 0 \\ 1 & 1 & 2 & -1 \end{bmatrix}
$$
- **$x_B$:** Columna RHS:  
$$
x_B = \begin{bmatrix} 30 \\ 20 \\ 15 \end{bmatrix}
$$
- **$b$:** Columna RHS:  
$$
b = \begin{bmatrix} 30 \\ 20 \\ 15 \end{bmatrix}
$$
- **$A$:** Todas las columnas menos RHS:  
$$
A = \begin{bmatrix} 2 & 1 & 2 & 1 & 0 & 0 & 0 \\ 1 & 2 & 1 & 0 & 0 & 1 & 0 \\ 1 & 1 & 2 & 0 & -1 & 0 & 1 \end{bmatrix}
$$
- **Fila $Z$:** $c_B B^{-1} N - c_N$, calculada arriba.

---

## Justificación Matemática

- **Factibilidad:** $s_1 = 30, a_1 = 20, a_2 = 15$ cumplen $Ax = b$ y son $\geq 0$.  
- **Base válida:** $B$ es invertible (identidad).  
- **Optimización:** Valores negativos en $Z$ ($-10, -15, -20$) indican mejora posible al meter $x_1, x_2, x_3$.
