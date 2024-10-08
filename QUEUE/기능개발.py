import math

def solution(progresses, speeds):
    answer = []
    day = math.ceil((100-progresses[0])/speeds[0])
    same_day = 0
    for progress, speed in zip(progresses, speeds):
        if progress + speed*day >= 100:
            same_day += 1
        else:
            answer.append(same_day)
            same_day = 1
            day = math.ceil((100-progress)/speed)
    answer.append(same_day)
    return answer
'''
첫 번째 기능이 100이 될 때까지 날짜가 지나간다
끝나면 그 다음 기능은 지금의 날짜로 끝났는지 확인하고 보낸다
현재 일자에 속도로 작업이 끝났는지 확인하면서 넘기는 것
같은 날짜에 다 끝나면 다 같은 날 끝난 것

1씩 올리고
더하면서 100 되면 탈출
그리고 현재 일수를 다시 그 다음 요소에 곱해서
100과 같거나 큰지 확인
탈출

소요시간 35분
큐를 사용하지 않고 풀었으며
큐 또는 스택을 사용하는 이유 또한 다른 사람의 코드를 보고 알 수 있었음
다시 풀어볼 문제
'''