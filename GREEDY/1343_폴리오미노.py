def main():
    board = input()
    answer = ''
    array = []
    for i in board:
        if len(array) == 0:
            array.append(i)
        elif i == array[-1][0]:
            array[-1] += i
        else:
            array.append(i)
    for i in array:
        if '.' in i:
            answer += i
        elif len(i)%2 != 0:
            answer = '-1'
            break
        else:
            answer += (len(i)//4)*'AAAA' + ((len(i)%4)//2)*'BB'
    print(answer)        

if __name__ == "__main__":
    main()
