# 24.04.03

def main():
    rope_num = int(input())
    rope_list = []
    max_weight = 0
    for _ in range(rope_num):
        rope_list.append(int((input())))
    rope_list.sort(reverse=True)
    for i in range(len(rope_list)):
        max_weight = max(max_weight, rope_list[i]*(i+1))
    print(max_weight)
    
if __name__ == "__main__":
    main()