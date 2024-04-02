def main():
    change = int(input())
    count_five = 100000
    count_two = 100000
    count_mix = 100000
    if change%5 == 0:
        count_five = change//5
    if change%2 == 0:
        count_two = change//2

    time = change//5
    for i in range(time, 0, -1):
        if (change-(5*i))%2 == 0:
            count_mix = min(i+(change-(5*i))//2, count_mix)

    if count_five == count_two == count_mix == 100000:
        print(-1)
    else:
        print(min(count_five, count_two, count_mix))
    

if __name__ == "__main__":
    main()