import itertools

def solution(number):
    answer = 0
    three_student = list(itertools.combinations(number, 3))
    for one, two, three in three_student:
        if one+two+three == 0:
            answer += 1
    return answer

'''
소요시간 6분
탐색 문제 : 왜인지는 모름

튜플은 sum이 있다. 기억하자
'''