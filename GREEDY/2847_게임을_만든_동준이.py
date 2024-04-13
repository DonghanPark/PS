# 24.04.13
# 끝에 한 틱 다르게 줄 수 있음

def main():
    N = int(input())
    num = []
    asw = 0
    for _ in range(N):
        num.append(int(input()))
    for j in range(N-2, -1, -1):
        if num[j] >= num[j+1]:
           asw += (num[j] - num[j+1] +1)
           num[j] -=  (num[j] - num[j+1] +1)
    print(asw)
    return 0

if __name__ == "__main__":
    main()