def solution(phone_book):
    length_list = {len(i) for i in phone_book}
    prefix_list = {i:1 for i in phone_book}
    for phone_num in phone_book:
        for length in length_list:
            if (len(phone_num) > length):
                if (phone_num[:length] in prefix_list):
                    return False
    return True
    
    '''
    시간 초과
    a = dict()
    phone_book.sort(key=len)
    for i in range(len(phone_book)):
        length = len(phone_book[i])
        for j in phone_book[i+1:]:
            if j[:length] == phone_book[i]:
                return False
    return True

    틀린 코드
    a = dict()
    length_list = {len(i) for i in phone_book}
    for i in phone_book:
        for j in length_list:
            if (len(i) >= j):
                if (i[:j] in a):
                    return False
                else:
                    a[i[:j]] = 1
    return True
    '''
'''
회고
소요시간 : 1시간 30분

접근 방식 1
직관적으로 2중 for문으로 prefix 가져오는 것. sort하고
시간 초과

접근 방식 2
처음에 prefix를 만들지 않고 진행하면서 만들려고 하니
추가하지 않아야 할 prefix를 추가하게 되었음
여기에서 테스트 케이스를 만들어 이를 검증하였음
["1", "23", "246", "7980"]

접근 방식 3
prefix 전용 dict를 만들어 처리
또한 phone_num 길이가 현재 lengh 보다 큰 걸로 하여
prefix는 검사하지 않음

다른 사람 풀이 1
def solution(phoneBook):
    phoneBook = sorted(phoneBook)

    for p1, p2 in zip(phoneBook, phoneBook[1:]):
        if p2.startswith(p1):
            return False
    return True
startswith 오늘 처음 앎

다른 사람 풀이 2
def solution(phone_book):
    answer = True
    hash_map = {}
    for phone_number in phone_book:
        hash_map[phone_number] = 1
    for phone_number in phone_book:
        temp = ""
        for number in phone_number:
            temp += number
            if temp in hash_map and temp != phone_number:
                answer = False
    return answer
    
현재 전화번호의 각 각자리를 가져와 더하면서 처리할 생각을 하지 못했음.
읽기에 좋으나 현재 나의 방식처럼 미리 lengh를 구해서 처리했다면 더 빨랐을 듯

총평
startswith 알게 됨

'''
