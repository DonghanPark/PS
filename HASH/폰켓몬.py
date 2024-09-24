def solution(nums):
    a = set()
    for i in nums:
        a.add(i)
    if len(a) > len(nums)/2:
        return len(nums)/2
    else:
        return len(a)
    
'''
회고

- 접근방식
일단 왜 해시인지 모르겠음
같은 번호면 같은 종류라는 것이 포인트
중복을 제거해주는 것은 set

set의 길이가 N/2보다 작으면
고르는 수에 비해 종류 수가 작다는 말
따라서 set의 길이로 return

그게 아닌 경우는 모두 다 다른 종류를 받은 경우
이 경우는 N/2가 최대
6 종류를 받아도 선택은 3종류 밖에 못하니까
'''

'''
- 타인의 풀이
def solution(ls):
    return min(len(ls)/2, len(set(ls)))

내 풀이 보다 좋은 점
1. 두 수를 비교하고 작은 것을 return 하는 것은 min으로 사용 가능
2. set(list) 이렇게 바로 list를 set으로 바꾸는 것 가능
'''