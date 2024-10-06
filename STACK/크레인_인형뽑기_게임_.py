def solution(board, moves):
    new_board = [[] for _ in range(len(board))]
    for i in range(len(board)-1, -1, -1):
        for j in range(len(board)):
            if board[i][j] != 0:
                new_board[j].append(board[i][j])
    answer = 0
    stack = []
    for i in moves:
        if not new_board[i-1]:
            pass
        else:
            if not stack:
                stack.append(new_board[i-1].pop())
            else:
                if new_board[i-1][-1] == stack[-1]:
                    new_board[i-1].pop()
                    stack.pop()
                    answer += 1
                else:
                    stack.append(new_board[i-1].pop())
    return answer*2
'''
[0,0,0,0,0],
[0,0,1,0,3],
[0,2,5,0,1],
[4,2,4,4,2],
[3,5,1,3,1]

stack 필요
moves는 board의 index 역할
여기서 하나씩 빼오고
list에 요소가 없는데 pop은 안되니까
전제조건 필요
나머지는 일반적인 스택과 같음

더 좋은 풀이 있음
'''