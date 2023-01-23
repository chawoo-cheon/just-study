# scope_file = open("test.txt","w",encoding="utf8")
# print("테스트 1", file = scope_file)
# print("테스트 2", file = scope_file)
# scope_file.close()

# scope_file = open("test.txt","a",encoding="utf8")
# scope_file.write("테스트3\n")
# scope_file.write("테스트4")
# scope_file.close()

# scope_file = open("test.txt","r",encoding="utf8")
# print(scope_file.read())
# scope_file.close()

# scope_file = open("test.txt","r",encoding="utf8")
# print(scope_file.readline()) # 줄별로 읽기 , 한줄 읽고 커서 다음줄 이동
# print(scope_file.readline(), end="") # 줄바꿈 없음.
# scope_file.close()

# scope_file=open("test.txt","r",encoding="utf8")
# while True:
#     line = scope_file.readline()
#     if not line:
#         break
#     print(line)
# scope_file.close()

# scope_file=open("test.txt","r",encoding="utf8")
# lines = scope_file.readlines() #list 형태로 저장
# print(lines)
# for line in lines :
#     print(line)
# scope_file.close()

import pickle

# profile_file = open("profile.pickle","wb") # 따로 인코딩 설정할 필요 없음
# profile = {"name":"thousand","age":30,"addr":"Sinlim"}
# print(profile)
# pickle.dump(profile, profile_file) # profile 에 있는 정보를 file 에 저장
# profile_file.close()

# profile_file = open("profile.pickle","rb") 
# profile = pickle.load(profile_file) #file 에 있는 정보 로딩
# print(profile)
# profile_file.close()

# with open("profile.pickle","rb") as profile_file:
#     print(pickle.load(profile_file))



