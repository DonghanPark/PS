# 24.03.23

def main():
    t = int(input())
    time = [300, 60, 10]
    answer = []
    for i in time:
        answer.append(t//i)
        t = t%i
    if t:
        print(-1)
    else:
        print(*answer)

if __name__ == '__main__':
    main()