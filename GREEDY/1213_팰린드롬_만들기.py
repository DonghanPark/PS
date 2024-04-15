# 24.04.15
# 더 괜찮은 풀이 있음
# 근데 왜 그리디인지는 모르겠음

def main():
    alphapet = input()
    palin = dict()
    odd_count = 0
    odd = ''
    asw = ''
    for i in alphapet:
        if i not in palin.keys():
            palin[i] = 1
        else:
            palin[i] += 1
    palin = dict(sorted(palin.items()))
    
    for i in palin:
        if (palin[i]%2 != 0):
            odd_count += 1
            odd = i
        if odd_count > 1:
            print("I'm Sorry Hansoo")
            return 0

    for i in palin:
        asw += i*(palin[i]//2)
        palin[i] -= (palin[i]//2)
    print(asw+odd+asw[::-1])

    return 0

if __name__ == "__main__":
    main()