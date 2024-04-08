# 24.03.24

def main():
    max_num = int(input())
    sum = 0
    count = 0
    
    for i in range(1, max_num+1):
        sum += i
        count += 1
        if sum > max_num:
            print(count-1)
            break
    if max_num == 1:
        print(1)
                
if __name__ == "__main__":
    main()