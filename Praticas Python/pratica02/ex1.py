"""
   Disciplina  : ECO0015 - Técnicas de Programação
   Professor   : Wendley Souza da Silva
   Descrição   : Exemplo 1 - Prática 02 - Python
   Autor(a)    : Izaias Machado Pessoa Neto
   Data atual  : 16/03/2021
"""

import math

num_fact = int(input("Digite o número que deseja calcular o fatorial: "))
print("O fatorial de {} eh {}".format(num_fact, math.factorial(num_fact)))

num_log = float(input("Digite um número para calcular seu logarítmo na base 10: "))
print("O log de {} na base 10 eh {}".format(num_log, math.log10(num_log)))

num_root = float(input("Digite um número para calcular uma raíz: "))
num_exp = int(input("Agora, digite o expoente da raíz: "))
print("A raíz de {} na base {} eh {}".format(num_root, num_exp, math.pow(num_root, 1 / num_exp)))