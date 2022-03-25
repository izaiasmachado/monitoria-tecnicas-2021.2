def metersToMilimeters(meters):
    convertionRate = 1.e3
    milimeters = meters * convertionRate
    return milimeters

meters = float(input("Digite um valor em metros: "))
milimeters = metersToMilimeters(meters)
print('{} metros é {} milimetros'.format(meters, milimeters))