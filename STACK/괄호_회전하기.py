def check_normal(bracket):
    stack = []
    check = ['[]', '{}', '()']
    for i in bracket:
        if len(stack) > 0:
            if stack[-1]+i in check:
                stack.pop()
            else:
                stack.append(i)
        else:
            stack.append(i)
    if stack:
        return False
    else:
        return True
            

def solution(s):
    answer = 0
    for i in range(len(s)):
        if check_normal(s[i:]+s[:i]):
            answer += 1
        
    return answer
    
'''
소요시간 10분

여기서 더 좋은 풀이는
여는 괄호와 닫는 괄호로 경우를 나누어서 처리하는 것

def check_normal(bracket):
    stack = []
    matching = {')': '(', '}': '{', ']': '['}
    
    for i in bracket:
        if i in matching.values():  # 여는 괄호일 경우 스택에 추가
            stack.append(i)
        elif i in matching:  # 닫는 괄호일 경우
            if not stack or stack[-1] != matching[i]:  # 스택이 비었거나, 맞는 짝이 아니면 False
                return False
            stack.pop()  # 맞는 짝이 있으면 스택에서 제거
            
    return not stack  # 스택이 비어 있으면 True (모든 괄호가 맞는 짝이 있는 경우)


def solution(s):
    answer = 0
    n = len(s)
    
    for i in range(n):
        rotated_s = s[i:] + s[:i]
        if check_normal(rotated_s):
            answer += 1
    
    return answer
'''