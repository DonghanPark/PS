def check_normal(x, y):
    if (x > 5 or x < -5 or y > 5 or y < -5):
        return False
    else:
        return True

def solution(dirs):
    answer = set()
    x, y = 0, 0 
    for i in dirs:
        # print(i)
        if i == 'U':
            if check_normal(x, y+1):
                answer.add((x, y, x, y+1))
                answer.add((x, y+1, x, y))
                y += 1
        elif i == 'D':
            if check_normal(x, y-1):
                answer.add((x, y, x, y-1))
                answer.add((x, y-1, x, y))
                y -= 1
        elif i == 'R':
            if check_normal(x+1, y):
                answer.add((x, y, x+1, y))
                answer.add((x+1, y, x, y))
                x += 1
        else:
            if check_normal(x-1, y):
                answer.add((x, y, x-1, y))
                answer.add((x-1, y, x, y))
                x -= 1
        # print(answer)
    return len(answer)//2

'''
소요시간 70분

같은 길이라는 것이 포인트
그리고 이것 때문에 처음에 테스트 케이스를 잘못 만들었음

리스트는 요소가 많을 때. 좌표의 경우 x, y로 두는 것이 가독성에 더 좋음
명령어를 딕셔너리로 해서 해당 좌표 +, -를 표현하는 것이 더 좋았을 것

어떻게 하면 반복을 줄일지. 그리고 그것을 어떻게 한번에 코드로 표현할지 고민할 것

아무튼 정말 나 스스로에게 화가 많이 난 문제
'''