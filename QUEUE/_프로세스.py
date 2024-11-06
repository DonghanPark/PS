from collections import deque

def solution(priorites, location):
    count = 1
    deq = deque(priorites)
    while(True):
        if (max(deq) > deq[0]):
            deq.append(deq.popleft())
            if (location == 0):
                location = len(deq)
            location -= 1
        elif (location == 0):
            return count
        else:
            deq.popleft()
            count += 1
            location -= 1

# 완전히 다시 풀어야 함
# def solution(priorities, location):
#     answer = []
#     count = location
#     if location != 0:
#         priorities = priorities[location:] + priorities[:location]
#     print(priorities)
#     for i in range(len(priorities)):
#         if (priorities[i] > priorities[0]):
#             count = (len(priorities) - i)
#             for j in range(i, len(priorities)):
#                 print(priorities[j], priorities[0])
#                 if (priorities[j] < priorities[0]):
#                     count -= 1
#             break
#     return count+1

# chatGPT code
# def solution(priorites, location):
#     count = 0  # 첫 번째 인쇄는 1부터 시작하므로 count는 0부터 시작
#     deq = deque([(p, i) for i, p in enumerate(priorites)])  # (우선순위, 원래 인덱스)로 저장
#     print(deq)
#     while deq:
#         # 가장 높은 우선순위 찾기
#         if deq[0][0] == max(deq, key=lambda x: x[0])[0]:
#             # 가장 높은 우선순위가 첫 번째 요소라면
#             count += 1
#             _, idx = deq.popleft()  # 첫 번째 요소 제거
#             if idx == location:  # 우리가 원하는 문서라면
#                 return count
#         else:
#             # 첫 번째 요소가 가장 높은 우선순위가 아니면
#             deq.append(deq.popleft())  # 뒤로 보내기