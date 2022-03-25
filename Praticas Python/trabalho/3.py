"""
   Disciplina  : ECO0015 - Técnicas de Programação
   Professor   : Wendley Souza da Silva
   Descrição   : Questão 03 - Trabalho - Python
   Autor(a)    : Izaias Machado Pessoa Neto
   Data atual  : 31/03/2021
"""

from datetime import datetime

"""
    Classe para formatar uma nota.
"""
class Notas:
    texto = ''
    data_criacao = ''
    tags = ''

    def verifica (self, busca_filtro:str):
        for tag in self.tags.split(','):
            if tag == busca_filtro:
                return True

        return False

"""
    Classe que guardar as notas e seus métodos.
"""
class BlocoDeNotas:
    def __init__  (self):
        self.notas = []

    def __buscar_nota(self, _id):
        return self.notas[_id]

    def nova_nota (self, texto:str, tags:str):
        nota = Notas()
        nota._id = len(self.notas)
        nota.texto = texto
        nota.tags = tags
        nota.data_criacao = datetime.now()
        self.notas.append(nota)

    def modificar_nota (self, nota_id:int, texto:str):
        self.__buscar_nota(nota_id).texto = texto

    def modificar_tags (self, nota_id:int, tags:str):
        self.__buscar_nota(nota_id).tags = tags
    
    def buscar (self, filtro:str):
        results = []
        for nota in self.notas:
            if nota.verifica(filtro):
                results.append(nota)
        
        return results

    def deletar (self, _id):
        del self.notas[_id]

"""
    Aqui, temos uma classe para a interface gráfica
"""
class Telas:
    """
        Construtor da classe, inicia as opções, o bloco de notas e o modificador de saida.
    """
    def __init__ (self):
        self.blocoDeNotas = BlocoDeNotas()
        self.exit = False
        self.options = [
            { 'number': 1, 'display': 'Criar nova nota', 'action': self.criarNota },
            { 'number': 2, 'display': 'Listar notas', 'action': self.listarNotas},
            { 'number': 3, 'display': 'Buscar notas', 'action': self.buscarNotas},
            { 'number': 4, 'display': 'Modificar texto de uma nota', 'action': self.modificarTexto},
            { 'number': 5, 'display': 'Modificar tags de uma nota', 'action': self.modificarTags},
            { 'number': 6, 'display': 'Deletar nota', 'action': self.deletarNotas},
            { 'number': 0, 'display': 'Sair', 'action': self.__setupExit }
        ]

        self.__displayOptions()

    """
        Essa função mostra o menu principal junto com as opções. O input do usuário é validado para
        saber se está dentro do intervalo. Por fim, se o modificador de saida for falso,
        a tela de opções é mostrada novamente. Caso contrário, o programa é finalizado.
    """
    def __displayOptions(self):
        print('========== Opções ==========')
        for i in range(len(self.options)):
            option = self.options[i]
            number = option['number']
            display = option['display']
            print(' {} - {}'.format(number, display))
        print('============================')
        
        choosen_option = -1
        valid = True

        try:
            choosen_option = int(input('Digite a opção desejada: '))
            valid = (choosen_option >= 0 and choosen_option <= 6) 
        except:
            valid = False

        if not(valid):
            print('Opção inválida, tente novamente.')

        for i in range(len(self.options)):
            option = self.options[i]
            number = option['number']
            action = option['action']

            if number == choosen_option:
                action()

        if not(self.exit): 
            return self.__displayOptions() 

    """
        Imprime uma única nota.
    """
    def imprimirNota (self, nota):
        print('============================')
        print('ID: {}'.format(nota._id))
        print('Texto: {}'.format(nota.texto))
        print('Tags: {}'.format(nota.tags))
        print('Data de Criação: {}'.format(nota.data_criacao))

    """
        Recebe uma lista e imprime cada nota. Se não houver nenhuma, é informado com uma mensagem de não encontrado.
    """
    def imprimirNotas (self, notas):
        if len(notas) < 1:
            print('Nenhuma nota encontrada :/')
        else:
            for nota in notas:
                self.imprimirNota(nota)

    def criarNota (self):
        print('============================')
        texto = str(input('Digite o texto da nota: '))
        tags = str(input('Digite as tags da nota (seguido de vírgula e sem espaço): '))
        self.blocoDeNotas.nova_nota(texto, tags) 
        return self.__displayOptions() 

    def listarNotas (self):
        self.imprimirNotas(self.blocoDeNotas.notas)

    def buscarNotas (self):
        busca = str(input('Digite uma tag para busca: '))
        notas = self.blocoDeNotas.buscar(busca)
        self.imprimirNotas(notas)

    def modificarTexto (self):
        try:
            _id = int(input('Digite o id da nota que deseja modificar o texto: '))
            novo_texto = str(input('Digite o novo texto: '))
            self.blocoDeNotas.modificar_nota(_id, novo_texto)
            print('Nota modificada com sucesso!')
        except:
            print('Nota não encontrada ou texto inválido, tente novamente.')

    def modificarTags (self):
        try:
            _id = int(input('Digite o id da nota que deseja modificar as tags: '))
            novas_tags = str(input('Digite as novas tags (seguido de vírgula e sem espaço): '))
            self.blocoDeNotas.modificar_tags(_id, novas_tags)
            print('Tags modificadas com sucesso!')
        except:
            print('Nota não encontrada ou texto inválido, tente novamente.')

    def deletarNotas(self):
        try:
            _id = int(input('Digite o id da nota que deseja deletar: '))
            self.blocoDeNotas.deletar(_id)
            print('Nota deletada com sucesso!')
        except:
            print('Nota não encontrada ou texto inválido, tente novamente.')

    """
        Muda o estado do modificador de saida para verdadeiro. Depois, uma mensagem é impressa.
    """
    def __setupExit(self):
        self.exit = True
        print('Obrigado por usar o programa, até a próxima ;)')

Telas()
