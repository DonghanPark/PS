import sys

def main():
    N = int(input())
    house = []
    hap = float("inf")
    aws = 0
    house = list(map(int, sys.stdin.readline().split()))
    sum_house = sum(house)
    house.sort
    house = set(house)
    print(sum_house)
    for i in house:
        temp = sum_house-i*N
        if temp < 0:
            if(abs(temp) < pre_hap):
                print(abs(temp), " ", pre_hap)
                break
        pre = i
        pre_hap = abs(sum_house-i*N)
    print(pre)
    return 0

if __name__ == "__main__":
    main()