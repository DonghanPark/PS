def solution(participant, completion):
    a = dict()
    for i in participant:
        if i in a:
            a[i] += 1
        else:
            a[i] = 1
    for j in completion:
        if (a[j] > 1):
            a[j] -= 1
        else:
            del(a[j])
    return list(a.keys())[0]

'''
회고
소요시간 : 15분

- 접근 방식1
participant 안에 completion이 있는지 확인하고 없으면 return
=> 동명이인 처리 못함

- 접근 방식2
participant 안에 completion이 있으면 지우는 걸로
def solution(participant, completion):
    for i in completion:
        if (i in participant):
            participant.remove(i)
            
    return participant[0]
=> 효율성 떨어짐. remove 때문인 걸로 추측

- 접근 방식3
participant를 dict로 만들고
completion가 participant에 있으면 수를 빼거나 삭제함
문제에서 completion의 길이는 participant의 길이보다 1 작습니다.라고 했으므로
key의 첫번째를 반환하면 된다.

- 다른사람 풀이1
from collections import Counter
import collections

def solution(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion)
    return list(answer.keys())[0]
라이브러리에 관련 함수가 있었음. 그 외에는 나와 방식은 유사

- 다른 사람 풀이2
def solution(participant, completion):
    answer = ''
    temp = 0
    dic = {}
    for part in participant:
        dic[hash(part)] = part
        temp += int(hash(part))
    for com in completion:
        temp -= hash(com)
    answer = dic[temp]

    return answer
이게 진짜 해시를 사용한 것. hash는 값 변환이 일어나는데 그 특성을 이용하여
모두 더하고 빼면 딱 하나가 남는 것

최종 풀이에 대한 생각 : 지금의 코드가 깔끔하다고 느껴지지 않음
해시는 key를 변환하여 저장한다는 아이디어로 접근한 것이 주요한 방법이라고 생각
'''