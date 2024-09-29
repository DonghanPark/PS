def solution(clothes):
    cloth_num = dict()
    for _, cloth_type in clothes:
        if (cloth_type in cloth_num):
            cloth_num[cloth_type] += 1
        else:
            cloth_num[cloth_type] = 1
            
    answer = 1
    for i in cloth_num.values():
        answer *= i+1
        
    return answer-1
'''
import itertools

def solution(clothes):
    cloth_num = dict()
    for cloth_name, cloth_type in clothes:
        if (cloth_type in cloth_num):
            cloth_num[cloth_type] += 1
        else:
            cloth_num[cloth_type] = 1
    answer = len(clothes)
    print(cloth_num)
    for i in range(1, len(cloth_num)):
        mul = 1
        for j in itertools.combinations(cloth_num.values(), i+1):
            for k in j:
                mul *= k
            answer += mul
            mul = 1
    return answer
'''

'''
소요시간 30분
이건 수학적인 능력이 조금 포함된 문제
처음에는 +1해서 구할 생각을 하지 못했고
그래서 combination으로 접근함

문제를 보고 10분 정도 생각하는 시간을 꼭 가져야 겠다고 생각한 문제
'''