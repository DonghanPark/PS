def solution():
    N = 10
    answer = ""
    while (N):
        answer = str(N%2) + answer
        N = N//2
    print(answer)
    return 0

solution()