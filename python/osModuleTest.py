#sys 모듈은 파이썬 인터프리터가 제공하는 변수와 함수를 직접제어 할수 있게 해주는 모듈
#os 모듈은 환경변수나 디렉터리, 파일등의 os 자원을 제어할 수있게 해주는 모듈
#pickle 객체의 형태를 그대로 유지하면서 파일에 저장하고 불러올 수 있게 하는 모듈

import os, sys, pickle
test = os.getcwd()
print(test)
print(sys.argv)

f = open("test.txt",'wb')
data = {1:'pythoun',2:'you need'}

pickle.dump(data,f)
f.close

f = open("test.txt", 'rb')
data = pickle.load(f)
print(data)


os.system("dir")
