# 24.03.24

def main():
    tc = 0
    while True:
        L, P, V = map(int, input().split())
        if L == 0 and P == 0 and V == 0:
            break
        
        tc += 1
        answer = 0
        
        if (V%P < L):
            answer = L*(V//P) + V%P
        else:
            answer = L*(V//P) + L
        print("Case {}:".format(tc), answer)


if __name__ == "__main__":
    main()