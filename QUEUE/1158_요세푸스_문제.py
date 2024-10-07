import sys
def solution():
    N, K = map(int, sys.stdin.readline().split())
    seq = [i for i in range(1, N+1)]
    answer = []
    iter = 0
    while True:
        iter += K-1
        if len(seq) == 0:
            break
        if iter >= len(seq):
            iter %= len(seq)
        answer.append(str(seq[iter]))
        del seq[iter]
    print("<"+', '.join(answer)+">")
solution()