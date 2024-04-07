# 24.04.07
# A better solution exists

def main():
    n = input()
    max_num = int(''.join(sorted(n, reverse=True)))
    if (max_num%30 == 0):
        print(max_num)
    else:
        print(-1)
    return 0     

if __name__ == "__main__":
    main()
