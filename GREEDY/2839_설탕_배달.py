# 24.04.14
# 좀 더 생각하기
# 접근은 발전했음

def main():
    N = int(input())
    asw = 0
    if N%5 == 0:
        print(N//5)
        return 0
    else:
        while N >= 3:
            N -= 3
            asw += 1
            if N%5 == 0:
                print(asw + N//5)
                return 0
    if N != 0:
        print(-1)
    return 0

if __name__ == '__main__':
    main()