from sys import stdin

#this function should return the minimal list of coins that equals $b in descending order.
def func(value):
    # codes go here
    coin = []
    while value > 0:
        if value >= 10:
            value = value - 10
            coin.append(10)
        elif value >=5:
            value = value - 5
            coin.append(5)
        elif value >=2:
            value = value - 2
            coin.append(2)
        else:
            value = value - 1
            coin.append(1)
    return coin

if __name__ == '__main__':
    value = int(stdin.readline())
    print(func(value))
