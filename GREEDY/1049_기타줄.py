import sys

def main():
    m, n = map(int, sys.stdin.readline().split())
    price = 0
    six_price = 1000
    one_price = 1000
    for _ in range(n):
        six, one = map(int, sys.stdin.readline().split())
        six_price = min(six_price, six)
        one_price = min(one_price, one)
    if m >= 6:
        price += min(six_price, one_price*6)*(m//6)
        m %= 6
    if m > 0:
        price += min(six_price, one_price*m)
    print(price)
    return 0

if __name__ == "__main__":
    main()