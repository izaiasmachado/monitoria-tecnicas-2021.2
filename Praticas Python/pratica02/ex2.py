"""
   Disciplina  : ECO0015 - Técnicas de Programação
   Professor   : Wendley Souza da Silva
   Descrição   : Exemplo 2 - Prática 02 - Python
   Autor(a)    : Izaias Machado Pessoa Neto
   Data atual  : 16/03/2021
"""

import classes 

def printObj(obj):
    ehMulher = (obj.getSexo() == 0)
    pronome = 'mãe' if ehMulher else 'pai'
    ehPaiOuMae = (type(obj) == classes.Pais)
    filho = obj.getCrianca() if ehPaiOuMae else False

    print("Seu nome é {}".format(obj.getNome()))

    if ehPaiOuMae:
        print('{} é {} de {}'.format(obj.getNome(), pronome, filho.getNome()))

print("-- Primeira pessoa: --")
obj1 = classes.Pessoa("Pedro", 1)
printObj(obj1)

print("-- Segunda pessoa: --")
obj2 = classes.Pessoa("Carla", 0)
printObj(obj2)

print("-- Terceira pessoa: --")
obj3 = classes.Pais("Júlia", 0, obj2)
printObj(obj3)

print("-- Quarta pessoa: --")
obj4 = classes.Pais("Carlos", 1, obj3)
printObj(obj4)