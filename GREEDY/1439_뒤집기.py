def main():
    pre = -1
    zero_count = 0
    one_count = 0
    num_string = input()
    for i in num_string:
        if i != pre and i == '0':
            zero_count += 1
            pre = i
        elif i != pre and i == '1':
            one_count += 1
            pre = i
    print(min(zero_count, one_count))

if __name__ == "__main__":
    main()