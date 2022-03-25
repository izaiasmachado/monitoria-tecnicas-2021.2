# --------- EXEMPLO 1 --------- #
def soma(a, b):
    return a + b

a = input("Digite o primeiro numero: ")
b = input("Digite o segundo numero: ")
print("A soma de", a, "+", b, "eh igual a", soma(a, b))


# --------- EXEMPLO 2 --------- #
def receberElementosAteZero():
    el = ['']

    while el[-1] != 0:
        num = int(input("Digite um inteiro: "))
        el.append(num)

    del el[0]
    return el

def somarElementos(elementos):
    soma = 0
    for el in elementos:
        soma += el

    return soma

elementos = receberElementosAteZero()
soma = somarElementos(elementos)
print("A soma eh", soma)
