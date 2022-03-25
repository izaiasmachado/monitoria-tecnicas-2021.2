"""
   Disciplina  : ECO0015 - Técnicas de Programação
   Professor   : Wendley Souza da Silva
   Descrição   : Classes Exemplo 2 - Prática 02 - Python
   Autor(a)    : Izaias Machado Pessoa Neto
   Data atual  : 16/03/2021
"""

class Pessoa(object):
    FEMALE = 0
    MALE = 1
    
    def __init__(self, nome, sexo):
        super().__init__()
        self.nome = nome
        self.sexo = sexo
    
    def getNome(self):
        return self.nome

    def setNome(self, nome):
        self.nome = nome

    def getSexo(self):
        return self.sexo

    def setSexo(self, sexo):
        self.sexo = sexo

    def __str__(self):
        return str(self.nome)
    
class Pais(Pessoa):
    def __init__(self, nome, sexo, crianca):
        super().__init__(nome, sexo)
        self.crianca = crianca 

    def getCrianca(self):
        return self.crianca

    def setCrianca(self, crianca):
        self.crianca = crianca
    
    def __str__(self):
        pass