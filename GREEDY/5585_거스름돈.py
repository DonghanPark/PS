# 24.03.23

def main():
    change = 1000 - int(input())
    count = 0
    for i in [500, 100, 50, 10, 5, 1]:
        count += change//i
        change %= i
    print(count)

if __name__ == "__main__":
    main()