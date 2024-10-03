def solution(s):
    answer = -1
    stack = []
    
    for i in s:
        if not stack:
            stack.append(i)
        elif i == stack[-1]:
            stack.pop()
        else:
            stack.append(i)
    if stack:
        return 0
    else:
        return 1

'''
같으면 빼는데
baabaa -> bbaa
이러면 앞부터 다시 빼야 하는 것
이걸 처리할 수 있는 것이 stack
따라서 동일하게 하나씩 넣고 빼면 되는 것

소요 시간 10분.
뭐 할 것도 없었음

마지막에 return 부분만 손 봐주면 되는 것
'''