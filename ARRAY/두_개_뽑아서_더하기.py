def solution(numbers):
    answer = set()
    for i in range(len(numbers)):
        for j in range(i+1, len(numbers)):
            answer.add(numbers[i]+numbers[j])
    
    return sorted(list(answer))

'''
소요시간 : 5분

문제 조건을 잘 살피기
list sorting 안 해서 바로 통과 못했음
'''