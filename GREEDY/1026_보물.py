# 24.04.04

def main():
    len = int(input())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    A.sort()
    B.sort(reverse=True)
    sum = 0
    for i in range(len):
        sum = sum + (A[i]*B[i])
    print(sum)
    return 0     

if __name__ == "__main__":
    main()
