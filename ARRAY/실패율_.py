# 무조건 다시 풀기

def solution(N, stages):
    count = [0] * (N+2)
    for i in stages:
        count[i] += 1
    
    fail = {}
    achived_player = len(stages)
    
    for n in range(1, N+1):
        if count[n] == 0:
            fail[n] = 0
        else:
            fail[n] = count[n] / achived_player
            achived_player -= count[n]
        
    answer = sorted(fail.keys(), key=lambda x : fail[x], reverse=True)
    
    return answer
    
    # for n in range(N):
    #     non_clear = 0
    #     achived_player = 0
    #     for stage in stages:
    #         if (stage >= n+1):
    #             achived_player += 1
    #         else:
    #             pass
    #         if (stage == n+1):
    #             non_clear += 1
    #     if (achived_player == 0):
    #         fail.append([0, n+1])
    #     else:
    #         fail.append([non_clear/achived_player, n+1])
    # # print(fail)
    # # fail.sort(key=lambda answer: answer[0], reverse=True)
    # # print(fail)
    # answer = sorted(fail, key=lambda answer: answer[0], reverse=True)
    # return list(zip(*answer))[1]


'''
시간초과 3개
def solution(N, stages):
    tables = {i:[0, 0] for i in range(N)}
    for n in range(N):
        for stage in stages:
            if (stage > n+1):
                tables[n][1] += 1
            elif (stage == n+1):
                tables[n][0] += 1
                tables[n][1] += 1
    answer = []
    for i in range(len(tables)):
        if (tables[i][1] == 0):
            answer.append((i+1, 0))
        else:
            answer.append((i+1, tables[i][0]/tables[i][1]))
    answer.sort(key=lambda answer: answer[1], reverse=True)
    return list(zip(*answer))[0]
'''

'''
시간초과 1개

def solution(N, stages):
    tables = {i:[0, 0] for i in range(N)}
    for stage in stages:
        for n in range(min(stage,N)):
            if (stage > n+1):
                tables[n][1] += 1
            elif (stage == n+1):
                tables[n][0] += 1
                tables[n][1] += 1
    answer = []
    for i in range(len(tables)):
        if (tables[i][1] == 0):
            answer.append((i+1, 0))
        else:
            answer.append((i+1, tables[i][0]/tables[i][1]))
    answer.sort(key=lambda answer: answer[1], reverse=True)
    return list(zip(*answer))[0]
'''

'''
2시간 넘게 걸렸고
무조건 종이에 써서 푸는 연습하기
그리고 결국 시간초과 1개 해결 못해서 답안 봤음

2중 for문을 줄이는 것이 핵심
람다식 표현도 어려웠음
'''