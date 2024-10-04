def solution(prices):
    stack = []
    answer = [0] * len(prices)
    
    time = 0
    for price in prices:
        if not stack:
            stack.append((price, time))
        else:
            for i in range(len(stack)-1, -1, -1):
                if price < stack[i][0]:
                    answer[stack[i][1]] = time - stack[i][1]
                    stack.pop()
            stack.append((price, time))
        time += 1
        
    if stack:
        for element in stack:
            answer[element[1]] = time - 1 - element[1]
    
    return answer


'''
소요시간 20분

내가 작성한 for문에서 while을 사용하는 것이 더 깔끔한 코드
그리고 마지막에 stack에서 받을 수 있는 변수가 2개니까 그걸 모두 활용하는 것도 좋은 듯
튜플에 직접 접근하는 것이 아니라
또 마지막에 if와 for을 사용하지 않고 while로 한번에 처리 가능함
원리와 접근 방식은 매우 잘 선택함

for reverse 확실히 확인하기 (시작, 멈춤, interval)
테스트 케이스 추가가 정말 중요하다
'''