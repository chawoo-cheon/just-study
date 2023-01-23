import os, stat ,sys

#stat module is
# os.stat(), os.fstat(), os.lstat() 의 결과를 해석하기 위한 상수와 함수를 정의.
#https://docs.python.org/ko/3/library/stat.html
flags = (os.O_CREAT | os.O_EXCL) 
#os.O_EXCL - 파일이 존재한다면, error 발생시키기 때문에 try except 문으로 진행해야한다.
mode = stat.S_IWUSR | stat.S_IRUSR | stat.S_IRGRP | stat.S_IROTH
try:
    fd = os.open("fileDescriptTest.txt", flags, mode)
    os.close(fd)
except OSError as e :
    print("Error!! already exist this file !! {0}".format(e.errno))


fd = os.open("fileDescriptTest.txt",os.O_RDWR)
print(fd)
os.close(fd)
os.close(0)
fd = os.open("fileDescriptTest.txt",os.O_RDWR)
print(fd)
os.close(fd)