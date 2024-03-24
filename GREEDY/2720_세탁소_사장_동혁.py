# 24.03.23

def main():
    tc = int(input())
    for _ in range(tc):
        change = int(input())
        answer = []
        
        for j in [25, 10, 5, 1]:
            answer.append(change//j)
            change = change%j
            
        print(*answer)

if __name__ == '__main__':
    main()