def solution(arr1, arr2):
    answer = []
    for i in range(len(arr1)):
        temp = []
        for j in range(len(arr2[0])):
            sum = 0
            for k in range(len(arr1[0])):
                sum += (arr1[i][k]*arr2[k][j])
            temp.append(sum)
        answer.append(temp)
    return answer

'''
소요시간 30분
확실히 미리 생각하고 시작하는 것이 왜 중요한지 알 수 있었던 문제.
분명 예전에 풀었던 건데 머리로만 하니까 계속 꼬였음

zip의 역할 알아보기
묶어주는 것

temp와 sum을 없애는 코드

'''